package org.unkongress.bigmac.dao

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import spock.lang.Specification

@ContextConfiguration(classes=BicMacDao.class)
class BicMacDaoTest extends Specification {

    @Autowired
    BicMacDao bicMacDao;

    def "read BigMac Index from quandl webservice"() {
        when:
        def data = bicMacDao.getData("DEU")

        then:
        null != data
        data?.dataset?.name == "Big Mac Index - Germany"
    }
}
