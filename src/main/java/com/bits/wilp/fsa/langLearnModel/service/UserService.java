package com.bits.wilp.fsa.langLearnModel.service;

import java.util.Base64;
import java.util.Optional;


import org.springframework.stereotype.Service;
import com.bits.wilp.fsa.langLearnModel.models.Users;

@Service
public class UserService {

	
	UsersRepository userRepository;
	
	public String authenticateUser(Users user) throws UserNotFoundException {
		byte[] byteArr= Base64.getDecoder().decode(user.getEmail());
		String str = new String(byteArr);
		  user.setEmail(str);
		Optional<Users> opUser= userRepository.findById(user.getEmail());
		  if(opUser.isPresent())
		  {
			  Users dbUser = opUser.get();
			  if(user.getPassword().equals(dbUser.getPassword()))
				  return "Authenticated User";
			  else
				  return "Incorrect User";
		  }
		  
		  throw new UserNotFoundException("No user present!");
		}
	public String addUser(Users user) {
	 byte[] byteArr= Base64.getDecoder().decode(user.getPassword());
	  String str = new String(byteArr);
	  user.setPassword(str);
	  Users savedUser = userRepository.save(user);
	  return savedUser.getEmail()+"user added to DB";
	}

}
