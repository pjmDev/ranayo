package net.ranayo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ranayo.model.userRole;

@Repository
public interface userRoleRepository extends JpaRepository<userRole, String>{

	userRole findByurRole(String urRole);
	
}
  