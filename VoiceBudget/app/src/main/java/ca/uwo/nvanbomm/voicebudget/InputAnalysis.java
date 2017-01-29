package ca.uwo.nvanbomm.voicebudget;

import android.os.AsyncTask;
import android.os.Handler;

import org.xml.sax.ErrorHandler;

import java.util.ArrayList;

/**
 * Created by nicho on 1/28/2017.
 */

public class InputAnalysis{

    User user = new User();

    public String parseInput(ArrayList<String> inputList){
        String voiceInput=" ";
        for (String word : inputList){
            voiceInput+=word+ " ";
        }

        //Check for first option
        if ((voiceInput.contains("afford")||voiceInput.contains("get")||voiceInput.contains("order"))
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

            //dollarAmount = Integer.parseInt(words[indexOf(words,"dollar")-1]);

            //check buzzword validity, return category
            System.out.println(user.IsFeasiblePurchase(dollarAmount,category));
            System.out.println(category);
            return(!category.equals("none")&&user.IsFeasiblePurchase(dollarAmount,category))?"Treat yourself ;)":"You Wish!";

        }

        //check for second option
        else if (voiceInput.contains("budget")){
            String[] words = voiceInput.split("\\s+");
            String category="none";
            for (String word : words){
                if (!getCategory(word).equals("none")) {
                    category = getCategory(word);
                    break;
                }
            }
            return ""+user.GetBudgetRemainder(category);

        }

        return voiceInput;
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

    private String getCategory(String buzzword){
        /* REFERENCE
            0:transport 1:food  2:entertainment
        */
        int catnum=-1;
        String[][] categories={{"car","bus","train","transport","transportation"},{"meal","meals","drink","snack","coffee","food"},
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
