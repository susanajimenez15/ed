package org.institutoserpis.ed.myactivity2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import java.util.*;

public class Android_Intent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android__intent);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Uri number = Uri.parse("tel:5551234");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

        // Punto del mapa basado en la dirección
        Uri localizacion = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
        // Punto del mapa basado en latitud/longitud
        // Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // el parametro z es el zoom
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, localizacion);

        Uri webpage = Uri.parse("http://www.android.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

        //Enviar email con archivo adjunto
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        // The intent does not have a URI, so declare the "text/plain" MIME type

        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"susi@ejemplo.com"}); // recipiente del String email
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del Email");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Texto del email");
        emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
        // You can also attach multiple items by passing an ArrayList of Uris

       //Crear un evento en el calendario
        //Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
        //Calendar beginTime = Calendar.getInstance().set(2012, 0, 19, 7, 30);
        //Calendar endTime = Calendar.getInstance().set(2012, 0, 19, 10, 30);
        //calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
        //calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
        //calendarIntent.putExtra(CalendarContract.Events.TITLE, "Ninja class");
        //calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo");
    }



}
