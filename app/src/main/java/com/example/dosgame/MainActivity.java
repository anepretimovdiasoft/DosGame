package com.example.dosgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

import com.example.dosgame.fragment.GameFragment;
import com.example.dosgame.fragment.MenuFragment;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private MaterialButton btnMenu;
    private MenuFragment menuFragment;
    private GameFragment gameFragment;
    private boolean inGame;

    private MaterialButton btnRestart;
    private MaterialButton btnCheck;

    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuFragment = new MenuFragment();

        inGame = true;

        setContentView(R.layout.activity_main);
        gameFragment = (GameFragment) getSupportFragmentManager().getFragments().get(0);

        chronometer = findViewById(R.id.ch_time);
        chronometer.start();


        btnMenu = findViewById(R.id.btn_menu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getSupportFragmentManager();

                if (inGame) {
                    fragmentManager
                            .beginTransaction()
                            .add(R.id.nav_host_fragment_container, menuFragment)
                            .commit();
                    btnMenu.setText("game");
                } else {
                    fragmentManager
                            .beginTransaction()
                            .remove(menuFragment)
                            .commit();
                    btnMenu.setText("menu");
                }
                inGame = !inGame;
            }
        });

        btnRestart = findViewById(R.id.btn_restart);
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chronometer.stop();
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();

                gameFragment.reset();
            }
        });

        btnCheck = findViewById(R.id.btn_check);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gameFragment.checkResult()) {
                    Toast.makeText(MainActivity.this, "WIN WITH TIME : " + chronometer.getText(), Toast.LENGTH_SHORT).show();
                    chronometer.stop();
                }
                else
                    Toast.makeText(MainActivity.this, "LOSE", Toast.LENGTH_SHORT).show();
            }
        });

    }


}