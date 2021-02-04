package com.marshall.customersubscriptionservice.model.user;

public class UserMatchLicence {
    private Long userId;
    private Long matchId;

    public UserMatchLicence(Long userId, Long matchId) {
        this.userId = userId;
        this.matchId = matchId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }
}