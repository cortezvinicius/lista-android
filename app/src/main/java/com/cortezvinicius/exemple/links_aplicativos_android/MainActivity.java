package com.cortezvinicius.exemple.links_aplicativos_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cortezvinicius.exemple.links_aplicativos.LinksAplicativos;

public class MainActivity extends AppCompatActivity {

    private Button paginaWeb, whatsapp, email, maps;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paginaWeb = findViewById(R.id.abrirPaginaWeb);
        whatsapp = findViewById(R.id.abriWhatsapp);
        email = findViewById(R.id.abrirEmail);
        maps = findViewById(R.id.maps);
        final LinksAplicativos linksAplicativos = new LinksAplicativos(this);


        paginaWeb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                linksAplicativos.abrirPaginaWeb("https://www.google.com.br");
            }
        });

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linksAplicativos.abrirWhatsapp("3592610903", "Olá Mundo");
            }
        });

        email.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String[] email = {"cortezvinicius881@gmail.com"};
                linksAplicativos.abrirEmail(email, "olá Mundo", "Título");
            }
        });

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linksAplicativos.abrirMapas("-20.916493","-46.983915", false);
            }
        });

    }
}
