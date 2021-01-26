package br.ufc.quixada.dspdm.wishlist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.ufc.quixada.dspdm.wishlist.transactions.Constants;
import br.ufc.quixada.dspdm.wishlist.model.LivroModel;

public class MainActivity extends AppCompatActivity {

    public static int REQUEST_ADD = 1;
    public static int REQUEST_EDIT = 2;

    public static int contadorId = 0;
    
    EditText edtEdition;
    int idLivroEditar;

    int selected;
    ArrayList<LivroModel> listaLivros;
    ArrayAdapter adapter;
    ListView listViewLivros;
    
    boolean editar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selected = -1;
        edtEdition = findViewById(R.id.editTextEdition);

        listaLivros = new ArrayList<LivroModel>();

        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, listaLivros);

        listViewLivros = findViewById(R.id.listViewLivros);
        listViewLivros.setAdapter(adapter);
        listViewLivros.setSelector(android.R.color.holo_blue_dark);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu_activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                clicarAdicionar();
                break;
            case R.id.edit:
                clicarEditar();
                break;
        }
        return true;
    }

    public void clicarAdicionar() {
        Intent intent = new Intent(this, Livro.class);
        contadorId++;
        intent.putExtra("id", contadorId);
        startActivityForResult(intent, Constants.REQUEST_ADD);
    }

    public void clicarEditar() {

        if(listaLivros.size() == 0){
            Toast.makeText(this, "Lista vazia, adicione valor!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(edtEdition.getText().length() != 0) {

            idLivroEditar = Integer.parseInt(edtEdition.getText().toString());

            Intent intent = new Intent(this, Livro.class);

            for(LivroModel livro: listaLivros) {
                if(livro.getId() == idLivroEditar) {
                    intent.putExtra("id", livro.getId());
                    intent.putExtra("titulo", livro.getTitulo());
                    intent.putExtra("autor", livro.getAutor());
                    editar = true;
                    startActivityForResult(intent, Constants.REQUEST_EDIT);
                    break;
                }
            }

            if(!editar){
                Toast.makeText(this, "O item não existe, Favor escolha um id!", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Favor escolha um id!", Toast.LENGTH_SHORT).show();
        }
        //String contAux = Integer.toString(contadorId);
        
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Constants.REQUEST_ADD && resultCode == Constants.RESULT_ADD) {

            //int id = (int) data.getExtras().get("id");
            String titulo = (String)data.getExtras().get("titulo");
            String autor = (String)data.getExtras().get("autor");

            LivroModel livro = new LivroModel(contadorId, titulo, autor);

            listaLivros.add(livro);
            adapter.notifyDataSetChanged();

        }
        else if(requestCode == Constants.REQUEST_EDIT && resultCode == Constants.RESULT_ADD) {
            String titulo = (String)data.getExtras().get("titulo");
            String autor = (String)data.getExtras().get("autor");

            for(LivroModel livro: listaLivros) {
                if(livro.getId() == idLivroEditar) {
                    livro.setTitulo(titulo);
                    livro.setAutor(autor);
                    break;
                }
            }
            adapter.notifyDataSetChanged();
            editar = false;
        }
        else if(resultCode == Constants.RESULT_CANCEL){
            if(requestCode == Constants.REQUEST_ADD){
                contadorId--;
            }
            Toast.makeText(this, "Cancelado", Toast.LENGTH_LONG).show();
        }
        System.out.println("req: "+requestCode + " - " + "res: " + resultCode);
        editar = false;

    }
}