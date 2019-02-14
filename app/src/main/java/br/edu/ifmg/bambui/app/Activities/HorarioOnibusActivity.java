package br.edu.ifmg.bambui.app.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import br.edu.ifmg.bambui.app.classes.Toolbar_Classe;
import br.edu.ifmg.bambui.app.R;

public class HorarioOnibusActivity extends Toolbar_Classe {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_onibus);

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Horário de Ônibus");
        CreateDrawerLayout();

        final Button buttonSemana = (Button) findViewById(R.id.buttonbusaosemana);
        buttonSemana.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MostraHorarioBusaoActivity.class);
                intent.putExtra("layout", "semana");
                startActivity(intent);
            }
        });

        final Button buttonFds = (Button) findViewById(R.id.buttonbusaofds);
        buttonFds.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MostraHorarioBusaoActivity.class);
                intent.putExtra("layout", "fds");
                startActivity(intent);
            }
        });
    }
}
