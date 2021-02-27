package br.ufc.quixada.dspdm.oficina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

import br.ufc.quixada.dspdm.oficina.transactions.Constants;

public class Register extends AppCompatActivity {

    EditText edt_nome;
    EditText edt_cpf;
    EditText edt_senha;
    EditText edt_dt_nasc;
    EditText edt_rua;
    EditText edt_bairro;
    EditText edt_modelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edt_nome = findViewById(R.id.edt_nome);
        edt_cpf = findViewById(R.id.edt_cpf);
        edt_senha = findViewById(R.id.edt_senha);
        edt_rua = findViewById(R.id.edt_rua);
        edt_bairro = findViewById(R.id.edt_bairro);
        edt_modelo = findViewById(R.id.edt_modelo);

    }

    public void RealizarCadastro(View view) {
        Intent intent = new Intent();

        String nome = edt_nome.getText().toString();
        String cpf = edt_cpf.getText().toString();
        String senha = edt_senha.getText().toString();
        String rua = edt_rua.getText().toString();
        String bairro = edt_bairro.getText().toString();
        String modelo = edt_modelo.getText().toString();

        intent.putExtra("nome", nome);
        intent.putExtra("cpf", cpf);
        intent.putExtra("senha", senha);
        intent.putExtra("rua", rua);
        intent.putExtra("bairro", bairro);
        intent.putExtra("modelo", modelo);

        setResult(Constants.RESULT_ADD, intent);
        finish();

    }

    public void cancelar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}