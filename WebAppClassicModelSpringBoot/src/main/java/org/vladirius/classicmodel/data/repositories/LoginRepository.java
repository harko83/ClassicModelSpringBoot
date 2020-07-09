package org.vladirius.classicmodel.data.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.vladirius.classicmodel.data.models.LoginsEntity;

@Repository
public interface LoginRepository extends CrudRepository<LoginsEntity, Integer> {

//	LoginsEntity register(LoginsEntity loginsEntity);
	
	@Query("SELECT u FROM logins u WHERE u.logins = :login")
	public LoginsEntity getUserByUsername(@Param("login") String login);
	
	
}
