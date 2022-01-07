package com.cesar.tacobell;

// MÉTODO DEPRECADO AHORA USAMOS UN VIEW CONTROLLER (SOLO VEMOS UN HTML)

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// @Controller
public class HomeController {

    // @GetMapping("/")
    public String home() {
        return "home";
    } // home es el nombre del fichero que luego busca
}