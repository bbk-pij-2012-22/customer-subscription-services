package com.marshall.customersubscriptionservice.dao;

import com.marshall.customersubscriptionservice.model.user.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long> {
    /**
     *
     * @param userId the ID of the User to be found
     * @return the User object related to the ID or null
     */
    User findByUserId(Long userId);
}