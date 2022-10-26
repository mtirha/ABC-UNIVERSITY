package edu.miu.adminservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="users")
@NoArgsConstructor
@Data
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long id;

	@Column(unique = true)
	private String userNumber;

	private String firstName;
	private String lastName;

	private String email;

	private String phone_number;

	@Embedded
	private Address address;

	public static String GenerateNumber(String lastNumber, String role){
		String result = null;
		if(lastNumber == null){
			result = role.toUpperCase() + "000001" ;
		}else{
			String num = lastNumber.substring(3);
			int val = Integer.valueOf(num);
			val += 1;
			result = role.toUpperCase() + String.valueOf(val).format("%06d", val) ;
		}
		System.out.println(result);
		return result;
	}
}
