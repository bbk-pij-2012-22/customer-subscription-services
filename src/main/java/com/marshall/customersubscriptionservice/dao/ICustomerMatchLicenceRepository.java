package com.marshall.customersubscriptionservice.dao;

import com.marshall.customersubscriptionservice.model.customer.CustomerMatchLicence;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICustomerMatchLicenceRepository extends CrudRepository<CustomerMatchLicence, Long> {
    /**
     *
     * @param customerId - The ID of the user in question
     * @return List of Match objects that the user is licenced to view
     */
    List<CustomerMatchLicence> findByCustomerId(Long customerId);
}