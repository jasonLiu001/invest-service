package cn.lands.liuwang.investservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web")
public class HomeController extends BaseController {
    /**
     * 首页
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String Index() {
        return "index";
    }

    /**
     * 登录页
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login() {
        return "login";
    }

    /**
     * 关于页
     */
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String About() {
        return "about";
    }
}
