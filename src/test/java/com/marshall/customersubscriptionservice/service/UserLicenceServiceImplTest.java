package com.marshall.customersubscriptionservice.service;

import com.marshall.customersubscriptionservice.IntegrationTest;
import com.marshall.customersubscriptionservice.exception.UserNotExistsException;
import com.marshall.customersubscriptionservice.model.event.Match;
import com.marshall.customersubscriptionservice.model.event.Player;
import com.marshall.customersubscriptionservice.model.user.UserMatchLicence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import javax.transaction.Transactional;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class UserLicenceServiceImplTest extends IntegrationTest {

    private final IUserLicenceService userLicenceService;

    @Autowired
    public UserLicenceServiceImplTest(IUserLicenceService userLicenceService) {
        this.userLicenceService = userLicenceService;
    }

    @Test
    @Rollback
    @Transactional
    public void fetchUserMatchLicencesForUserId1test() throws UserNotExistsException {
        List<UserMatchLicence> userMatchLicences = userLicenceService.getLicencedMatches(1L);
        int expected = 1;
        int actual = userMatchLicences.size();
        assertEquals(expected, actual);

        UserMatchLicence userMatchLicence = userMatchLicences.get(0);
        Match match = userMatchLicence.getMatch();
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
        Exception expectedException = assertThrows(UserNotExistsException.class,
                () -> userLicenceService.getLicencedMatches(11L));

        String expectedErrorMessage = "User ID 11 does not exist.";
        String actualErrorMessage = expectedException.getMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}