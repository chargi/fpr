package com.fpr.exercise;

/*
    2 Pure Polymorphic Fold

    Implement Haskell’s higher-order function fold in C++ or Java.
    folds’s signature is fold :: (a −> a −> a) −> a −> [a] −>a, which means
    that the function has three arguments:
    1. a function f :: a −> a −> a, which means a function with two arguments
    of one type, returning a result of the same type. Examples are addition
    or multiplication, which take two ints and return their sum/product.
    2. an initial folding value of type a.

    3. a list of elements of type a.
    fold returns a single value of type a by applying f to the list elements as follows:
    • apply f to the initial folding value and the first element of the list
    • apply f to the result above and the second element of the input list.
    • repeat/recurse until you reach the end of the input list.
    Implement at three example inputs for your fold function. Each
    input must be of a different type (int, string, float, a type/class you define,. . . ).

    • Example: fold + 0 [1 2 3] should return 6
    • Example: fold ∗ 3 [1 2 3] should return 18
    • As with the map exercise, make sure your solution is pure and polymorphic.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class PurePolymorphicFold {
    public static <T> T polyFold(List<T> argList, T initValue, BinaryOperator<T> lambda) {
        if (argList.size() == 0)
            return initValue;

        List <T> resList = new ArrayList<>(argList);;

        //Do initial value calculation
        T obj = resList.get(0);
        T initialCalc = lambda.apply(initValue,obj);
        resList.set(0,initialCalc);

        resList = polyFold(resList,lambda);
        return resList.get(0);
    }

    private static <T> List<T> polyFold(List<T> result, BinaryOperator<T> lambda) {
        if (result.size() == 1)
            return result;

        T obj1 = result.get(0);
        T obj2 = result.get(1);
        T resObj = lambda.apply(obj1,obj2);
        result.set(1,resObj);
        result.remove(0);
        polyFold(result,lambda);
        return result;
    }
}
