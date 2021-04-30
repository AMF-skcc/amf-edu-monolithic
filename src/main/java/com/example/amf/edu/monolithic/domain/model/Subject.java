package com.example.amf.edu.monolithic.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
	private Long id;
	private String name;
	private Long courseId;
	private String courseName;
	private String building;
	private String floor;
	private String roomNo;
	private Long adminId;
	private String adminName;
	private Long instructorId;
	private String instructorName;
}
