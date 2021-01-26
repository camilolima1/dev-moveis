
package br.ufc.quixada.dspdm.wishlist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.ufc.quixada.dspdm.wishlist.transactions.Constants;

public class Livro extends AppCompatActivity {

    TextView edtid;
    EditText edtTitulo;
    EditText edtAutor;

    boolean edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro);

        edtid = findViewById(R.id.editTextId);
        edtTitulo = findViewById(R.id.editTextTitulo);
        edtAutor = findViewById(R.id.editTextAutor);

        if(getIntent().getExtras().get("nome") != null && getIntent().getExtras().get("titulo") != null) {
            String id = (String)getIntent().getExtras().get("id");
            String titulo = (String)getIntent().getExtras().get("titulo");
            String autor = (String)getIntent().getExtras().get("autor");

            edtid.setText(id);
            edtTitulo.setText(titulo);
            edtAutor.setText(autor);

        } else {
            String id = getIntent().getExtras().get("id").toString();
            edtid.setText(id);
        }

    }

    public void adicionar(View view) {

        Intent intent = new Intent();

        String id = edtid.getText().toString();
        String titulo = edtTitulo.getText().toString();
        String autor = edtAutor.getText().toString();

        intent.putExtra("titulo", titulo);
        intent.putExtra("autor", autor);

        setResult(Constants.RESULT_ADD, intent);
        finish();

    }

    public void cancelar(View view) {
        setResult(Constants.RESULT_CANCEL);
        finish();
    }

}