package org.vladirius.classicmodel.data.repositories;

import org.springframework.stereotype.Repository;
import org.vladirius.classicmodel.data.models.LoginsEntity;

@Repository
public interface LoginRepository {

	LoginsEntity register(LoginsEntity loginsEntity);
	
	
}
