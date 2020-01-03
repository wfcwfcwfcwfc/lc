package io.fengchao.leetcode.problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class FlattenNestedIterator implements Iterator<Integer> {

    NestedInteger nestedInteger;
    LinkedList<Iterator<NestedInteger>> iteratorStack;
    Iterator<NestedInteger> iterator;

    public FlattenNestedIterator(List<NestedInteger> nestedList) {
        this.iteratorStack = new LinkedList<>();
        this.iterator = nestedList.iterator();
    }

    @Override
    public Integer next() {
        return nestedInteger.getInteger();
    }

    @Override
    public boolean hasNext() {
        while(iteratorStack.size() > 0 || iterator.hasNext()) {
            if(iterator.hasNext()) {
                NestedInteger candidate = iterator.next();
                if(nestedInteger.isInteger()) {
                    nestedInteger = candidate;
                    return true;
                } else {
                    iteratorStack.add(iterator);
                    iterator = candidate.getList().iterator();
                }
            } else {
                iterator = iteratorStack.removeLast();
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
