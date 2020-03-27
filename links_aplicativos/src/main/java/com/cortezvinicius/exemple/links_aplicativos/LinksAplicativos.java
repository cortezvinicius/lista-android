package com.cortezvinicius.exemple.links_aplicativos;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class LinksAplicativos
{
    private Activity activity;

    public LinksAplicativos(Activity activity)
    {
        this.activity = activity;
    }

    public void abrirPaginaWeb(String url)
    {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        this.activity.startActivity(intent);
    }

    public void abrirWhatsapp(String numero, String menssagem)
    {
        if (menssagem == null)
        {
            String url = "https://api.whatsapp.com/send?phone=55" + numero;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            this.activity.startActivity(intent);
        }else
        {
            String url = "https://api.whatsapp.com/send?phone=55" + numero + "&text=" + menssagem + "&source=&data=";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            this.activity.startActivity(intent);
        }
    }
    public void abrirEmail(String email[], String menssagem, String titulo)
    {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.EXTRA_SUBJECT, titulo);
        intent.putExtra(Intent.EXTRA_TEXT, menssagem);
        if (intent.resolveActivity(this.activity.getPackageManager()) != null) {
            this.activity.startActivity(intent);
        }
    }

    public void abrirMapas(String latitude, String longitude , boolean acao)
    {
        if (acao == true)
        {

            String destino = latitude +","+ longitude;

            Uri uri = Uri.parse("google.navigation:q=" + destino + "&mode=d");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            activity.startActivity(intent);

        }else
        {
            String uri = "http://maps.google.com/maps?daddr=" + latitude + "," + longitude;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setPackage("com.google.android.apps.maps");
            activity.startActivity(intent);
        }
    }

}
