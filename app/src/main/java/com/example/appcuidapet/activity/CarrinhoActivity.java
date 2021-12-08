package com.example.appcuidapet.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appcuidapet.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.List;


public class CarrinhoActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private Button btnFinalizarCompra;
    private ImageButton SomaButton, DiminuiButton;
    private TextView TextViewQtde, subTotalText, TextViewTotalPedido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);


        btnFinalizarCompra = findViewById(R.id.btnFinalizarCompra);
        SomaButton = findViewById(R.id.SomaButton);
        DiminuiButton = findViewById(R.id.DiminuiButton);
        TextViewQtde =  findViewById(R.id.TextViewQtde);
        subTotalText = findViewById(R.id.subTotalText);
        TextViewTotalPedido = findViewById(R.id.TextViewTotalPedido);


        btnFinalizarCompra();
        SomaButton();
        DiminuiButton();
        TextViewTotalPedido();


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.ic_buy);

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


    private void DiminuiButton() {
        DiminuiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double valorUnitario = 120.0;
                Double subTotal = Double.parseDouble(subTotalText.getText().toString());
                Integer qtde =  Integer.parseInt(TextViewQtde.getText().toString());
                qtde -= 1;

                if(qtde>=1){
                    String subtotal = String.valueOf(subTotal-valorUnitario);
                    subTotalText.setText(subtotal.toString());
                    TextViewQtde.setText(qtde.toString());
                } else {
                    Toast.makeText(getApplicationContext(), "Valor mínimo de itens no carrinho", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void SomaButton() {
        SomaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double valorUnitario = 120.0;
                Double subTotal = Double.parseDouble(subTotalText.getText().toString());
                Integer qtde =  Integer.parseInt(TextViewQtde.getText().toString());
                qtde += 1;

                if(qtde>=1){
                    String subtotal = String.valueOf(qtde * valorUnitario);
                    subTotalText.setText(subtotal);
                    TextViewQtde.setText(qtde.toString());
                }
            }
        });
       return;
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


    private void TextViewTotalPedido() {
        TextViewTotalPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double valorUnitario = 120.0;
                Integer qtde =  Integer.parseInt(TextViewQtde.getText().toString());
                qtde += 1;

                if(qtde>=1){
                    String subtotal = String.valueOf(qtde * valorUnitario);
                    subTotalText.setText(subtotal);
                    TextViewQtde.setText(qtde.toString());
                }
            }
        });

        return;
    }

}

