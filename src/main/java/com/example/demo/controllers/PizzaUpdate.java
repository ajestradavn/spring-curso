package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customexceptions.NotFoundException;

@Configuration
public class PizzaUpdate {

    public record Request(String name) {}

    public record Response(String id, String name) {}

    @RestController
    @RequestMapping("/pizzas/{id}")
    public class Controller {

        @PutMapping
        public ResponseEntity<?> action(@PathVariable String id, @RequestBody Request request) {

            var list = new ArrayList<Response>();
            list.add(new Response("3", "pizza-3"));
            var item = list.stream().filter(pizza -> pizza.id.equals(id)).findAny().orElseThrow(() -> new NotFoundException());
            // TODO: modificar pizza
            System.out.println(request);
            return ResponseEntity.status(204).body(null);

        }

    }

}
