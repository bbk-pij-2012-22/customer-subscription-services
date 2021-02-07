package com.marshall.customersubscriptionservice.web.api;

import com.marshall.customersubscriptionservice.exception.CustomerNotExistsException;
import com.marshall.customersubscriptionservice.model.customer.CustomerMatchLicence;
import com.marshall.customersubscriptionservice.service.ICustomerLicenceService;
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
public class CustomerLicenceResource {

    private final ICustomerLicenceService userLicenceService;

    public CustomerLicenceResource(ICustomerLicenceService userLicenceService) {
        this.userLicenceService = userLicenceService;
    }

    @GetMapping(path = "/{customerId}/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserMatchLicenceWrapper> getUserMatchLicences(@PathVariable("customerId") Long customerId,
                                                              @RequestParam(required = false) String summaryType) throws CustomerNotExistsException {
            List<CustomerMatchLicence> licencedMatches = userLicenceService.getLicencedMatches(customerId);
            return buildResponse(licencedMatches, summaryType);
    }

    private List<UserMatchLicenceWrapper> buildResponse(List<CustomerMatchLicence> licencedMatches, String summaryType) {

        List<UserMatchLicenceWrapper> response = new ArrayList<>();
        for (CustomerMatchLicence customerMatchLicence : licencedMatches) {
            UserMatchLicenceWrapper userLicenceWrapper = new UserMatchLicenceWrapper(customerMatchLicence);

            if (summaryType != null) {
               userLicenceWrapper.setSummary(MatchSummaryStringUtil.buildMatchSummary(customerMatchLicence, summaryType));
            }

            response.add(userLicenceWrapper);
        }

        return response;
    }
}