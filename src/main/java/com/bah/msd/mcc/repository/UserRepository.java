package com.bah.msd.mcc.repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.msd.mcc.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}

