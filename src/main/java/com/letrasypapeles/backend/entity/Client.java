package com.letrasypapeles.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name="tbl_clients")
@Entity
public class Client {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(unique = true)
	private String email;

	private String password;

	private int fidelityPoints;

	//@ManyToMany(fetch = FetchType.EAGER)
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name="tbl_role_clients",
		joinColumns = @JoinColumn(name="client_id"),
		inverseJoinColumns = @JoinColumn(name="role_name")
	)
	private Set<Role> roles;
}
