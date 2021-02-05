package com.marshall.customersubscriptionservice.service;

import com.marshall.customersubscriptionservice.IntegrationTest;
import com.marshall.customersubscriptionservice.model.user.UserMatchLicence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

class UserLicenceServiceImplTest extends IntegrationTest {

    private final IUserLicenceService userLicenceService;

    @Autowired
    public UserLicenceServiceImplTest(IUserLicenceService userLicenceService) {
        this.userLicenceService = userLicenceService;
    }

    @Test
    @Rollback
    @Transactional
    public void fetchUserMatchLicences() {
        List<UserMatchLicence> userMatchLicences = userLicenceService.getLicencedMatches(1L);
        //todo: assertions
    }
}