package org.unkongress.bigmac.service.converter

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.unkongress.bigmac.dto.timeseries.Root
import org.unkongress.bigmac.util.JsonUtil
import spock.lang.Specification

import static org.unkongress.bigmac.util.JsonUtil.writeRoot

@ContextConfiguration(classes=ConsumerPriceConverter.class)
class ConsumerPriceConverterTest extends Specification {

    @Autowired
    ConsumerPriceConverter consumerPriceConverter

    def "convert BigMac Root object to Measure"() {
        when:
        def consumerPriceRoot = JsonUtil.readRootFrom('/json/consumerPrice.json')
        assert consumerPriceRoot != null

        def measure = consumerPriceConverter.convert(consumerPriceRoot)
        //writeRoot(measure, '/home/kuwe/Dev/workspaces/bigmac/lib/src/test/resources/json/out.json')

        then:
        null != measure
        measure.key == "Consumer Price Index - Germany"
        measure.description.startsWith("Please visit")
        measure.values.size() == 325
        measure.values[0].date != null
        measure.values[0].value > 0
    }
}
