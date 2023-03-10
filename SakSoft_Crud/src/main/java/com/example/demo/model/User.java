package com.example.demo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@JsonIgnoreProperties({ "hibernateLazyInitializer" }) // because error while fetch data by id
@Entity
@Table
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int User_Id;
	@NonNull
	private String First_Name;
	private String Last_Name;
	private String Email_Id;
	private int Age;
	public User() {
		super();
	}
	public User(int user_Id, String first_Name, String last_Name, String email_Id, int age) {
		super();
		User_Id = user_Id;
		First_Name = first_Name;
		Last_Name = last_Name;
		Email_Id = email_Id;
		Age = age;
	}
	public int getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getEmail_Id() {
		return Email_Id;
	}
	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "User [User_Id=" + User_Id + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", Email_Id="
				+ Email_Id + ", Age=" + Age + "]";
	}
}
