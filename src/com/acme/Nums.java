package com.acme;

import com.sun.tools.javac.util.ArrayUtils;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public  class Nums {
    public Optional<Character> firstNonRepeatedCharacterWithMap(String s) {
        Map<Character, Integer> map  = new HashMap();
        for (char c : s.toCharArray()) {
           map.compute(c, (k, v) -> v == null ? 1 : v+1);
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                return Optional.of(e.getKey());
            }
        }
        return Optional.empty();
    }

    public char firstNonRepeatedCharacter(String s) {
        // not first but any
        int[] cnt = new int[256];
        for (char c : s.toCharArray()) {
            cnt[c] += 1;
        }
        for (int i = 0; i < cnt.length ; i++) {
            if (cnt[i] == 1) {
                return (char)i;
            }
        }
        return (char)0;
    }

    public String findLargestNumber(List<String> ls) {
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String probe1 = o1 + o2;
                String probe2 = o2 + o1;
                return probe2.compareTo(probe1);
            }
        };
        ls.sort(comp);
        return ls.stream().collect(Collectors.joining());
    }

    public int numberOfDigits(int n) {
        // 10 =2 ; 100 = 3; 1000 =4;
        return 1 + (int) Math.log10(n);
    }

    public Stream<Integer> generateFibo(int limit)  {
        return Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(limit)
                .map(n -> n[0]);
    }

    public Boolean IsPrime(Integer i) {
        if (i <= 1)
            return  false;
        else if (i==2)
            return true;
        boolean result =  false;
        for (int n =2; n < i; n++) {
            if (i % n == 0)
               return false;
        }
        return  true;
    }

    public Boolean IsPrimeStream(Integer i) {
        return i > 1 && IntStream.range(2, i).noneMatch(n -> i % n == 0);
    }

    public Boolean IsPrimeErat(Integer n)  {
        return  IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(i -> n % i == 0);
    }

    public List<Integer> generatePrime(Integer n)  {
        return IntStream.range(2, n)
                        .filter(number -> IntStream.range(2,number)
                                .noneMatch(divider -> number % divider == 0))
                        .boxed()
                        .collect(Collectors.toList());

    }

    public int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return  count;
    }

    public int numDupDigitsAtMostN(int n)  {
        Function<char[], Integer> dups = (chars) -> {
            final byte[] map_counts = new byte[255];
            for (char c: chars) {
                map_counts[(char)c]++;
                if (map_counts[(char)c] == 2) {
                    return 1;
                }
            }
            return  0;
        };

        int result = 0;
        for (int i =0; i <= n; i++ ) {
            String s = String.valueOf(i);
            result += dups.apply(s.toCharArray());
        }
        return result;
    }
}
