package com.example.usertestingapplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/counter")
public class CounterController {

    private AtomicInteger count = new AtomicInteger(0);
}
