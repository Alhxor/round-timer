package net.xorium.roundtimer;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import java.sql.Time;

public class ButtonTimer extends CountDownTimer {

    private Button btn;
    private String btnDefaultText;
    private Time time;
    private Boolean clicked;
    private MediaPlayer beep;
    private static final long TICK = 10; // ms

    /* Turns a button into a button with timer */
    public static void add(Context context, Button b, long duration) {
        final ButtonTimer bt = new ButtonTimer(context, b, duration);

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

    private ButtonTimer(Context context, Button b, long startTime) {
        super(startTime, TICK);

        clicked = false;
        btn = b;
        btnDefaultText = b.getText().toString();
        time = new Time(startTime);
        beep = MediaPlayer.create(context, R.raw.beep);
    }

    private void click() {
        super.start();
        beep.start();
        clicked = true;
    }

    private void stop() {
        super.cancel();
        clicked = false;
        btn.setText(btnDefaultText);
    }

    @Override
    public void onFinish() {
        this.click(); // keep restarting until cancelled
    }

    @Override
    public void onTick(long msUntilFinished) {
        time.setTime(msUntilFinished);
        Long ms = (msUntilFinished % 1000) / 100;
        // TODO: use String.format instead
        btn.setText(time.toString().substring(3) + "." + ms.toString());
    }

    private Boolean isClicked() {
        return clicked;
    }
}
