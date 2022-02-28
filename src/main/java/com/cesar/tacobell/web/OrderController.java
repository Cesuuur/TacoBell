package com.cesar.tacobell.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

import com.cesar.tacobell.Order.Order;
import com.cesar.tacobell.data.OrderRepository;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;

    @Autowired
    // Una instancia de OrderRepository es "inyectada" directamente por Spring,
    // creo que también valdría directamente arriba
    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        orderRepo.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}


//DEPRECADO - SIN PERSISTENCIA DE DATOS
//
//@Slf4j
//@Controller
//@RequestMapping("/orders")
//public class OrderController {
//    @GetMapping("/current")
//    public String orderForm(Model model) {
//        model.addAttribute("order", new Order());
//        return "orderForm";
//    }
//
//    @PostMapping
//    public String processOrder(@Valid Order order, Errors errors) {
//        if (errors.hasErrors()) {
//            return "orderForm";
//        }
//        log.info("Order submitted: " + order);
//        return "redirect:/";
//    }
//
//}
