package org.vladirius.classicmodel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vladirius.classicmodel.data.models.OfficesEntity;
import org.vladirius.classicmodel.data.repositories.OfficesRepository;
@Service
public class OfficesServices {
	@Autowired
	private OfficesRepository repo;
	
	public List<OfficesEntity> getOffices(){
		List<OfficesEntity> officeList = new ArrayList<OfficesEntity>();
		for(OfficesEntity office: repo.findAll()) {
			officeList.add(office);
		}
		return officeList;
	}

	public OfficesEntity getOffice(int id) {
		return repo.findById(id).get();
	}

	public void addPost(OfficesEntity listElement) {
		repo.save(listElement);
	}

	public void updateOffice(OfficesEntity office) {
		repo.save(office);
	}

	public void deleteOffice(int id) {
		repo.deleteById(id);
	}
}
