package com.itslp.desarollodeaplicacionesmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] unidades = getResources().getStringArray(R.array.unidades);
        Spinner spinner=(Spinner)findViewById(R.id.spinnerUnidades);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.spinner_layout, R.id.text, unidades);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String[] unidadesTemperatura  = getResources().getStringArray(R.array.unidadesTemperatura);
            String[] unidadesMasa = getResources().getStringArray(R.array.unidadesMasa);
            String[] unidadesLongitud = getResources().getStringArray(R.array.unidadesLongitud);
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (unidades[position].equals("Temperatura")) {
                    Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
                    ArrayAdapter<String> adapter1  = new ArrayAdapter<String>(MainActivity.this, R.layout.spinner_layout, R.id.text, unidadesTemperatura);
                    spinner1.setAdapter(adapter1);
                    spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            String unidadOcupada = unidadesTemperatura[i];
                            Log.d("MENSAJE", unidadOcupada);

                            ArrayList<String> array = new ArrayList<>();
                            for(int j = 0; j < unidadesTemperatura.length; j ++) {
                                try {
                                    if (unidadOcupada.equals(unidadesTemperatura[j])){
                                    } else {
                                        array.add(unidadesTemperatura[j]);
                                    }
                                } catch (Exception ex) {
                                    Log.d("Error", ex.getMessage());
                                }
                            }

                            Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
                            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity.this, R.layout.spinner_layout, R.id.text, array);
                            spinner2.setAdapter(adapter2);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
                else if  (unidades[position].equals("Longitud")) {
                    Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
                    ArrayAdapter<String> adapter1;
                    adapter1 = new ArrayAdapter<String>(MainActivity.this, R.layout.spinner_layout, R.id.text, unidadesLongitud);
                    spinner1.setAdapter(adapter1);

                    Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity.this, R.layout.spinner_layout, R.id.text, unidadesLongitud);
                    spinner2.setAdapter(adapter2);
                } else {
                    Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
                    ArrayAdapter<String> adapter1;
                    adapter1 = new ArrayAdapter<String>(MainActivity.this, R.layout.spinner_layout, R.id.text, unidadesMasa);
                    spinner1.setAdapter(adapter1);

                    Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity.this, R.layout.spinner_layout, R.id.text, unidadesMasa);
                    spinner2.setAdapter(adapter2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
    }
}