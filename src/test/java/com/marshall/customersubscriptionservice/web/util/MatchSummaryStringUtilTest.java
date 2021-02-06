package com.marshall.customersubscriptionservice.web.util;

import com.marshall.customersubscriptionservice.model.event.Match;
import com.marshall.customersubscriptionservice.model.event.Player;
import com.marshall.customersubscriptionservice.model.user.UserMatchLicence;
import com.marshall.customersubscriptionservice.web.constants.WebConstants;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatchSummaryStringUtilTest {

    private UserMatchLicence userMatchLicence;
    private Match match;

    public MatchSummaryStringUtilTest() {
        Date now = new Date();
        Player playerA = new Player();
        playerA.setPlayerName("A.Agassi");
        Player playerB = new Player();
        playerB.setPlayerName("J.McEnroe");
        match = new Match(1L, 1L, now, playerA, playerB);
        userMatchLicence = new UserMatchLicence(1L, 1L, match);
    }

    @Test
    public void buildMatchSummaryIllegalArgumentTest() {
        assertThrows(IllegalArgumentException.class, () ->
        MatchSummaryStringUtil.buildMatchSummary(userMatchLicence, "illegal argument"));
    }

    @Test
    public void buildMatchSummaryAvBTest() {
        String expected = "A.Agassi vs J.McEnroe";
        String actual = MatchSummaryStringUtil.buildMatchSummary(userMatchLicence, WebConstants.SUMMARY_TYPE_A_v_B);
        assertEquals(expected, actual);
    }
}