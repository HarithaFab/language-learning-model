package com.bits.wilp.fsa.langLearnModel.service;

import java.util.Optional;


import com.bits.wilp.fsa.langLearnModel.models.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bits.wilp.fsa.langLearnModel.models.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, String> {
	
public Optional<Users> findByEmail(String email);

}
