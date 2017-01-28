package ca.uwo.nvanbomm.voicebudget;

/**
 * Created by nicho on 1/28/2017.
 */


public class User {
    float balance;
    //Define budgets
    ArrayList<Budget> userBudgets;


    User() {
        balance = 10000;
        userBudgets = new ArrayList<Budget>();
        userBudget.add(new Budget("transportation", 75));
        userBudget.add(new Budget("fun", 150));
        userBudget.add(new Budget("food", 100));
        userBudget.add(new Budget("groceries", 400);
    }

    //Get GeneralBalance
    //Get BudgetBalance(str: budgetName) returns float
    //Check BudgetRemainder(str: budgetName) returns float
    //Check IsFeasiblePurchase(float: cost, str: budgetName) returns bool

    float GetGeneralBalance(){
        return balance;
    }

    float GetBudgetBalance(String budgetName){
        for(int i = 0; i < userBudgets.size(); i++){
            if (userBudgets[i].getName() == budgetName){
                return userBudgets[i].getBalance();
            }
        }
    }

    float GetBudgetRemainder(String budgetName){

    }

    boolean IsFeasiblePurchase(float cost, String budgetName){

    }


}
