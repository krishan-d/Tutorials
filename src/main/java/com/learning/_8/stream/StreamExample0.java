package com.learning._8.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExample0 {
    /*
    Stream API:
    Stream API is used to process collections of objects.
    A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result.

    Features:
    Stream is not a data structure, instead it takes input from Collections, Arrays or I/O channels.
    Stream don't change the original data structure, only provide result as per pipelined methods.
    Each intermediate operation is lazily executed and returns a stream as a result, hence various intermediate operations can be pipelined.
    Terminal operations mark the end of the stream and return the result.

    Generating Streams:
    stream(): Returns a sequential stream considering collection as its source.
    parallelStream(): Returns a parallel Stream considering collection as its source.

    Stream Operations:
    1.Intermediate Operation: (Return Stream<T>)
        1.1 map: returns stream consisting of the results of applying the given function to thr elements of stream.
        1.2 filter: To select elements as per the Predicate passed as argument.
        1.3 sorted: To sort the stream.
        1.4 flatMap
        1.5 distinct
        1.6 limit

    2.Terminal operations: (Return a result of definite type)
        2.1 collect: Return result of intermediate operations performed on the stream.
        2.2 foeEach: To iterate through every element of the stream.
        2.3 reduce: To reduce the elements of a stream to a single value. Takes BinaryOperator as a parameter.
        2.4 anyMatch/allMatch/noneMatch
        2.5 count
        2.6 findAny/findFirst
        2.7 forEach
        2.8 min/max
        2.9 toArray
    */
    public static void main(String[] args) {

        /*
        Intermediate operations:
        */
        //Map
        List<Integer> numbers = Arrays.asList(2, 4, 7, 1, 0);
        List<Integer> square0 = numbers.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(square0);
        //OR
        List<Integer> square1 = numbers.stream().map(x -> x * x).toList();

        //Filter
        List<Integer> required_data = numbers.stream().filter(n -> n >= 2).collect(Collectors.toList());
        System.out.println("Filtered (n>=2): " + required_data);

        //sorted
        List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted: " + sorted);

        List<Integer> reverse_sorted = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("sorted using comparator: " + reverse_sorted);

        //limit
        System.out.println("limit: ");
        Random random = new Random();
        random.ints().limit(4).forEach(System.out::println);

        /*
        Terminal operations:
        */
        //collect
        Set<Integer> square_set = numbers.stream().map(x -> x * x).collect(Collectors.toSet());
        System.out.println("\nSet: " + square_set);

        //forEach
        numbers.stream().map(x -> x * x).forEach(System.out::println);

        //reduce
        int even_sum = numbers.stream().filter(x -> x % 2 == 0).reduce(0, (sum, i) -> sum + i);
        //Here, sum variable is assigned 0 as initial value and i is added to it.
        System.out.println("reduce: " + even_sum);


        //Parallel Processing:
        List<String> strings = Arrays.asList("Eve", "", "Hi", "I", "Parallel Processing", "");
        //count of empty string
        long count0 = strings.stream().filter(String::isEmpty).count();
        System.out.println("count (stream): " + count0);
        long count1 = strings.parallelStream().filter(String::isEmpty).count();
        System.out.println("count (parallelStream): " + count1);


        //Collectors:
        //To combine the result of processing on the elements of a stream.
        String merged_string = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged string: " + merged_string);

        //Statistics:
        IntSummaryStatistics statistics = numbers.stream().mapToInt(i -> i).summaryStatistics();
        System.out.println("Max: " + statistics.getMax() + " Min: " + statistics.getMin());
        System.out.println("Sum: " + statistics.getSum() + " Average: " + statistics.getAverage());

    }
}
