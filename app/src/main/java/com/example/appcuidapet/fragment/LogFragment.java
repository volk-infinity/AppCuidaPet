package com.example.appcuidapet.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.appcuidapet.R;
import com.example.appcuidapet.activity.ContatoActivity;
import com.example.appcuidapet.activity.MainActivity;
import com.example.appcuidapet.activity.ResetPasswordActivity;
import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class LogFragment extends Fragment {


    public LogFragment() {
        // Required empty public constructor
    }

    private TextInputEditText varEmail, varSenha;
    private String email, senha;
    private Button btnEntrar;
    TextView txtEsqueciSenha;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_log, container, false);

        varEmail = view.findViewById(R.id.txtEmailLog);
        varSenha = view.findViewById(R.id.txtSenhaLog);
        txtEsqueciSenha = view.findViewById(R.id.txtEsqueciSenha);
        email = varEmail.getText().toString();
        senha = varSenha.getText().toString();

        txtEsqueciSenha();


        btnEntrar = view.findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validationLogUser(email, senha);
            }
        });

        return view;
    }

    private void txtEsqueciSenha() {

        txtEsqueciSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext().getApplicationContext(), ResetPasswordActivity.class);
                startActivity(intent);
            }
        });

    }


    public void validationLogUser(String email, String senha) {
        String txtEmail = varEmail.getText().toString();
        String txtSenha = varSenha.getText().toString();


        if (txtEmail.isEmpty() && txtSenha.isEmpty()) {
            Toast.makeText(getActivity(),
                    "Preencha TODOS os campos!",
                    Toast.LENGTH_LONG).show();
            getActivity().finish();
            Intent intent = new Intent(getContext().getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }






}



