package com.yr.spring.finalex.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yr.spring.finalex.model.Payment;
import com.yr.spring.finalex.service.PaymentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Controller
public class PaymentWebController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${api.payment.url}")
    private String paymentApiUrl;

    @GetMapping("/payment/new")
    public String showPaymentForm(@RequestParam(required = false) String reservationId, Model model) {
        Payment payment = new Payment();
        payment.setReservationId(reservationId); // Pre-fill link to reservation
        
        payment.setAmount(150.75);
        payment.setMethod("Credit Card");
        
        model.addAttribute("payment", payment);
        return "paymentForm";
    }

    @PostMapping("/payment/save")
    public String processPayment(
            @ModelAttribute Payment payment,
            Model model) throws JsonProcessingException 
    {

        ObjectMapper mapper = new ObjectMapper();
        String paymentJson = mapper.writeValueAsString(payment);
        System.out.println("Form Data as JSON: " + paymentJson);

        paymentService.save(payment);

     // Fetch list of Payments from API
        ResponseEntity<List<Payment>> response = restTemplate.exchange(
                paymentApiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Payment>>() {}
        );

        List<Payment> apiPaymentList = response.getBody();
        System.out.println("Dynamic API Payment List: " + apiPaymentList);

        // Pass values to the view
        model.addAttribute("submittedJson", paymentJson);
        model.addAttribute("apiDataList", apiPaymentList);

        return "confirmation_payment";
    }
}
