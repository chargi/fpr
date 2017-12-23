package com.fpr.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
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
 3
 3.1 Details/hints
 • Example: scan + 0 [1 2 3 4] should return [1 3 6 10]
 • Example: scan ∗ 3 [1 2 3 4] should return [3 6 18 72]
 • As with the map exercise, make sure your solution is pure and polymorphic.
 *
 */


public class PurePolymorphicScan {
    public static <T,U> List<U> polyScan(BiFunction<U,T,U> lambda, U initValue, List<T> argList) {
        if (argList.size() == 0)
            return new ArrayList<>();

        List <T> copiedArgList = new ArrayList<>(argList);
        List <U> resList = new ArrayList<>();
        //Do initial value calculation
        T firstValue = copiedArgList.get(0);
        U initialCalc = lambda.apply(initValue,firstValue);

        //Do list stuff
        resList.add(initialCalc);
        copiedArgList.remove(0);

        resList = polyScan(copiedArgList,lambda,resList);
        return resList;
    }

    private static <T,U> List<U> polyScan(List<T> todo, BiFunction<U,T,U> lambda, List<U> result) {
        if (todo.size() == 0)
            return result;

        //Get values
        int lastIndex = result.size()-1;
        U obj1 = result.get(lastIndex);
        T obj2 = todo.get(0);

        //Calculate
        U resObj = lambda.apply(obj1,obj2);

        //Do list stuff
        result.add(resObj);
        todo.remove(0);

        polyScan(todo,lambda,result);
        return result;
    }
}