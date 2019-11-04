package com.techelevator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.dao.CustomerDao;
import com.techelevator.dao.model.Customer;

@Controller
public class CustomerSearchController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping("/customerSearch")
    public String showCustomerSearchForm(ModelMap modelHolder) {
    	return "customerList";
    }
    
    @RequestMapping("/customerResult")
    public String searchCustomers(@RequestParam String search, @RequestParam String sort, ModelMap modelHolder) {
    	List<Customer> customers = customerDao.searchAndSortCustomers(search, sort);
    	
    	modelHolder.put("customers", customers);
    	
    	return "customerList";
    }
}