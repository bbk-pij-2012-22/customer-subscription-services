package com.marshall.customersubscriptionservice.web.api;

import com.marshall.customersubscriptionservice.service.IUserLicenceService;
import com.marshall.customersubscriptionservice.web.model.UserLicenceResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api/user/licence")
public class UserLicenceResource {

    private IUserLicenceService userLicenceService;

    public UserLicenceResource(IUserLicenceService userLicenceService) {
        Objects.requireNonNull(userLicenceService);
        userLicenceService = userLicenceService;
    }
    public List<UserLicenceResponse> getUserMatchLicences() {

        return Collections.emptyList(); // gm obv remove when implemented
    }
}