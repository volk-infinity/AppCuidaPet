package com.example.appcuidapet.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.appcuidapet.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class CarrinhoActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Button btnFinalizarCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);


        btnFinalizarCompra = findViewById(R.id.btnFinalizarCompra);

        btnFinalizarCompra();


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.ic_buy);

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

    private void btnFinalizarCompra() {
        btnFinalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FormasPagamentoActivity.class);
                startActivity(intent);
            }
        });
    }

}
