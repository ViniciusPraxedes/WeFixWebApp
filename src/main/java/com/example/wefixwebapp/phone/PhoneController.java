package com.example.wefixwebapp.phone;

import com.example.wefixwebapp.customer.Customer;
import com.example.wefixwebapp.customer.CustomerRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PhoneController {
    private PhoneRepository phoneRepository;

    public PhoneController(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @RequestMapping(value = "/WeFix/customer/phone", method = RequestMethod.GET)
    public String displayPhonePage(ModelMap model, HttpSession httpSession){
        String customerName = (String) httpSession.getAttribute("customerName");
        Phone phone = new Phone(0,"", customerName);
        model.put("phone",phone);
        return "phonePage";
    }
    @RequestMapping(value = "/WeFix/customer/phone", method = RequestMethod.POST)
    public String submitAddPhoneForm(@Valid @ModelAttribute("phone") Phone phone, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "landingPage";
        }
        System.out.println(phone.getModel());
        phoneRepository.save(phone);
        return "redirect:/WeFix/customer/phone/service";
    }
}
