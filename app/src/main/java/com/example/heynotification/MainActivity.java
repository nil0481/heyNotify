package com.example.heynotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ArrayList<Cake> cakes;
    Adapter adapter;

    Button cartbutton,selectbutton;
    public static final String NOTIFICATION_CHANNEL_ID = "10001" ;
    private final static String default_notification_channel_id = "default" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        JsonParser jsonparser = new JsonParser();
//        JsonObject jobj=null;
//        jobj = jsonparser.makeHttpRequest("http://myurlhere.com");
        recyclerView=findViewById(R.id.cakelist);
        cakes=new ArrayList<>();
        cartbutton=findViewById(R.id.msgbutton);
        selectbutton=findViewById(R.id.notibutton);

        cartbutton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              String msg = "Hello, You have a message!";



              Intent notificationIntent = new Intent(getApplicationContext(), Message.class);
//              startActivity(notificationIntent);

              notificationIntent.addCategory(Intent.CATEGORY_LAUNCHER);
              notificationIntent.setAction(Intent.ACTION_MAIN);
              notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
              PendingIntent resultIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent, 0);
              NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(),
                      default_notification_channel_id)
                      .setSmallIcon(R.drawable.ic_launcher_foreground)
                      .setContentTitle("Message")
                      .setContentText(msg)
                      .setContentIntent(resultIntent);
              NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
              if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                  int importance = NotificationManager.IMPORTANCE_HIGH;
                  NotificationChannel notificationChannel = new
                          NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance);
                  mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
                  assert mNotificationManager != null;
                  mNotificationManager.createNotificationChannel(notificationChannel);
              }
              assert mNotificationManager != null;
              mNotificationManager.notify((int) System.currentTimeMillis(),
                      mBuilder.build());




          }


        });

        selectbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String noti = "Hello, You have a notification!";


                Intent notificationIntent = new Intent(getApplicationContext(), Notify.class);
//              startActivity(notificationIntent);

                notificationIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                notificationIntent.setAction(Intent.ACTION_MAIN);
                notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                PendingIntent resultIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent, 0);
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(),
                        default_notification_channel_id)
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("Notification")
                        .setContentText(noti)
                        .setContentIntent(resultIntent);
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    int importance = NotificationManager.IMPORTANCE_HIGH;
                    NotificationChannel notificationChannel = new
                            NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance);
                    mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
                    assert mNotificationManager != null;
                    mNotificationManager.createNotificationChannel(notificationChannel);
                }
                assert mNotificationManager != null;
                mNotificationManager.notify((int) System.currentTimeMillis(),
                        mBuilder.build());




            }


        });


        extractCakes();


    }




    private void extractCakes() {


        String[] name = {"TIRUPATI BALAJI", "SHIVA TEMPLES", " JYOTIRLINGAM", "THE EIGHT IMMORTALS", " KAMAKHYA DEVI", "LORD SHIVA", "KALANTAK",
                "HEALTH BENEFITS", "MAHA MRITYUNJAYA", "MOLES", "COWURINE", "TIME TRAVEL", "AMARNATH YATRA"};
        String[] img = {"https://aastik.in/wp-content/uploads/2017/03/e0c73592c8ca318891ab8d256e223ce8-218x150.jpg", "https://aastik.in/wp-content/uploads/2017/05/adiyogi-shiva-218x150.jpg", "https://aastik.in/wp-content/uploads/2016/09/Lord-Mahakal-Jyotir-linga-100x70.jpg",
                "https://aastik.in/wp-content/uploads/2017/05/dragon-warrior-4-by-camilkuo-on-deviantart-218x150.jpg",
                "https://aastik.in/wp-content/uploads/2016/09/Secrets-Of-Kamakhya-Devi-Temple-Menstruating-Goddess-In-India-2-218x150.jpg",
                "https://aastik.in/wp-content/uploads/2017/03/IMG_0595-218x150.jpg", "https://aastik.in/wp-content/uploads/2016/09/asd-218x150.jpg",
                "https://aastik.in/wp-content/uploads/2017/03/heartsickness-428103_1920-218x150.jpg", "https://aastik.in/wp-content/uploads/2017/03/heartsickness-428103_1920-218x150.jpg",
                "https://aastik.in/wp-content/uploads/2016/09/mole-new-218x150.png", "https://aastik.in/wp-content/uploads/2017/05/578940_527767147274756_1596797716_n-218x150.jpg",
                "https://aastik.in/wp-content/uploads/2017/08/quantum-time-travel-218x150.jpg", "https://aastik.in/wp-content/uploads/2016/09/11005066_928123923878503_1305796995_n-218x150.jpg"};

        String[] desc = {"The Legend Shri Venkateswara: Venkateswara the king, is the incarnation of Lord Vishnu. ",
                "A Grand Mystery: Does the ancient Hindu sages (ऋषि) had some technology ", " Meaning of Jyotirlingam: Jyotirlingam means light or fiery form of lord shiva",
                " According to the Hindu Mythology Kaliyuga  (the time in which we are right now) will come to an end, God have decided the judgment...",
                "About the Temple Kamakhya Devi Temple is located in western part of Guwahati in assam", "What Is Special About Mount Kailash Mt. Kailash is the mountain which is considered as one of the most beautiful and divine",
                "Kalantak Shiva: As we all know that Lord Shiva has many names and there is a story behind every name. ",
                "According to a scripture Ashtanga  Hridayam written by Maharishi Vagbhata limestone can cure 70 diseases in human body.",
                "Meaning: Maha – Greater Mrityu – Death Jaya      -  Victory Maha Mrityunjaya –", "According to Indian and Chinese astrology, moles on a body tell the future of a person. ",
                "Renowned Ayurveda author Vagbhata who wrote extremely amazing book on Ayurveda Ashtanga Hridaya 3500 years ago",
                "Here we have summed up three time travel stories,all these time travelers have traveled through time in future or past and have also give...", "Amarnath yatra is a journey done by lakhs of Hindus in a year. What is there in this place called amaranth"};
        for (int i = 0, j = 0; i < name.length; i++) {
            Cake cake = new Cake();
            cake.setCake_name(name[i]);
            cake.setWeight(desc[i]);
//            cake.setPrice(name[i]);

            cake.setImgUrl(img[i]);
            cakes.add(cake);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            adapter = new Adapter(getApplicationContext(), cakes);
            recyclerView.setAdapter(adapter);

        }

    }
}
