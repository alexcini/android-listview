package br.com.heiderlopes.jogoscomlistview.adapter;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.heiderlopes.jogoscomlistview.R;
import br.com.heiderlopes.jogoscomlistview.model.Jogo;

public class JogosAdapter extends BaseAdapter {

    private Context context;
    private List<Jogo> jogos;
    public JogosAdapter(Context context, List<Jogo> jogos) {
        this.context = context;
        this.jogos = jogos;
    }

    //Informa o total de itens na lista
    @Override
    public int getCount() {
        return jogos.size();
    }

    //Devolve o item da lista de acordo com sua posição
    @Override
    public Object getItem(int position) {
        return jogos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return jogos.get(position).getId();
    }

    //Cria a view para cada item (jogo) da nossa lista
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //No código estamos inflando o layout da nossa linha
        //O primeiro parametro é o layout que iremos inflar
        //O segundo parametro: é o layout pai ao qual iremos adicionar nossa
        //   lista no caso usamos o parent (parametro do tipo ViewGroup)
        //O terceiro parametro: indica se queremos criar a view nesse momento,
        // como ainda não fizemos nenhuma alteração referente ao jogo, enviamos false.
        // Dessa forma, iremos realizar os binds para só depois ser criada a View
        View view;

        //Cria o objeto viewholder
        JogoViewHolder holder;

        //Verificamos se a view esta pronta para usar, caso esteja nula devemos criar uma nova
        // caso contrário podemos reaproveitá-la
        if(convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.jogo_item, parent, false);
            holder = new JogoViewHolder(view);
            view.setTag(view);
        } else {
            view = convertView;
            holder = (JogoViewHolder)view.getTag();
        }

        //Pegamos o jogo que sera colocado na linha através da posição (position)
        Jogo jogo = jogos.get(position);
        //Depois que temos a nossa view criada, realizaremos os binds
        //entre os elementos do nosso layout com os elementos da nossa lista
        holder.ivJogo.setImageDrawable(ContextCompat.getDrawable(context, jogo.getResourceIdImagem()));
        holder.tvNome.setText(jogo.getNome());
        holder.tvAnoLancamento.setText(String.valueOf(jogo.getAnoLancamento()));



        return view;
    }

    //O ViewHolder é um desing pattern utilizado na lista para evitar problema com o
    //processamento do aparelho, já que cada linha da nossa lista será instanciada
    //dinamicamente. O ViewHolder só instancia novos dados, se os mesmos já não estiverem
    //instanciados.
    public class JogoViewHolder {

        final ImageView ivJogo;
        final TextView tvNome;
        final TextView tvAnoLancamento;

        //O findViewById percorre o xml em busca da view de acordo com o id informado
        public JogoViewHolder(View view) {
            ivJogo = (ImageView) view.findViewById(R.id.ivJogo);
            tvNome = (TextView)view.findViewById(R.id.tvNome);
            tvAnoLancamento = (TextView) view.findViewById(R.id.tvAnoLancamento);
        }

    }

}