package com.marshall.customersubscriptionservice.web.model;

import com.marshall.customersubscriptionservice.model.event.Match;
import com.marshall.customersubscriptionservice.model.customer.CustomerMatchLicence;

import java.util.Date;

public class UserMatchLicenceWrapper {
    private final Long matchId;
    private final Date startDate;
    private final String playerA;
    private final String playerB;
    private String summary;

    public UserMatchLicenceWrapper(CustomerMatchLicence customerMatchLicence) {
        Match match = customerMatchLicence.getMatch();
        this.matchId = match.getMatchId();
        this.startDate = match.getStartDate();
        this.playerA = match.getPlayerA().getPlayerName();
        this.playerB = match.getPlayerB().getPlayerName();
    }

    public Long getMatchId() {
        return matchId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getPlayerA() {
        return playerA;
    }

    public String getPlayerB() {
        return playerB;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}