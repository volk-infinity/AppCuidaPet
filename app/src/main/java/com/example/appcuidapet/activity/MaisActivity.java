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

public class MaisActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    CardView contato,localizacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mais);

        contato = findViewById(R.id.contato);
        localizacao = findViewById(R.id.localizacao);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.ic_mais);



        contato();
        localizacao();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.ic_home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);

                        return true;

                    case R.id.ic_category:
                        startActivity(new Intent(getApplicationContext(),CategoriaActivity.class));
                        overridePendingTransition(0,0);
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

                        return true;
                }

                return false;
            }
        });

    }

    private void contato() {
        contato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ContatoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void localizacao() {
        localizacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LocalizacaoActivity.class);
                startActivity(intent);
            }
        });
    }

}