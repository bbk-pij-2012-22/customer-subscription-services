package com.marshall.customersubscriptionservice.model.user;

public class UserTournamentLicence {

    private Long userId;
    private Long tournamentId;

    public UserTournamentLicence(Long userId, Long tournamentId) {
        this.userId = userId;
        this.tournamentId = tournamentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }
}