package org.unkongress.bigmac.dao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.unkongress.bigmac.dto.timeseries.Country
import spock.lang.Specification

@ContextConfiguration(classes=CountryDao.class)
class CountryDaoTest extends Specification {

    @Autowired
    CountryDao countryDao;

    def "read Countries from CSV"() {
        when:
        def data = countryDao.getCountries()

        then:
        null != data
        13 == data.size()
        "Argentina" == data[0].asType(Country).name
    }
}
