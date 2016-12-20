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
public class LoginFragment extends Fragment {
    EditText editText;
    EditText editText2;
    Button Login;
    Button atras;
    MainActivity mainActivity;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        mainActivity = (MainActivity) getActivity();
        editText = (EditText) v.findViewById(R.id.editText);
        editText2 = (EditText) v.findViewById(R.id.editText2);
        atras = (Button) v.findViewById(R.id.button2);
        Login = (Button) v.findViewById(R.id.button);
        return v;
    }

    public void login(View v) {
        mainActivity.qbAdmin.login(editText.getText().toString(), editText2.getText().toString());
        mainActivity.cambiarFragment(0);
    }

    public void atras(View v) {
        mainActivity.cambiarFragment(1);
    }
}
