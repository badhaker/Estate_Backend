package com.estate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
	
	@Column(name = "id", nullable = false, updatable = false, insertable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;	
	
	@Column(name="name",nullable = false, length =   100)
	private String name;
	
	@Column(name="email",nullable = false, length = 100, unique = true)
	private String email;
	
	@Column(name ="password",nullable = false, columnDefinition = "TEXT")
	private String password;

	@Column(name ="mobile")
	private String mobile;

}
