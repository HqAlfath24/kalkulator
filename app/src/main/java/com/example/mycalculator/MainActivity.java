package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RadioButton rbTambah, rbkurang, rbkali, rbBagi;
    EditText edtbil1, edtbil2;
    TextView txtbil1, txtbil2, txtOpr, txtHasil;
    Button btnHitung;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AdapterData adapterData;
    List<String> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
    }

    private void initComponent() {
        rbTambah = (RadioButton) findViewById(R.id.rbTambah);
        rbkurang = (RadioButton) findViewById(R.id.rbKurang);
        rbkali = (RadioButton) findViewById(R.id.rbKali);
        rbBagi = (RadioButton) findViewById(R.id.rbBagi);

        edtbil1 = (EditText) findViewById(R.id.edtBil1);
        edtbil2 = (EditText) findViewById(R.id.edtBil2);

        txtbil1 = (TextView) findViewById(R.id.txtBil1);
        txtOpr = (TextView) findViewById(R.id.txtOpr);
        txtbil2 = (TextView) findViewById(R.id.txtBil2);
        txtHasil = (TextView) findViewById(R.id.txtHasil);

        btnHitung = (Button) findViewById(R.id.btnHitung);

        recyclerView = (RecyclerView) findViewById(R.id.rvData);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { hitung(); }
        });
    }

    public void hitung(){
        String tanda = "";
        String bil1 = edtbil1.getText().toString();
        String bil2 = edtbil2.getText().toString();

        double b1 = Double.parseDouble(bil1);
        double b2 = Double.parseDouble(bil2);
        double hasil = 0;

        if (rbTambah.isChecked()){
            hasil = b1+b2;
            tanda = "+";
        }else if(rbkurang.isChecked()){
            hasil = b1-b2;
            tanda = "-";
        }else if(rbkali.isChecked()){
            hasil = b1*b2;
            tanda = "*";
        }else if(rbBagi.isChecked()) {
            hasil = b1 / b2;
            tanda = "/";
        }else {
            Toast.makeText(MainActivity.this, "Silahkan pilih operator aritmatika terlebih dahulu!!!", Toast.LENGTH_SHORT).show();
        }

        txtbil1.setText(bil1);
        txtbil2.setText(bil2);
        txtOpr.setText(tanda);
        txtHasil.setText(String.valueOf(hasil));
    }
}