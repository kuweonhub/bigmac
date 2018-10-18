package org.unkongress.bigmac.dto.timeseries

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Dataset {

    String name
    String description
    String[][] data


    String toString() {
        "Name: $name Email: $description"
    }

}
