package org.unkongress.bigmac.service.converter

import org.unkongress.bigmac.dto.Entry
import org.unkongress.bigmac.dto.Measure
import org.unkongress.bigmac.dto.timeseries.Root

abstract class AbstractTimeSeriesConverter {

    def Measure convert(Root timeseriesRoot) {
        def result = new Measure();
        result.key = timeseriesRoot.dataset.name
        result.description = timeseriesRoot.dataset.description
        result.values = collect(timeseriesRoot.dataset.data)
        return result
    }

    abstract def Entry[] collect(String[][] data)

}
