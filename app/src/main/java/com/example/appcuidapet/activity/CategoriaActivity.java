package com.example.appcuidapet.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appcuidapet.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class CategoriaActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    CardView categoriaCachorros,categoriaGatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        categoriaCachorros = findViewById(R.id.categoriaCachorros);
        categoriaGatos = findViewById(R.id.categoriaGatos);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.ic_category);



        categoriaCachorros();
        categoriaGatos();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.ic_home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
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

    private void categoriaGatos() {
        categoriaGatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CategoriaGatosActivity.class);
                startActivity(intent);
            }
        });
    }

    private void categoriaCachorros() {
        categoriaCachorros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CategoriaCachorrosActivity.class);
                startActivity(intent);
            }
        });
    }
}




