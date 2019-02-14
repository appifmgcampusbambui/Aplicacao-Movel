package br.edu.ifmg.bambui.app.classes;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import br.edu.ifmg.bambui.app.R;

import br.edu.ifmg.bambui.app.Activities.CalendarioAcademicoActivity;
import br.edu.ifmg.bambui.app.Activities.CardapioActivity;
import br.edu.ifmg.bambui.app.Activities.HorarioOnibusActivity;
import br.edu.ifmg.bambui.app.Activities.ListaEventosActivity;
import br.edu.ifmg.bambui.app.Activities.ListaNoticiasActivity;
import br.edu.ifmg.bambui.app.Activities.MainActivity;
import br.edu.ifmg.bambui.app.Activities.MapsActivity;
import br.edu.ifmg.bambui.app.Activities.SobreActivity;

public class Toolbar_Classe extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public Toolbar toolbar;
    public DrawerLayout drawerLayout;
    public NavigationView navigationView;

    public void CreateDrawerLayout(){
        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle("MeuCampus");

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.cloe_drawer);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //botao de voltar não fecha o app
    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {

            case R.id.menu_meucampus: {
                //Toast.makeText(this, "Menu MeuCampus", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.menu_noticias: {
                //Toast.makeText(this, "Menu Noticias", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),ListaNoticiasActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_eventos: {
                //Toast.makeText(this, "Menu Evntos", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),ListaEventosActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_calendario_academico: {
                //Toast.makeText(this, "Menu Calendário Acadêmico", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),CalendarioAcademicoActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_cardapio: {
                //Toast.makeText(this, "Menu Cardapio", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),CardapioActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_busao: {
                //Toast.makeText(this, "Menu Busão", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),HorarioOnibusActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_mapa: {
                //Toast.makeText(this, "Menu Mapa", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
                break;
            }
            /*case R.id.menu_teste: {
                Toast.makeText(this, "Menu Teste", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), Teste_Activity.class);
                startActivity(intent);
                break;
            }*/
            case R.id.menu_sobre: {
                //Toast.makeText(this, "Menu Sobre", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SobreActivity.class);
                startActivity(intent);
                break;
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
