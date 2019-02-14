package br.edu.ifmg.bambui.app.Activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import br.edu.ifmg.bambui.app.Conexao.Utils_objCardapio;
import br.edu.ifmg.bambui.app.classes.Cardapio_Classe;
import br.edu.ifmg.bambui.app.classes.Toolbar_Classe;
import br.edu.ifmg.bambui.app.R;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CardapioActivity extends Toolbar_Classe {

    private Button botao;
    String data;
    private Context mContext;
    private TextView textoA1;
    private TextView textoJ1;
    private TextView textoA2;
    private TextView textoJ2;
    private TextView textoA3;
    private TextView textoJ3;
    private TextView textoA4;
    private TextView textoJ4;
    private TextView textoA5;
    private TextView textoJ5;
    private TextView textoA6;
    private TextView textoJ6;
    private TextView dia_semana;
    //private static final String URL = "http://10.0.2.2/appmeucampus/integracao/cardapio/retornarCardapiosPorData?data=";
    public static final String URL = "http://app.bambui.ifmg.edu.br/integracao/cardapio/retornarCardapiosPorData?data=";

    static final int DATE_DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);
        botao = (Button) findViewById(R.id.btn_cardapio);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == botao)
                    showDialog(DATE_DIALOG_ID);
            }
        });
        this.mContext = this;

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Cardápio");
        CreateDrawerLayout();

        //identificando os componentes a serem alterados após a recuperação dos dados
        this.textoA1 = (TextView) findViewById(R.id.a1);
        this.textoJ1 = (TextView) findViewById(R.id.j1);
        this.textoA2 = (TextView) findViewById(R.id.a2);
        this.textoJ2 = (TextView) findViewById(R.id.j2);
        this.textoA3 = (TextView) findViewById(R.id.a3);
        this.textoJ3 = (TextView) findViewById(R.id.j3);
        this.textoA4 = (TextView) findViewById(R.id.a4);
        this.textoJ4 = (TextView) findViewById(R.id.j4);
        this.textoA5 = (TextView) findViewById(R.id.a5);
        this.textoJ5 = (TextView) findViewById(R.id.j5);
        this.textoA6 = (TextView) findViewById(R.id.a6);
        this.textoJ6 = (TextView) findViewById(R.id.j6);
        this.dia_semana = (TextView) findViewById(R.id.dia_da_semana);

        //buscando o cardápio do dia
        Calendar calendario = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = sdf.format(calendario.getTime());
        RecuperaDados teste = new RecuperaDados(URL,data);
        teste.execute();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Calendar calendario = Calendar.getInstance();

        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener, ano, mes,
                        dia);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    data = ((dayOfMonth < 10)? "0" + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth)) + "/"
                            +((monthOfYear + 1 < 10)? "0" + String.valueOf(monthOfYear + 1):String.valueOf(monthOfYear + 1)) + "/" + String.valueOf(year);
                    /*Intent intent = new Intent(mContext, MostrarCardapioActivity.class);
                    System.out.println(data);
                    intent.putExtra("Data", data);
                    startActivity(intent);*/
                    RecuperaDados teste = new RecuperaDados(URL,data);//"08/05/2018"
                    teste.execute();
                }
            };
    public class RecuperaDados extends AsyncTask<Void, Void, Cardapio_Classe> {

        private ProgressDialog load;
        private String data;
        String endereco;

        public RecuperaDados(String url, String data) {
            this.endereco = url;
            this.data = data;
        }

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(CardapioActivity.this, "Por favor, aguarde...", "Recuperando informações do Servidor.");
        }

        @Override
        protected Cardapio_Classe doInBackground(Void... params) {
            Utils_objCardapio util = new Utils_objCardapio();
            try {
                return util.getInformacaoCardapio(endereco+data);
            } catch (JSONException e) {
                e.printStackTrace();
                Cardapio_Classe c = new Cardapio_Classe();
                return c;
            }
        }

        @Override
        protected void onPostExecute(Cardapio_Classe c) {
            textoA1.setText(c.getA1());
            textoA2.setText(c.getA2());
            textoA3.setText(c.getA3());
            textoA4.setText(c.getA4());
            textoA5.setText(c.getA5());
            textoA6.setText(c.getA6());

            textoJ1.setText(c.getJ1());
            textoJ2.setText(c.getJ2());
            textoJ3.setText(c.getJ3());
            textoJ4.setText(c.getJ4());
            textoJ5.setText(c.getJ5());
            textoJ6.setText(c.getJ6());

            dia_semana.setText(c.getData());
            load.dismiss();
        }
    }

}
