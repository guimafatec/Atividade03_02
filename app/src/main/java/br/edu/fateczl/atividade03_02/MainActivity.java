package br.edu.fateczl.atividade03_02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    /*
     * @author: Gustavo Guimarães de Oliveira
    */
    private EditText etConsumo;
    private EditText etLitros;
    private TextView tvRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etConsumo = findViewById(R.id.etConsumo);
        etLitros = findViewById(R.id.etLitros);
        tvRes = findViewById(R.id.tvRes);
        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc(){
        float consumo = Float.parseFloat(etConsumo.getText().toString());
        float litros = Float.parseFloat(etLitros.getText().toString());
        float autonomia_metros = (consumo * litros) * 1000;
        String res = getString(R.string.autonomy) + " " + autonomia_metros + " metros";
        tvRes.setText(res);
        etConsumo.setText("");
        etLitros.setText("");
    }
}