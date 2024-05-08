package indigo.login.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "profile_data")
public class ProfileData implements Serializable {
	private static final long serialVersionUID = 2896849150443394377L;

	@Id
	private String email;
	private String phone;
	private String password_user;



}
