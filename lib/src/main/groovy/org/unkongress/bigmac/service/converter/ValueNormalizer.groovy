package org.unkongress.bigmac.service.converter

import groovy.util.logging.Slf4j
import org.apache.commons.math3.stat.StatUtils
import org.springframework.stereotype.Component
import org.unkongress.bigmac.dto.Measure
import org.unkongress.bigmac.dto.timeseries.MultiMeasureWrapper

@Slf4j
@Component
class ValueNormalizer {

    def MultiMeasureWrapper normalize(MultiMeasureWrapper multiMeasureWrapper) {
        List<ValueStatsObject> statsList = getStats(multiMeasureWrapper.getMeasures())

        double minMean = getMinMean(statsList)

        def MultiMeasureWrapper result = new MultiMeasureWrapper()

        statsList.each {
            it.normalizeValues(minMean)
            result.addMeasure(it.getMeasure())
        }

        return result
    }

    def double getMinMean(List<ValueStatsObject> valueStatsObjects) {
        def meanList = []
        valueStatsObjects.each {
            meanList << it.mean
        }
        return meanList.min()
    }

    def List<ValueStatsObject> getStats(ArrayList<Measure> measures) {
        List<ValueStatsObject> result = []
        measures.each {
            result << new ValueStatsObject(it)
        }
        return result
    }

    static class ValueStatsObject {

        def Measure measure
        def List<Double> values
        def double mean
        def boolean dirty = false

        ValueStatsObject(Measure measure) {
            this.measure = measure
            this.values = measure.getValues().collect { it.getValue() }
            this.mean = StatUtils.mean(values as double[])
        }

        def normalizeValues(double offset) {
            assert !dirty, "This object is dirty. You can call normalizeValues just once per instance."
            double shift = mean - offset

            measure.values.each {
                it.setValue(it.value - shift)
            }
            this.dirty = true
        }
    }
}