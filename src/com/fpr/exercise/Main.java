package com.fpr.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Consumer<Object> lambdaPrint = System.out::println;

        //PolyMap
        {
            List<Integer> test1 = new ArrayList<>(Arrays.asList(1, 2, 3));
            List<Double> test2 = new ArrayList<>(Arrays.asList(0., 2.5, 2000.999));
            List<String> test3 = new ArrayList<>(Arrays.asList("Peter", "Paula", "Fritz", "Party"));


            System.out.println("===Map===\n");
            PurePolymorphicMap.polyMap(test1, (x) -> x * x)
                    .forEach(lambdaPrint);

            List<Boolean> test1Bool = PurePolymorphicMap.polyMap(test1, (x) -> x > 2);
            test1Bool
                    .forEach(lambdaPrint);

            List<Long> test2Result = PurePolymorphicMap.polyMap(test2, (x) -> (long) (x + 100));
            test2Result
                    .forEach(lambdaPrint);

            PurePolymorphicMap.polyMap(test3, (x) -> x.concat(" "))
                    .forEach(lambdaPrint);
        }

        //PolyFold
        {
            System.out.println("===Fold===\n");
            List<Integer> test1 = new ArrayList<>(Arrays.asList(1, 2, 3));
            List<Double> test2 = new ArrayList<>(Arrays.asList(.0, 1.5, 200.09));
            List<String> test3 = new ArrayList<>(Arrays.asList("Peter", "Paula", "Fritz", "Party"));


            System.out.println(
                    PurePolymorphicFold.polyFold(test1, 0, (x, y) -> x + y)
            );

            System.out.println(
                    PurePolymorphicFold.polyFold(test1, 0, (x, y) -> (x + y) * 3)
            );

            System.out.println(
                    PurePolymorphicFold.polyFold(test2, 1.0, (x, y) -> x * y)
            );

            System.out.println(
                    PurePolymorphicFold.polyFold(test3, "Themen: ", (x, y) -> x + y + ", ")
            );
        }
        //PolyScan
        {
            System.out.println("===Scan===\n");
            List<Integer> test1 = new ArrayList<>(Arrays.asList(1, 2, 3));
            List<Double> test2 = new ArrayList<>(Arrays.asList(0.5, 1.5, 200.09));
            List<String> test3 = new ArrayList<>(Arrays.asList("Peter", "Paula", "Fritz", "Party"));

            List<Integer> test1Result = PurePolymorphicScan.polyScan((x, y) -> x + y, 0, test1);

            test1Result
                    .forEach(lambdaPrint);

            PurePolymorphicScan.polyScan((x, y) -> x * y, 3, test1)
                    .forEach(lambdaPrint);

            PurePolymorphicScan.polyScan((x, y) -> x * y, 1.0, test2)
                    .forEach(lambdaPrint);

            PurePolymorphicScan.polyScan((x, y) -> x + y + ", ", "Themen: ", test3)
                    .forEach(lambdaPrint);
        }

        //Divide and Conquer
        //QuickSort
        {
            System.out.println("===QuickSort===\n");
            List<Integer> test1 = new ArrayList<>(Arrays.asList(1,18,5,3,8,8,5,10,8,12,22,19,4,2));
            List<Integer> test2 = new ArrayList<>(Arrays.asList(100,500,3,4,7,9,-10));
            List<Integer> test3 = new ArrayList<>(Arrays.asList(1,1,1,1,1));

            QuickSort qs = new QuickSort();

            List<Integer> test1Result = DnCHigherOrder.divideAndConquer(
                qs.trivial,
                qs.solve,
                qs.divide,
                qs.combine,
                test1);
            test1Result.forEach(lambdaPrint);

            List<Integer> test2Result = DnCHigherOrder.divideAndConquer(
                qs.trivial,
                qs.solve,
                qs.divide,
                qs.combine,
                test2);
            test2Result.forEach(lambdaPrint);

            List<Integer> test3Result = DnCHigherOrder.divideAndConquer(
                qs.trivial,
                qs.solve,
                qs.divide,
                qs.combine,
                test3);
            test3Result.forEach(lambdaPrint);

        }

        //BinarySearch
        {
            System.out.println("===BinarySearch===\n");

            List<Integer> test1 = new ArrayList<>(Arrays.asList(1,18,5,3,8,8,5,10,8,12,22,19,4,2));
            List<Integer> test2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10));

            BinarySearch bs = new BinarySearch();

            BinarySearch.SearchParams test1ctx = new BinarySearch.SearchParams(test1,8);
            BinarySearch.SearchParams test2ctx = new BinarySearch.SearchParams(test2,10);

            BinarySearch.SearchParams<Integer> test1result = DnCHigherOrder.divideAndConquer(
                bs.trivial,
                bs.solve,
                bs.divide,
                bs.combine,
                test1ctx
            );
            System.out.println("Found "+test1result.getValue()+" in list "+test1result.getFoundValues()+" times.");

            BinarySearch.SearchParams<Integer> test2result = DnCHigherOrder.divideAndConquer(
                    bs.trivial,
                    bs.solve,
                    bs.divide,
                    bs.combine,
                    test2ctx
            );
            System.out.println("Found "+test2result.getValue()+" in list "+test2result.getFoundValues()+" times.");

        }
    }
}