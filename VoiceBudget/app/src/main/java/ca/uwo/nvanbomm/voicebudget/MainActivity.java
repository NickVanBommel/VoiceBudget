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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        User currUser = new User();
        ImageButton speakButton = (ImageButton) findViewById(R.id.ibtnAsk);
>>>>>>> origin/master
        final TextView tvResponse = (TextView) findViewById(R.id.tvResponse);



    }



}
