package com.aurionpro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aurionpro.entity.AccounRequest;
import com.aurionpro.entity.Account;
import com.aurionpro.entity.Admin;
import com.aurionpro.entity.Customer;
import com.aurionpro.service.AdminService;
import com.aurionpro.service.CustomerService;

@RestController
@RequestMapping("/app")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private DocumentController documentController;
	
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
	
	@PostMapping("/customers/{customerId}/createAccount")
	public ResponseEntity<String> addAccountRequest(@PathVariable int customerId ,@RequestParam("file") MultipartFile file, @RequestParam("data") AccounRequest data )
	{
		
		
		String uploadFile = documentController.uploadFile(file,customerId,data);
		return new ResponseEntity<String>(uploadFile,HttpStatus.OK);
	}
	
	
}
