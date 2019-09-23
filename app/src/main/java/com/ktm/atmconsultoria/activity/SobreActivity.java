package com.ktm.atmconsultoria.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.ktm.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_sobre);
        String descricao = "bla bla lsaindeiondewionfioewnfoewfnewoifneow fnqefio enfew fonewoi gewiog" + "\n" + "fewbifewifbewifb uewif ewiugb ewiugb wgiuebwgi \n";
        View sobreView = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.logo)
                .setDescription(descricao)
                .addGroup("Fale conosco")
                .addEmail("atmconsultoria@gmail.com")
                .addFacebook("facebook.com/atmcosultoria")
                .addGitHub("https://github.com/kauemurakami", "acesso meu portifolio")
                .addInstagram("@kauemurakami")
                .create();

        setContentView(sobreView);
    }
}
