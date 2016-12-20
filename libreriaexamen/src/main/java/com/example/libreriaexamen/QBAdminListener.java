package com.example.libreriaexamen;

import com.quickblox.core.model.QBBaseCustomObject;
import com.quickblox.users.model.QBUser;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by alvaro.montes on 29/11/2016.
 */
public interface QBAdminListener {
    public void logeado(boolean bllogeado, QBUser user);
    public void registrado(boolean blregistrado);
    public void datosDescargados(ArrayList<QBBaseCustomObject> datos);
    public void datosTablaIdiomaDescargado(HashMap<Integer, String> palabrasDescargadas);
}
