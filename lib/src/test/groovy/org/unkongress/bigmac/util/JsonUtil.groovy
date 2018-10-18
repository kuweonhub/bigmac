package org.unkongress.bigmac.util

import com.fasterxml.jackson.databind.ObjectMapper
import org.unkongress.bigmac.dto.timeseries.Root

class JsonUtil {

    static def Root readRootFrom(String fileLoc) {
        ObjectMapper mapper = new ObjectMapper();
        Root result = mapper.readValue(this.getClass().getResource( fileLoc ), Root)
    }

    static def writeRoot(Object obj, String fileLoc) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(fileLoc), obj);
    }
}
