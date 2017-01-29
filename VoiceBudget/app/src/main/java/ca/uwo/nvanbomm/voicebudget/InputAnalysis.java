package ca.uwo.nvanbomm.voicebudget;

import android.os.AsyncTask;
import android.os.Handler;

import org.xml.sax.ErrorHandler;

/**
 * Created by nicho on 1/28/2017.
 */

public class InputAnalysis{

    User user = new User();

    public String parseInput(String voiceInput){

        //Check for first option
        if ((voiceInput.contains("afford")||voiceInput.contains("get"))
                &&(voiceInput.contains("dollar"))){
            String[] words = voiceInput.split("\\s+");
            int dollarAmount;
            String buzzword;

            dollarAmount = Integer.parseInt(words[indexOf(words,"dollar")-1]);
            buzzword = words[indexOf(words,"dollar")+1];

            //check buzzword validity, return category

        }

        //check for second option
        else if (voiceInput.contains("remaining budget")&&voiceInput.contains("for")){
            String[] words = voiceInput.split("\\s+");
            String buzzword;
            buzzword = words[indexOf(words,"for")+1];

            //check buzzword validity, return category

        }

        return "error";
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
            if (words[x].equals("word")){
                return x;
            }
        }

        return index;
    }

    private String getCategory(String buzzword){
        /* REFERENCE
            0:transport
            1:food
            2:entertainment
        */
        int catnum=-1;
        String[][] categories={{"car","bus","train"},{"meal","meals","drink","snack","coffee"},
                {"activity","bar","outing","game","book"}};
    return "temp";

    }
}
