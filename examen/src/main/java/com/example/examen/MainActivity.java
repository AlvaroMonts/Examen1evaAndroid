package com.example.examen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.examen.R;
import com.example.libreriaexamen.QBAdmin;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    LoginFragment fragLog;
    RegistroFragment fragReg;
    FragmentManager fm;
    FragmentTransaction transaction;
    //android.support.v4.app.FragmentManager fm;
   // android.support.v4.app.FragmentTransaction fragmentTransaction;
    MainActivityController controlador;
    QBAdmin qbAdmin;



    EditText editText;
    EditText editText2;
    Button Registro;
    Button atras;

    EditText editText3;
    EditText editText4;
    Button Login;
    Button atras2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controlador = new MainActivityController(this);
        qbAdmin = new QBAdmin(controlador, this);
        fm = getSupportFragmentManager();
        fragReg = (RegistroFragment) fm.findFragmentById(R.id.fragment);
        fragLog = (LoginFragment) fm.findFragmentById(R.id.fragment2);
        // login
        editText3 = (EditText) fragLog.getView().findViewById(R.id.editText3);
        editText4 = (EditText) fragLog.getView().findViewById(R.id.editText4);
        atras2 = (Button) fragLog.getView().findViewById(R.id.atrasLog);
        Login = (Button) fragLog.getView().findViewById(R.id.login);
        controlador.toString();
        Login.setOnClickListener(controlador);
        atras2.setOnClickListener(controlador);
        // registro
        editText = (EditText) fragReg.getView().findViewById(R.id.editText);
        editText2 = (EditText) fragReg.getView().findViewById(R.id.editText2);
        Registro = (Button) fragReg.getView().findViewById(R.id.registrar);
        atras = (Button) fragReg.getView().findViewById(R.id.atrasReg);
        Registro.setOnClickListener(controlador);
        atras.setOnClickListener(controlador);
        cambiarFragment(0);
        qbAdmin.startSesion();
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

