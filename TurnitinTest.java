package biz.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This class encapsulates the Turnitin test coding implementation.
 *
 * This test can easily be run as a JUnit test. If you want to run the test manually, eliminate the Junit import,
 * the @Test annotation on the test method, and call the test from the default constructor.
 *
 */
public class TurnitinTest {

    public TurnitinTest() {


    }

    @Test
    public void countAndSortWordFrequencyTest() {

        String text = "the cat is in the bag";

        List<String> wordList = Arrays.asList(text.split("\\s+"));

        Map<String,Long> wordMap = wordList.stream()
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> {
                            throw new IllegalStateException();
                        }));

        wordMap.entrySet().forEach(e -> {
            System.out.println(e.getValue() + " " + e.getKey());
        });
    }
}
