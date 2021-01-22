package streamapi;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class MyStreamApi {
    public static void main(String[] args) {
        List<Integer> collection = new Random()
                .ints(0, 20)
                .limit(20)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
        log.info(String.valueOf(collection));

        List<Integer> multipleTwiceCollection = collection
                .stream()
                .map(o -> o * 2)
                .collect(Collectors.toList());
        log.info(String.valueOf(multipleTwiceCollection));

        System.out.println("ForEach:");
        multipleTwiceCollection
                .stream()
                .map(o -> o * 2)
                .parallel()
                .forEach(s -> System.out.print(s + " "));

        System.out.println("\nForEach Ordered:");
        multipleTwiceCollection
                .stream()
                .map(o -> o * 2)
                .parallel()
                .forEachOrdered(s -> System.out.print(s + " "));

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        Stream<Integer> stream = list.stream();
        list.add(4);
        list.add(5);
        list.add(6);
        log.info("Non-interference stream " + stream.collect(Collectors.toList()));

    }
}
