package com.fpr.exercise;

public class Main {

    public static void main(String[] args) {

    }

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
