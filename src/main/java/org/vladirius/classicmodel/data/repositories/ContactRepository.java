package org.vladirius.classicmodel.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vladirius.classicmodel.data.models.ContactEntity;
//This will be AUTO IMPLEMENTED by Spring into a Bean called contactRepository
//CRUD refers Create, Read, Update, Delete
@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, Integer> {

}
