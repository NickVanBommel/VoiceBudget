package ca.uwo.nvanbomm.voicebudget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User currUser = new User();
        ImageButton ibtnAsk = (ImageButton) findViewById(R.id.ibtnAsk);
        TextView tvResponse = (TextView) findViewById(R.id.tvResponse);


    }
}
