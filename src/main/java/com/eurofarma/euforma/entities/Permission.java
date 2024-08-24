package com.eurofarma.euforma.entities;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "permission")
public class Permission implements GrantedAuthority{
	

}
