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

public class oficinaTab extends Fragment {

    ArrayList<String> oficina;
    ListView listViewOficinas;

    ArrayAdapter<String> adapter;

   //DAOOficina oficina = new DAOOficina();

    public static oficinaTab newInstance() {
        oficinaTab fragment = new oficinaTab();
        return fragment;
    }

    public oficinaTab() {
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

        View view = inflater.inflate(R.layout.oficina_tab, container, false);
        // Inflate the layout for this fragment
        List<String> oficina = new ArrayList<String>();
        oficina.add("Oficina 1");
        oficina.add("Oficina 2");
        oficina.add("Oficina 3");

        adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,oficina);

        listViewOficinas = view.findViewById(R.id.listViewOficina);
        listViewOficinas.setAdapter(adapter);
        listViewOficinas.setSelector(android.R.color.holo_blue_dark);
        return view;

    }

}