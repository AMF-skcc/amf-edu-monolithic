package com.example.amf.edu.monolithic.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private Long id;
	private String name;
	private Long teamId;
	private String teamName;
	private String role;
	private String email;
	private String mobile;
	private String password;

	public void erasePassword(){
		this.password=null;
	}

}
