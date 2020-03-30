package com.zzx.collection.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

    @Test
    public void testHashSet(){
        Set<String> setString = new HashSet<>();
        setString.add("1");
        setString.add("2");
        setString.add("2");
        setString.add("3");
        setString.forEach(System.out::println);
    }

    @Test
    public void testTreeSet(){
        TreeSet treeSet = new TreeSet();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(6);

        treeSet.forEach(System.out::println);
    }
}
