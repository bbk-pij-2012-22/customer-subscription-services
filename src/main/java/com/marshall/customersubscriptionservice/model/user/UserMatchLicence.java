package com.marshall.customersubscriptionservice.model.user;

import com.marshall.customersubscriptionservice.model.event.Match;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user_match_licence")
public class UserMatchLicence {

    @Id
    private Long userMatchLicenceId;
    private Long userId;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "match_id")
    private Match match;

    public UserMatchLicence() {
    }

    public UserMatchLicence(Long userMatchLicenceId, Long userId, Match match) {
        this.userMatchLicenceId = userMatchLicenceId;
        this.userId = userId;
        this.match = match;
    }

    public Long getUserMatchLicenceId() {
        return userMatchLicenceId;
    }

    public void setUserMatchLicenceId(Long userMatchLicenceId) {
        this.userMatchLicenceId = userMatchLicenceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}