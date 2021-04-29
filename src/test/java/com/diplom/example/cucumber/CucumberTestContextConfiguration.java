package com.diplom.example.cucumber;

import com.diplom.example.DiplomayinApp;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = DiplomayinApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
