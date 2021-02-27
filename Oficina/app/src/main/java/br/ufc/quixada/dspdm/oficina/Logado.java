package br.ufc.quixada.dspdm.oficina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.google.android.material.tabs.TabLayout;

import br.ufc.quixada.dspdm.oficina.DAO.DAOCliente;
import br.ufc.quixada.dspdm.oficina.model.ModelCliente;
import br.ufc.quixada.dspdm.oficina.transactions.Constants;

public class Logado extends AppCompatActivity {

    private static String cpf;
    private static String senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logado);

        TabLayout tabs = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());

        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflate = getMenuInflater();
//        inflate.inflate(R.menu.top_app_bar, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.edit:
//                clicarEditar();
//                break;
//            case R.id.notify:
//                clicarExit();
//                break;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    public void clicarEditar() {
        DAOCliente cliente = new DAOCliente();

        ModelCliente cli = (cliente.SelecionarCliente(this.cpf));

        Intent intent = new Intent(this, EditarDados.class);

        intent.putExtra("cpf", this.cpf);
        intent.putExtra("senha", this.senha);
        intent.putExtra("nome", cli.getNome());
        intent.putExtra("rua", cli.getRua());
        intent.putExtra("bairro", cli.getBairro());
        intent.putExtra("modeloCarro", cli.getModeloCarro());

        startActivity(intent);
    }

    public void clicarExit() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}