package ca.uwo.nvanbomm.voicebudget;

/**
 * Created by andyk on 2017-01-28.
 */

public class Budget {
    float limit;
    float balance;
    String name;

    //Constructors-----------------------------------------------------------------------

    /**
     * Constructor for the Budget class. sets the initial name and limit
     * @param cLimit the budget limit
     * @param cName the name of the budget
     */
    public Budget(float cLimit, String cName){
        limit = cLimit;
        name=cName;
    }


    //General Functions-------------------------------------------------------------------

    /**
     * Used to spend the given amount of money. adds to balance
     * @param amount amount of money to spend
     */
    public void spend(float amount){
        balance += amount;
    }

    //Get/Set functions-------------------------------------------------------------------

    public float getLimit() {
        return limit;
    }

    public float getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setLimit(float limit) {
        this.limit = limit;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }
}
