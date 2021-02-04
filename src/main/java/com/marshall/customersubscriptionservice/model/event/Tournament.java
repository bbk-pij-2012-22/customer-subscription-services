package com.marshall.customersubscriptionservice.model.event;

import org.joda.time.DateTime;

public class Tournament {

    private Long tournamentId;
    private String tournamentName;
    private DateTime startDate;

    public Tournament(Long tournamentId, String tournamentName, DateTime startDate) {
        this.tournamentId = tournamentId;
        this.tournamentName = tournamentName;
        this.startDate = startDate;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }
}