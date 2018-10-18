package org.unkongress.bigmac.dto

class Entry {

    Date date
    double value

    @Override
    public String toString() {
        return "Entry{" +
                "date=" + date +
                ", value=" + value +
                '}';
    }
}
