package com.techops.service;

import com.techops.entities.Operation;

import java.util.List;

public interface IKataService {

	public void deposit(double amount);
	public void withdrawal(double amount);
	public List<Operation> listOperation();

}