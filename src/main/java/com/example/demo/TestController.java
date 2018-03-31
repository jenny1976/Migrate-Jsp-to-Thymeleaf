package com.example.demo;

import com.example.demo.model.Stock;
import java.util.List;
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

        List<Stock> dummyItems = Stock.dummyItems();

//        return new ModelAndView("thymeleaf/th-page", "items", dummyItems);
        return new ModelAndView("th-page", "items", dummyItems);
    }

    @GetMapping(path = {"/jsp"})
    public ModelAndView showJspPage() {

        List<Stock> dummyItems = Stock.dummyItems();

        return new ModelAndView("jsp/welcome", "items", dummyItems);
    }

//    @GetMapping("/jsp")
//    String jspPage(Model model,@RequestParam String name) {
//        model.addAttribute("name", name);
//        return "jsp/sample";
//    }
//
//    @GetMapping("/thymeleaf")
//    String thymeleafPage(Model model,@RequestParam String name) {
//        model.addAttribute("name", name);
//        return "thymeleaf/sample";
//    }
}
