package com.marshall.customersubscriptionservice.web.util;


import org.apache.commons.lang.time.DateUtils;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TimeUtilTest {

    @Test
    public void differenceInMinutesFutureTest() {
        Date now = new Date();
        Date tenMinutesInFuture = DateUtils.addMinutes(now, 10);
        assertTrue(now.before(tenMinutesInFuture));

        Long expectedDifferenceInMinutes = 10L;
        Long actualDifferenceInMinutes = TimeUtil.differenceInMinutes(now, tenMinutesInFuture);
        assertEquals(expectedDifferenceInMinutes, actualDifferenceInMinutes);
    }

    @Test
    public void differenceInMinutesPastTest() {
        Date now = new Date();
        Date twentyMinutesInPast = DateUtils.addMinutes(now,-20);
        assertTrue(now.after(twentyMinutesInPast));

        Long expectedDifferenceInMinutes = 20L;
        Long actualDifferenceInMinutes = TimeUtil.differenceInMinutes(now, twentyMinutesInPast);
        assertEquals(expectedDifferenceInMinutes, actualDifferenceInMinutes);
    }
}