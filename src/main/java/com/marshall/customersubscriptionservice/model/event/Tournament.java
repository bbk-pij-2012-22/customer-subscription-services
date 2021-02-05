package com.marshall.customersubscriptionservice.model.event;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tournament")
public class Tournament {

    @Id
    private Long tournamentId;
    private String tournamentName;
    private Date startDate;

    public Tournament() {
    }

    public Tournament(Long tournamentId, String tournamentName, Date startDate) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}