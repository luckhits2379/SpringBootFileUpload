package com.ng.springboot.fileupload;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Error {

	@Max(value = 100, message = "Number can not be more than 100")
	@Min(value = 0, message = "Number can not be less than 0")
	public int id;

	@NotBlank(message = "Name can not be blank")
	@Length(min = 5, max = 20, message = "Name can only be between 5 and 50 character")
	public String name;

	@NotBlank(message = "Email can not be blank")
	@Email(message = "Invalid email")
	public String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Error [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
