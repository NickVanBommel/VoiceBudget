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

import java.util.ArrayList;
import ca.uwo.nvanbomm.voicebudget.InputAnalysis;
import ca.uwo.nvanbomm.voicebudget.VoiceRecognition;
import android.content.Context;

public class MainActivity extends Activity {


    private static final int REQ_CODE = 666;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton ibtnAsk = (ImageButton) findViewById(R.id.ibtnAsk);
        final TextView tvResponse = (TextView) findViewById(R.id.tvResponse);
        final ImageButton ibtnHelp = (ImageButton) findViewById(R.id.ibtnHelp);
        final ImageButton ibtnSettings = (ImageButton) findViewById(R.id.ibtnSettings);
        //final Context con = this;
        ibtnAsk.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                StartVoiceRecognition();
            }
        });

        ibtnHelp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectHelp(v);
            }
        });

        ibtnSettings.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectSettings(v);
            }
        });
    }

    public void selectHelp(View view)
    {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }
    public void selectSettings(View view)
    {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
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
            InputAnalysis ia = new InputAnalysis();
            responseText.setText(ia.parseInput(hits));
        }
    }



}
