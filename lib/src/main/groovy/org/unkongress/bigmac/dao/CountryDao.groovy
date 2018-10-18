package org.unkongress.bigmac.dao

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component
import org.unkongress.bigmac.dto.timeseries.Country

@Slf4j
@Component
class CountryDao {

    List getCountries() {
        def mapper = new CsvMapper()
        def schema = mapper
                .schemaFor(Country.class)
                .withColumnSeparator('|' as char)
        return mapper
                .readerFor(Country.class)
                .with(schema)
                .readValues(this.getClass().getResource('/data/countries.csv'))
                .readAll()
    }

}
