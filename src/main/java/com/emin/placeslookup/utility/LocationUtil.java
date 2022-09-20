package com.emin.placeslookup.utility;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Map;

@Component
public class LocationUtil {

    Logger logger = LoggerFactory.getLogger(LocationUtil.class);

    @Value("${coordinates.decimal.precision:4}")
    byte precision;

    public Map<Double, Double> formatCoordinateWithPrecision(double lat, double lng) throws Exception {

        checkPrecision();

        double formattedLat = BigDecimal.valueOf(lat).setScale(precision, RoundingMode.HALF_UP).doubleValue();
        double formattedLng = BigDecimal.valueOf(lng).setScale(precision, RoundingMode.HALF_UP).doubleValue();

        return Collections.singletonMap(formattedLat, formattedLng);
    }

    private void checkPrecision() throws Exception{
        if(StringUtils.isEmpty(String.valueOf(this.precision))) {
            logger.error("coordinates.decimal.precision is empty");
            throw new RuntimeException();
        } else if (this.precision > 16) {
            logger.warn("coordinates.decimal.precision value is out of bound, > 16\nSetting the precision value to 16");
            this.precision = 16;
        } else if (this.precision < 0) {
            logger.warn("coordinates.decimal.precision value is out of bound, precision < 0\nSetting the precision value to 0");
            this.precision = 0;
        }
    }

}
