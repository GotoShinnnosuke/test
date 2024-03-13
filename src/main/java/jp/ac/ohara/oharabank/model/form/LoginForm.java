package jp.ac.ohara.oharabank.model.form;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class LoginForm {
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;
	
}
