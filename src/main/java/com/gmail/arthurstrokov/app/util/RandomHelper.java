package com.gmail.arthurstrokov.app.util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomHelper {
    RandomHelper() {
    }

    private static final Random random = new Random();

    public static List<Integer> getCollect(int count) {
        return random.ints(count, 0, Integer.MAX_VALUE).boxed().collect(Collectors.toList());
    }
}
