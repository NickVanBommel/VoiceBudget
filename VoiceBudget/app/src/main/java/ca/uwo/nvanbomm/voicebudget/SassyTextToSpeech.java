package ca.uwo.nvanbomm.voicebudget;

/**
 * Created by danazagar on 2017-01-28.
 */

import android.speech.tts.TextToSpeech;
import android.content.Context;

import org.w3c.dom.Text;

import java.util.Locale;

public class SassyTextToSpeech {

    private int langIndex;
    private TextToSpeech tts;

    SassyTextToSpeech(int langToUse)
    {
        langIndex = langToUse;
    }

    public void Initialize(final Context context){
        if (tts == null){
            tts = new TextToSpeech(context, new TextToSpeech.OnInitListener(){
                @Override
                public void onInit(int i){
                    if(i != TextToSpeech.ERROR) {
                        if (langIndex == 0)
                        {
                            tts.setLanguage(Locale.UK);
                        }
                        else if (langIndex == 1)
                        {
                            tts.setLanguage(Locale.US);
                        }
                        else if (langIndex == 2)
                        {
                            tts.setLanguage(Locale.GERMAN);
                        }
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
