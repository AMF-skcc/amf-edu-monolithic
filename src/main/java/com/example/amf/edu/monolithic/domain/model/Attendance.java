package com.example.amf.edu.monolithic.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
	private Long id;
	private Long courseId;
	private String courseName;
	private Long memberId;
	private String memberName;
}
