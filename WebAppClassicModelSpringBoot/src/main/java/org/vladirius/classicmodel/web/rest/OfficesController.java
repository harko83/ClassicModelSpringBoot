package org.vladirius.classicmodel.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vladirius.classicmodel.data.models.OfficesEntity;
import org.vladirius.classicmodel.service.OfficesServices;

@RestController
public class OfficesController {
	@Autowired
	private OfficesServices services;
	
	@RequestMapping("/offices")
	public List<OfficesEntity> getOffices(){
		return services.getOffices();
	}
	
	@RequestMapping("/offices/{id}")
	public OfficesEntity getOffice(@PathVariable int id) {
		return services.getOffice(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/offices")
	public void addOffice(@RequestBody OfficesEntity listElement) {
		services.addPost(listElement);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/offices/{id}")
	public void updateOffice(@RequestBody OfficesEntity office) {
		services.updateOffice(office);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/offices/{id}")
	public void DeleteOffice(@PathVariable int id) {
		services.deleteOffice(id);
	}
}
