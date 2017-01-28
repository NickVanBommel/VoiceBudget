package ca.uwo.nvanbomm.voicebudget;

/**
 * Created by nicho on 1/28/2017.
 */

import java.util.ArrayList;

import ca.uwo.nvanbomm.voicebudget.Budget;


public class User {
    int balance;
    //Define budgets
    ArrayList<Budget> userBudgets;


    User() {
        balance = 10000;
        userBudgets = new ArrayList<Budget>();
        //userBudgets.add(new Budget(75*100, "transportation"));
        //userBudgets.add(new Budget(150*100, "fun"));
        //userBudgets.add(new Budget(100*100, "food"));
        //userBudgets.add(new Budget(400*100, "groceries"));
    }

    //Check BudgetRemainder(str: budgetName) returns float
    //Check IsFeasiblePurchase(float: cost, str: budgetName) returns bool

    int GetGeneralBalance(){
        return balance;
    }

    int GetBudgetLimit(String budgetName){
        for(int i = 0; i < userBudgets.size(); i++){
            //if (userBudgets[i].getName() == budgetName){
                //return userBudgets[i].getLimit();
            //}
        }
        return 0;
    }
    int GetBudgetBalance(String budgetName){
        for(int i = 0; i < userBudgets.size(); i++){
            //if (userBudgets[i].getName() == budgetName){
                //return userBudgets[i].getBalance();
            //}
        }
        return 0;
    }

    int GetBudgetRemainder(String budgetName){
        int budgetBalance = GetBudgetBalance(budgetName);
        int budgetLimit = GetBudgetLimit(budgetName);
        return budgetLimit - budgetBalance;
    }

    boolean IsFeasiblePurchase(int cost, String budgetName){
        int budgetBalance = GetBudgetBalance(budgetName);
        if (cost < budgetBalance){
            return true;
        } else {
            return false;
        }
    }


}
