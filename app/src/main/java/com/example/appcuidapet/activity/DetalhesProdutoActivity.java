package com.example.appcuidapet.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;

import com.example.appcuidapet.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

public class DetalhesProdutoActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private Button btnAddCarinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_produto);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btnAddCarinho = findViewById(R.id.btnAddCarinho);

        btnAddCarinho();


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

    private void btnAddCarinho() {
        btnAddCarinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Produto adicionado ao carrinho", Toast.LENGTH_LONG).show();
                
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_detalhes_produto, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.mnFavoritar :
                Toast.makeText(
                        this,
                        "Adicionado aos favoritos",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.mnCarrinho:
                Toast.makeText(
                        this,
                        "Adicionado ao carrinho",
                        Toast.LENGTH_LONG).show();
                break;

                case android.R.id.home:
                        finish();
                        return true;

        }

        return super.onOptionsItemSelected(item);
    }

}

