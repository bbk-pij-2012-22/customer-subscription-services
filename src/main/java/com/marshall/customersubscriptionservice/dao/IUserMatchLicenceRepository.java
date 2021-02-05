package com.marshall.customersubscriptionservice.dao;

import com.marshall.customersubscriptionservice.model.user.UserMatchLicence;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserMatchLicenceRepository extends CrudRepository<UserMatchLicence, Long> {
    /**
     *
     * @param userId - The ID of the user in question
     * @return List of Match objects that the user is licenced to view
     */
    List<UserMatchLicence> findByUserId(Long userId);
}