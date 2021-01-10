package br.ufc.quixada.dspdm.componentesbasicosandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    private ToggleButton tBtn_estado;

    EditText eText;
    Button btn;
    RelativeLayout rl;
    AutoCompleteTextView auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
        atualizarTexto();

    }

    public void addListenerOnButton() {

        tBtn_estado = (ToggleButton) findViewById(R.id.tBtn_estado);

        tBtn_estado.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer result = new StringBuffer();
                result.append("Estado : ").append(tBtn_estado.getText());

                Toast.makeText(MainActivity.this, result.toString(),
                        Toast.LENGTH_SHORT).show();

            }


        });

    }

    public void atualizarTexto() {
        eText = (EditText) findViewById(R.id.edittext);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str = eText.getText().toString();
                Toast msg = Toast.makeText(getBaseContext(),str,Toast.LENGTH_LONG);
                msg.show();
            }
        });
    }

    public void autocompletar() {
        String str[]={"Arun","Mathev","Vishnu","Vishal","Arjun",
                "Arul","Balaji","Babu","Boopathy","Godwin","Nagaraj"};

        rl = (RelativeLayout) findViewById(R.id.rl);

        auto = new AutoCompleteTextView(MainActivity.this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                ((int) LayoutParams.WRAP_CONTENT, (int) LayoutParams.WRAP_CONTENT);

        params.leftMargin = 80;
        params.topMargin = 130;

        auto.setLayoutParams(params);
        auto.setEms(10);

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,str);

        auto.setThreshold(1);
        auto.setAdapter(adp);

        rl.addView(auto);
    }

}