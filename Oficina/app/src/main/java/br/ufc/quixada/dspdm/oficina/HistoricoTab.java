package br.ufc.quixada.dspdm.oficina;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class HistoricoTab extends Fragment {
    List<String> historico;

    ListView listViewHistorico;
    ArrayAdapter adapter;

    //DAOOficina oficina = new DAOOficina();

    public static HistoricoTab newInstance() {
        HistoricoTab fragment = new HistoricoTab();
        return fragment;
    }

    public HistoricoTab() {
        // Deve existir um construtor vazio
        // na classe que estende um Fragment
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.historico_tab, container, false);
        // Inflate the layout for this fragment
        historico = new ArrayList<String>();
        historico.add("Historico Oficina 1");
        historico.add("Historico Oficina 2");
        historico.add("Historico Oficina 3");

        adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, historico);

        listViewHistorico = view.findViewById(R.id.listViewHistorico);
        listViewHistorico.setAdapter(adapter);
        listViewHistorico.setSelector(android.R.color.holo_blue_dark);
        return view;

    }
}
