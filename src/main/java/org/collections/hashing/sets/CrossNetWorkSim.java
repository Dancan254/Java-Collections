package org.collections.hashing.sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CrossNetWorkSim {
    public static void main(String[] args) {
        Set<String> newtWorkAUsers = new HashSet<>(Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve"));
        Set<String> newtWorkBUsers = new HashSet<>(Arrays.asList("Bob", "Charlie", "David", "Eve", "Frank"));
        Set<String> newtWorkCUsers = new HashSet<>(Arrays.asList("David", "Eve", "Frank", "Grace", "Helen"));

        // find users active across all networks
        Set<String> crossNetworkUsers = new HashSet<>(newtWorkAUsers);
        crossNetworkUsers.retainAll(newtWorkBUsers);
        crossNetworkUsers.retainAll(newtWorkCUsers);
        System.out.println("Users active across all networks: " + crossNetworkUsers);
        // //Excpected output: [David, Eve]

        // find users active in only one network
        Set<String> usersActiveInOneNetwork = new HashSet<>(newtWorkAUsers);
        usersActiveInOneNetwork.removeAll(newtWorkBUsers);
        usersActiveInOneNetwork.removeAll(newtWorkCUsers);
        System.out.println("Users active in only one network: " + usersActiveInOneNetwork); // Excpected output: [Alice]

        Set<String> networkAPosts = new HashSet<>(Arrays.asList("post1", "post2", "post3", "post4", "post5"));
        Set<String> networkBPosts = new HashSet<>(Arrays.asList("post4", "post5", "post6", "post7", "post8"));
        Set<String> networkCPosts = new HashSet<>(Arrays.asList("post7", "post8", "post9", "post10", "post11"));
        // all unique posts across networks
        Set<String> allPosts = new HashSet<>(networkAPosts);
        allPosts.addAll(networkBPosts);
        allPosts.addAll(networkCPosts);
        System.out.println("All unique posts across networks: " + allPosts);
    }
}
