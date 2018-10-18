package org.unkongress.bigmac.dto

class Measure {

    String key
    String description
    List<Entry> values

    @Override
    public String toString() {
        return "Measure{" +
                "key='" + key + '\'' +
                ", description='" + description + '\'' +
                ", values=" + values +
                '}';
    }
}
