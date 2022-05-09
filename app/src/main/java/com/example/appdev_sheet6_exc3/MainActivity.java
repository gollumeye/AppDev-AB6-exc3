package com.example.appdev_sheet6_exc3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.time.Duration;

public class MainActivity extends AppCompatActivity {
    GestureDetector gestureDetector;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.view);

        gestureDetector= new GestureDetector(this, new PersonalizedGestureDetector());

        view.setOnTouchListener(touchListener);

    }

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return gestureDetector.onTouchEvent(event);

        }
    };

    public void showSnackbar(String input){
        Snackbar snackbar = Snackbar.make(view, input, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    class PersonalizedGestureDetector extends GestureDetector.SimpleOnGestureListener{
        public PersonalizedGestureDetector() {
            super();
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            showSnackbar("Detected Single Tap Event");
            return super.onSingleTapUp(e);
        }

        //Long press gesture
        @Override
        public void onLongPress(MotionEvent e) {
            showSnackbar("Detected Long Press Event");
            super.onLongPress(e);
        }

        //Scroll gesture
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            showSnackbar("Detected Scroll Event");
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        //Swipe gesture
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            showSnackbar("Detected Fling Event");
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        //Down motion, but up up motion has not been detected yet
        @Override
        public void onShowPress(MotionEvent e) {
            showSnackbar("Detected Down Motion Event with no Up Motion yet");
            super.onShowPress(e);
        }

        //double tap gesture
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            showSnackbar("Detected Double Tap Event");
            return super.onDoubleTap(e);
        }

    }



}