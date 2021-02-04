package com.marshall.customersubscriptionservice.dao;

import com.marshall.customersubscriptionservice.model.event.Match;
import java.util.List;

public interface IUserMatchLicenceDao {
    /**
     *
     * @param userId - The ID of the user in question
     * @return List of Match objects that the user is licenced to view
     */
    List<Match> getByUserId(Long userId);
}