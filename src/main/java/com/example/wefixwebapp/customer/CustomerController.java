package com.example.wefixwebapp.customer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/WeFix/customer", method = RequestMethod.GET)
    public String displayCustomerPage(ModelMap model){
        Customer customer = new Customer(0,"","","");
        model.addAttribute("customer",customer);
        return "customerPage";
    }
    @RequestMapping(value = "/WeFix/customer", method = RequestMethod.POST)
    public String submitCustomerPageForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult,HttpServletRequest request,HttpSession httpSession){
        if(bindingResult.hasErrors()){
            return "customerPage";
        }
        String customerName = request.getParameter("name");
        httpSession.setAttribute("customerName",customerName);
        customerRepository.save(customer);
        System.out.println(customer);
        return "redirect:/WeFix/customer/phone";
    }
}
