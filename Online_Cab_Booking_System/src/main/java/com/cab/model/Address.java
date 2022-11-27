package com.cab.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	Integer addressId;
	
	@NotNull(message = "streetNo. cannot be null")
	private String streetNo;
	
	@NotNull(message = "buildingName cannot be null")
	private String buildingName;
	
	@NotNull(message = "city cannot be null")
	private String city;
	
	@NotNull
	@Pattern(regexp="[0-9]{6}", message = "Only Valid for 6 digit indian pincode")
	private String pincode;
	
	@NotNull(message = "state cannot be null")
	private String state;
	
	@NotNull(message = "country cannot be null")
	private String country;

	public Address(@NotNull(message = "streetNo. cannot be null") String streetNo,
			@NotNull(message = "buildingName cannot be null") String buildingName,
			@NotNull(message = "city cannot be null") String city,
			@NotNull @Pattern(regexp = "[0-9]{6}", message = "Only Valid for 6 digit indian pincode") String pincode,
			@NotNull(message = "state cannot be null") String state,
			@NotNull(message = "country cannot be null") String country) {
		super();
		this.streetNo = streetNo;
		this.buildingName = buildingName;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
	}
	
	
	
	
}
