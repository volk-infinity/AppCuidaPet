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

public class CategoriaCachorrosActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    CardView AlimentDog,AcessoDog,HigieneDog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_cachorros);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AlimentDog = findViewById(R.id.AlimentDog);
        AcessoDog = findViewById(R.id.AcessoDog);
        HigieneDog = findViewById(R.id.HigieneDog);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.ic_category);


        AlimentDog();
        AcessoDog();
        HigieneDog();


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

    private void AlimentDog() {
        AlimentDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AlimentacaoDogActivity.class);
                startActivity(intent);
            }
        });
    }

    private void AcessoDog() {
        AcessoDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AcessoriosDogActivity.class);
                startActivity(intent);
            }
        });
    }


    private void HigieneDog() {
        HigieneDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HigieneDogActivity.class);
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