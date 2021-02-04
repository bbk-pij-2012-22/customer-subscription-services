package com.marshall.customersubscriptionservice.web.model;

import com.marshall.customersubscriptionservice.model.event.Match;
import org.joda.time.DateTime;

public class UserMatchLicenceWrapper {
    private final Long matchId;
    private final DateTime startDate;
    private final String playerAName;
    private final String playerBName;
    private String summary;

    public UserMatchLicenceWrapper(Match match) {
        this.matchId = match.getMatchId();
        this.startDate = match.getStartDate();
        this.playerAName = match.getPlayerA().getPlayerName();
        this.playerBName = match.getPlayerB().getPlayerName();
    }

    public Long getMatchId() {
        return matchId;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public String getPlayerAName() {
        return playerAName;
    }

    public String getPlayerBName() {
        return playerBName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}