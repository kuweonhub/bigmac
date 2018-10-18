package org.unkongress.bigmac.service.converter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.unkongress.bigmac.dto.Entry
import org.unkongress.bigmac.dto.Measure
import spock.lang.Specification

@ContextConfiguration(classes=TimeSeriesIntersector.class)
class TimeSeriesIntersectorTest extends Specification {

    @Autowired
    TimeSeriesIntersector intersector

    def dateList = [
            [dateOf("2014-03-01"), dateOf("2014-01-01")],
            [dateOf("2013-02-01"), dateOf("2013-01-01")]
    ]

    def List<Measure> measures = [
            new Measure(
                key: "M 1",
                description: "Desc 1",
                values: [
                        new Entry(date: dateOf("2014-12-31"), value: 5d),
                        new Entry(date: dateOf("2015-01-31"), value: 6d),
                        new Entry(date: dateOf("2015-02-28"), value: 7d),
                        new Entry(date: dateOf("2015-03-31"), value: 8d)
                ]
            ),
            new Measure(
                    key: "M 2",
                description: "Desc 2",
                    values: [
                        new Entry(date: dateOf("2014-11-30"), value: 15d),
                        new Entry(date: dateOf("2015-01-31"), value: 16d),
                        new Entry(date: dateOf("2015-02-28"), value: 17d)
                ]
            )
    ]

    def "intersect Measures"() {
        given:
        measures

        when:
        def result = intersector.intersect(measures)

        then:
        result.measures.size() == 2
        result.measures[0].values.size() == 3
        result.measures[1].values.size() == 2
    }

    def "remove Elements Out-Of-Date-Range " () {
        given:
        measures

        when:
        def result = intersector.removeElementsOutOfDateRange(measures, dateOf("2015-02-01"), dateOf("2015-03-01"))

        then:
        result[0].values.size() == 1
        result[1].values.size() == 1
    }

    def "get Max Date Of Minimum"() {
        given:
        dateList

        when:
        def minimum = intersector.getMaxDateOfMinimum(dateList)

        then:
        minimum.equals(dateOf("2014-01-01"))

    }

    def "get Min Date Of sMaximum"() {
        given:
        dateList

        when:
        def maximum = intersector.getMinDateOfMaximum(dateList)

        then:
        maximum.equals(dateOf("2013-02-01"))
    }

    def Date dateOf(String dateString) {
        return Date.parse("yyyy-MM-dd", dateString)
    }
}
