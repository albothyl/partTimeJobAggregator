package com.java.partTimeJob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2015-05-24.
 */
@Slf4j
@Controller
public class HealthCheckController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public ModelAndView healthCheck() {
        log.info("healthCheck in");
        return new ModelAndView("healthCheck");
    }
}
