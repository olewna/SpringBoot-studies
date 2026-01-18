package com.example.demo.service;

import com.example.demo.domain.Person;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CsvParserService {
    public Map<String, Person> parseCsvData(String csvFilePath) {
        Map<String, Person> personMap = new HashMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] nextLine;
            boolean headerSkipped = false;

            while ((nextLine = reader.readNext()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }

                String id = nextLine[0];
                String firstName = nextLine[1];
                String lastName = nextLine[2];
                String email = nextLine[3];
                int yearOfBirth = Integer.parseInt(nextLine[4]);

                Person person = new Person();
                person.setId(id);
                person.setFirstName(firstName);
                person.setLastName(lastName);
                person.setEmail(email);
                person.setYearOfBirth(yearOfBirth);

                personMap.put(id, person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return personMap;
    }
}
