package net.xorium.roundtimer;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.widget.Button;

import java.sql.Time;

public class ButtonTimer extends CountDownTimer {

    private Button btn;
    private String btnDefaultText;
    private Time time;
    private Boolean clicked;
    private MediaPlayer beep;
    private static final long TICK = 10; // ms

    ButtonTimer(Context context, Button b, long startTime) {
        super(startTime, TICK);

        clicked = false;
        btn = b;
        btnDefaultText = b.getText().toString();
        time = new Time(startTime);
        beep = MediaPlayer.create(context, R.raw.beep);
    }

    public void click() {
        super.start();
        beep.start();
        clicked = true;
    }

    public void stop() {
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

    public Boolean isClicked() {
        return clicked;
    }
}
