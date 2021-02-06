package com.marshall.customersubscriptionservice.web.util;

import com.marshall.customersubscriptionservice.model.event.Match;
import com.marshall.customersubscriptionservice.model.event.Player;
import com.marshall.customersubscriptionservice.model.user.UserMatchLicence;
import com.marshall.customersubscriptionservice.web.constants.WebConstants;

import java.util.Date;

public class MatchSummaryStringUtil {

    private static final String STARTED_IN_THE_PAST = "started %d minutes ago";
    private static final String STARTS_IN_THE_FUTURE = "starts in %d minutes";

    public static String buildMatchSummary(UserMatchLicence userMatchLicence, String summaryType) {
        String matchSummary;
        Match match = userMatchLicence.getMatch();
        Player playerA = match.getPlayerA();
        Player playerB = match.getPlayerB();

        switch (summaryType) {
            case WebConstants.SUMMARY_TYPE_A_v_B:
                matchSummary = playerA.getPlayerName() + " vs " + playerB.getPlayerName();
                break;
            case WebConstants.SUMMARY_TYPE_A_v_B_TIME:
                Date now = new Date();
                Date startDate = match.getStartDate();
                Long differenceInMinutes = TimeUtil.differenceInMinutes(now, startDate);
                matchSummary = playerA.getPlayerName() + " vs " + playerB.getPlayerName() + ", ";

                if (now.after(startDate)) {
                    matchSummary = matchSummary + String.format(STARTED_IN_THE_PAST, differenceInMinutes);
                } else {
                    matchSummary = matchSummary + String.format(STARTS_IN_THE_FUTURE, differenceInMinutes);
                }
                break;
            default:
                throw new IllegalArgumentException("Summary type parameter must be " +
                        WebConstants.SUMMARY_TYPE_A_v_B + " or " + WebConstants.SUMMARY_TYPE_A_v_B_TIME);
        }

        return matchSummary;
    }
}