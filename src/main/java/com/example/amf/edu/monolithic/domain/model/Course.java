package com.example.amf.edu.monolithic.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	private Long id;
	private String name;
	private Long adminId;
}
