package com.marshall.customersubscriptionservice.web.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TimeUtil {

    public static Long differenceInMinutes(Date date1, Date date2) {
        LocalDateTime dateTime1 = dateToLocalDateTime(date1);
        LocalDateTime dateTime2 = dateToLocalDateTime(date2);
        return Math.abs(ChronoUnit.MINUTES.between(dateTime1, dateTime2));
    }

    private static LocalDateTime dateToLocalDateTime(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}