package com.ontu.lab5.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloWorldController 
{
@GetMapping("/hello-world")
public String HelloWorld(){
return "Hello World";
}
}