package org.unkongress.bigmac.dao

import org.springframework.web.client.RestTemplate
import org.unkongress.bigmac.dto.timeseries.Root

abstract class AbstractTimeSeriesDao {

    def apiKey = getQuandlKey()

    Root getData(String countryCode) {
        assert apiKey != null, 'The Quandl api key is not set. ' +
                'It is used to authenticate at the Quandl open data server. ' +
                'Please set your Quandl api key as a system property with the key quandl_api_key'
        def template = new RestTemplate()
        return template.getForObject(getUrl(apiKey, countryCode), Root.class)
    }

    abstract def String getUrl(String apiKey, String countryCode)

    private static getQuandlKey() {
        String envKey = System.getenv('quandl_api_key')
        if (null != envKey) {
            return envKey
        }
        return System.getProperty('quandl_api_key');
    }

}
