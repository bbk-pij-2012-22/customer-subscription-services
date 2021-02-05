package com.marshall.customersubscriptionservice.service;

import com.marshall.customersubscriptionservice.dao.IUserMatchLicenceRepository;
import com.marshall.customersubscriptionservice.model.user.UserMatchLicence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLicenceServiceImpl implements IUserLicenceService {

    private final IUserMatchLicenceRepository userMatchLicenceRepository;

    public UserLicenceServiceImpl(IUserMatchLicenceRepository userMatchLicenceRepository) {
        this.userMatchLicenceRepository = userMatchLicenceRepository;
    }

    @Override
    public List<UserMatchLicence> getLicencedMatches(Long userId) {
        return userMatchLicenceRepository.findByUserId(userId);
    }
}