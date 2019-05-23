package com.example.napalarm;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NapEnd extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.napend);

        NotificationManager NM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NM.cancel(MainActivity.NAPNOTI);

        Button btn = (Button) findViewById(R.id.end_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
