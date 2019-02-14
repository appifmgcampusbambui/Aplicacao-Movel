package br.edu.ifmg.bambui.app.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.edu.ifmg.bambui.app.classes.Cardapio_Classe;
import br.edu.ifmg.bambui.app.viewholder.ViewHolder;
import br.edu.ifmg.bambui.app.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder>{

    private List<Cardapio_Classe> list;

    public RecyclerAdapter(List<Cardapio_Classe> list){
        this.list = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardapio_old,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Cardapio_Classe cardapio_classe = list.get(position);

        holder.textoA1.setText(cardapio_classe.getA1());
        holder.textoA2.setText(cardapio_classe.getA2());
        holder.textoA3.setText(cardapio_classe.getA3());
        holder.textoA4.setText(cardapio_classe.getA4());
        holder.textoA5.setText(cardapio_classe.getA5());
        holder.textoA6.setText(cardapio_classe.getA6());

        holder.textoJ1.setText(cardapio_classe.getJ1());
        holder.textoJ2.setText(cardapio_classe.getJ2());
        holder.textoJ3.setText(cardapio_classe.getJ3());
        holder.textoJ4.setText(cardapio_classe.getJ4());
        holder.textoJ5.setText(cardapio_classe.getJ5());
        holder.textoJ6.setText(cardapio_classe.getJ6());

        holder.dia_semana.setText(cardapio_classe.getData());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
