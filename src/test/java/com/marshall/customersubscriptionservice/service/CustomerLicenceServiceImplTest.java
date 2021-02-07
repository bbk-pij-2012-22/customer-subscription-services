package com.marshall.customersubscriptionservice.service;

import com.marshall.customersubscriptionservice.IntegrationTest;
import com.marshall.customersubscriptionservice.exception.CustomerNotExistsException;
import com.marshall.customersubscriptionservice.model.event.Match;
import com.marshall.customersubscriptionservice.model.event.Player;
import com.marshall.customersubscriptionservice.model.customer.CustomerMatchLicence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import javax.transaction.Transactional;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CustomerLicenceServiceImplTest extends IntegrationTest {

    private final ICustomerLicenceService userLicenceService;

    @Autowired
    public CustomerLicenceServiceImplTest(ICustomerLicenceService userLicenceService) {
        this.userLicenceService = userLicenceService;
    }

    @Test
    @Rollback
    @Transactional
    public void fetchUserMatchLicencesForUserId1test() throws CustomerNotExistsException {
        List<CustomerMatchLicence> customerMatchLicences = userLicenceService.getLicencedMatches(1L);
        int expected = 1;
        int actual = customerMatchLicences.size();
        assertEquals(expected, actual);

        CustomerMatchLicence customerMatchLicence = customerMatchLicences.get(0);
        Match match = customerMatchLicence.getMatch();
        Long expectedMatchId = 1L;
        Long actualMatchId = match.getMatchId();
        assertEquals(expectedMatchId, actualMatchId);

        Player playerA = match.getPlayerA();
        String expectedPlayerName = "A. Agassi";
        String actualPlayerName = playerA.getPlayerName();
        assertEquals(expectedPlayerName, actualPlayerName);

        Player playerB = match.getPlayerB();
        expectedPlayerName = "J. McEnroe";
        actualPlayerName = playerB.getPlayerName();
        assertEquals(expectedPlayerName, actualPlayerName);
    }

    @Test
    @Rollback
    @Transactional
    public void exceptionThrownForInvalidUserIdTest() {
        Exception expectedException = assertThrows(CustomerNotExistsException.class,
                () -> userLicenceService.getLicencedMatches(11L));

        String expectedErrorMessage = "Customer ID 11 does not exist.";
        String actualErrorMessage = expectedException.getMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}