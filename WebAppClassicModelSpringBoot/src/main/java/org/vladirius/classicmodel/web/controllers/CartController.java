package org.vladirius.classicmodel.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.vladirius.classicmodel.data.models.Item;
import org.vladirius.classicmodel.service.ProductsService;

@Controller
@RequestMapping("/client/cart")
public class CartController {
	@Autowired
	private ProductsService productsService;
	
	@GetMapping("")
	public String cart() {
		return "cart";
	}
	
	@RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
	public String buy(@PathVariable("id") String productCode, HttpSession session) {
		if(session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>() ;
			cart.add(new Item(productsService.find(productCode), 1));
			session.setAttribute("cart", cart);
		} else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = isExist(productCode, cart);
			if (index == -1) {
				cart.add(new Item(productsService.find(productCode), 1));
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cart);
		}
		
		return "redirect:../../../products";
	}
	
	private int isExist(String id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getProductCode().equalsIgnoreCase(id)) {
				return i;
			}
		}
		return -1;
	}

}
