package br.ufc.quixada.dspdm.oficina;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.ufc.quixada.dspdm.oficina.DAO.DAOCliente;
import br.ufc.quixada.dspdm.oficina.DAO.DAOLogin;
import br.ufc.quixada.dspdm.oficina.model.ModelCliente;
import br.ufc.quixada.dspdm.oficina.model.ModelLogin;
import br.ufc.quixada.dspdm.oficina.transactions.Constants;

public class MainActivity extends AppCompatActivity {

    DAOCliente listaCliente = new DAOCliente();
    DAOLogin listaLogin = new DAOLogin();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void Register(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivityForResult(intent, Constants.REQUEST_ADD);
    }

    public  void Login(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Dados Cliente
        String nome = (String) data.getExtras().get("nome");
        String cpf = (String) data.getExtras().get("cpf");
        String rua = (String) data.getExtras().get("rua");
        String bairro = (String) data.getExtras().get("bairro");
        String modelo = (String) data.getExtras().get("modelo");

        //Dados Login (senha, cpf)
        String senha = (String) data.getExtras().get("senha");

        ModelCliente modelCliente = new ModelCliente(cpf, nome, rua, bairro, modelo);
        listaCliente.addCliente(modelCliente);

        ModelLogin login = new ModelLogin(cpf, senha);
        listaLogin.addLogin(login);

    }

}