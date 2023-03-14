package com.example.wefixwebapp.customer;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {
    private CustomerRepository customerRepository;
    private int idCounter = 0;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //Displays customer management page and displays all customers in the list
    @RequestMapping(value = "/customerManagement", method = RequestMethod.GET)
    public String displayAllCustomers(ModelMap model){
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers",customers);
        return "customerManagementPage";
    }

    //Display the add customer page
    @RequestMapping(value = "/WeFix/customer", method = RequestMethod.GET)
    public String displayCustomerPage(ModelMap model){
        Customer customer = new Customer(idCounter++,"","","");
        model.addAttribute("customer",customer);
        return "customerPage";
    }

    //Submit the add customer form(adds a new customer)
    @RequestMapping(value = "/WeFix/customer", method = RequestMethod.POST)
    public String submitCustomerPageForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "customerPage";
        }
        customer.setId(idCounter);
        customerRepository.save(customer);
        System.out.println(customer);
        return "redirect:/WeFix/customer/phone";
    }

    //Deletes customer from database
    @RequestMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam int id){
        customerRepository.deleteById(id);
        return "redirect:customerManagement";
    }
}
