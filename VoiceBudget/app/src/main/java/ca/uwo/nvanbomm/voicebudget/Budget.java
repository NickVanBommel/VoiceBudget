package main.java.ca.uwo.nvanbomm.voicebudget;

/**
 * Created by andyk on 2017-01-28.
 */

public class Budget {
    int limit;
    int balance;
    String name;

    //Constructors-----------------------------------------------------------------------

    public Budget(int cLimit, String cName){
        limit = cLimit;
        name=cName;
    }


    //General Functions-------------------------------------------------------------------

    public void spend(int amount){
        balance += amount;
    }

    //Get/Set functions-------------------------------------------------------------------


    public int getLimit() {
        return limit;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }
}
