package com.marshall.customersubscriptionservice.web.util;

import com.marshall.customersubscriptionservice.model.event.Match;
import com.marshall.customersubscriptionservice.web.constants.WebConstants;

public class MatchSummaryStringUtil {

    public static String buildMatchSummary(Match match, String summaryType) {
        String matchSummary = null;

        switch (summaryType) {
            case WebConstants.SUMMARY_TYPE_A_v_B:
                // Todo build avb summary
                matchSummary = "";
                break;
            case WebConstants.SUMMARY_TYPE_A_v_B_TIME:
                // Todo build avb time summary
                matchSummary = "";
                break;
            default:
                throw new IllegalArgumentException();
        }

        return matchSummary;
    }
}