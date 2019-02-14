package br.edu.ifmg.bambui.app.Activities;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import br.edu.ifmg.bambui.app.Activities.listener.OnListClickInteractionListener;
import br.edu.ifmg.bambui.app.adapter.RecyclerAdapterCalendario;
import br.edu.ifmg.bambui.app.classes.Eventos_Classe;
import br.edu.ifmg.bambui.app.classes.Noticias_Classe;
import br.edu.ifmg.bambui.app.classes.Toolbar_Classe;
import br.edu.ifmg.bambui.app.R;

import java.util.ArrayList;
import java.util.List;

//import com.bumptech.glide.Glide;
//import com.master.glideimageview.GlideImageView;

public class CalendarioAcademicoActivity extends Toolbar_Classe {

    private FragmentActivity fa;
    // Hold a reference to the current animator,
    // so that it can be canceled mid-way.
    private Animator mCurrentAnimator;

    // The system "short" animation time duration, in milliseconds. This
    // duration is ideal for subtle animations or animations that occur
    // very frequently.
    private int mShortAnimationDuration;
    private List<Integer> list = new ArrayList<>();
    ViewHolder mViewHolder = new ViewHolder();
    private Context mContext;

    private static class ViewHolder{
        RecyclerView recyclerCalendario;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario_academico);

        this.mContext = this;

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Calendário Acadêmico");
        CreateDrawerLayout();

        //obter o recyler
        this.mViewHolder.recyclerCalendario = (RecyclerView) this.findViewById(R.id.recycler_view_calendario);

        //definir o layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        this.mViewHolder.recyclerCalendario.setLayoutManager(linearLayoutManager);

        //list.add(R.drawable.ca1);list.add(R.drawable.ca2);list.add(R.drawable.ca3);list.add(R.drawable.ca4);
        list.add(R.drawable.ca5);list.add(R.drawable.ca6);list.add(R.drawable.ca7);list.add(R.drawable.ca8);list.add(R.drawable.ca9);
        RecyclerAdapterCalendario ca_adapter = new RecyclerAdapterCalendario(list,listener);
        mViewHolder.recyclerCalendario.setAdapter(ca_adapter);

    }

    // Implementa o evento de click para passar por parâmetro para a ViewHolder
    OnListClickInteractionListener listener = new OnListClickInteractionListener() {
        @Override
        public void onClick(Noticias_Classe noticiaa) {
        }
        @Override
        public void onClick(Integer src,View view) {
            //zoomImageFromThumb(view, src);
        }
        @Override
        public void onClick(Eventos_Classe eventoo) {

        }
    };



}
