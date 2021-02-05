package com.marshall.customersubscriptionservice.model.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_tournament_licence")
public class UserTournamentLicence {

    @Id
    private Long userTournamentLicenceId;
    private Long userId;
    private Long tournamentId;

    public UserTournamentLicence() {
    }

    public Long getUserTournamentLicenceId() {
        return userTournamentLicenceId;
    }

    public void setUserTournamentLicenceId(Long userTournamentLicenceId) {
        this.userTournamentLicenceId = userTournamentLicenceId;
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