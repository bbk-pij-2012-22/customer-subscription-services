package com.marshall.customersubscriptionservice.service;

import com.marshall.customersubscriptionservice.dao.ICustomerMatchLicenceRepository;
import com.marshall.customersubscriptionservice.dao.ICustomerRepository;
import com.marshall.customersubscriptionservice.exception.CustomerNotExistsException;
import com.marshall.customersubscriptionservice.model.customer.Customer;
import com.marshall.customersubscriptionservice.model.customer.CustomerMatchLicence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerLicenceServiceImpl implements ICustomerLicenceService {

    private final ICustomerMatchLicenceRepository customerMatchLicenceRepository;
    private final ICustomerRepository customerRepository;

    public CustomerLicenceServiceImpl(ICustomerMatchLicenceRepository customerMatchLicenceRepository,
                                      ICustomerRepository customerRepository) {
        this.customerMatchLicenceRepository = customerMatchLicenceRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerMatchLicence> getLicencedMatches(Long customerId) throws CustomerNotExistsException {
        validateCustomerId(customerId);
        return customerMatchLicenceRepository.findByCustomerId(customerId);
    }

    private void validateCustomerId(Long customerId) throws CustomerNotExistsException {
        Customer customer = customerRepository.findByCustomerId(customerId);
        if (customer == null) {
            throw new CustomerNotExistsException("Customer ID " + customerId + " does not exist.");
        }
    }
}