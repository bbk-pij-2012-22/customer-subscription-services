package com.marshall.customersubscriptionservice.web.util;

import com.marshall.customersubscriptionservice.model.event.Match;
import com.marshall.customersubscriptionservice.model.event.Player;
import com.marshall.customersubscriptionservice.model.user.UserMatchLicence;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MatchSummaryStringUtilTest {

    private UserMatchLicence userMatchLicence;
    private Match match;

    public MatchSummaryStringUtilTest() {
        Player playerA = new Player();
        Player playerB = new Player();
        match = new Match(1L, 1L, new Date(), playerA, playerB);
        userMatchLicence = new UserMatchLicence(1L, 1L, match);
    }

    @Test
    public void buildMatchSummaryIllegalArgumentTest() {
        assertThrows(IllegalArgumentException.class, () ->
        MatchSummaryStringUtil.buildMatchSummary(userMatchLicence, "illegal argument"));
    }
}