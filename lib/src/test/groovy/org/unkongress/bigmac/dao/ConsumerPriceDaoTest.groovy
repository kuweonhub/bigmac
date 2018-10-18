package org.unkongress.bigmac.dao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes=ConsumerPriceDao.class)
class ConsumerPriceDaoTest extends Specification {

    @Autowired
    ConsumerPriceDao consumerPriceDao;

    def "read Consumer Price Index from quandl webservice"() {
        when:
        def data = consumerPriceDao.getData("DEU")

        then:
        null != data
        data?.dataset?.name == "Consumer Price Index - Germany"
    }
}
