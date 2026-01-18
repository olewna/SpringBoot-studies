package com.example.demo;

import com.example.demo.domain.Person;
import com.example.demo.service.CsvParserService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

public class DemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        CsvParserService csvParserService = new CsvParserService();

        String csvFilePath = "src/main/resources/persons.csv";
        Map<String, Person> personMap = csvParserService.parseCsvData(csvFilePath);

        for (Person person : personMap.values()) {
            System.out.println(person.toString());
        }

        context.close();
    }
}
