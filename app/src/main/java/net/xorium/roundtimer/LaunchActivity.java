package net.xorium.roundtimer;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LaunchActivity extends AppCompatActivity {

    /* Turns button into a button with timer using ButtonTimer class */
    private void addButtonTimer(int btnID, long duration) {
        Button b = findViewById(btnID);
        final ButtonTimer bt = new ButtonTimer(this, b, duration);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bt.isClicked())
                    bt.stop();
                else
                    bt.click();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        Resources res = getResources();
        addButtonTimer(R.id.button1, (long) res.getInteger(R.integer._00_30));
        addButtonTimer(R.id.button2, (long) res.getInteger(R.integer._01_00));
        addButtonTimer(R.id.button3, (long) res.getInteger(R.integer._01_30));
        addButtonTimer(R.id.button4, (long) res.getInteger(R.integer._02_00));
        addButtonTimer(R.id.button5, (long) res.getInteger(R.integer._03_00));
    }
}
