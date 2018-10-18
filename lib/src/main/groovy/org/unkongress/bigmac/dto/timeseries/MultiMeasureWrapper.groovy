package org.unkongress.bigmac.dto.timeseries

import org.unkongress.bigmac.dto.Measure

class MultiMeasureWrapper {

    List<Measure> measures = []

    def addMeasure(Measure measure) {
        measures << measure
    }

    def addMeasures(List<Measure> measureList) {
        measures.addAll(measureList)
    }

    @Override
    public String toString() {
        return "MultiMeasureWrapper{" +
                "measures=" + measures +
                '}';
    }
}
