package br.edu.ifmg.bambui.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.edu.ifmg.bambui.app.Activities.listener.OnListClickInteractionListener;
import br.edu.ifmg.bambui.app.classes.Noticias_Classe;
import br.edu.ifmg.bambui.app.viewholder.NoticiaViewHolder;
import br.edu.ifmg.bambui.app.R;

import java.util.List;

public class RecyclerAdapterNoticias extends RecyclerView.Adapter<NoticiaViewHolder>{

    private List<Noticias_Classe> list;
    private OnListClickInteractionListener mOnListClickInterationListener;

    public RecyclerAdapterNoticias(List<Noticias_Classe> list, OnListClickInteractionListener listener){
        this.list = list;
        mOnListClickInterationListener = listener;
    }


    @Override
    public NoticiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_noticia,parent,false);

        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_noticia,parent,false);

        return new NoticiaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoticiaViewHolder holder, int position) {

        Noticias_Classe noticiaa = list.get(position);
        holder.bindData(noticiaa,mOnListClickInterationListener);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}