package ca.uwo.nvanbomm.voicebudget;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    ImageButton ibtnGoogleMic;

    ImageButton ibtnDeltaMic;

    ImageButton ibtnAndy;

    Button btnSave;

    Switch swtAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent intent = getIntent();

        final boolean audioOn = intent.getBooleanExtra("AUDIO_ON", true);
        final String micImage = intent.getStringExtra("MIC_IMAGE");

        ibtnGoogleMic = (ImageButton) findViewById(R.id.ibtnGoogleMic);
        ibtnDeltaMic = (ImageButton) findViewById(R.id.ibtnDeltaMic);
        ibtnAndy = (ImageButton) findViewById(R.id.ibtnAndy);
        btnSave = (Button) findViewById(R.id.btnSave);
        swtAudio = (Switch) findViewById(R.id.swtAudio);

        swtAudio.setChecked(audioOn);

        if (audioOn)
        {
            swtAudio.setText("On");
        }
        else
        {
            swtAudio.setText("Off");
        }

        if (micImage == "Google")
        {
            ibtnDeltaMic.setBackgroundResource(R.drawable.roundedbutton);
            ibtnGoogleMic.setBackgroundResource(R.drawable.roundedbuttonselected);
            ibtnAndy.setBackgroundResource(R.drawable.roundedbutton);
        }
        else if (micImage == "Delta")
        {
            ibtnGoogleMic.setBackgroundResource(R.drawable.roundedbutton);
            ibtnDeltaMic.setBackgroundResource(R.drawable.roundedbuttonselected);
            ibtnAndy.setBackgroundResource(R.drawable.roundedbutton);
        }
        else if (micImage == "Andy")
        {
            ibtnAndy.setBackgroundResource(R.drawable.roundedbuttonselected);
            ibtnGoogleMic.setBackgroundResource(R.drawable.roundedbutton);
            ibtnDeltaMic.setBackgroundResource(R.drawable.roundedbutton);
        }

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

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectSave(v);
            }
        });

        swtAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (swtAudio.isChecked())
                {
                    swtAudio.setText("On");
                }
                else
                {
                    swtAudio.setText("Off");
                }
            }

        });

    }

    public void selectSave(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra("AUDIO_ON", swtAudio.isChecked());

        if (ibtnGoogleMic.getBackground() == ContextCompat.getDrawable(getApplicationContext(), R.drawable.roundedbuttonselected))
        {
            intent.putExtra("MIC_IMAGE", "Google");
        }
        else if(ibtnDeltaMic.getBackground() == ContextCompat.getDrawable(getApplicationContext(), R.drawable.roundedbuttonselected))
        {
            intent.putExtra("MIC_IMAGE", "Delta");
        }
        else if(ibtnAndy.getBackground() == ContextCompat.getDrawable(getApplicationContext(), R.drawable.roundedbuttonselected))
        {
            intent.putExtra("MIC_IMAGE", "Andy");
        }

        startActivity(intent);
    }
}
