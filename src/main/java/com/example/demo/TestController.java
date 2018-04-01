package com.example.demo;

import com.example.demo.model.Stock;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jennifer Schulz, jennykroete.gmx.de
 */
@RestController
public class TestController {

    @GetMapping(path = {"/thymeleaf"})
    public ModelAndView showPage() {

        ModelAndView model = new ModelAndView("stocks");
        model.addObject("items", Stock.dummyItems());
        return model;

//        return getDefaultView(Optional.of("thymeleaf"), "/stocks");
    }

    @GetMapping(path = {"/jsp"})
    public ModelAndView showJspPage() {

        return getDefaultView(Optional.empty(), "/welcome");
    }

    private ModelAndView getDefaultView(Optional<String> viewResolver, String viewName) {
        ModelAndView model = new ModelAndView(createView(viewResolver, viewName));
        model.addObject("items", Stock.dummyItems());
        return model;
    }

    private String createView(Optional<String> viewResolver, String viewName) {
        String result = viewResolver.isPresent() ? viewResolver.get() : "jsp";
        result += viewName;
        return result;
    }
}
