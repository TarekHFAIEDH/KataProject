package com.techops.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
public abstract class Operation implements Serializable{
@Id @GeneratedValue
private Long numero;
private Date dateOperation;
private double amount;
@Column(name = "type", insertable = false, updatable=false )
private String type_operation;

	public Operation(Date dateOperation, double amount) {
		super();

		this.dateOperation = dateOperation;
		this.amount = amount;
	}



	
	
	
	
}