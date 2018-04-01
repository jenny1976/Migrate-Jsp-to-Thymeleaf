package com.example.demo;

import com.example.demo.model.Stock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jennifer Schulz, jennykroete.gmx.de
 */
@RestController
public class TestController {

    @GetMapping(path = {"/thymeleaf"})
    public ModelAndView showPage() {

        return new ModelAndView("stocks", "items", Stock.dummyItems());
    }

    @GetMapping(path = {"/jsp"})
    public ModelAndView showJspPage() {

        return new ModelAndView("jsp/welcome", "items", Stock.dummyItems());
    }

    @GetMapping(path = {"/mixed"})
    public ModelAndView mixedPage() {

        return new ModelAndView("jsp/mixed", "items", Stock.dummyItems());
    }
}
