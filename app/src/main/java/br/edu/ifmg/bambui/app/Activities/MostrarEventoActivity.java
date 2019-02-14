package br.edu.ifmg.bambui.app.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.TextView;

import br.edu.ifmg.bambui.app.Conexao.Utils_objEventos;
import br.edu.ifmg.bambui.app.classes.Eventos_Classe;
import br.edu.ifmg.bambui.app.classes.Toolbar_Classe;
import br.edu.ifmg.bambui.app.R;

import org.json.JSONException;

import java.util.ArrayList;

public class MostrarEventoActivity extends Toolbar_Classe {

    private TextView nomeEvento;

    private TextView data_inicial;
    private TextView hora_inicio;
    private TextView hora_termino;
    private TextView data_final;
    private WebView wv;
    private Eventos_Classe eventoAtual;
    private RecuperaDados recd;

    //public static final String URL_ACT = "http://10.0.2.2/appmeucampus/integracao/evento/retornarEvento?id=";
    public static final String URL_ACT = "http://app.bambui.ifmg.edu.br/integracao/evento/retornarEvento?id=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_evento);

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Eventos");
        CreateDrawerLayout();

        nomeEvento = (TextView) findViewById(R.id.textViewNomeEventoAtual);
        hora_inicio = (TextView) findViewById(R.id.textViewHoraInicio);
        hora_termino = (TextView) findViewById(R.id.textViewHoraTermino);
        data_inicial = (TextView) findViewById(R.id.textViewDataInicial);
        data_final = (TextView) findViewById(R.id.textViewDataFinal);
        wv = (WebView) findViewById(R.id.webviewEvento);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setSupportZoom(false);//recomendado pelo android pois n sabe como ira se comportar caso dê zoom

        nomeEvento.setText("default");
        hora_inicio.setText("default");
        hora_termino.setText("default");
        data_inicial.setText("default");
        data_final.setText("defaul");

        Intent it = getIntent();
        eventoAtual = it.getParcelableExtra("Evento");

        recd = new RecuperaDados(URL_ACT, "BuscarPorID",eventoAtual.getId());
        recd.execute();

    }

    public class RecuperaDados extends AsyncTask<Void, Void, ArrayList<Eventos_Classe>> {

        private ProgressDialog load;
        private int num;
        String operacao;
        String endereco;

        public RecuperaDados(String url, String operacao, int num) {
            this.endereco = url;
            this.operacao = operacao;
            this.num = num;
        }

        @Override
        protected void onPreExecute() {
            load = ProgressDialog.show(MostrarEventoActivity.this, "Por favor, aguarde...", "Recuperando informações do Servidor.");
        }

        @Override
        protected ArrayList<Eventos_Classe> doInBackground(Void... params) {
            Utils_objEventos util = new Utils_objEventos();
            try {
                return util.getInformacaoEventos(endereco, operacao, num);
            } catch (JSONException e) {
                e.printStackTrace();
                ArrayList<Eventos_Classe> eventos = new ArrayList<>();
                eventos.add(new Eventos_Classe());
                return eventos;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<Eventos_Classe> listaEventos) {
            nomeEvento.setText(listaEventos.get(0).getNome());
            data_inicial.setText(listaEventos.get(0).getData_inicial().replace(' ', '/'));
            data_final.setText(listaEventos.get(0).getData_final().replace(' ', '/'));
            //descricao.setText(listaEventos.get(0).getDescricao());
            String texto = "<html>" +
                    " <head></head>" +
                    " <body style='text-align:justify;color:black;'>" +
                    "<div style='padding: 8px 8px; border: solid 1px #C5E1A5; background-color: #fafafa;'>" +
                    listaEventos.get(0).getDescricao() +
                    "</div></body>" +
                    "</html>";
            wv.loadData(texto, "text/html; charset=utf-8", "utf-8");
            hora_inicio.setText(listaEventos.get(0).getHora_inicio());
            hora_termino.setText(listaEventos.get(0).getHora_termino());
            load.dismiss();
        }
    }
}
