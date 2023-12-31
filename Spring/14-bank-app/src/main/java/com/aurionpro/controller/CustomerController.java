package com.aurionpro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aurionpro.entity.Account;
import com.aurionpro.entity.AccountRequest;
import com.aurionpro.entity.Admin;
import com.aurionpro.entity.Customer;
import com.aurionpro.entity.User;
import com.aurionpro.service.AdminService;
import com.aurionpro.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins="http://localhost:4200")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private DocumentController documentController;
	@Autowired
	private UserController userController;
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers= customerService.getAll();
		return new ResponseEntity<>(customers,HttpStatus.OK);
	}

	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		Customer addedCustomer=customerService.addCustomer(customer);
		return new ResponseEntity<>(addedCustomer,HttpStatus.CREATED);
	}
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> getUserById(@PathVariable int customerId){
		Customer customer = customerService.findById(customerId);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@GetMapping("customers/userid/{userId}")
	public ResponseEntity<Customer> getByUserId(@PathVariable int userId){
		ResponseEntity<User> responseEntity=userController.getUserById(userId);
		User user = responseEntity.getBody();
		Customer customer = customerService.findByUserId(user);
		return new ResponseEntity<>(customer,HttpStatus.OK);

	}
	
	
	
	@PostMapping("/customers/{customerId}/createAccount")
	public ResponseEntity<String> addAccountRequest(@PathVariable int customerId ,@RequestParam("file") MultipartFile file, String data )
	{
		AccountRequest accountRequestData=null;
		try {
            accountRequestData = new ObjectMapper().readValue(data, AccountRequest.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
		String uploadFile = documentController.uploadFile(file,customerId,accountRequestData);
		return new ResponseEntity<String>(uploadFile,HttpStatus.OK);
	}
	
	
}
