package main.java.MaxBoiko.introduction;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsTest1 {

    //@Test
    public void regular() {

        ArrayList<String> names = new ArrayList<String>();
        names.add("Alex");
        names.add("Don");
        names.add("John");
        names.add("Max");
        names.add("Anton");
        names.add("Abby");

        int count = 0;

        for (int i = 0; i < names.size(); i++) {
            String actualName = names.get(i);
            if (actualName.startsWith("A")) {
                count++;
            }
        }

        System.out.println(count);
    }

    @Test
    public void streamFilter() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Alex");
        names.add("Don");
        names.add("John");
        names.add("Max");
        names.add("Anton");
        names.add("Abby");

        for (int i = 0; i < names.size() ; i++) {
            String singleName = names.get(i);
            if(singleName.length()>3) {
                System.out.println("Traditional way: " + singleName);
            }
        }

        Long c = names.stream().filter(s->s.startsWith("A")).count();
        System.out.println("c is: " + c);

        long d = Stream.of("Alex", "Don", "John", "Max", "Anton", "Abby").filter(s->{
            s.startsWith("A");
            //return false;
            return true;
        }).count();
        System.out.println("d is: " + d);

        names.stream().filter(s->s.length()>3).forEach(s-> System.out.println("Stream way: " + s));
        //limited result
        names.stream().filter(s->s.length()>3).limit(1).forEach(s-> System.out.println("Stream way limited: " + s));

    }

    @Test
    public void streamMap() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Alex");
        names.add("Don");
        names.add("John");
        names.add("Max");
        names.add("Anton");
        names.add("Abby");

        //list with the last letter "n" and all the names are with Uppercase
        Stream.of("Alex", "Don", "John", "Max", "Anton", "Abby")
                .filter(s->s.endsWith("n")).map(s->s.toUpperCase()).forEach(s-> System.out.println(s));

        //sorted list
        List<String> namesSorted = Arrays.asList("Alex", "Don", "John", "Max", "Anton", "Abby");
        namesSorted.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).sorted()
                .forEach(s-> System.out.println("Sorted list: " + s));

        //merge the lists
        Stream<String> newStream = Stream.concat(names.stream(),namesSorted.stream());
        //newStream.sorted().forEach(s-> System.out.println(s));

        boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Anton"));
        Assert.assertTrue(flag);
    }

    @Test
    public void streamCollect() {

        List<String> newList = Stream.of("Alex", "Don", "John", "Max", "Anton", "Abby").filter(s->s.endsWith("n"))
                .map(s->s.toUpperCase()).collect(Collectors.toList());
        newList.stream().limit(1).forEach(s-> System.out.println(s));
        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
        }

        List<Integer> numbers = Arrays.asList(1,4,3,1,7,9,10,7,11,3);
        //numbers.stream().distinct().sorted().forEach(s-> System.out.println(s));
        List<Integer> listOfNumbers = numbers.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("3rd element is: " + listOfNumbers.get(2));

    }
}
