package org.vladirius.classicmodel.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {
	protected BaseController() {}
	
	protected ModelAndView view(ModelAndView mav, String viewName, HttpStatus httpStatus) {
		mav.setViewName(viewName);
		
		if (httpStatus !=null) {
			mav.setStatus(httpStatus);
		}
		return mav;
	}
	
    protected ModelAndView view(ModelAndView mav, String viewName) {
        return this.view(mav, viewName, null);
    }

    protected ModelAndView view(String viewName, HttpStatus httpStatus) {
        return this.view(new ModelAndView(), viewName, httpStatus);
    }

    protected ModelAndView view(String viewName) {
        return this.view(new ModelAndView(), viewName, null);
    }

    protected ModelAndView redirect(String viewName) {
        return this.view(new ModelAndView(), "redirect:" + viewName, null);
    }
}
