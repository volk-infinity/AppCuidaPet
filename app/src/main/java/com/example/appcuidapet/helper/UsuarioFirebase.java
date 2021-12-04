package com.example.appcuidapet.helper;

import com.example.appcuidapet.config.ConfigFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UsuarioFirebase {


    public static String getIdUser(){

        FirebaseAuth usuario = ConfigFirebase.getFirebaseAuth();
        String email = usuario.getCurrentUser().getEmail();
        String idUser = Base64Custom.codificarBase64(email);

        return idUser;

    }

    public static FirebaseUser getUserAtual(){
        FirebaseAuth usuario = ConfigFirebase.getFirebaseAuth();
        return usuario.getCurrentUser();
    }





}
