package com.example.usertestingapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/counter")
public class CounterController {

    private AtomicInteger count = new AtomicInteger(0);

    @GetMapping
    public String getCounterPage(Model model){
        return "counter";
    }

    @ModelAttribute("resetForm")
    public ResetForm initResetForm(){
        ResetForm result = new ResetForm();
        result.setValue(0);
        return result;
    }

    @ModelAttribute("count")
    public int initCount(){
        return count.get();
    }
}
