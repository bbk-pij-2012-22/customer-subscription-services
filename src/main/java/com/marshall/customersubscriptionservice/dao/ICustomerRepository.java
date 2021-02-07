package com.marshall.customersubscriptionservice.dao;

import com.marshall.customersubscriptionservice.model.customer.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {
    /**
     *
     * @param customerId the ID of the User to be found
     * @return the User object related to the ID or null
     */
    Customer findByCustomerId(Long customerId);
}