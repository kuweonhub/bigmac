package org.unkongress.bigmac.service.converter

import org.springframework.stereotype.Component
import org.unkongress.bigmac.dto.Entry
import org.unkongress.bigmac.dto.Measure
import org.unkongress.bigmac.dto.timeseries.Root

@Component
class BigMacConverter extends AbstractTimeSeriesConverter {

    @Override
    def Entry[] collect(String[][] data) {
        def result = new Entry[data.length]
        data.eachWithIndex { dataArray, index ->
            result[index] = new Entry()
            result[index].date = Date.parse("yyyy-MM-dd", dataArray[0])
            result[index].value = Double.parseDouble(dataArray[3]) // USD price
        }
        return result
    }

}
