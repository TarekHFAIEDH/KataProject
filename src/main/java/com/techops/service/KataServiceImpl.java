package com.techops.service;

import java.util.Date;
import java.util.List;

import com.techops.dao.IOperationRepository;
import com.techops.entities.Deposit;
import com.techops.entities.Operation;
import com.techops.entities.Withdrawal;
import com.techops.entities.Deposit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KataServiceImpl implements IKataService {

	@Autowired
	private IOperationRepository operationRepository;

	private static Logger logger = Logger.getLogger(KataServiceImpl.class);
	

	@Override
	public void deposit(double amount) {
		Deposit v = new Deposit(new Date(), amount);
		operationRepository.save(v);
	}

	@Override
	public void withdrawal(double amount) {
		Withdrawal r = new Withdrawal(new Date(), amount);
		operationRepository.save(r);
		
	}

	@Override
	public List<Operation> listOperation() {
		
		return operationRepository.listOperation();
	}



}