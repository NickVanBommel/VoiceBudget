package ca.uwo.nvanbomm.voicebudget;

/**
 * Created by nicho on 1/28/2017.
 */

public class User {
    int balance;
    //Define budgets
    ArrayList<Budget> userBudgets = new ArrayList<Budget>();

    User() {
        balance = 10000;
    }

    //Get GeneralBalance
    //Get BudgetBalance(str: budgetName) returns float
    //Check BudgetRemainder(str: budgetName) returns float
    //Check IsFeasiblePurchase(float: cost, str: budgetName) returns bool


}
