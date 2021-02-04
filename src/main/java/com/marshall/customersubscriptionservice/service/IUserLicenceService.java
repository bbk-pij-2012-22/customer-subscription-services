package com.marshall.customersubscriptionservice.service;

import com.marshall.customersubscriptionservice.model.event.Match;
import java.util.List;

public interface IUserLicenceService {

    List<Match> getLicencedMatches(Long userId);
}