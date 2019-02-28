package net.ranayo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ranayo.model.user;

/**
 * @Name : Park Jung Min
 * @Date : 2019. 02. 25.
 * @Description : User Repository
 */
@Repository
public interface userRepository extends JpaRepository<user, Long>{
	user findByusEmail(String usEmail);
}
