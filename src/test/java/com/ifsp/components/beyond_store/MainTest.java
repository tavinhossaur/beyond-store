package com.ifsp.components.beyond_store;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private List<Double> parseSalesList(String input) {
        List<Double> salesList = new ArrayList<>();

        try {
            salesList = Arrays.stream(input.replace(",", " ").split("\\s+")).filter(s -> !s.isBlank()).map(Double::parseDouble).toList();
        } catch (Exception e) {
            return Collections.emptyList();
        }

        return salesList;
    }

    @Test
    public void testParseSalesListWithSpaces() {
        List<Double> expected = Arrays.asList(100.0, 200.0, 300.0);
        assertEquals(expected, parseSalesList("100 200 300"));
    }

    @Test
    public void testParseSalesListWithCommas() {
        List<Double> expected = Arrays.asList(10.5, 20.0, 30.25);
        assertEquals(expected, parseSalesList("10.5, 20.0, 30.25"));
    }

    @Test
    public void testParseSalesListWithMixedSeparators() {
        List<Double> expected = Arrays.asList(1.0, 2.0, 3.0);
        assertEquals(expected, parseSalesList("1, 2 3"));
    }

    @Test
    public void testParseSalesListWithInvalidInput() {
        assertEquals(Collections.emptyList(), parseSalesList("abc, 123"));
    }

    @Test
    public void testPrintMenuOptions() {
        List<String> options = Arrays.asList("Option 1", "Option 2", "Option 3");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            options.forEach(option -> System.out.println(option));
        } finally {
            System.setOut(originalOut);
        }

        String output = outContent.toString().trim();
        String expected = String.join(System.lineSeparator(), options);

        assertEquals(expected, output);
    }
} 