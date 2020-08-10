package org.vladirius.classicmodel.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.vladirius.classicmodel.data.models.Item;
import org.vladirius.classicmodel.service.ProductsService;

@Controller
@RequestMapping("/client/cart")
public class CartController {
	@Autowired
	private ProductsService productsService;
	
	/*
	 * Afficher le panier
	 */
	@GetMapping("")
	public ModelAndView cart(HttpSession session) {
		ModelAndView mav = new ModelAndView("cart");
		mav.addObject("totalCart", total(session));
		return mav;
	}
	
	/*
	 * Ajouter un article au panier
	 */
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

	/*
	 * Enlever un article du panier
	 */
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable("id") String productCode, HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = isExist(productCode, cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "redirect:../../cart";
	}
	
	/*
	 * Actualiser le panier
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		String[] quantities = request.getParameterValues("quantity");
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		for (int i = 0; i < cart.size(); i++) {
			cart.get(i).setQuantity(Integer.parseInt(quantities[i]));
		}
		session.setAttribute("cart", cart);
		return "redirect:/client/cart";
	}
	
	/*
	 * Valider le panier
	 */
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkOut(HttpSession session) {
		if (session.getAttribute("username") == null) {
			return "redirect:/client/cart";
		} else {
			return null;
		}
	}


	/*
	 * Verifier si article existe deja
	 */
	private int isExist(String id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getProductCode().equalsIgnoreCase(id)) {
				return i;
			}
		}
		return -1;
	}
	
	private Double total(HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		double s = 0.00d;
		if (cart != null) {
			for (Item item : cart) {
				s += item.getQuantity() * item.getProduct().getMSRP();
			}
			return s;
		}
		return s;
	}

}
