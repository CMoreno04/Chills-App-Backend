package com.chillisrestaurant.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class SpaRedirectController {

    @GetMapping(value = "/")
    public RedirectView redirect() {
        return new RedirectView("/login");
    }
}
