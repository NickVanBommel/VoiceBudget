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
        balance = prefs.getFloat("balanceKey",1000); //add to sharedprefs after
        userBudgets = new ArrayList<Budget>();
        userBudgets.add(new Budget(prefs.getFloat("transportationKey", 75), "transportation"));
        userBudgets.add(new Budget(prefs.getFloat("funKey", 150), "fun"));
        userBudgets.add(new Budget(prefs.getFloat("foodKey", 200), "food"));
    }

    float GetGeneralBalance(){
        refresh();
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
        SharedPreferences prefs = context.getSharedPreferences(PREFS_FILE, 0);
        return prefs.getFloat(budgetName+"Key", 0) + prefs.getFloat(budgetName+"BalKey", 0);
    }

    boolean IsFeasiblePurchase(float cost, String budgetName){
//        refresh();
//        float budgetBalance = GetBudgetBalance(budgetName);
//        float budgetLimit = GetBudgetLimit(budgetName);
        SharedPreferences prefs = context.getSharedPreferences(PREFS_FILE, 0);
        float budgetBalance = prefs.getFloat(budgetName+"BalKey", 0);
        float budgetLimit = prefs.getFloat(budgetName+"Key", 0);
        System.out.println("cost and balance "+Float.toString(cost+budgetBalance));
        System.out.println("limit " + Float.toString(budgetLimit));

        if (cost+budgetBalance <= budgetLimit && cost+budgetBalance >= 0){
            return true;
        } else {
            return false;
        }
    }

    void spend(int index, float amount){
        refresh();
        SharedPreferences prefs = context.getSharedPreferences(PREFS_FILE, 0);
        SharedPreferences.Editor editor = prefs.edit();
        String cat="";
        switch (index) {
            case 0:
                cat = "transportation";
                break;
            case 1:
                cat = "fun";
                break;
            case 2:
                cat = "food";
                break;
        }
        editor.putFloat(cat + "BalKey", prefs.getFloat(cat+"Balkey",0)-amount);
        editor.putFloat("balanceKey",prefs.getFloat("balanceKey",1000)-amount);
        editor.commit();
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

    void setBudgetBalance(String categoryKey, float balance){
        //0=transportation, 1=fun, 2=food
        refresh();
        int index = -1;
        switch(categoryKey){
            case "transportationBalKey":
                index = 0;
                break;
            case "funBalKey":
                index = 1;
                break;
            case "foodBalKey":
                index=2;
                break;
        }
        userBudgets.get(index).setBalance(balance);
        SharedPreferences prefs = context.getSharedPreferences(PREFS_FILE, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat(categoryKey, balance);
        editor.commit();
    }

    private void refresh(){
        userBudgets.clear();
        SharedPreferences prefs = context.getSharedPreferences(PREFS_FILE, 0);
        balance = prefs.getFloat("balanceKey",1000); //add to sharedprefs after
        userBudgets = new ArrayList<Budget>();
        userBudgets.add(new Budget(prefs.getFloat("transportationKey", 75), "transportation"));
        userBudgets.add(new Budget(prefs.getFloat("funKey", 150), "fun"));
        userBudgets.add(new Budget(prefs.getFloat("foodKey", 200), "food"));
    }


}
