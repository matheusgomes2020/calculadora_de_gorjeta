package com.matheus.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarPorcentagem;
    private TextInputEditText textInputGorjeta;
    private TextView textGorjeta;
    private TextView textTotal;
    private TextView textPorcentagema;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        seekBarPorcentagem = findViewById(R.id.seekBar);
        textInputGorjeta = findViewById(R.id.textInputValor);
        textGorjeta = findViewById(R.id.textgorjeta2);
        textTotal = findViewById(R.id.textTotal2);
        textPorcentagema = findViewById(R.id.textPorcentagem);

        seekBarPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                textPorcentagema.setText( Math.round( porcentagem) + " %");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

    public void calcular(){

        String valorRecuperado = textInputGorjeta.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")){

            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valo primeiro!",
                    Toast.LENGTH_LONG
            ).show();

        }else {

            //Converter String para Double
            double valorDigitado = Double.parseDouble( valorRecuperado );

            //Calcula a gorjeta total
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = gorjeta + valorDigitado;

            //exibe a gorjeta e total
            //textGorjeta.setText("R$ " + Math.round(gorjeta));
            textGorjeta.setText("R$ " + gorjeta);
            textTotal.setText("R$ " + total);
        }
    }
}
