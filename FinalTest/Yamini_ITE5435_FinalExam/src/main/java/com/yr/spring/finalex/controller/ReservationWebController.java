package com.yr.spring.finalex.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yr.spring.finalex.model.Customer;
import com.yr.spring.finalex.model.Reservation;
import com.yr.spring.finalex.service.CustomerService;
import com.yr.spring.finalex.service.ReservationService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Controller
public class ReservationWebController {

    @Autowired
    private ReservationService reservationService;
    
    @Autowired
    private CustomerService customerService;

    @Autowired
    private RestTemplate restTemplate; // For dynamic JSON calls

    @Value("${api.reservation.url}")
    private String reservationApiUrl;

    
    // Step-1 > Show reservation form
    @GetMapping("/reservation/new")
    public String showReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservationForm";
    }

    // Step-2 > Handle form POST (Next button)
    @PostMapping("/reservation/save")
    public String processReservation(
            @ModelAttribute Reservation reservation,
            Model model) throws JsonProcessingException {

        // Convert submitted form data into JSON (Jackson)
        ObjectMapper mapper = new ObjectMapper();
        String reservationJson = mapper.writeValueAsString(reservation);
        System.out.println("Form Data as JSON: " + reservationJson);

        //Step-1:  Save Reservation in MongoDB
        reservationService.save(reservation);
        
        // Step-2: Check if customer exists by email using repository query
        Optional<Customer> existingCustomer = 
        		customerService.findByEmail(reservation.getEmail());

        if (!existingCustomer.isPresent()) {
            Customer newCustomer = new Customer();
            newCustomer.setFirstName(reservation.getFirstName());
            newCustomer.setLastName(reservation.getLastName());
            newCustomer.setEmail(reservation.getEmail());
            newCustomer.setPhoneNumber(reservation.getPhoneNumber());
            newCustomer.setReservationId(reservation.getId()); // Link reservation
            customerService.save(newCustomer);
            System.out.println("New customer created: " + newCustomer);
        } else {
            System.out.println("Customer with email " + reservation.getEmail() + " already exists. Skipping creation.");
        }
     
        // Read list of Reservations from dynamic API
        ResponseEntity<List<Reservation>> response = restTemplate.exchange(
                reservationApiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Reservation>>() {});

        List<Reservation> apiReservationList = response.getBody();

        // Passing values to confirmation page
        model.addAttribute("submittedJson", reservationJson);
        model.addAttribute("apiData", apiReservationList);

     // Step-3: Redirect to payment form, passing the reservation's id
        return "redirect:/payment/new?reservationId=" + reservation.getId();
        //return "confirmation_reservation";
    }
}
