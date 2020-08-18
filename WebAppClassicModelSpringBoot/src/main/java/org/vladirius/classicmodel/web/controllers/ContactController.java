package org.vladirius.classicmodel.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.vladirius.classicmodel.data.models.ContactEntity;
import org.vladirius.classicmodel.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	ContactService contactService;
	
	//show the contact form and also pass an empty backing bean object to store the form field values
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView contact() {
		
		return new ModelAndView("contact", "contactMSG", new ContactEntity());
	}
	
	//Get the form field values which are populated using the backing bean and store it in db
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public ModelAndView sendMessage(@ModelAttribute("contactMSG") ContactEntity contactEntity) {
		
		contactService.addMessage(contactEntity);
		
		return new ModelAndView("redirect:/index");
	}
	
}
