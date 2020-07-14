package com.techops.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Deposit")
public class Deposit extends Operation{

	public Deposit() {
		super();
		
	}

	public Deposit(Date dateOperation, double amount) {
		super(dateOperation, amount);
		
	}

	
	
}