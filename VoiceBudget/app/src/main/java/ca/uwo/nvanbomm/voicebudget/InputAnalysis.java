package ca.uwo.nvanbomm.voicebudget;

import android.os.AsyncTask;
import android.os.Handler;

import org.xml.sax.ErrorHandler;

/**
 * Created by nicho on 1/28/2017.
 */

public class InputAnalysis{

    public ErrorHandler inputErrorHandler;

    public InputAnalysis(ErrorHandler myErrorHandler)
    {
        inputErrorHandler = myErrorHandler;
    }
    public interface SuccessHandler{
        void onComplete(String response);
    }

    public void analyzeInput(final SuccessHandler inputHandler)
    {
        AsyncTask<Void, Void, String> myTask = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                return "totally did things in the background";
            }

            @Override
            protected void onPostExecute(String response)
            {
                inputHandler.onComplete(response);
            }
        };
        myTask.execute();
    }
}
