package com.marshall.customersubscriptionservice.model.customer;

import com.marshall.customersubscriptionservice.model.event.Match;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_match_licence")
public class CustomerMatchLicence {

    @Id
    private Long customerMatchLicenceId;
    private Long customerId;
    @OneToOne
    @JoinColumn(name = "match_id")
    private Match match;

    public CustomerMatchLicence() {
    }

    public CustomerMatchLicence(Long customerMatchLicenceId, Long customerId, Match match) {
        this.customerMatchLicenceId = customerMatchLicenceId;
        this.customerId = customerId;
        this.match = match;
    }

    public Long getCustomerMatchLicenceId() {
        return customerMatchLicenceId;
    }

    public void setCustomerMatchLicenceId(Long customerMatchLicenceId) {
        this.customerMatchLicenceId = customerMatchLicenceId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}