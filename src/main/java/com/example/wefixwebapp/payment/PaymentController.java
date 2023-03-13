package com.example.wefixwebapp.payment;

import com.example.wefixwebapp.customer.CustomerRepository;
import com.example.wefixwebapp.service.ServiceRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;


@Controller
public class PaymentController {
    private CustomerRepository customerRepository;
    private PaymentRepository paymentRepository;
    private ServiceRepository serviceRepository;

    public PaymentController(CustomerRepository customerRepository, PaymentRepository paymentRepository, ServiceRepository serviceRepository) {
        this.customerRepository = customerRepository;
        this.paymentRepository = paymentRepository;
        this.serviceRepository = serviceRepository;
    }

    //Display phone management page and list all payments
    @RequestMapping(value = "/paymentManagement", method = RequestMethod.GET)
    public String displayAllPayments(ModelMap model){
        List<Payment> payments = paymentRepository.findAll();
        model.addAttribute("payments",payments);
        return "paymentManagementPage";
    }

    //Display add payment page
    @RequestMapping(value = "/WeFix/customer/phone/service/payment",method = RequestMethod.GET)
    public String displayPaymentPage(ModelMap paymentModel){
        Payment payment = new Payment(0,"",0,"", LocalDateTime.now(),false);
        paymentModel.addAttribute("payment",payment);
        return "paymentPage";
    }

    //Submit add payment form(adds a new payment)
    @RequestMapping(value = "/WeFix/customer/phone/service/payment",method = RequestMethod.POST)
    public String submitPaymentForm(@Valid @ModelAttribute("payment") Payment payment, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "paymentPage";
        }
        int counter = (int) customerRepository.count();
        String customerName = customerRepository.getReferenceById(counter).getName();
        String serviceName = serviceRepository.getReferenceById(counter).getServiceName();
        payment.setServiceName(serviceName);
        payment.setCustomerName(customerName);
        payment.setPaid(true);
        payment.setTime(LocalDateTime.now());
        paymentRepository.save(payment);
        System.out.println(payment);
        return "paymentSuccess";
    }

    //Marks a payment as paid
    @RequestMapping("updateIsPaid")
    public String updateIsPaid(@RequestParam int id){
        Payment payment = paymentRepository.getReferenceById(id);
        paymentRepository.deleteById(id);
        payment.setPaid(true);
        paymentRepository.save(payment);
        return "redirect:paymentManagement";
    }

    //Marks a payment as unpaid
    @RequestMapping("updateIsPaidAgain")
    public String updateIsPaidAgain(@RequestParam int id){
        Payment payment = paymentRepository.getReferenceById(id);
        paymentRepository.deleteById(id);
        payment.setPaid(false);
        paymentRepository.save(payment);
        return "redirect:paymentManagement";
    }

    //Delete payment
    @RequestMapping("deletePayment")
    public String deletePayment(@RequestParam int id){
        paymentRepository.deleteById(id);
        return "redirect:paymentManagement";
    }
}
