package com.techelevator.shopping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.shopping.dao.IItemDao;
import com.techelevator.shopping.model.Item;

@RestController
@RequestMapping("/api")
public class ShoppingController {
	@Autowired
	IItemDao itemDAO;
	
	@GetMapping("/groceries")
	public List<Item> getGroceryList() {
		return itemDAO.list();
	}
	
	@PutMapping("/groceries")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Item updateGroceryItem(@RequestBody Item item) {
		return itemDAO.update(item);
	}
	
	@PutMapping("/groceries/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Item upgradeGroceryItem(@PathVariable int id) {
		Item item = itemDAO.read(id);
		item.setCompleted(!item.isCompleted());
		itemDAO.update(item);
		return item;
	}
	
	@PostMapping("/groceries")
	@ResponseStatus(HttpStatus.CREATED)
	public void addGroceryItem(@RequestBody Item item) {
		itemDAO.create(item);
	}
	
	@DeleteMapping("/groceries/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteGroceryItem(@PathVariable int id) {
		itemDAO.delete(id);
	}
}
