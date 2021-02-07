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

    private final ICustomerMatchLicenceRepository userMatchLicenceRepository;
    private final ICustomerRepository userRepository;

    public CustomerLicenceServiceImpl(ICustomerMatchLicenceRepository customerMatchLicenceRepository,
                                      ICustomerRepository customerRepository) {
        this.userMatchLicenceRepository = customerMatchLicenceRepository;
        this.userRepository = customerRepository;
    }

    @Override
    public List<CustomerMatchLicence> getLicencedMatches(Long customerId) throws CustomerNotExistsException {
        validateUserId(customerId);
        return userMatchLicenceRepository.findByCustomerId(customerId);
    }

    private void validateUserId(Long customerId) throws CustomerNotExistsException {
        Customer customer = userRepository.findByCustomerId(customerId);
        if (customer == null) {
            throw new CustomerNotExistsException("Customer ID " + customerId + " does not exist.");
        }
    }
}