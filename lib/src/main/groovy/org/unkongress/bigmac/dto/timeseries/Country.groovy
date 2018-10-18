package org.unkongress.bigmac.dto.timeseries

import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder([ "name", "code" ])
class Country {

    String name
    String code


    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
