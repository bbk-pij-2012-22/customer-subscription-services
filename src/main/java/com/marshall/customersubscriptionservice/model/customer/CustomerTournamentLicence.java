package com.marshall.customersubscriptionservice.model.customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_tournament_licence")
public class CustomerTournamentLicence {

    @Id
    private Long customerTournamentLicenceId;
    private Long customerId;
    private Long tournamentId;

    public CustomerTournamentLicence() {
    }

    public Long getCustomerTournamentLicenceId() {
        return customerTournamentLicenceId;
    }

    public void setCustomerTournamentLicenceId(Long customerTournamentLicenceId) {
        this.customerTournamentLicenceId = customerTournamentLicenceId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }
}