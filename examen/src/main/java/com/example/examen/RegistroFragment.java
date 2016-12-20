package com.example.examen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.examen.MainActivity;
import com.example.examen.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroFragment extends Fragment {
    EditText editText;
    EditText editText2;
    Button Registro;
    Button atras;
    MainActivity mainActivity;

    public RegistroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_registro, container, false);
        mainActivity = (MainActivity) getActivity();
        editText = (EditText) v.findViewById(R.id.editText);
        editText2 = (EditText) v.findViewById(R.id.editText2);
        Registro = (Button) v.findViewById(R.id.button);
        atras = (Button) v.findViewById(R.id.button2);
        Registro.setOnClickListener(mainActivity.controlador);
        atras.setOnClickListener(mainActivity.controlador);
        return v;
    }

}
