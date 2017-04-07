package br.com.heiderlopes.jogoscomlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.heiderlopes.jogoscomlistview.adapter.JogosAdapter;
import br.com.heiderlopes.jogoscomlistview.model.Jogo;

public class ListaJogosActivity extends AppCompatActivity {

    private List<Jogo> jogos;
    private ListView lvJogos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_jogos);

        jogos = getListaJogos();
        lvJogos = (ListView) findViewById(R.id.lvJogos);

        lvJogos.setAdapter(new JogosAdapter(ListaJogosActivity.this, jogos));
        lvJogos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListaJogosActivity.this,
                        jogos.get(position).getNome(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<Jogo> getListaJogos() {
        List<Jogo> jogos = new ArrayList<>();
        jogos.add(new Jogo(1, "God Of War", 2014, R.drawable.godofwar));
        jogos.add(new Jogo(2, "GTA V", 2014, R.drawable.gtav));
        jogos.add(new Jogo(3, "Horizon Zero Dawn", 2017, R.drawable.horizonzerodawn));
        jogos.add(new Jogo(4, "Metal Gear Solid V", 2014, R.drawable.metalgearsolidv));
        jogos.add(new Jogo(5, "Mortal Kombat XL", 2016, R.drawable.mortalkombatxl));
        jogos.add(new Jogo(6, "Resident Evil", 2017, R.drawable.residentevil));
        jogos.add(new Jogo(7, "The Witcher", 2014, R.drawable.thewitcher));
        jogos.add(new Jogo(8, "Uncharted 4", 2015, R.drawable.uncharted4));
        jogos.add(new Jogo(9, "Watch Dogs 2", 2016, R.drawable.watchdogs2));
        return jogos;
    }
}
