package ca.uwo.nvanbomm.voicebudget;

/**
 * Created by danazagar on 2017-01-28.
 */

import android.speech.tts.TextToSpeech;
import android.content.Context;
import java.util.Locale;

public class SassyTextToSpeech {

    private static TextToSpeech tts;

    public static void Initialize(final Context context){
        if (tts == null){
            tts = new TextToSpeech(context, new TextToSpeech.OnInitListener(){
                @Override
                public void onInit(int i){
                    if(i != TextToSpeech.ERROR) {
                        tts.setLanguage(Locale.UK);
                    }
                }
            });
        }
    }

    public static void Speaking(final String resultText){
        tts.speak(resultText,TextToSpeech.QUEUE_FLUSH, null);
    }
}
