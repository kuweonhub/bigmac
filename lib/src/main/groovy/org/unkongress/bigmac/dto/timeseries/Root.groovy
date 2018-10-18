package org.unkongress.bigmac.dto.timeseries

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Root {

    Dataset dataset

    @Override
    public String toString() {
        return "Root{" +
                "dataset=" + dataset +
                '}';
    }
}
