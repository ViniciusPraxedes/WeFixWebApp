package com.example.wefixwebapp.payment;


import com.example.wefixwebapp.customer.Customer;
import com.example.wefixwebapp.customer.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.time.LocalDateTime;

@Controller
public class PaymentController {
    private CustomerRepository customerRepository;
    private PaymentRepository paymentRepository;

    public PaymentController(CustomerRepository customerRepository, PaymentRepository paymentRepository) {
        this.customerRepository = customerRepository;
        this.paymentRepository = paymentRepository;
    }

    @RequestMapping(value = "/WeFix/customer/phone/service/payment",method = RequestMethod.GET)
    public String displayPaymentPage(ModelMap paymentModel){
        Payment payment = new Payment(0,"",0,"", LocalDateTime.now(),false);
        paymentModel.addAttribute("payment",payment);
        return "paymentPage";
    }
    @RequestMapping(value = "/WeFix/customer/phone/service/payment",method = RequestMethod.POST)
    public String submitPaymentForm(@Valid @ModelAttribute("payment") Payment payment, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "paymentPage";
        }
        int counter = (int) customerRepository.count();
        String name = customerRepository.getReferenceById(counter).getName();
        System.out.println(name);
        payment.setCustomerName(name);
        payment.setPaid(true);
        payment.setTime(LocalDateTime.now());
        paymentRepository.save(payment);
        System.out.println(payment);
        return "paymentSuccess";
    }
}
