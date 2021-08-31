package ru.sber.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ru.sber.demo.message.MessageService;

import javax.validation.Valid;

@RestController
@RequestMapping("/demo")
public class MyController {
    private static final Logger log = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private MessageService service;

    @Value("${myprop}")
    private String myValue;

    @PostMapping("/saveMessage")
    public String saveMessage(@RequestBody @Valid Message message) {
        return service.save(message);
    }

    @GetMapping("/getMessage/{id}")
    public Message getMessage(@PathVariable String id) {
        return service.get(id);
    }

    @GetMapping("/getSetting")
    public String getSetting() {
        return "value1";
    }
}
