package com.example.appcuidapet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.MenuItemCompat;

import com.example.appcuidapet.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageView imgHome;
    CardView produto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imgHome = findViewById(R.id.imgHome);
        produto1 = findViewById(R.id.produto1);

        imgHome();
        produto1();


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.ic_home);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.ic_home:

                        return true;

                    case R.id.ic_category:
                        startActivity(new Intent(getApplicationContext(), CategoriaActivity.class));
                        overridePendingTransition(0, 0);
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

    //config botao pesquisa

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.mnPesquisar);


        return super.onCreateOptionsMenu(menu);
    }


    private void imgHome() {
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoriaActivity.class);
                startActivity(intent);
            }
        });
    }

    private void produto1() {
        produto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetalhesProdutoActivity.class);
                startActivity(intent);
            }
        });
    }

}