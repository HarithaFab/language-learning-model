package com.bits.wilp.fsa.langLearnModel.service;

import java.util.Base64;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bits.wilp.fsa.langLearnModel.models.Users;

@Service
public class UserService {


	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	@Autowired
	UsersRepository userRepository;
	
	public String authenticateUser(Users user) throws UserNotFoundException {
		byte[] byteArr= Base64.getDecoder().decode(user.getEmail());
		String str = new String(byteArr);
		  user.setEmail(str);
		Optional<Users> opUser= userRepository.findByEmail(user.getEmail());
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
			log.info("Reached 0");
		byte[] byteArr= Base64.getDecoder().decode(user.getEmail());
	  String str = new String(byteArr);
	  log.info("Reached 1");
	  user.setEmail(str);
	  user.setPassword(user.getPassword());
	  log.info("Reached 2");
	  userRepository.save(user);
	  log.info("Reached 3");
	  return user.getEmail()+"user added to DB";
	}

}
