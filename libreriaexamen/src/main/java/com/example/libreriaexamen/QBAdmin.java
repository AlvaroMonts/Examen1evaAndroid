package com.example.libreriaexamen;

import android.app.Activity;
import android.os.Bundle;

import com.quickblox.auth.QBAuth;
import com.quickblox.auth.model.QBSession;
import com.quickblox.core.QBEntityCallback;
import com.quickblox.core.QBSettings;
import com.quickblox.core.exception.QBResponseException;
import com.quickblox.core.request.QBRequestGetBuilder;
import com.quickblox.customobjects.QBCustomObjects;
import com.quickblox.customobjects.model.QBCustomObject;
import com.quickblox.users.QBUsers;
import com.quickblox.users.model.QBUser;

import java.util.ArrayList;
import java.util.HashMap;

public class QBAdmin {
    QBAdminListener listener;

    public QBAdmin(QBAdminListener listener, Activity activity) {
        this.listener = listener;

        String APP_ID = "50017";
        String AUTH_KEY = "Oe732e2AuUmOema";
        String AUTH_SECRET = "DDa5778gV3eBszm";
        String ACCOUNT_KEY = "RMmAJBwgNwZZ1ArnNfig";

        QBSettings.getInstance().init(activity,APP_ID, AUTH_KEY, AUTH_SECRET);
        QBSettings.getInstance().setAccountKey(ACCOUNT_KEY);

    }

    public void login(String user, String pass){
        QBUser qbUsers = new QBUser(user, pass);
        QBUsers.signIn(qbUsers, new QBEntityCallback<QBUser>() {
            @Override
            public void onSuccess(QBUser qbUser, Bundle bundle) {
                listener.logeado(true, qbUser); // el qbuser de parametro de encima
            }

            @Override
            public void onError(QBResponseException e) {
                listener.logeado(false, null);
            }
        });

    }

    public void registrar(String user, String pass){
        QBUser usuario = new QBUser(user, pass);

        QBUsers.signUp(usuario, new QBEntityCallback<QBUser>() {
            @Override
            public void onSuccess(QBUser user, Bundle args) {
                listener.registrado(true);
            }

            @Override
            public void onError(QBResponseException errors) {
                listener.registrado(false);
            }
        });
    }

    public void startSesion(){
        QBAuth.createSession(new QBEntityCallback<QBSession>() {
            @Override
            public void onSuccess(QBSession session, Bundle params) {
                System.out.println("Sesion iniciada");
            }

            @Override
            public void onError(QBResponseException errors) {
                System.out.println("Sesion no iniciada");
            }
        });
    }

    public void selectTabla(int id_cat) {
        QBRequestGetBuilder select = new QBRequestGetBuilder();
        select.eq("idcategoria", id_cat);
        QBCustomObjects.getObjects("noticiatexto", select, new QBEntityCallback<ArrayList<QBCustomObject>>() {
            @Override
            public void onSuccess(ArrayList<QBCustomObject> qbCustomObjects, Bundle bundle) {
                HashMap<Integer, String> palabras = new HashMap<Integer, String>();
                for (int a =0; a < qbCustomObjects.size(); a++) {
                    String texto = qbCustomObjects.get(a).getFields().get("noticiatexto").toString();
                    int id = (int) qbCustomObjects.get(a).getFields().get("noticiaid");
                    palabras.put(id, texto);
                }
                listener.datosTablaNoticiasTexto(palabras);
            }

            @Override
            public void onError(QBResponseException e) {

            }
        });
    }
}
