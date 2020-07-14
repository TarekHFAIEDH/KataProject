package com.techops.rest;

import java.util.List;

import com.techops.entities.Deposit;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techops.entities.Operation;
import com.techops.entities.Withdrawal;
import com.techops.service.IKataService;
import com.techops.entities.Deposit;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping(value = "/KataServices")
public class ServiceKataRest {

	@Autowired
	private IKataService bankService;
	private static Logger logger = Logger.getLogger(ServiceKataRest.class);
	
	

	@RequestMapping(value = "/deposit", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> deposit(@RequestBody Deposit operation) {
		try {
			double amount = operation.getAmount();
			bankService.deposit(amount);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	

	// http://localhost:8080/services/
	@RequestMapping(value = "/withdrawal", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> withdrawal(@RequestBody Withdrawal operation) {
		try {
			double amount = operation.getAmount();
			bankService.withdrawal(amount);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/operations", method = RequestMethod.GET)
	public ResponseEntity<List<Operation>> listOperation(){
		
		List<Operation> operations=null;
		try {
			operations = bankService.listOperation();
		} catch (Exception e) {
			return new ResponseEntity<List<Operation>>(operations, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Operation>>(operations, HttpStatus.OK);
		
	}
	


	
	
}
