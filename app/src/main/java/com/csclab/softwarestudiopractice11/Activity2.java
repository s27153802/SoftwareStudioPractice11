package com.csclab.softwarestudiopractice11;


import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by mei on 5/24/16.
 */

public class Activity2 extends Activity {

    private TextView nameText;
    private ImageView dino;
    private Bundle bundle;
    private String name;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        /** To Do:
         * (1) Find the UI element on xml file
         * (2) Use Bundle to retrieve name string
         * (3) Display "Welcome 'username' "
         * (4) Set image resource (Hint: drawable) and its touch listener **/
        bundle = this.getIntent().getExtras();
        String name = bundle.getString("name");
        nameText = (TextView) findViewById(R.id.welcome);
        nameText.setText("Welcome "+name);
        dino=(ImageView)  findViewById(R.id.imageView);
        dino.setImageResource(R.drawable.dino);
        dino.setOnTouchListener(imgListener);




        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private OnTouchListener imgListener;

    {
        imgListener = new OnTouchListener() {
            private float x, y; //The x, y position that image exist
            private int mx, my; // The distance from original position to finger dragging

            /**
             * To Do:
             * (1) Handle different touch events in onTouch method
             * (2) You can use v.layout() to change dinosaur's position
             * Hint: The event you may encounter: ACTION_DOWN & ACTION_MOVE
             **/

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mx = (int) (event.getRawX() - x);
                my = (int) (event.getRawY() - 50 - y);
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        x=event.getX();
                        y=event.getY();
                        v.invalidate();
                   //     v.layout((int)x,(int)(y+v.getHeight()),(int)(x+v.getWidth()),(int)y);
                    break;
                    case   MotionEvent.ACTION_MOVE:

                        v.layout(mx,my,(int)(mx+v.getWidth()),(int)(my+v.getHeight()));
                        v.invalidate();
                        break;
                    case MotionEvent.ACTION_UP:
                        v.layout((int)mx,(int)my,(int)(mx+v.getWidth()),(int)(my+v.getHeight()));
                        v.invalidate();
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        v.layout((int)0,(int)0,(int)(0+v.getWidth()),(int)(0+v.getHeight()));
                        v.invalidate();


                    break;

                }
                return true;
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Activity2 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.csclab.softwarestudiopractice11/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Activity2 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.csclab.softwarestudiopractice11/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
