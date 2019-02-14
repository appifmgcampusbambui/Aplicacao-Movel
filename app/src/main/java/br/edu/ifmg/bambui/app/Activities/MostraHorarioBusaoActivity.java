package br.edu.ifmg.bambui.app.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import br.edu.ifmg.bambui.app.classes.Toolbar_Classe;
import br.edu.ifmg.bambui.app.R;

public class MostraHorarioBusaoActivity extends Toolbar_Classe {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent it = getIntent();
        String layout = it.getStringExtra("layout");
        System.out.println(layout);
        setContentView((layout.equals("semana")) ? R.layout.activity_mostra_horario_busao_semana : R.layout.activity_mostra_horario_busao_fds);

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Horário de Ônibus");
        CreateDrawerLayout();



    }

}
