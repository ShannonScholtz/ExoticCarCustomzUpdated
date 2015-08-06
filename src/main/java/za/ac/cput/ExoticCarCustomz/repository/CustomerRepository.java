package za.ac.cput.ExoticCarCustomz.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.ExoticCarCustomz.domain.Customer;

/**
 * Created by student on 2015/07/30.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
