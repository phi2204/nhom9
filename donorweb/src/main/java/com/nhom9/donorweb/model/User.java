package com.nhom9.donorweb.model;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ho_ten;
	private String email;
	private String password;
	private String dia_chi;
	
	@ManyToOne
	@JoinColumn(name = "id_role")
	private Role role;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Collection<Donations> donations;

	public User(String ho_ten, String email, String password, String dia_chi, Role role) {
		super();
		this.ho_ten = ho_ten;
		this.email = email;
		this.password = password;
		this.dia_chi = dia_chi;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", ho_ten=" + ho_ten + ", email=" + email + ", password=" + password + ", dia_chi="
				+ dia_chi + ", role=" + role.getId() + "]";
	}
	
}
