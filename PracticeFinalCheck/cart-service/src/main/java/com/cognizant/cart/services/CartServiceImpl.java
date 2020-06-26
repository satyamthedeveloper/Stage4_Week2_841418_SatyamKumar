package com.cognizant.cart.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ExchangeServiceProxy.MenuItemExchangeServiceProxy;
import com.cognizant.cart.dao.CartDao;
import com.cognizant.cart.exceptions.ItemNotFoundException;
import com.cognizant.cart.model.Cart;
import com.cognizant.cart.model.MenuItem;

import lombok.extern.slf4j.Slf4j;

//Implements Service Interface of Cart
@Slf4j
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	MenuItemExchangeServiceProxy proxyService;

	@Autowired
	CartDao cartDao;

	@Override
	public void addCartItem(int userId, int menuItemId) throws ItemNotFoundException {
		log.debug("START");
		
		MenuItem item = proxyService.findMenuItemById(menuItemId);
		if(item == null) {
			throw new ItemNotFoundException();
		}
		
		Cart cart = new Cart();
		cart.setItem_id(menuItemId);
		cart.setUser_id(userId);
		cartDao.save(cart);
		log.debug("END");
	}

	@Override
	public ArrayList<MenuItem> getAllCartItems(int userId) {
		log.debug("START");
		
		if(cartDao.findUserIdCount(userId) == 0) {
			return null;
		}
		
		ArrayList<Cart> cartList = cartDao.findByUserId(userId);
		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		log.debug(Integer.toString(menuItemList.size()));
		log.debug(menuItemList.toString());
		if(cartList != null)
		{
		for(Cart cart:cartList) {
			MenuItem menuItem = proxyService.findMenuItemById(cart.getItem_id());
			menuItemList.add(menuItem);
		}
		}
		log.debug("task executed.");
		return menuItemList;
	}

	@Override
	public void deleteCartItem(int userId, int menuItemId) {
		log.debug("START");
		MenuItem menuItem = proxyService.findMenuItemById(menuItemId);
		ArrayList<Cart> cartList = cartDao.findByUserId(userId);
		Cart delCart = null;
		for(Cart cart:cartList) {
			if(cart.getItem_id() == menuItemId) {
				delCart = cart;
			}
			
		if(delCart != null) {
			log.debug("deleting: " + menuItem.toString());
			cartDao.delete(delCart);
		}
		}
	}

	
	
}
