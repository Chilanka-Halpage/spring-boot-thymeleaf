package csh.springbootthymeleafform.entity;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
@Entity
@Table(name = "USER_DETAILS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@NotEmpty(message = "This field must not be empty")
	private String name;
	@Email(message = "Must be a valid email like name@example.com")
	@NotEmpty(message = "This field must not be empty")
	private String email;
	private String profession;
	@NotBlank(message = "Select one option")
	private String gender;
	private String note;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
	private Date birthday;
}
