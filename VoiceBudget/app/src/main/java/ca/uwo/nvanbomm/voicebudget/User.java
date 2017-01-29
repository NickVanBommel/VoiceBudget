package ca.uwo.nvanbomm.voicebudget;

/**
 * Created by nicho on 1/28/2017.
 */

import java.util.ArrayList;



public class User {
    float balance;
    ArrayList<Budget> userBudgets;


    User() {
        balance = 10000;
        userBudgets = new ArrayList<Budget>();
        userBudgets.add(new Budget(75, "transportation"));
        userBudgets.add(new Budget(150, "fun"));
        userBudgets.add(new Budget(100, "food"));
        userBudgets.add(new Budget(400, "groceries"));
    }

    float GetGeneralBalance(){
        return balance;
    }

    float GetBudgetLimit(String budgetName){
        for(int i = 0; i < userBudgets.size(); i++){
            if (userBudgets.get(i).getName() == budgetName){
                return userBudgets.get(i).getLimit();
            }
        }
        return 0;
    }
    float GetBudgetBalance(String budgetName){
        for(int i = 0; i < userBudgets.size(); i++){
            if (userBudgets.get(i).getName() == budgetName){
                return userBudgets.get(i).getBalance();
            }
        }
        return 0;
    }

    float GetBudgetRemainder(String budgetName){
        float budgetBalance = GetBudgetBalance(budgetName);
        float budgetLimit = GetBudgetLimit(budgetName);
        return budgetLimit - budgetBalance;
    }

    boolean IsFeasiblePurchase(float cost, String budgetName){
        float budgetBalance = GetBudgetBalance(budgetName);
        float budgetLimit = GetBudgetLimit(budgetName);
        if (cost+budgetBalance <= budgetLimit){
            return true;
        } else {
            return false;
        }
    }


}
