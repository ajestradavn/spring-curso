package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customexceptions.NotFoundException;

@Configuration
public class PizzaGet {

    public record Response(String id, String name){}

    @RestController
    @RequestMapping("/pizzas/{id}")
    public class Controller {

        @GetMapping
        public ResponseEntity<?> action(@PathVariable String id, @RequestHeader("X-DNI") String dni) {

            var list = new ArrayList<Response>();
            list.add(new Response("3", "pizza-3"));
            var item = list.stream().filter(pizza -> pizza.id.equals(id)).findAny().orElseThrow(() -> new NotFoundException());
            System.out.println(dni);
            return ResponseEntity.status(200).body(item);

        }

    }

}
