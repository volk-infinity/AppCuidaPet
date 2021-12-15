package com.example.appcuidapet.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.appcuidapet.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class AlimentacaoDogActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageView imgProduto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentacao_dog);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        imgProduto1 = findViewById(R.id.imgProduto1);

        imgProduto1();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.ic_category);


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
                        startActivity(new Intent(getApplicationContext(), CarrinhoActivity.class));
                        overridePendingTransition(0, 0);
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

    private void imgProduto1() {
        imgProduto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetalhesProdutoActivity.class);
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