package com.example.sprintfinalmodulo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sprintfinalmodulo4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent contactIntent = new Intent(MainActivity.this, ContactoBinding.class);

        binding.btnContactar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactIntent.putExtra("idFondo", R.drawable.fondo);
                contactIntent.putExtra("idProfile", R.drawable.mi_imagen);
                startActivity(contactIntent);
            }
        });

        binding.btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
