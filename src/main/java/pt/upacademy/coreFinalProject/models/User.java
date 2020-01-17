package pt.upacademy.coreFinalProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = User.GET_ALL_USERS, query = "SELECT u FROM User u")
})
public class User extends EntityRoot {

	private static final long serialVersionUID = 1L;

	public static final String GET_ALL_USERS = "getAllUsers";
	
	private String username;
	private String email;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
	private String hashcode;
	private String salt;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashcode() {
		return hashcode;
	}

	public void setHashcode(String hashcode) {
		this.hashcode = hashcode;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", role=" + role + ", hashcode=" + hashcode
				+ ", salt=" + salt + "]";
	}

	
}
