package com.example.wefixwebapp.service;

import com.example.wefixwebapp.customer.CustomerRepository;
import com.example.wefixwebapp.phone.PhoneRepository;
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
public class ServiceController {
    private ServiceRepository serviceRepository;
    private CustomerRepository customerRepository;
    private PhoneRepository phoneRepository;

    public ServiceController(ServiceRepository serviceRepository, CustomerRepository customerRepository, PhoneRepository phoneRepository) {
        this.serviceRepository = serviceRepository;
        this.customerRepository = customerRepository;
        this.phoneRepository = phoneRepository;
    }

    //Display service management page and list all the services
    @RequestMapping(value = "/serviceManagement",method = RequestMethod.GET)
    public String displayAllServices(ModelMap model){
        List<Service> services = serviceRepository.findAll();
        model.addAttribute("services",services);
        return "serviceManagementPage";
    }
    //Display add service page
    @RequestMapping(value = "/WeFix/customer/phone/service", method = RequestMethod.GET)
    public String displayBudgetingPage(ModelMap model){
        Service service = new Service(0,"","","","",false);
        model.addAttribute("service",service);
        return "servicePage";
    }
    //Submit the add service form(adds a new service)

    @RequestMapping(value = "/WeFix/customer/phone/service", method = RequestMethod.POST)
    public String submitService(ModelMap model,@Valid @ModelAttribute("service") Service service, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "landingPage";
        }
        int counter = (int) customerRepository.count();
        service.setId(counter);

        if (service.getServiceName().equals("hardware fix")){
            service.setDescription("we will fix your hardware");
        }
        if (service.getServiceName().equals("screen repair")){
            service.setDescription("we will fix your screen");
        }
        if (service.getServiceName().equals("check up")){
            service.setDescription("we will do a check up");
        }

        String customerName = customerRepository.getReferenceById(counter).getName();
        String phoneModel = phoneRepository.getReferenceById(counter).getModel();
        service.setCustomerName(customerName);
        service.setPhoneModel(phoneModel);
        System.out.println(service);
        serviceRepository.save(service);
        return "redirect:/WeFix/customer/phone/service/payment";
    }
    //Update the boolean isDone to true(Marks the service as done)
    @RequestMapping(value = "updateServiceStatus")
    public String updateServiceStatus(@RequestParam int id){
        Service service = serviceRepository.getReferenceById(id);
        serviceRepository.deleteById(id);
        service.setDone(true);
        serviceRepository.save(service);
        return "redirect:serviceManagement";
    }
    //Update the boolean isDone to false(Marks the service as undone)
    @RequestMapping(value = "updateServiceStatusAgain")
    public String updateServiceStatusAgain(@RequestParam int id){
        Service service = serviceRepository.getReferenceById(id);
        serviceRepository.deleteById(id);
        service.setDone(false);
        serviceRepository.save(service);
        return "redirect:serviceManagement";
    }
    //Delete the service
    @RequestMapping(value = "deleteService")
    public String deleteService(@RequestParam int id){
        serviceRepository.deleteById(id);
        return "redirect:serviceManagement";
    }
}
