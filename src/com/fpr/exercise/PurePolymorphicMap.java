package com.fpr.exercise;

    /*
    1 Pure Polymorphic Map

    Implement Haskell’s higher-order function map in C++ or Java.
    map’s signature is map :: (a −> b) −> [a] −> [b], which means that the
    function has two arguments:
    1. a function f :: a −> b, where a and b can be any type.
    2. a list of elements of type a

    map applies the function f to every element of the input list and returns the list
    of results, which is of type b
    Implement at three example inputs for your map function. Each
    input must be of a different type (int, string, double, a type/class you define,. . . ).

    • Example: map (\x−> x∗x) [1 2 3] should return [1 4 9]

    Here, Function is a SAM interface (see course slides and Livecoding files).
    • Use helper functions if necessary, do not put everything into one function
    if the code gets too long.
    • Instead of Haskell’s lists, use ArrayList in Java and std::vector in C++.
    • Make sure your solution is pure! This means map must return a new list
    as a result, and not modify the input. The input list should be unchanged
    after calling map.
    • Make sure your solution is polymorphic! This means map must accept
    functions/lists of any type. To achieve this, use templates in C++ or
    generic functions in Java.
    • For the function parameter of map, use the std: function type in C++ and
    a Single Abstract Method (SAM) Interface in Java. In both cases, use
    lambda expressions to define each function.
     */

import java.util.List;
import java.util.function.Function;

public class PurePolymorphicMap {
    public static <T> List<T> polyMap(List<T> argList, Function<T,T> lambda) {
        List<T> resList = argList;
        int index = 0;
        resList = polyMap(resList,lambda,index);
        return resList;
    }

    public static <T> List<T> polyMap(List<T> result, Function<T,T> lambda, int i) {
        if (result.size() == i)
            return result;

        T obj = result.get(i);
        T resObj = lambda.apply(obj);
        result.set(i,resObj);
        int newIndex = i+1;
        polyMap(result,lambda,newIndex);
        return result;
    }
}