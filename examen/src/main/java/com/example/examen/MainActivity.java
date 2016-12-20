package com.example.examen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    Fragment1 frag1;
    Fragment2 frag2;
    Fragment3 frag3;
    TextView textView;
    TextView textView2;
    Button atras3;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controlador = new MainActivityController(this);
        qbAdmin = new QBAdmin(controlador, this);
        fm = getSupportFragmentManager();
        fragReg = (RegistroFragment) fm.findFragmentById(R.id.fragment);
        fragLog = (LoginFragment) fm.findFragmentById(R.id.fragment2);
        frag1 = (Fragment1) fm.findFragmentById(R.id.fragment3);
        frag2 = (Fragment2) fm.findFragmentById(R.id.fragment4);
        frag3 = (Fragment3) fm.findFragmentById(R.id.fragment5);
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
        // frag 1
        atras3 = (Button) frag1.getView().findViewById(R.id.button);
        atras3.setOnClickListener(controlador);
        b1 = (Button) frag1.getView().findViewById(R.id.button2);
        b1.setOnClickListener(controlador);
        b2 = (Button) frag1.getView().findViewById(R.id.button3);
        b2.setOnClickListener(controlador);
        b3 = (Button) frag1.getView().findViewById(R.id.button4);
        b3.setOnClickListener(controlador);
        b4 = (Button) frag1.getView().findViewById(R.id.button5);
        b4.setOnClickListener(controlador);
        b5 = (Button) frag1.getView().findViewById(R.id.button6);
        b5.setOnClickListener(controlador);
        b6 = (Button) frag1.getView().findViewById(R.id.button7);
        b6.setOnClickListener(controlador);
        // frag 2
        textView = (TextView) frag2.getView().findViewById(R.id.idNot);
        textView2 = (TextView) frag2.getView().findViewById(R.id.textNot);
        // frag 3
        cambiarFragment(-1);
        qbAdmin.startSesion();
    }

    public void cambiarFragment(int frag) {

        transaction = fm.beginTransaction();
        if(frag == -1) {
            // inicializar
            transaction.hide(frag1);
            transaction.hide(frag2);
            transaction.hide(frag3);
            transaction.hide(fragLog);
            transaction.show(fragReg);
        }
         else if(frag == 0) {
            // cambiar log a reg;
            transaction.hide(fragLog);
            transaction.show(fragReg);
        } else if(frag == 1) {
            // cambiar reg a log
            transaction.hide(fragReg);
            transaction.show(fragLog);
        } else if(frag == 2) {
            // cambiar log a frag1
            transaction.hide(fragLog);
            transaction.show(frag1);
        } else if(frag == 3) {
            // cambiar frag1 a frag2
            transaction.hide(frag1);
            transaction.show(frag2);
        } else if(frag == 4) {
            // cambiar frag2 a frag3
            transaction.hide(frag2);
            transaction.show(frag3);
        }  else if(frag == 5) {
            // cambiar de cualquier frag a log
            transaction.hide(frag1);
            transaction.show(fragLog);
        }
        transaction.commit();
    }

}

