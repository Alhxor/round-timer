package net.xorium.roundtimer;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        Resources res = getResources();

        ButtonTimer.add(this, (Button) findViewById(R.id.button1),
                        (long) res.getInteger(R.integer._00_30));
        ButtonTimer.add(this, (Button) findViewById(R.id.button2),
                        (long) res.getInteger(R.integer._01_00));
        ButtonTimer.add(this, (Button) findViewById(R.id.button3),
                        (long) res.getInteger(R.integer._01_30));
        ButtonTimer.add(this, (Button) findViewById(R.id.button4),
                        (long) res.getInteger(R.integer._02_00));
        ButtonTimer.add(this, (Button) findViewById(R.id.button5),
                        (long) res.getInteger(R.integer._03_00));
    }
}
