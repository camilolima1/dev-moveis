package br.ufc.quixada.dspdm.oficina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.ufc.quixada.dspdm.oficina.DAO.DAOLogin;
import br.ufc.quixada.dspdm.oficina.model.ModelLogin;

public class Login extends AppCompatActivity {

    DAOLogin login = new DAOLogin();

    EditText edt_cpf;
    EditText edt_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_cpf = findViewById(R.id.edt_cpf_login);
        edt_senha = findViewById(R.id.edt_senha_login);

    }

    public void Logar(View view) {

        Intent intent = new Intent(getApplicationContext(), Logado.class);

        ModelLogin l = new ModelLogin("1", "1");
        login.addLogin(l);

        String cpf = edt_cpf.getText().toString();
        String senha = edt_senha.getText().toString();

        intent.putExtra("cpf", cpf);
        intent.putExtra("senha", senha);

        if(login.Logar(cpf, senha).equals("ok")){
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Login ou Senha incorretos!", Toast.LENGTH_LONG).show();
        }

    }

    public void cancelar(View view) {
        finish();
    }
}