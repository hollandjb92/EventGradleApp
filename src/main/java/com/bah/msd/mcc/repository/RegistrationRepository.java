package com.bah.msd.mcc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bah.msd.mcc.domain.Registration;

@Repository
public interface RegistrationRepository extends CrudRepository<Registration, Long>{

}
