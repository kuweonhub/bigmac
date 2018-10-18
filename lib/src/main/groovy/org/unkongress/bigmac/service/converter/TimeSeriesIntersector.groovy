package org.unkongress.bigmac.service.converter

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component
import org.unkongress.bigmac.dto.Entry
import org.unkongress.bigmac.dto.Measure
import org.unkongress.bigmac.dto.timeseries.MultiMeasureWrapper

@Slf4j
@Component
class TimeSeriesIntersector {

    def MultiMeasureWrapper intersect(Measure... measures) {
        assert measures != null, 'measures must not be null'
        return intersect(measures.toList())
    }

    def MultiMeasureWrapper intersect(List<Measure> measures) {
        assert measures != null, 'measures must not be null'

        def MultiMeasureWrapper result = new MultiMeasureWrapper()
        if (measures.size() == 1) {
            result.addMeasure(measures[0])
            return result
        }

        def timeSeries = extractTimeSeries(measures)
        def minDate = getMaxDateOfMinimum(timeSeries)
        def maxDate = getMinDateOfMaximum(timeSeries)

        log.debug("Date range: " + minDate + " to " +maxDate)

        List<Measure> filtered = removeElementsOutOfDateRange(measures, minDate, maxDate)
        result.addMeasures(filtered)
        return result
    }

    def List<Measure> removeElementsOutOfDateRange(List<Measure> measures, Date minDate, Date maxDate) {
        measures.each {measure ->
            def result = measure.values.findAll {it.date >= minDate && it.date <= maxDate}
            measure.setValues(result)
        }
        return measures
    }

    def Date getMaxDateOfMinimum(List<List<Date>> dateList) {
        List<Date> minimumList = []
        dateList.each {singleMeasureList ->
            minimumList << singleMeasureList.min()
        }
        return minimumList.max()
    }

    def Date getMinDateOfMaximum(List<List<Date>> dateList) {
        List<Date> maximumList = []
        dateList.each {singleMeasureList ->
            maximumList << singleMeasureList.max()
        }
        return maximumList.min()
    }

    def extractTimeSeries(List<Measure> measures) {
        List<List<Date>> result= []
        measures.each { measure ->
            List<Date> measureDateList = []
            measure.values.each { entry ->
                measureDateList << entry.getDate()
            }
            result << measureDateList
        }
        return result
    }
}
