package com.marshall.customersubscriptionservice.model.event;

import org.joda.time.DateTime;

public class Match {

    private Long matchId;
    private Long tournamentId;
    private DateTime startDate;
    private Player playerA;
    private Player playerB;

    public Match(Long matchId, Long tournamentId, DateTime startDate, Player playerA, Player playerB) {
        this.matchId = matchId;
        this.tournamentId = tournamentId;
        this.startDate = startDate;
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public void setPlayerA(Player playerA) {
        this.playerA = playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public void setPlayerB(Player playerB) {
        this.playerB = playerB;
    }
}