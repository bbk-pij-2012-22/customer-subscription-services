package com.marshall.customersubscriptionservice.web.api;

import com.marshall.customersubscriptionservice.model.event.Match;
import com.marshall.customersubscriptionservice.service.IUserLicenceService;
import com.marshall.customersubscriptionservice.web.util.MatchSummaryStringUtil;
import com.marshall.customersubscriptionservice.web.model.UserMatchLicenceWrapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "/api/user/licence")
public class UserLicenceResource {

    private final IUserLicenceService userLicenceService;

    public UserLicenceResource(IUserLicenceService userLicenceService) {
        this.userLicenceService = userLicenceService;
    }

    @GetMapping(path = "/{userId}/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserMatchLicenceWrapper> getUserMatchLicences(@PathVariable("userId") Long userId,
                                                              @RequestParam String summaryType) {
        List<Match> licencedMatches = userLicenceService.getLicencedMatches(userId);

        return buildResponse(licencedMatches, summaryType);
    }

    private List<UserMatchLicenceWrapper> buildResponse(List<Match> licencedMatches, String summaryType) {

        List<UserMatchLicenceWrapper> response = new ArrayList<>();
        for (Match match : licencedMatches) {
            UserMatchLicenceWrapper userLicenceWrapper = new UserMatchLicenceWrapper(match);

            if (summaryType != null) {
               userLicenceWrapper.setSummary(MatchSummaryStringUtil.buildMatchSummary(match));
            }

            response.add(userLicenceWrapper);
        }

        return response;
    }
}