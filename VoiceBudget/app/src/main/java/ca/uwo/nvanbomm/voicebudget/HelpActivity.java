package ca.uwo.nvanbomm.voicebudget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    boolean audioOn;
    String micImage;
    int langIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Intent intent = getIntent();

        Button btnDone = (Button) findViewById(R.id.btnDone);

        audioOn = intent.getBooleanExtra("AUDIO_ON", false);
        micImage = intent.getStringExtra("MIC_IMAGE");
        langIndex = intent.getIntExtra("LANGUAGE", 0);


        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectMain(v);
            }
        });

    }

    public void selectMain(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra("AUDIO_ON", audioOn);
        intent.putExtra("MIC_IMAGE", micImage);
        intent.putExtra("LANGUAGE", langIndex);

        startActivity(intent);

    }

}
