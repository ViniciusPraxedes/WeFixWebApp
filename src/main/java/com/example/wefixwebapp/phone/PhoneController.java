package com.example.wefixwebapp.phone;

import com.example.wefixwebapp.customer.CustomerRepository;
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
public class PhoneController {
    private PhoneRepository phoneRepository;
    private CustomerRepository customerRepository;

    public PhoneController(PhoneRepository phoneRepository, CustomerRepository customerRepository) {
        this.phoneRepository = phoneRepository;
        this.customerRepository = customerRepository;
    }

    //Display phone management page and list all phone in the database
    @RequestMapping(value = "/phoneManagement",method = RequestMethod.GET)
    public String displayAllPhones(ModelMap model){
        List<Phone> phones = phoneRepository.findAll();
        model.addAttribute("phones",phones);
        return "phoneManagementPage";
    }

    //Display add phone page
    @RequestMapping(value = "/WeFix/customer/phone", method = RequestMethod.GET)
    public String displayPhonePage(ModelMap model){
        Phone phone = new Phone(0,"", "");
        model.addAttribute("phone",phone);
        return "phonePage";
    }

    //Submit add phone form (add new phone)
    @RequestMapping(value = "/WeFix/customer/phone", method = RequestMethod.POST)
    public String submitAddPhoneForm(@Valid @ModelAttribute("phone") Phone phone, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "landingPage";
        }
        int counter = (int) customerRepository.count();
        String customerName = customerRepository.getReferenceById(counter).getName();
        phone.setCustomer(customerName);
        phone.setId(counter);
        System.out.println(phone);
        phoneRepository.save(phone);
        return "redirect:/WeFix/customer/phone/service";
    }

    //Delete phone from the database
    @RequestMapping(value = "/deletePhone")
    public String deletePhone(@RequestParam int id){
        phoneRepository.deleteById(id);
        return "redirect:phoneManagement";
    }
}
