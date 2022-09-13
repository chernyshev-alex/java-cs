package com.acme;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StreamsTest {
    @Test
    void GroupAverageTest() {
        String[][] rows = new String[][]{
            { "A", "40" },
            { "B", "10" },
            { "A", "60" }};

        Map<String, Double> expected =  new HashMap() {{ put("A" , 50.0); put("B" , 10.0); }};
        assertEquals(expected,  new Streams().averageGroupByName(rows));
    }

}