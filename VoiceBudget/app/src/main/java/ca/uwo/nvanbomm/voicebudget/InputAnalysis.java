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
        if ((voiceInput.contains("afford")||voiceInput.contains("get"))
                &&(voiceInput.contains("$"))){
            String[] words = voiceInput.split("\\s+");
            int dollarAmount =5;
            String buzzword = "car";

            //dollarAmount = Integer.parseInt(words[indexOf(words,"dollar")-1]);

            //check buzzword validity, return category
            System.out.println(user.IsFeasiblePurchase(dollarAmount,getCategory(buzzword)));
            System.out.println(getCategory(buzzword));
            return(!getCategory(buzzword).equals("none")&&user.IsFeasiblePurchase(dollarAmount,getCategory(buzzword)))?"yes you can":"Nope";

        }

        //check for second option
        else if (voiceInput.contains("remaining budget")&&voiceInput.contains("for")){
            String[] words = voiceInput.split("\\s+");
            String buzzword;
            buzzword = words[indexOf(words,"for")+1];

            //check buzzword validity, return category

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
        String[][] categories={{"car","bus","train"},{"meal","meals","drink","snack","coffee"},
                {"activity","bar","outing","game","book"}};
        for (int x = 0;x<categories.length;x++){
            if (indexOf(categories[x],buzzword)!=-1){

                catnum=x;
                break;
            }
        }
        switch(catnum){
            case 0: return "transportation";
            case 1: return "food";
            case 2: return "entertainment";
            default: return "none";
        }
    }
}
