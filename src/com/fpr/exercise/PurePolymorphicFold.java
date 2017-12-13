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

public class PurePolymorphicFold {
}
