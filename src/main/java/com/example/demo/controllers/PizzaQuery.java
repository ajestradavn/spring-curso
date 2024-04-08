package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Configuration
public class PizzaQuery {

    public record Response(String id, String name) {
    }

    @RestController
    @RequestMapping("/pizzas")
    public class Controller {

        @GetMapping
        public ResponseEntity<?> action(@RequestParam(required = false) String name,
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "10") int size) {

            var list = new ArrayList<Response>();
            list.add(new Response("2", "pizza-2"));
            return ResponseEntity.status(200).body(list);
        }

    }

}
