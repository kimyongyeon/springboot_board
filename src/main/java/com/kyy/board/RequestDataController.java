package com.kyy.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yongyeonkim on 2016. 8. 16..
 */
@Controller
@RequestMapping("/data")
public class RequestDataController {
    @RequestMapping(value = "/param", method = RequestMethod.GET)
    public @ResponseBody String withParam(@RequestParam String foo) {
        return "Obtained 'foo' query parameter value " + foo + "";
    }
}
