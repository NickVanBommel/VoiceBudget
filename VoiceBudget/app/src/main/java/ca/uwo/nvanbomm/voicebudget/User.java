package ca.uwo.nvanbomm.voicebudget;

/**
 * Created by nicho on 1/28/2017.
 */

import Budget.java;


public class User {
    int balance;
    //Define budgets
    ArrayList<Budget> userBudgets;


    User() {
        balance = 10000;
        userBudgets = new ArrayList<Budget>();
        userBudget.add(new Budget(75*100, "transportation"));
        userBudget.add(new Budget(150*100, "fun"));
        userBudget.add(new Budget(100*100, "food"));
        userBudget.add(new Budget(400*100, "groceries"));
    }

    //Check BudgetRemainder(str: budgetName) returns float
    //Check IsFeasiblePurchase(float: cost, str: budgetName) returns bool

    int GetGeneralBalance(){
        return balance;
    }

    int GetBudgetLimit(String budgetName){
        for(int i = 0; i < userBudgets.size(); i++){
            if (userBudgets[i].getName() == budgetName){
                return userBudgets[i].getLimit();
            }
        }
    }
    int GetBudgetBalance(String budgetName){
        for(int i = 0; i < userBudgets.size(); i++){
            if (userBudgets[i].getName() == budgetName){
                return userBudgets[i].getBalance();
            }
        }
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
