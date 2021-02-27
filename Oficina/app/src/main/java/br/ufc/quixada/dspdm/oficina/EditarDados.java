package br.ufc.quixada.dspdm.oficina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.ufc.quixada.dspdm.oficina.DAO.DAOCliente;
import br.ufc.quixada.dspdm.oficina.model.ModelCliente;
import br.ufc.quixada.dspdm.oficina.model.ModelLogin;

public class EditarDados extends AppCompatActivity {

    private String cpf;

    EditText edt_nome;
    EditText edt_senha;
    EditText edt_rua;
    EditText edt_bairro;
    EditText edt_modelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_dados);

        edt_nome = findViewById(R.id.edt_nome);
        edt_senha = findViewById(R.id.edt_senha);
        edt_rua = findViewById(R.id.edt_rua);
        edt_bairro = findViewById(R.id.edt_bairro);
        edt_modelo = findViewById(R.id.edt_modelo);

        this.cpf = getIntent().getExtras().getString("cpf");
        String nome = getIntent().getExtras().getString("nome");
        String rua = getIntent().getExtras().getString("rua");
        String bairro = getIntent().getExtras().getString("bairro");
        String modeloCarro = getIntent().getExtras().getString("modeloCarro");
        String senha = getIntent().getExtras().getString("senha");

        edt_nome.setText(nome);
        edt_senha.setText(senha);
        edt_rua.setText(rua);
        edt_bairro.setText(bairro);
        edt_modelo.setText(modeloCarro);

    }

    public void AtualizarDados(View view) {

        String nome = edt_nome.getText().toString();
        String senha = edt_senha.getText().toString();
        String rua = edt_rua.getText().toString();
        String bairro = edt_bairro.getText().toString();
        String modelo = edt_modelo.getText().toString();

        ModelCliente cliente = new ModelCliente(this.cpf, nome, rua, bairro, modelo);

        DAOCliente cliente1 = new DAOCliente();
        if(cliente1.atualizarCliente(cliente).equals("ok")) {
            Toast.makeText(this, "Dados atualizados com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            Toast.makeText(this, "Dados não atualizados. Tente novamente!", Toast.LENGTH_SHORT).show();
        }
    }

    public void cancelar(View view) {
       finish();
    }

}