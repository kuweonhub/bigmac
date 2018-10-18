package org.unkongress.bigmac.service.converter

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.unkongress.bigmac.dto.timeseries.Root
import org.unkongress.bigmac.util.JsonUtil
import spock.lang.Specification

import static org.unkongress.bigmac.util.JsonUtil.readRootFrom
import static org.unkongress.bigmac.util.JsonUtil.writeRoot

@ContextConfiguration(classes=BigMacConverter.class)
class BigMacConverterTest extends Specification {

    @Autowired
    BigMacConverter bigMacConverter;

    def "convert BigMac Root object to Measure"() {
        when:
        def bigMacRoot = readRootFrom('/json/bigMac.json')
        assert bigMacRoot != null

        def measure = bigMacConverter.convert(bigMacRoot)
        //writeRoot(measure, '/home/kuwe/Dev/workspaces/bigmac/lib/src/test/resources/json/out.json')

        then:
        null != measure
        measure.key == "Big Mac Index - Germany"
        measure.description.startsWith("The Big Mac Index is an informal")
        measure.values.size() == 13
        measure.values[0].date != null
        measure.values[0].value > 0
    }
}
