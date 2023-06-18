package com.example.sprintfinalmodulo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sprintfinalmodulo4.databinding.ActivityContactoBinding;

public class ContactoBinding extends AppCompatActivity {
    private ActivityContactoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent myIntent = getIntent();

        binding.fondoImg.setImageResource(myIntent.getIntExtra("idFondo", 0));
        binding.profileImg.setImageResource(myIntent.getIntExtra("idProfile", 0));

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.txtMsg.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "No puedes enviar un mensaje vacío!", Toast.LENGTH_LONG).show();
                    binding.txtMsg.setError("Con un saludo me conformo :)");
                } else {
                    String email = "sup.cmcc@gmail.com";
                    String subject = "Hola Claudio";
                    String message = binding.txtMsg.getText().toString().trim();

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("message/rfc822"); // Establece el tipo MIME para correo electrónico

                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                    intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                    intent.putExtra(Intent.EXTRA_TEXT, message);

                    // Verifica si hay alguna aplicación que pueda manejar la acción
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(Intent.createChooser(intent, "Enviar correo electrónico"));
                    } else {
                        Toast.makeText(getApplicationContext(), "No se encontró ninguna aplicación de correo electrónico.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.btnWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "+56935249871";
                String message = "¡Claudio! Necesito contactarme contigo.";
                String url = "https://wa.me/" + phoneNumber + "/?text=" + Uri.encode(message);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        binding.btnGitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://github.com/claucas90";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(link));
                startActivity(intent);
            }
        });

        binding.btnLinkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://www.linkedin.com/in/claudio-michel-castro-cifuentes/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(link));
                startActivity(intent);
            }
        });
    }
}
