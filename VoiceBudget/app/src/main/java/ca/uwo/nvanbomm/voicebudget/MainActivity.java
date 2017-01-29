package ca.uwo.nvanbomm.voicebudget;

import android.net.Uri;
import android.os.Handler;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User currUser = new User();
        ImageButton speakButton = (ImageButton) findViewById(R.id.ibtnAsk);
        final TextView tvResponse = (TextView) findViewById(R.id.tvResponse);



    }


}
