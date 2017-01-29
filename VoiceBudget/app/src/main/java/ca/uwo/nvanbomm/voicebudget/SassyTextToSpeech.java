package ca.uwo.nvanbomm.voicebudget;

/**
 * Created by danazagar on 2017-01-28.
 */

import android.speech.tts.TextToSpeech;
import android.content.Context;

import org.w3c.dom.Text;

import java.util.Locale;

public class SassyTextToSpeech {

    private TextToSpeech tts;

    public void Initialize(final Context context){
        if (tts == null){
            tts = new TextToSpeech(context, new TextToSpeech.OnInitListener(){
                @Override
                public void onInit(int i){
                    if(i != TextToSpeech.ERROR) {
                        tts.setLanguage(Locale.US);
                    }
                }
            });
        }
    }

    public void Speaking(final String resultText){
        tts.speak(resultText,TextToSpeech.QUEUE_FLUSH, null);
    }

    public boolean SpeakingRn(){
        return tts.isSpeaking();
    }

    public void StopTalking(){
        tts.stop();
    }
}
