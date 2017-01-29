package ca.uwo.nvanbomm.voicebudget;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    ImageButton ibtnGoogleMic;

    ImageButton ibtnDeltaMic;

    ImageButton ibtnAndy;

    Switch swtAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent intent = getIntent();
        ibtnGoogleMic = (ImageButton) findViewById(R.id.ibtnGoogleMic);
        ibtnDeltaMic = (ImageButton) findViewById(R.id.ibtnDeltaMic);
        ibtnAndy = (ImageButton) findViewById(R.id.ibtnAndy);
        swtAudio = (Switch) findViewById(R.id.swtAudio);

        ibtnGoogleMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibtnDeltaMic.setBackgroundResource(R.drawable.roundedbutton);
                ibtnGoogleMic.setBackgroundResource(R.drawable.roundedbuttonselected);
                ibtnAndy.setBackgroundResource(R.drawable.roundedbutton);
            }
        });

        ibtnDeltaMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibtnGoogleMic.setBackgroundResource(R.drawable.roundedbutton);
                ibtnDeltaMic.setBackgroundResource(R.drawable.roundedbuttonselected);
                ibtnAndy.setBackgroundResource(R.drawable.roundedbutton);
            }
        });

        ibtnAndy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibtnAndy.setBackgroundResource(R.drawable.roundedbuttonselected);
                ibtnGoogleMic.setBackgroundResource(R.drawable.roundedbutton);
                ibtnDeltaMic.setBackgroundResource(R.drawable.roundedbutton);
            }
        });

    }
}
