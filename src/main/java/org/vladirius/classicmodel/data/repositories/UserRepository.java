package org.vladirius.classicmodel.data.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.vladirius.classicmodel.data.models.LoginsEntity;

@Repository
public interface UserRepository extends CrudRepository<LoginsEntity, Long> {
	
	@Query(value = "SELECT * FROM logins as l WHERE l.login = :login", nativeQuery = true)
	LoginsEntity getUserByUsername(@Param("login")String username);
}
