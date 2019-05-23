package com.example.napalarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final int NAPNOTI = 1;
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Button btn = (Button) findViewById(R.id.start_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "안녕히 주무세요.", Toast.LENGTH_SHORT).show();
                v.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this,NapEnd.class);
                        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);

                        //noti.defaults |= Notification.DEFAULT_SOUND;
                        //noti.flags |= Notification.FLAG_INSISTENT;
                        Notification.Builder builder = new Notification.Builder(MainActivity.this)
                                .setContentIntent(pendingIntent)
                                .setSmallIcon(R.drawable.ic_launcher_background)
                                .setContentTitle("일어나세요.")
                                .setContentText("test")
                                .setDefaults(Intent.FLAG_ACTIVITY_NEW_TASK)
                                .setDefaults(Notification.DEFAULT_SOUND)
                                .setTicker("소식이 왔어요!");
                        Notification notification = builder.build();
                        notificationManager.notify(MainActivity.NAPNOTI,notification);
                    }
                }, 5*1000);
            }
        });
    }
}
