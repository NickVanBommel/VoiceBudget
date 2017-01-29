package ca.uwo.nvanbomm.voicebudget;

import android.net.Uri;
import android.os.Handler;
import android.os.Bundle;
import android.app.Activity;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.Intent;

import org.w3c.dom.Text;

import java.util.ArrayList;
import ca.uwo.nvanbomm.voicebudget.InputAnalysis;

<<<<<<< HEAD
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;

import ai.api.android.AIConfiguration;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.ui.AIButton;

public class MainActivity extends AppCompatActivity {

=======
public class MainActivity extends Activity {
>>>>>>> origin/master


    private static final int REQ_CODE = 666;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        User currUser = new User();
        ImageButton speakButton = (ImageButton) findViewById(R.id.ibtnAsk);
>>>>>>> origin/master
        final TextView tvResponse = (TextView) findViewById(R.id.tvResponse);

        speakButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                StartVoiceRecognition();
            }
        });
    }

    private void StartVoiceRecognition(){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "DEMO");
        startActivityForResult(intent, REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == REQ_CODE && resultCode == RESULT_OK && null != data){
            ArrayList<String> hits = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            TextView responseText = (TextView) findViewById(R.id.tvResponse);
            responseText.setText(InputAnalysis.parseInput(hits));
        }
    }



}
