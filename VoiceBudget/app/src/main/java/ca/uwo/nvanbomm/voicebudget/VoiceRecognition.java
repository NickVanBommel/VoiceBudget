package ca.uwo.nvanbomm.voicebudget;

import android.app.Activity;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;
import android.util.Log;
/**
 * Created by danazagar on 2017-01-28.
 */

public class VoiceRecognition {

    private Context CONTEXT;
    private static final Intent reset = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    protected SpeechRecognizer speechRecog;
    protected Intent speechRecogIntent;

    public VoiceRecognition(Context context){
        this.CONTEXT = context;
        initSpeechRecognizer();
    }

    private void initSpeechRecognizer(){
        speechRecog = SpeechRecognizer.createSpeechRecognizer(CONTEXT);
        speechRecogIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechRecogIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
    }

    class Listener implements RecognitionListener {
        private final String TAG = VoiceRecognition.class.getSimpleName();

        @Override
        public void onBeginningOfSpeech() {
        }

        @Override
        public void onEndOfSpeech() {
        }

        @Override
        public void onReadyForSpeech(Bundle params) {
        }

        @Override
        public void onRmsChanged(float rmsdB) {
        }

        @Override
        public void onBufferReceived(byte[] buffer) {

        }

        @Override
        public void onError(int error) {
            Log.e(TAG, "onError:" + error);

            if (error == SpeechRecognizer.ERROR_SPEECH_TIMEOUT
                    || error == SpeechRecognizer.ERROR_NO_MATCH) {

                speechRecog.startListening(reset);
            }
        }

        @Override
        public void onPartialResults(Bundle partialResults) {

        }

        @Override
        public void onResults(Bundle results) {
            if ((results != null)
                    && results.containsKey(SpeechRecognizer.RESULTS_RECOGNITION)) {
                ArrayList<String> heard =
                        results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                float[] scores = results.getFloatArray(SpeechRecognizer.CONFIDENCE_SCORES);

                for (int i = 0; i < heard.size(); i++) {
                    Log.d(TAG, "onResultsheard:" + heard.get(i)
                            + " confidence:" + scores[i]);

                }
                //do something here
            }
            speechRecog.startListening(reset);


        }

        @Override
        public void onEvent(int eventType, Bundle params) {

        }
    }

}
