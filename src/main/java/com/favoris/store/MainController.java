package com.favoris.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by uer on 12.06.20.
 */
@Controller
public class MainController {
    @RequestMapping("/")
    @ResponseBody
    String index(){
        return "Work";
    }
}
