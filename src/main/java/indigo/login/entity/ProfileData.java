package indigo.login.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "ProfileData")
public class Data implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2896849150443394377L;

	@Id
	private Long id;
	private String email;
	@Column(insertable = false, updatable = false)
	private String phone;
	@Column(insertable = false, updatable = false)
	private String password;




}
