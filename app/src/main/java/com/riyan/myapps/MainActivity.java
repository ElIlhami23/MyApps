package com.riyan.myapps;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //MENAMBAHKAN OBJECK KALENDER
    Calendar Kalender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* INI ADALAH CASTING COMPONENTS */
        final EditText nama = (EditText) findViewById(R.id.etNama);
        final EditText alamat = (EditText) findViewById(R.id.etAlamat);
        final EditText tempat_lahir = (EditText) findViewById(R.id.etTempatLahir);
        final EditText tanggal_lahir = (EditText) findViewById(R.id.etTanggalLahir);
        final EditText telepon = (EditText) findViewById(R.id.etTelepon);
        final Spinner kelamin = (Spinner) findViewById(R.id.spKelamin);
        final Button tambah = (Button) findViewById(R.id.btTambah);
        final Button ulangi = (Button) findViewById(R.id.btUlangi);
        final Button batal = (Button) findViewById(R.id.btBatal);
        final Button kirim = (Button) findViewById(R.id.btKirim);

        Kalender = Calendar.getInstance();

        //MENAMBAGKAN FASILITAS KLIK PADA TANGGAL//
        tanggal_lahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Kalender.set(Calendar.YEAR, year);
                        Kalender.set(Calendar.MONTH, month);
                        Kalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        String format = "dd-mm-yyyy";
                        SimpleDateFormat sdf = new SimpleDateFormat(format);
                        tanggal_lahir.setText(sdf.format(Kalender.getTime()));
                    }
                },
                        Kalender.get(Calendar.YEAR), Kalender.get(Calendar.MONTH), Kalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        /*TOAST = MsgBox
        --------------------------------------------------------
        BUTTON TAMBAH DIKLIK*/
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Tombol Tambah ditekan", Toast.LENGTH_SHORT).show();
            }
        });


        /*DIALOG = MsgBox WITH OPTION YES/NO
        --------------------------------------------------------
        BUTTON ULANGI DIKLIK*/
        ulangi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new
                        AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setMessage(("Ulangi data?"));
                alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(MainActivity.this, "Ya", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialogBuilder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); //menutup dialog
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View b) {
                View parentView = findViewById(R.id.main_layout_id);
                String pesan = "Test SnackBar-nya Berhasil Ya";

                final Snackbar snackbar = Snackbar.make(parentView, pesan, Snackbar.LENGTH_LONG);
                snackbar.show();
            }

        });


        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("Nama", nama.getText().toString());
                bundle.putString("Alamat", alamat.getText().toString());
                bundle.putString("Tempat Lahir", tempat_lahir.getText().toString());
                bundle.putString("Tanggal Lahir", tanggal_lahir.getText().toString());
               bundle.putString("Jenis Kelamin", jenis_Kelamin.getSelectedItem().toString());







            }


        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout_action_bar,menu);
        return super.onCreateOptionsMenu(menu);
    }
}


