package com.alexbm.a30eventos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtEve, txtTit, txtCam;
    Button button;
    int x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEve = findViewById(R.id.textEvento);
        txtTit = findViewById(R.id.txtTit);
        txtCam = findViewById(R.id.textCambios);
        button = findViewById(R.id.button);


        txtCam.setVisibility(View.INVISIBLE);

        //Evento cuanto tocan
        txtEve.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        txtCam.setVisibility(View.VISIBLE);
                        txtEve.setText("MotionEvent.ACTION_DOWN, pulsar");
                        txtEve.setTextColor(Color.rgb(255,0,0));
                        txtEve.setBackgroundColor(Color.rgb(255, 255, 255));
                        txtCam.setText("onTouch");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        txtEve.setText("MotionEvent.ACTION_MOVE, manter y mover");
                        txtEve.setTextColor(Color.rgb(0, 0, 0  ));
                        break;
                    case MotionEvent.ACTION_UP:
                        txtEve.setText("MotionEvent.ACTION_UP, soltar");
                        txtEve.setTextColor(Color.rgb(180,0,180));
                        txtCam.setVisibility(View.INVISIBLE);
                        break;
                }
                return true;
            }
        });

        //Evento al hacer click
        button.setOnClickListener(view -> {
            if (x==0){
                txtEve.setBackgroundColor(Color.rgb(22, 208, 222 ));
                txtTit.setBackgroundColor(Color.rgb(22, 208, 222 ));
                txtCam.setVisibility(View.VISIBLE);
                txtCam.setText("onClick");
                x=1;
            }else {
                txtEve.setBackgroundColor(Color.rgb(210, 222, 22  ));
                txtTit.setBackgroundColor(Color.rgb(210, 222, 22  ));
                txtCam.setText("onClick, otra vez");
                x=0;
            }
        });

        //Evento al mantener pulsado
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                txtEve.setTextColor(Color.rgb(255, 255, 255  ));
                txtEve.setBackgroundColor(Color.rgb(0, 0, 0 ));
                txtCam.setVisibility(View.VISIBLE);
                txtCam.setText("onLongClick");
                return true;
            }
        });

    }
}