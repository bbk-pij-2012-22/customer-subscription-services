package com.marshall.customersubscriptionservice.service;

import com.marshall.customersubscriptionservice.exception.CustomerNotExistsException;
import com.marshall.customersubscriptionservice.model.customer.CustomerMatchLicence;

import java.util.List;

public interface ICustomerLicenceService {

    List<CustomerMatchLicence> getLicencedMatches(Long customerId) throws CustomerNotExistsException;
}