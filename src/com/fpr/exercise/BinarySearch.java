package com.fpr.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class BinarySearch {

    //Trivial or solvable when element is in the branch or only one element
    public Predicate<SearchParams<Integer>> trivial =
        ints -> ints.getList().size() <=1 ||
                ints.getList().stream().noneMatch(x -> x.equals(ints.getValue()));

    public Function<SearchParams<Integer>,
        SearchParams<Integer>> solve = (x) -> {
            if (x.getList().size() == 1)
                if (x.getList().get(0).equals(x.getValue()))
                    x.increaseFound();
            return x;
    };

    public Function<SearchParams<Integer>, DnCHigherOrder.SimplePair<SearchParams<Integer>>> divide =
        this::splitInHalf;

    public BiFunction<SearchParams<Integer>, SearchParams<Integer>,SearchParams<Integer>> combine =
        (left,right) -> (
                left.mergeWithOther(right)
        );

    //Divide the list in half
    private DnCHigherOrder.SimplePair<SearchParams<Integer>> splitInHalf(SearchParams<Integer> input) {
        List<Integer> leftList;
        List<Integer> rightList;
        List<Integer> givenList = input.getList();
        int splitValue = givenList.size()/2;

        leftList = givenList.subList(0,splitValue);
        rightList = givenList.subList(splitValue,givenList.size());

        return new DnCHigherOrder.SimplePair<>(
                new SearchParams<>(leftList,input.getValue()),
                new SearchParams<>(rightList,input.getValue())
        );
    }


    public static class SearchParams<V> {
        List<V> list;
        int foundValues = 0;
        V value;

        public SearchParams(List<V> list, V value) {
            setList(list);
            setValue(value);
        }

        public SearchParams<V> mergeWithOther(SearchParams<V> input) {
            List<V> tmpList = new ArrayList<>(getList());
            tmpList.addAll(input.getList());
            SearchParams<V> toReturn = new SearchParams<>(tmpList,getValue());
            toReturn.setFoundValues(this.getFoundValues()+input.getFoundValues());
            return toReturn;
        }

        public List<V> getList() {
            return list;
        }

        public void setList(List<V> list) {
            this.list = list;
        }

        public void setFoundValues(int arg) {
            this.foundValues = arg;
        }

        public int getFoundValues() {
            return foundValues;
        }

        public void increaseFound() {
            foundValues++;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }


}


