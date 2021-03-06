package com.example.appcuidapet.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.appcuidapet.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;


public class FormasPagamentoActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    CardView PagamentoCredito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formas_pagamento);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        PagamentoCredito = findViewById(R.id.PagamentoCredito);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.ic_buy);


        PagamentoCredito();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.ic_home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);

                        return true;

                    case R.id.ic_category:
                        startActivity(new Intent(getApplicationContext(), CategoriaActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.ic_buy:

                        return true;

                    case R.id.ic_favoritos:
                        startActivity(new Intent(getApplicationContext(), FavoritosActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.ic_mais:
                        startActivity(new Intent(getApplicationContext(), MaisActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }

                return false;
            }
        });

    }

    private void PagamentoCredito() {

        PagamentoCredito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PagamentoCreditoActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){

        switch (menuItem.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

}