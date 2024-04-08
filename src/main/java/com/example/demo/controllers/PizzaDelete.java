package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customexceptions.NotFoundException;

@Configuration
public class PizzaDelete {

    public record Response(String id, String name) {}

    @RestController
    @RequestMapping("/pizzas/{id}")
    public class Controller {

        @DeleteMapping
        public ResponseEntity<?> action(@PathVariable String id) {
            var list = new ArrayList<Response>();
            list.add(new Response("3", "pizza-3"));
            var item = list.stream().filter(pizza -> pizza.id.equals(id)).findAny().orElseThrow(() -> new NotFoundException());
            //TODO: Eliminar pizza
            System.out.println(id);
            return ResponseEntity.status(204).body(null);
            
        }

    }

}
