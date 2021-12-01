package com.example.appcuidapet.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.appcuidapet.R;
import com.example.appcuidapet.activity.MainActivity;
import com.example.appcuidapet.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import org.jetbrains.annotations.NotNull;


/**
 * A simple {@link Fragment} subclass.
 */

public class RegisterFragment extends Fragment {

    private Button btnCadastrar;
    private TextInputEditText varNome, varEmail, varSenha;
    private String email, senha;
    private FirebaseAuth auth;


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


        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validationUser(email, senha);
            }
        });

        return view;

    }

    public void validationUser(String email, String senha) {
        String txtNomeUser = varNome.getText().toString();
        String txtEmail = varEmail.getText().toString();
        String txtSenha = varSenha.getText().toString();

        if (!txtNomeUser.isEmpty() && !txtEmail.isEmpty() && !txtSenha.isEmpty())
            if (!txtNomeUser.isEmpty()) {
                if (!txtEmail.isEmpty()) {
                    if (!txtSenha.isEmpty()) {

                        Usuario usuario = new Usuario();
                        usuario.setNome(txtNomeUser);
                        usuario.setEmail(txtEmail);
                        usuario.setSenha(txtSenha);

                        registerUser(usuario);
                    } else {
                        Toast.makeText(getActivity(),
                                "Senha não preenchida",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getActivity(),
                            "E-mail não preenchido",
                            Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getActivity(),
                        "Nome não preenchido",
                        Toast.LENGTH_LONG).show();
            }

        else {
            Toast.makeText(getActivity(),
                    "Preencha todos os campos!",
                    Toast.LENGTH_LONG).show();


        }
    }

    private void registerUser(final Usuario usuario) {
        auth = ConfigFirebase.getFirebaseAuth();
        auth.createUserWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(getActivity(),
                            "Sucesso ao cadastrar o usuário",
                            Toast.LENGTH_LONG).show();
                    getActivity().finish();

                    Intent intent = new Intent(getContext().getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                    try {
                        String idUsuario = (usuario.getEmail());
                        usuario.setIdUsuario(idUsuario);
                        usuario.salvar();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    String excecao = "";
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) {
                        excecao = "Digite uma senha mais forte";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        excecao = "Digite um e-mail valido";
                    } catch (FirebaseAuthUserCollisionException e) {
                        excecao = "Essa conta já foi cadastrada";
                    } catch (Exception e) {
                        excecao = "Erro ao cadastrar usuário" + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(getActivity(),
                            excecao,
                            Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}























