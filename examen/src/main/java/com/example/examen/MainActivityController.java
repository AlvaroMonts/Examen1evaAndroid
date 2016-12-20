package com.example.examen;

import android.content.Intent;
import android.view.View;

import com.example.examen.MainActivity;
import com.example.mylibrary.QBAdmin;

/**
 * Created by alvaro.montes on 20/12/2016.
 */
public class MainActivityController implements View.OnClickListener, View.OnFocusChangeListener {
    MainActivity vista;
    QBAdmin qbAdmin;


    public MainActivityController(MainActivity vista) {
        this.vista = vista;
       // qbAdmin = new QBAdmin(this, vista);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == vista.fragLog.Login.getId()) {
            vista.cambiarFragment(0);
           // qbAdmin.login(vista.fragLog.editText.getText().toString(), vista.fragLog.editText2.getText().toString());
        } else if (vista.fragReg.Registro.isPressed()) {
            vista.cambiarFragment(1);
           // qbAdmin.registrar(vista.fragReg.editText.getText().toString(), vista.fragReg.editText2.getText().toString());
        }/* else if (vista.cambiarMainActivity) {
            Intent i = new Intent(vista, LogeadoMainActivity.class);
            vista.startActivity(i);
            vista.finish();
        }*/

    }

    @Override
    public void onFocusChange(View view, boolean b) {

    }
}
