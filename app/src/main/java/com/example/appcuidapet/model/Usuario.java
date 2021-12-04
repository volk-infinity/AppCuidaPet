package com.example.appcuidapet.model;

import com.example.appcuidapet.config.ConfigFirebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;
import com.example.appcuidapet.helper.UsuarioFirebase;
import com.google.firebase.database.FirebaseDatabase;



public class Usuario {
    private String idUsuario;
    private String nome;
    private String email;
    private String senha;

    public Usuario() {

    }

    @Exclude
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Exclude
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    @Exclude
    public Map<String, Object> converterParaMap(){
        HashMap<String, Object> usuarioMap = new HashMap<>();

        usuarioMap.put("email",getEmail());
        usuarioMap.put("nome", getNome());
        usuarioMap.put("senha",getSenha());

        return usuarioMap;
    }


    public void salvar() {
        DatabaseReference firebaseRef = ConfigFirebase.getFirebaseDatabase();
        DatabaseReference usuario = firebaseRef.child("usuarios").child(getIdUsuario());

        usuario.setValue(this);
    }
}



