//movie price

import java.util.*;

interface OnlineAccount {
    int basePrice = 100;
    int regularMoviePrice = 50;
    int exclusiveMoviePrice = 200;
}

class Account implements OnlineAccount, Comparable<Account> {
    private int noOfRegularMovies;
    private int noOfExclusiveMovies;
    private String ownerName;

    // Constructor
    public Account(String ownerName, int noOfRegularMovies, int noOfExclusiveMovies) {
        this.ownerName = ownerName;
        this.noOfRegularMovies = noOfRegularMovies;
        this.noOfExclusiveMovies = noOfExclusiveMovies;
    }

    // Monthly cost calculation
    public double monthlyCost() {
        return basePrice 
             + noOfRegularMovies * regularMoviePrice 
             + noOfExclusiveMovies * exclusiveMoviePrice;
    }

    // Compare accounts based on monthly cost
    @Override
    public int compareTo(Account other) {
        return Double.compare(this.monthlyCost(), other.monthlyCost());
    }

    // toString method
    @Override
    public String toString() {
        return "Owner is " + ownerName + " and monthly cost is " + (int)monthlyCost() + " USD.";
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // number of accounts
        sc.nextLine();

        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String ownerName = sc.next();
            int noOfRegularMovies = sc.nextInt();
            int noOfExclusiveMovies = sc.nextInt();
            accounts.add(new Account(ownerName, noOfRegularMovies, noOfExclusiveMovies));
        }

        // Find account with max monthly cost
        Account mostValuable = Collections.max(accounts);

        System.out.println("Most valuable account details:");
        System.out.println(mostValuable);
    }
}
