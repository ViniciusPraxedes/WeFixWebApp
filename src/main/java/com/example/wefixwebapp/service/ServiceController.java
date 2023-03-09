package com.example.wefixwebapp.service;

import com.example.wefixwebapp.customer.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServiceController {
    private ServiceRepository serviceRepository;

    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @RequestMapping(value = "/WeFix/customer/phone/service", method = RequestMethod.GET)
    public String displayBudgetingPage(ModelMap model){
        Service service = new Service(0,"","");
        model.put("service",service);
        return "servicePage";
    }

    @RequestMapping(value = "/WeFix/customer/phone/service", method = RequestMethod.POST)
    public String submitService(ModelMap model,@Valid @ModelAttribute("service") Service service, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "landingPage";
        }
        System.out.println(service.getServiceName());
        serviceRepository.save(service);
        return "redirect:/WeFix/customer/phone/service/payment";
    }
}
