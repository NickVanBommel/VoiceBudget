package ca.uwo.nvanbomm.voicebudget;

/**
 * Created by nicho on 1/28/2017.
 */


public class User {
    int balance;
    //Define budgets
    ArrayList<Budget> userBudgets;


    User() {
        balance = 10000;
        userBudgets = new ArrayList<Budget>();
        userBudget.add(new Budget("transportation", 75));
        userBudget.add(new Budget("fun", 150));
        userBudget.add(new Budget("food", 100));
        userBudget.add(new Budget("groceries", 400));
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
