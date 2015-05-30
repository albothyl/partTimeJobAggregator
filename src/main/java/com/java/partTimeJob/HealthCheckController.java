package com.java.partTimeJob;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2015-05-24.
 */
@Controller
public class HealthCheckController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public ModelAndView healthCheck() {
        return new ModelAndView("healthCheck");
    }
}
