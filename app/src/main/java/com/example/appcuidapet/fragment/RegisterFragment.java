package com.example.appcuidapet.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.appcuidapet.R;
import com.example.appcuidapet.activity.AlimentacaoDogActivity;
import com.example.appcuidapet.activity.MainActivity;
import com.example.appcuidapet.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */

public class RegisterFragment extends Fragment {

    Button btnCadastrar;
    TextInputEditText varNome, varEmail, varSenha;
    String email, senha;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        varNome = view.findViewById(R.id.txtNomeUser);
        varEmail = view.findViewById(R.id.txtEmailRegister);
        varSenha = view.findViewById(R.id.txtSenhaRegister);
        btnCadastrar = view.findViewById(R.id.btnCadastrar);
        email = varEmail.getText().toString();
        senha = varSenha.getText().toString();


       return view;

    }



}








