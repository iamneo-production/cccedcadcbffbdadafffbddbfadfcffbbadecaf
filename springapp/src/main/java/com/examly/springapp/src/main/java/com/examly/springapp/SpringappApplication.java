package com.examly.springapp;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.examly")
public class SpringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringappApplication.class, args);

		ArrayList<Cricketer> cricketersList = new ArrayList<>();

        cricketersList.add(new Cricketer("Virat Kohli", 32, "India"));
        cricketersList.add(new Cricketer("Steve Smith", 31, "Australia"));
        cricketersList.add(new Cricketer("Kane Williamson", 30, "New Zealand"));

        // Add more cricketers as needed

        // Sort by name using Comparable
        Collections.sort(cricketersList);

        // Print the cricketers sorted by name
        System.out.println("Cricketers sorted by name:");
        for (Cricketer cricketer : cricketersList) {
            System.out.println("Name: " + cricketer.getName() +
                    ", Age: " + cricketer.getAge() +
                    ", Country: " + cricketer.getCountry());
        }

        // Sort by age using Comparator
        Collections.sort(cricketersList, new CricketerAgeComparator());

        // Print the cricketers sorted by age
        System.out.println("Cricketers sorted by age:");
        for (Cricketer cricketer : cricketersList) {
            System.out.println("Name: " + cricketer.getName() +
                    ", Age: " + cricketer.getAge() +
                    ", Country: " + cricketer.getCountry());
        }
	}

}
