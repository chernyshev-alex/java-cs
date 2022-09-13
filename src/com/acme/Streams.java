package com.acme;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Streams {
    public Map<String, Double> averageGroupByName(String[][] rows) {
        return Arrays.stream(rows).collect(
                Collectors.groupingBy(r -> r[0],
                        Collectors.averagingInt(r -> Integer.parseInt(r[1]))));
    }
}
