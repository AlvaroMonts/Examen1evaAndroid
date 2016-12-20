package com.example.examen;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.examen.MainActivity;
import com.example.libreriaexamen.*;
import com.quickblox.core.model.QBBaseCustomObject;
import com.quickblox.users.model.QBUser;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by alvaro.montes on 20/12/2016.
 */
public class MainActivityController implements View.OnClickListener, View.OnFocusChangeListener, QBAdminListener {
    MainActivity vista;

    public MainActivityController(MainActivity vista) {
        this.vista = vista;

    }


    @Override
    public void onClick(View view) {
        if (vista.Login.isPressed()) {
            vista.qbAdmin.login(vista.editText4.getText().toString(), vista.editText3.getText().toString());
        } else if (vista.Registro.isPressed()) {
            vista.qbAdmin.registrar(vista.editText2.getText().toString(), vista.editText.getText().toString());
        } else if (vista.atras2.isPressed()) {
            vista.cambiarFragment(0);
        } else if (vista.atras.isPressed()) {
            vista.cambiarFragment(1);
        }/* else if (vista.cambiarMainActivity) {
            Intent i = new Intent(vista, LogeadoMainActivity.class);
            vista.startActivity(i);
            vista.finish();
        }*/
    }

    @Override
    public void onFocusChange(View view, boolean b) {

    }

    @Override
    public void logeado(boolean bllogeado, QBUser user) {
        if (bllogeado) {
            
        } else {
            Toast toast = Toast.makeText(this.vista, "El usuario y/o contraseña no son validos", Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void registrado(boolean blregistrado) {
        if (blregistrado) {
            vista.cambiarFragment(1);
        } else {
            Toast toast = Toast.makeText(this.vista, "El usuario y/o contraseña no son validos", Toast.LENGTH_SHORT);
        }
    }
}
