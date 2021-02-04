package com.marshall.customersubscriptionservice.web.util;

import com.marshall.customersubscriptionservice.model.event.Match;
import com.marshall.customersubscriptionservice.model.event.Player;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatchSummaryStringUtilTest {

    @Test
    public void buildAvBStringAcceptableParameters() {
        Match match = new Match(12345L, 54321L, new DateTime(),
                new Player("John McEnroe"), new Player("Andre Agassi"));
        String summaryType = "AvB";
        String expected = "John McEnroe vs Andre Agassi";
        String result = MatchSummaryStringUtil.buildMatchSummary(match, summaryType);
        assertEquals(expected, result);
    }
}