package com.fpr.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Implements Haskell's higher-order function scan in Java for three different
 * types.
 *
 * Example: scan + 0 [1 2 3 4] should return [1 3 6 10]
 *
 * Example: scan * 3 [1 2 3 4] should return []3 6 18 72]
 *
 * Note: Due to convenience and code simplicity the arrays are printed with
 * commas, e.g. [1 2 3 4] is printed as [1, 2, 3, 4]
 *
 */

//TODO: auf <T,U> umbauen

public class PurePolymorphicScan {
    public static <T> List<T> polyScan(List<T> argList, T initValue, BinaryOperator<T> lambda) {
        if (argList.size() == 0)
            return new ArrayList<T>();

        List <T> resList = new ArrayList<>(argList);
        //Do initial value calculation
        T obj = resList.get(0);
        T initialCalc = lambda.apply(initValue,obj);
        resList.set(0,initialCalc);

        int index = 1;
        resList = polyScan(resList,lambda,index);
        return resList;
    }

    private static <T> List<T> polyScan(List<T> result, BinaryOperator<T> lambda, int i) {
        if (result.size() == i)
            return result;

        T obj1 = result.get(i-1);
        T obj2 = result.get(i);
        T resObj = lambda.apply(obj1,obj2);
        result.set(i,resObj);
        int newIndex = i+1;
        polyScan(result,lambda,newIndex);
        return result;
    }
}