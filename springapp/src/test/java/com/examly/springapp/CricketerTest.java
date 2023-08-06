package com.examly.springapp;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CricketerTest {

    @Test
    public void testAddCricketers() {
        ArrayList<Cricketer> cricketersList = new ArrayList<>();

        cricketersList.add(new Cricketer("Virat Kohli", 32, "India"));
        cricketersList.add(new Cricketer("Steve Smith", 31, "Australia"));

        assertEquals(2, cricketersList.size(), "Number of cricketers added should be 2");
    }

    @Test
    public void testSortCricketersByName() {
        ArrayList<Cricketer> cricketersList = new ArrayList<>();
        cricketersList.add(new Cricketer("Virat Kohli", 32, "India"));
        cricketersList.add(new Cricketer("Steve Smith", 31, "Australia"));
        cricketersList.add(new Cricketer("Kane Williamson", 30, "New Zealand"));

        Collections.sort(cricketersList);

        assertEquals("Kane Williamson", cricketersList.get(0).getName(), "First cricketer should be Kane Williamson");
        assertEquals("Steve Smith", cricketersList.get(1).getName(), "Second cricketer should be Steve Smith");
        assertEquals("Virat Kohli", cricketersList.get(2).getName(), "Third cricketer should be Virat Kohli");
    }

    @Test
    public void testSortCricketersByAge() {
        ArrayList<Cricketer> cricketersList = new ArrayList<>();
        cricketersList.add(new Cricketer("Virat Kohli", 32, "India"));
        cricketersList.add(new Cricketer("Steve Smith", 31, "Australia"));
        cricketersList.add(new Cricketer("Kane Williamson", 30, "New Zealand"));

        Collections.sort(cricketersList, new CricketerAgeComparator());

        assertEquals("Kane Williamson", cricketersList.get(0).getName(), "Youngest cricketer should be Kane Williamson");
        assertEquals("Steve Smith", cricketersList.get(1).getName(), "Second youngest cricketer should be Steve Smith");
        assertEquals("Virat Kohli", cricketersList.get(2).getName(), "Oldest cricketer should be Virat Kohli");
    }
}