package ca.uwo.nvanbomm.voicebudget;

/**
 * Created by nicho on 1/28/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;



public class User {
    float balance;
    ArrayList<Budget> userBudgets;
    Context context;
    public static final String PREFS_FILE = "R.xml.preference";

    User(Context context) {
        this.context = context;
        SharedPreferences prefs = context.getSharedPreferences(PREFS_FILE, 0);
        balance = 10000; //add to sharedprefs after
        userBudgets = new ArrayList<Budget>();
        userBudgets.add(new Budget(prefs.getFloat("transportationKey", 75), "transportation"));
        userBudgets.add(new Budget(prefs.getFloat("funKey", 150), "fun"));
        userBudgets.add(new Budget(prefs.getFloat("foodKey", 200), "food"));
    }

    float GetGeneralBalance(){
        return balance;
    }

    float GetBudgetLimit(String budgetName){
        refresh();
        for(int i = 0; i < userBudgets.size(); i++){
            if (userBudgets.get(i).getName() == budgetName){
                return userBudgets.get(i).getLimit();
            }
        }
        return 0;
    }
    float GetBudgetBalance(String budgetName){
        refresh();
        for(int i = 0; i < userBudgets.size(); i++){
            if (userBudgets.get(i).getName() == budgetName){
                return userBudgets.get(i).getBalance();
            }
        }
        return 0;
    }

    float GetBudgetRemainder(String budgetName){
        refresh();
        float budgetBalance = GetBudgetBalance(budgetName);
        float budgetLimit = GetBudgetLimit(budgetName);
        return budgetLimit - budgetBalance;
    }

    boolean IsFeasiblePurchase(float cost, String budgetName){
        refresh();
        float budgetBalance = GetBudgetBalance(budgetName);
        float budgetLimit = GetBudgetLimit(budgetName);
        if (cost+budgetBalance <= budgetLimit){
            return true;
        } else {
            return false;
        }
    }

    void spend(int index, float amount){
        refresh();
        userBudgets.get(index).setBalance(userBudgets.get(index).getBalance()+amount);
    }

    void setBudgetLimit(String categoryKey, float limit){
        //0=transportation, 1=fun, 2=food
        refresh();
        int index = -1;
        switch(categoryKey){
            case "transportationKey":
                index = 0;
                break;
            case "funKey":
                index = 1;
                break;
            case "foodKey":
                index=2;
                break;
        }
        userBudgets.get(index).setLimit(limit);
        SharedPreferences prefs = context.getSharedPreferences(PREFS_FILE, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat(categoryKey, limit);
        editor.commit();
    }

    private void refresh(){
        userBudgets.clear();
        SharedPreferences prefs = context.getSharedPreferences(PREFS_FILE, 0);
        balance = 10000; //add to sharedprefs after
        userBudgets = new ArrayList<Budget>();
        userBudgets.add(new Budget(prefs.getFloat("transportationKey", 75), "transportation"));
        userBudgets.add(new Budget(prefs.getFloat("funKey", 150), "fun"));
        userBudgets.add(new Budget(prefs.getFloat("foodKey", 200), "food"));
    }


}
