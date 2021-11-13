package com.example.appcuidapet.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.appcuidapet.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class CategoriaGatosActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    CardView AlimentGato,AcessoGato,HigieneGato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_gatos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AlimentGato = findViewById(R.id.AlimentGato);
        AcessoGato = findViewById(R.id.AcessoGato);
        HigieneGato = findViewById(R.id.HigieneGato);


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.ic_category);


        AlimentGato();
        AcessoGato();
        HigieneGato();



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.ic_home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);

                        return true;

                    case R.id.ic_category:

                        return true;

                    case R.id.ic_buy:
                        startActivity(new Intent(getApplicationContext(),CarrinhoActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.ic_favoritos:
                        startActivity(new Intent(getApplicationContext(),FavoritosActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.ic_mais:
                        startActivity(new Intent(getApplicationContext(),MaisActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }

                return false;
            }
        });

    }

    private void AlimentGato() {
        AlimentGato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AlimentacaoGatoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void AcessoGato() {
        AcessoGato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AcessoriosGatoActivity.class);
                startActivity(intent);
            }
        });
    }


    private void HigieneGato() {
        HigieneGato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HigieneGatoActivity.class);
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