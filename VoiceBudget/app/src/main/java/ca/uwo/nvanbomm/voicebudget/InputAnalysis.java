package ca.uwo.nvanbomm.voicebudget;

import android.os.AsyncTask;
import android.os.Handler;

import org.xml.sax.ErrorHandler;

/**
 * Created by nicho on 1/28/2017.
 */

public class InputAnalysis{

    public ErrorHandler inputErrorHandler;
    public Handler inputSuccessHandler;

    public InputAnalysis(ErrorHandler myErrorHandler, Handler myHandler)
    {
        inputErrorHandler = myErrorHandler;
        inputSuccessHandler = myHandler;
    }

    public void analyzeInput(Handler inputHandler)
    {
        AsyncTask<Void, Void, String> myTask = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                return "totally did things in the background";
            }
        };
        myTask.execute();
    }
}
