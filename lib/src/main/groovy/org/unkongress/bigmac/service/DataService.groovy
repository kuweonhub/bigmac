package org.unkongress.bigmac.service

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.unkongress.bigmac.dao.BicMacDao
import org.unkongress.bigmac.dao.ConsumerPriceDao
import org.unkongress.bigmac.dao.CountryDao
import org.unkongress.bigmac.dto.Measure
import org.unkongress.bigmac.dto.timeseries.MultiMeasureWrapper
import org.unkongress.bigmac.service.converter.BigMacConverter
import org.unkongress.bigmac.service.converter.ConsumerPriceConverter
import org.unkongress.bigmac.service.converter.TimeSeriesIntersector
import org.unkongress.bigmac.service.converter.ValueNormalizer

@Slf4j
@RestController
class DataService {

    @Autowired
    BicMacDao bicMacDao;

    @Autowired
    ConsumerPriceDao consumerPriceDao;

    @Autowired
    BigMacConverter bigMacConverter;

    @Autowired
    ConsumerPriceConverter consumerPriceConverter;

    @Autowired
    TimeSeriesIntersector intersector;

    @Autowired
    ValueNormalizer normalizer;

    @Autowired
    CountryDao countryDao;


    //http://localhost:8080/getData?countryCode=DEU
    @CrossOrigin(origins="*")
    @RequestMapping("/getData")
    def getData(@RequestParam String countryCode) {
        def bigMacRawData = bicMacDao.getData(countryCode)
        def bigMacMeasure = bigMacConverter.convert(bigMacRawData)

        def consumerPriceRawData = consumerPriceDao.getData(countryCode)
        def consumerPriceMeasure = consumerPriceConverter.convert(consumerPriceRawData)

        def intersectedMeasures = intersector.intersect(bigMacMeasure, consumerPriceMeasure)
        log.debug("intersectedMeasures:" + intersectedMeasures)

        def result = normalizer.normalize(intersectedMeasures)

        return result.measures
    }

    @CrossOrigin(origins="*")
    @RequestMapping("/getCountries")
    def getCountries() {
        return countryDao.getCountries();
    }

}
