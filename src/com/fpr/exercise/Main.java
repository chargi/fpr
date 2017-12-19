package com.fpr.exercise;

/*
    Functional Interfaces
    Interface name Arguments Returns Example
    Predicate<T> T boolean Has this album been released yet?
    Consumer<T> T void Printing out a value
    Function<T,R> T R Get the name from an Artist object
    Supplier<T> None T A factory method
    UnaryOperator<T> T T Logical not (!)
    BinaryOperator<T> (T, T) T Multiplying two numbers (*)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Consumer<Object> lambdaPrint = System.out::println;

        //PolyMap
        {
            List<Integer> test1 = new ArrayList<>(Arrays.asList(1, 4, 10, 15));
            List<Double> test2 = new ArrayList<>(Arrays.asList(.0, 1.5, 200.09));
            List<String> test3 = new ArrayList<>(Arrays.asList("Peter", "Paula", "Fritz", "Party"));


            System.out.println("===Map===\n");
            PurePolymorphicMap.polyMap(test1, (x) -> x + x)
                    .stream()
                    .forEach(lambdaPrint);
            PurePolymorphicMap.polyMap(test2, (x) -> x + 100)
                    .stream()
                    .forEach(lambdaPrint);
            PurePolymorphicMap.polyMap(test3, (x) -> (String) x.concat(" "))
                    .stream()
                    .forEach(lambdaPrint);
        }

        //PolyFold
        {
            System.out.println("===Fold===\n");
            List<Integer> test1 = new ArrayList<>(Arrays.asList(1, 4, 10, 15));
            List<Double> test2 = new ArrayList<>(Arrays.asList(.0, 1.5, 200.09));
            List<String> test3 = new ArrayList<>(Arrays.asList("Peter", "Paula", "Fritz", "Party"));


            PurePolymorphicFold.polyFold(test1, 0, (x, y) -> x + y)
                    .stream()
                    .forEach(lambdaPrint);

            PurePolymorphicFold.polyFold(test2, 1.0, (x, y) -> x * y)
                    .stream()
                    .forEach(lambdaPrint);

            PurePolymorphicFold.polyFold(test3, "Themen: ", (x, y) -> x + y + ", ")
                    .stream()
                    .forEach(lambdaPrint);
        }
    }






    /*
    3 Pure Polymorphic Scan

    Implement Haskell’s higher-order function scan in C++ or Java.
    scans’s signature is scan :: (b −> a −> b) −> b −> [a] −> [b], which
    means that the function has three arguments:
    1. a function f :: b −> a −> b, which means a function with two arguments,
    returning a result of the first argument’s type.
    2. an initial scan value of type b.
    3. a list of elements of type a.
    scan is similar to fold, but returns a list successive reduced values:
    • apply f to the initial value and the first element of the input list gives the
    first element of the output list.
    • the nth output element is f applied to the nth input element and the
    n − 1st output element.
    • repeat/recurse until you reach the end of the input list.
    Implement at three example inputs for your scan function. Each
    input must be of a different type (int, string, float, a type/class you define,. . . ).

    • Example: scan + 0 [1 2 3 4] should return [1 3 6 10]
    • Example: scan ∗ 3 [1 2 3 4] should return [3 6 18 72]
    • As with the map exercise, make sure your solution is pure and polymorphic.
     */

    /*
    4 Higher-Order Divide and Conquer

    Implement a polymorphic higher-order function that solves problems with the
    divide and conquer algorithm (for information, see: http://en.wikipedia.
    org/wiki/Divide_and_conquer_algorithm) A divide and conquer (DaC) algorithm
    on an input works as follows:
    1. if the solution is trivial for the input, solve it.
    2. if the solution is not trivial, divide the input list into two parts.
    3. recursively solve each parts individually. (i.e., if their solution is
    not trivial, divide them again)
    4. combine both parts to the final result.
    Implement a function divideAndConquer that takes four functions and one
    DaC problem instance as input. The four functions represent the stages of
    the divide and conquer algorithm:
    1. trivial :: a −> bool: determine if an input can be solved
    2. solve :: a −> b: solve a trivial input, return result of type b
    3. divide :: a −> (a,a): divide the (non-trivial) input into two smaller inputs.
    4. combine :: (b,b) −> b: combine two results of type b into one result.
    The fifth and final input of divideAndConquer is the actual input problem to
    solve.
    Implement the following:
    1. the quickSort algorithm using the divideAndConquer higher-order function.
    2. a DaC algorithm that is not sorting (search the web for DaC examples)

    The quickSort function from the course slides is a classic example of a divide
    and conquer algorithm. It works as follows:
    • the input type is a list [a], the output is a sorted list of the same type
    • the input is trivial if the list has at most one element.
    • the solution of a trivial list is the list itself, as it is already sorted.
    • divide the list into two parts based on the pivot element: one part contains
    all elements that are smaller than the pivot element, the second part all
    others.
    • combine two lists by simply appending one to the other (i.e., concatenate
    them).
    As with the previous exercises:
    • make sure your solution is pure and polymorphic.
    • use lambda expressions and std::function (C++) or SAMs (Java) to implement
    function objects.
     */


}
