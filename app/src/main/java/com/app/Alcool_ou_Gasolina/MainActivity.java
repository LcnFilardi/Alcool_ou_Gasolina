package com.app.Alcool_ou_Gasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina ;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);

    }
    public void calcularPreco(View view){

        // Recuperar valores digitados

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        // Validar campos

        boolean camposValidados = validarCampos( editPrecoAlcool, editPrecoGasolina);
        if( camposValidados ){

            //Convertendo String para números

            Double valorAlcool = Double.parseDouble( precoAlcool );
            Double valorGasolina = Double.parseDouble( precoGasolina);
            Double resultado = valorAlcool/valorGasolina;

            if ( resultado >= 0.7){
                textResultado.setText("É melhor utilizar gasolina!");
            }else {
                textResultado.setText("É melhor utilizar álcool");
            }
        }else{
            textResultado.setText("Campos não preenchidos!");
        }
    }

    public boolean validarCampos(TextInputEditText pAlcool, TextInputEditText pGasolina ){
        Boolean camposValidados = true;

        if(pAlcool == null || pAlcool.equals("") ){
            camposValidados = false;
        }else if(pGasolina == null || pGasolina.equals("") ){
            camposValidados = false;
        }

        return camposValidados;
    }
}