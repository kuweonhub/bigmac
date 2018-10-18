package org.unkongress.bigmac.dao

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.unkongress.bigmac.dto.timeseries.Root

@Slf4j
@Component
class BicMacDao extends AbstractTimeSeriesDao {
    @Override
    String getUrl(String apiKey, String countryCode) {
        return "https://www.quandl.com/api/v3/datasets/ECONOMIST/BIGMAC_${countryCode}.json?api_key=${apiKey}"
    }
}
