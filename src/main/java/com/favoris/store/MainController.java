package com.favoris.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by uer on 12.06.20.
 */
@Controller
public class MainController {
    @RequestMapping("/")
    String index(){
        return "Work";
    }
}
