package com.marshall.customersubscriptionservice.service;

import com.marshall.customersubscriptionservice.model.event.Match;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLicenceServiceImpl implements IUserLicenceService {

    @Override
    public List<Match> getLicencedMatches(Long userId) {
        return null;
    }
}