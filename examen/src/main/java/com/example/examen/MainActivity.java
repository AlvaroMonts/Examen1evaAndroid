package com.example.examen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.examen.R;
import com.example.libreriaexamen.QBAdmin;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    LoginFragment fragLog;
    RegistroFragment fragReg;
    FragmentManager fm;
    FragmentTransaction transaction;
    MainActivityController controlador;
    QBAdmin qbAdmin;
   // boolean cambiarMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  cambiarMainActivity = false;
        controlador = new MainActivityController(this);
        qbAdmin = new QBAdmin(controlador, this);
        fm = getSupportFragmentManager();
        fragReg = (RegistroFragment) fm.findFragmentById(R.id.fragment);
        fragLog = (LoginFragment) fm.findFragmentById(R.id.fragment2);
        cambiarFragment(0);
    }

    public void cambiarFragment(int frag) {
        transaction = fm.beginTransaction();
        if(frag == 0) {
            // cambiar log a reg
            transaction.hide(fragLog);
            transaction.show(fragReg);
        } else if(frag == 1) {
            // cambiar reg a log
            transaction.hide(fragReg);
            transaction.show(fragLog);
        }
        transaction.commit();
    }

}

