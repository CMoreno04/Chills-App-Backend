package com.chillisrestaurant.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SpaRedirectController {

    @RequestMapping(value = "/**/{[path:[^\\.]*}")
    public RedirectView redirect() {
        return new RedirectView("/");
    }
}
