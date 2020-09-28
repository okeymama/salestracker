/**
 * 
 */
package com.sales.salestracker.dto;

import lombok.Data;

/**
 * @author cchaubey
 *
 */
@Data
public class UserDto {

	private Long userID;
	
	private String userName;
	
	private String password;
	
	private String firstName;
	
	private String lastName;

	

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
