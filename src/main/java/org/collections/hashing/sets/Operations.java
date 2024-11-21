package org.collections.hashing.sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Operations {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        // operation 1 - union -> combination of all unique elements from both sets
        // Real-world use: Merging data from two sources without duplicating entries.

        set1.addAll(set2);
        System.out.println("Union: " + set1);

        // operation 2 - intersection -> common elements between both sets
        // Real-world use: Finding common items between datasets (e.g., users who belong
        // to multiple groups).
        set1.retainAll(set2);
        System.out.println("Intersection: " + set1);

        // operation 3 - Assynmetric difference -> elements that are in one set but not
        // in the other
        // Real-world use: Finding items that are unique to one dataset (e.g., users who
        // belong to one group only).
        set1 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        set2 = new HashSet<>(Arrays.asList(7, 8, 9, 10, 11));
        Set<Integer> asymmetricDiff = new HashSet<>(set1);
        asymmetricDiff.removeAll(set2);
        System.out.println("Asymmetric Difference: " + asymmetricDiff);

        // operation 4 - symmetric difference -> elements that are in one set or the
        // other but not both
        // Real-world use: Finding items that are unique to one dataset or the other but
        // not both (e.g., users who belong to one group only or multiple groups).
        set1 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        set2 = new HashSet<>(Arrays.asList(7, 8, 9, 10, 11));
        Set<Integer> symmetricDiff = new HashSet<>(set1);
        symmetricDiff.addAll(set2);
        Set<Integer> temp = new HashSet<>(set1);
        temp.retainAll(set2);
        symmetricDiff.removeAll(temp);
        System.out.println("Symmetric Difference: " + symmetricDiff);

    }
}
