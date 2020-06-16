package org.vladirius.classicmodel.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vladirius.classicmodel.data.models.OrdersEntity;

@Repository
public interface OrdersRepository extends CrudRepository<OrdersEntity, Long>{

}
