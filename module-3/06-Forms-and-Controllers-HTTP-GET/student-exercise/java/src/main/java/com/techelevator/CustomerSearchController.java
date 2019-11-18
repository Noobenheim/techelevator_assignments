package com.techelevator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.dao.CustomerDao;
import com.techelevator.dao.model.Customer;

@Controller
public class CustomerSearchController {

    @Autowired
    private CustomerDao customerDao;
    
    
    @RequestMapping(path = "/customerSearch", method = RequestMethod.GET)
    public String showCustomerSearchForm() {
    	System.out.println("Displaying empty form");
    	
    	return "customerList";
    }
    
    @RequestMapping(path = "/customerSearchResults", method = RequestMethod.GET)
    public String showCustomerSearchResults(@RequestParam String customerName, @RequestParam String sortBy, ModelMap m) {
    	System.out.println("Got search data");

    	if(!customerName.isEmpty()) {
    		List<Customer> customers = customerDao.searchAndSortCustomers(customerName, sortBy);
    		m.put("customers", customers);
    	}
    	return "customerList";
    }

}