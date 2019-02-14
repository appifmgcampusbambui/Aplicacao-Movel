package br.edu.ifmg.bambui.app.Activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import br.edu.ifmg.bambui.app.classes.Toolbar_Classe;
import br.edu.ifmg.bambui.app.R;

public class TelaLugarActivity extends Toolbar_Classe {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lugar);

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Localização");
        CreateDrawerLayout();

        String nome_do_lugar = getIntent().getStringExtra("nomeLugar");
        textView = (TextView) findViewById(R.id.textView2);
        textView.setText(nome_do_lugar);
    }
}
