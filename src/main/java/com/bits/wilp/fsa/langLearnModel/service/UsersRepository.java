package com.bits.wilp.fsa.langLearnModel.service;

import java.util.Optional;


import org.springframework.stereotype.Repository;

import com.bits.wilp.fsa.langLearnModel.models.Users;

@Repository
public interface UsersRepository {
	
public Optional<Users> findById(String email);

public Users save(Users user);

}
