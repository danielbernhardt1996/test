package com.example.resttest.Controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.List;

@RestController // kan ta emot web request
public class HelloController {

    @RequestMapping("/") // kopplar metod till ett visst url   http://localhost:8080/
    public String index() {
        return "Hello!";
    }

    @RequestMapping("/hello2") //kopplar metod till ett visst url   http://localhost:8080/hello2
    public String text2() {
        return "hello 2!";
    }


    @RequestMapping("/name")
    public String nameHandler(@RequestParam String first, @RequestParam(required = false, defaultValue = "berra") String last){  //http://localhost:8080/name?first=Danne&last=Bernhardt
        return "hello "+first +" " + last;
    }

    //Lista
    @RequestMapping("/list")
    public String listTest(@RequestParam List<String> id){
        return "values "+id;
    }

    //Path
    @RequestMapping("/path/{id}")
    public String pathVarTest(@PathVariable String id){
    return "id " +id;
    }

    //HTML utseende
    @RequestMapping("/hellohtml")
    public String htmlPage(){
        return "<h1> Hello </h1>";
    }
}