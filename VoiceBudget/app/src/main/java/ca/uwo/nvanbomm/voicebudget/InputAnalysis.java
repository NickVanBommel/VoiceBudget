package ca.uwo.nvanbomm.voicebudget;

import android.os.AsyncTask;
import android.os.Handler;

import org.xml.sax.ErrorHandler;

import java.util.ArrayList;

/**
 * Created by Andy on 1/28/2017.
 */

public class InputAnalysis{

    User user = new User();

    /**
     * takes input from voice and reacts accordingly. options are check for affordability, check
     * remaining budget, and get account balance.
     * @param inputList list of input strings from the voice input
     * @return the appropriate response to the asked question.
     */
    public String parseInput(ArrayList<String> inputList){
        String voiceInput="";
        for (String word : inputList){
            voiceInput+=word+ " ";
        }
        voiceInput=voiceInput.toLowerCase();
        System.out.println(voiceInput);


        //Check for affordability
        if ((voiceInput.contains("afford")||voiceInput.contains("get")||voiceInput.contains("order")||voiceInput.contains("buy")||voiceInput.contains("purchase")
                ||voiceInput.contains("spend"))
                &&(voiceInput.contains("$"))){
            String[] words = voiceInput.split("\\s+");
            float dollarAmount =-1;
            for (String str: words){
                if (str.length()!=0 && str.charAt(0) == '$'){
                    dollarAmount=Float.parseFloat(str.substring(1));
                    break;
                }
            }
            if (dollarAmount < 0){
                return "Didn't catch that, please repeat!";
            }
            String category="none";
            for (String word : words){
                if (!getCategory(word).equals("none")) {
                    category = getCategory(word);
                    break;
                }
            }
            return(!category.equals("none")&&user.IsFeasiblePurchase(dollarAmount,category))?"Treat yourself ;)":"You Wish!";
        }

        //check for budget
        else if (voiceInput.contains("budget")||voiceInput.contains(" for ")||
                (voiceInput.contains("how much")&&(voiceInput.contains(" on ")||voiceInput.contains("afford")))||
                (voiceInput.contains(" most ")&&(voiceInput.contains(" on ")||voiceInput.contains(" at ")))){
            System.out.println(voiceInput.contains(" on "));
            String[] words = voiceInput.split("\\s+");
            String category="none";
            for (String word : words){
                if (!getCategory(word).equals("none")) {
                    category = getCategory(word);
                    break;
                }
            }
            return "You have $"+user.GetBudgetRemainder(category)+" remaining out of $"+user.GetBudgetLimit(category);

        }

        //check balance
        else if (voiceInput.contains("balance")||voiceInput.contains("money")||voiceInput.contains("cash")){
            String[] words = voiceInput.split("\\s+");
            String category="none";
            for (String word : words){
                if (!getCategory(word).equals("none")) {
                    category = getCategory(word);
                    break;
                }
            }
            return "You have $"+user.GetGeneralBalance()+" in your bank account!";

        }

        return "Invalid command";
    }

    /**
     * Finds the index of a given string from an array of strings
     * @param words the array of strings
     * @param word the string of which to find the index.
     * @return return the index of the string, or -1 if not found.
     */
    private int indexOf(String[] words, String word){
        int index =-1;
        for (int x=0;x<words.length;x++){
            if (words[x].equals(word)){
                return x;
            }
        }

        return index;
    }

    /**
     * Returns the category of the given "buzzword" (descriptor)
     * @param buzzword the word for which you want a category
     * @return the category of the buzzword
     */
    private String getCategory(String buzzword){
        /* REFERENCE
            0:transport 1:food  2:entertainment
        */
        int catnum=-1;
        String[][] categories={{"car","bus","train","transport","transportation"},{"meal","meals","drink","drinks","snack","coffee","food"},
                {"activity","bar","outing","game","book","fun","out"}};
        for (int x = 0;x<categories.length;x++){
            if (indexOf(categories[x],buzzword)!=-1){

                catnum=x;
                break;
            }
        }
        switch(catnum){
            case 0: return "transportation";
            case 1: return "food";
            case 2: return "fun";
            default: return "none";
        }
    }
}
