package kr.ac.hansung.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Offer {
	
	private int id;
	
	@NotNull(message="The year cannot be empty")
	private int year;
	
	@NotNull(message="The semestercannot be empty")
	private int semester;
	
	@NotEmpty(message="The className cannot be empty")
	private String className;
	
	@NotEmpty(message="The classification cannot be empty")
	private String classification;
	
	@NotEmpty(message="The profName cannot be empty")
	private String profName; 
	
	@NotNull(message="The grade cannot be empty")
	private int grade;
	

}
