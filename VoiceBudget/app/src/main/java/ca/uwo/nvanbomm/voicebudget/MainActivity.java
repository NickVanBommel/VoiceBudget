package ca.uwo.nvanbomm.voicebudget;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;

import ca.uwo.nvanbomm.voicebudget.SassyTextToSpeech;

public class MainActivity extends Activity {


    private static final int REQ_CODE = 666;
    private SassyTextToSpeech readAloud;
    private boolean audioOn;
    public static final String PREFS_FILE = "R.xml.preference";
    float transportationBudget;
    float funBudget;
    float foodBudget;
    String micImage;
    int langIndex;
    Button btnSpend;
    InputAnalysis ia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        audioOn = intent.getBooleanExtra("AUDIO_ON", false);
        langIndex = intent.getIntExtra("LANGUAGE", 0);

        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, 0);
//        transportationBudget = prefs.getFloat("transportationKey", 75);
//        funBudget = prefs.getFloat("funKey", 150);
//        foodBudget = prefs.getFloat("foodKey", 200);


        ImageButton ibtnAsk = (ImageButton) findViewById(R.id.ibtnAsk);
        final TextView tvResponse = (TextView) findViewById(R.id.tvResponse);
        final ImageButton ibtnHelp = (ImageButton) findViewById(R.id.ibtnHelp);
        final ImageButton ibtnSettings = (ImageButton) findViewById(R.id.ibtnSettings);
        btnSpend = (Button) findViewById(R.id.btnSpend);

        micImage = intent.getStringExtra("MIC_IMAGE");
        if (micImage != null)
        {
            if (micImage.equals("Google"))
            {
                ibtnAsk.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.mic));
            }
            else if (micImage.equals("Delta"))
            {
                ibtnAsk.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.deltahacks));
            }
            else if (micImage.equals("Andy"))
            {
                ibtnAsk.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.andy));
            }
            else if (micImage.equals("Logo"))
            {
                ibtnAsk.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.logo));
            }
        }
        else
        {
            micImage = "Google";
        }

        readAloud = new SassyTextToSpeech(langIndex);
        readAloud.Initialize(getApplicationContext());
        ibtnAsk.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (readAloud.SpeakingRn()){
                    readAloud.StopTalking();
                }
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

        btnSpend.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences(PREFS_FILE, 0);
                SharedPreferences.Editor editor = prefs.edit();

                System.out.println("category: "+prefs.getFloat(ia.getCategory() + "BalKey", 0));
                editor.putFloat(ia.getCategory() + "BalKey", prefs.getFloat(ia.getCategory() + "BalKey", 0) - ia.getDollarAmount());
                editor.putFloat("balanceKey", prefs.getFloat("balanceKey", 1000) - ia.getDollarAmount());
                editor.commit();
                tvResponse.setText("You spent " + ia.getDollarAmount() + "!!");
                btnSpend.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void selectHelp(View view)
    {
        Intent intent = new Intent(this, HelpActivity.class);
        intent.putExtra("AUDIO_ON", audioOn);
        intent.putExtra("MIC_IMAGE", micImage);
        intent.putExtra("LANGUAGE", langIndex);
        startActivity(intent);
    }
    public void selectSettings(View view)
    {
        Intent intent = new Intent(this, SettingsActivity.class);

        intent.putExtra("AUDIO_ON", audioOn);
        intent.putExtra("MIC_IMAGE", micImage);
        intent.putExtra("LANGUAGE", langIndex);

        startActivity(intent);
    }

    private void StartVoiceRecognition(){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Keep your budgets in check!");
        startActivityForResult(intent, REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        btnSpend.setVisibility(View.INVISIBLE);
        if (requestCode == REQ_CODE && resultCode == RESULT_OK && null != data){
            ArrayList<String> hits = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            TextView responseText = (TextView) findViewById(R.id.tvResponse);
            ia = new InputAnalysis(getApplicationContext());
            String output = ia.parseInput(hits);
            responseText.setText(output);
            parseForButton(output);
            //
            if (audioOn) {
                readAloud.Speaking(output);
            }
        }
    }

    public void parseForButton(String output)
    {
        if (output.contains("Treat yourself"))
        {
            btnSpend.setVisibility(View.VISIBLE);
        }
    }




}
