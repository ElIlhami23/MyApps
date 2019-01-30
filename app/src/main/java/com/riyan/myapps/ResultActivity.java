package com.riyan.myapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // untuk tombol back
        getSupportActionBar().setTitle("Hasil Input Anggota");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // definisikan widget
        final TextView tvNama = (TextView) findViewById(R.id.tv_nama);
        final TextView tvAlamat = (TextView) findViewById(R.id.tv_alamat);
        final TextView tvTempatLahir = (TextView) findViewById(R.id.tv_tempat_Lahir);
        final TextView tvTanggalLahir = (TextView) findViewById(R.id.tv_tanggal_lahir);
        final TextView tvJenisKelamin = (TextView) findViewById(R.id.tv_jenis_Kelamin);
        final TextView tvTelepon = (TextView) findViewById(R.id.tv_telepon);


        // ambil bundle
        Bundle bundle = null;
        bundle = this.getIntent().getExtras();


//test
        // letakan pada widget
        tvNama.setText(bundle.getString("Nama"));
        tvNama.setText(bundle.getString("Alamat"));
        tvNama.setText(bundle.getString("Tempat Lahir"));
        tvNama.setText(bundle.getString("Tanggal Lahir"));
        tvNama.setText(bundle.getString("Jenis Kelamin"));
        tvNama.setText(bundle.getString("Telepon"));
    }
}
