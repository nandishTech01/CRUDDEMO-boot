package com.anil.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.exception.userNotFoundException;
import com.anil.model.userModel;
import com.anil.repositary.userRepositary;



@RestController
@RequestMapping("/user")
public class userController {

	@Autowired
	private userRepositary userRepositary;
	

	
	
	@PostMapping("/create")
	public userModel createUser(@Valid @RequestBody userModel user) {
		
		
		return this.userRepositary.save(user);
	}
	
	
	@GetMapping("/getAll")
	public List<userModel> getAllUsers(){
		return this.userRepositary.findAll();
	}
	
	@GetMapping("/{user_id}")
	public ResponseEntity<userModel> getUserById(@PathVariable(value="user_id") Long userid) throws userNotFoundException{
		
		Optional<userModel> user = userRepositary.findById(userid);
		
		if(user!=null && !user.equals(" ")) {
			return ResponseEntity.ok().body(user.get());
		}
		else {
			throw new userNotFoundException("User not Found");
		}
	}
	

	@PutMapping("/update/{user_id}")
	public ResponseEntity<userModel> updateUser(@PathVariable(value="user_id") Long userid,@RequestBody userModel user) throws userNotFoundException{
		
		
		Optional<userModel> userde = userRepositary.findById(userid);
		userModel userObj =null;
		if(userde!=null && !userde.equals(" ")) {
			userObj=userde.get();
			userObj.setName(user.getName());
			userObj.setAddress(user.getAddress());
			userObj.setNumber(user.getNumber());
			userObj.setEmail(user.getEmail());

			return ResponseEntity.ok(this.userRepositary.save(userObj));
		}
		else {
			throw new userNotFoundException("User not Found");
		}
	}
	
	@DeleteMapping("/delete/{user_id}")
	public Map<String, Boolean> deleteUserById(@PathVariable(value="user_id") Long userid){
		
		Optional<userModel> user = userRepositary.findById(userid);
		
		this.userRepositary.delete(user.get());
		Map<String, Boolean> response =new HashMap<>();
		response.put("User deleted sucessfull", Boolean.TRUE);
		
		return response;
	
	}
	
	
}
