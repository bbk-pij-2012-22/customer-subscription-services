package com.marshall.customersubscriptionservice.service;

import com.marshall.customersubscriptionservice.exception.UserNotExistsException;
import com.marshall.customersubscriptionservice.model.event.Match;
import com.marshall.customersubscriptionservice.model.user.UserMatchLicence;

import java.util.List;

public interface IUserLicenceService {

    List<UserMatchLicence> getLicencedMatches(Long userId) throws UserNotExistsException;
}