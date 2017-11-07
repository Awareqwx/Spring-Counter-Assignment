package com.awareqwx.Counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController
{

    @RequestMapping("/")
    public String index(HttpSession session)
    {
        session.setAttribute("count", session.getAttribute("count") == null ? 1 : (int) session.getAttribute("count") + 1);
        return "index.jsp";
    }
    
    @RequestMapping("/counter")
    public String counter(Model model, HttpSession session)
    {
        model.addAttribute("times", session.getAttribute("count") == null ? 0 : (int) session.getAttribute("count"));
        return "counter.jsp";
    }
    
    @RequestMapping("/reset")
    public String reset(HttpSession session)
    {
        session.invalidate();
        return "redirect:/";
    }
    
}
