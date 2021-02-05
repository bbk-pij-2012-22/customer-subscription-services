package com.marshall.customersubscriptionservice.service;

import com.marshall.customersubscriptionservice.dao.IUserMatchLicenceRepository;
import com.marshall.customersubscriptionservice.dao.IUserRepository;
import com.marshall.customersubscriptionservice.exception.UserNotExistsException;
import com.marshall.customersubscriptionservice.model.user.User;
import com.marshall.customersubscriptionservice.model.user.UserMatchLicence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLicenceServiceImpl implements IUserLicenceService {

    private final IUserMatchLicenceRepository userMatchLicenceRepository;
    private final IUserRepository userRepository;

    public UserLicenceServiceImpl(IUserMatchLicenceRepository userMatchLicenceRepository,
                                  IUserRepository userRepository) {
        this.userMatchLicenceRepository = userMatchLicenceRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserMatchLicence> getLicencedMatches(Long userId) throws UserNotExistsException {
        validateUserId(userId);
        return userMatchLicenceRepository.findByUserId(userId);
    }

    private void validateUserId(Long userId) throws UserNotExistsException {
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new UserNotExistsException("User ID " + userId + " does not exist.");
        }
    }
}