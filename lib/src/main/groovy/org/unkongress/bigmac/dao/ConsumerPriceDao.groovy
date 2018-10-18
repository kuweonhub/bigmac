package org.unkongress.bigmac.dao

import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.unkongress.bigmac.dto.timeseries.Root

@Component
class ConsumerPriceDao extends AbstractTimeSeriesDao {

    @Override
    String getUrl(String apiKey, String countryCode) {
        return "https://www.quandl.com/api/v3/datasets/RATEINF/CPI_${countryCode}.json?api_key=${apiKey}"
    }
}
