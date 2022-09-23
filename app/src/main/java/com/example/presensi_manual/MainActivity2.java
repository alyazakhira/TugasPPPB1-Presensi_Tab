package com.example.presensi_manual;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        Spinner
        Spinner spinner = findViewById(R.id.edit_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.presensi_array, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

//        Date Picker
        findViewById(R.id.edit_tanggal).setOnClickListener(view -> showDatePicker());

//        Time Picker
        findViewById(R.id.edit_waktu).setOnClickListener(view -> showTimePicker());

//        Submit Button
        findViewById(R.id.btn_submit).setOnClickListener(view -> showAlertDialog());

//        End of onCreate
    }


    //    Spinner Method Selected
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String mSpinnerText = adapterView.getItemAtPosition(i).toString();
        TextView edSpinnerText = findViewById(R.id.edit_spinnertext);
        edSpinnerText.setText(mSpinnerText);
        if (i != 0) {
            findViewById(R.id.edit_ket).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.edit_ket).setVisibility(View.GONE);
        }
    }

    //    Spinner Method Not Selected
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        String mSpinnerText = adapterView.getItemAtPosition(0).toString();
        TextView edSpinnerText = findViewById(R.id.edit_spinnertext);
        edSpinnerText.setText(mSpinnerText);
    }

    //    DatePicker Method
    public void showDatePicker() {
        DialogFragment dateFragment = new DatePickerFrag();
        dateFragment.show(getSupportFragmentManager(), "date-picker");
    }

    public void dateResult (int day, int month, int year) {
        String day_string = Integer.toString(day);
        String month_string = Integer.toString(month+1);
        String year_string = Integer.toString(year);
        String dateMessage = day_string + " - " + month_string + " - " + year_string;

        EditText editTanggal = findViewById(R.id.edit_tanggal);
        editTanggal.setText(dateMessage);
    }

    //    TimePicker Method
    public void showTimePicker() {
        DialogFragment dateFragment = new TimePickerFrag();
        dateFragment.show(getSupportFragmentManager(), "time-picker");
    }

    public void timeResult(int hour, int minute){
        String hour_string = Integer.toString(hour);
        String minute_string = Integer.toString(minute);
        String timeMessage = hour_string + " : " + minute_string;

        EditText editWaktu = findViewById(R.id.edit_waktu);
        editWaktu.setText(timeMessage);
    }

    //    Alert Method
    public void showAlertDialog() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity2.this);
        alertBuilder.setTitle("Konfirmasi");
        alertBuilder.setMessage("Apakah kamu yakin data yang akan kamu kirim sudah sesuai?");

        //    Positive Button
        alertBuilder.setPositiveButton("YA", (dialogInterface, i) -> {
            String doneMessage = "Presensi Berhasil";
            Toast.makeText(getApplicationContext(), doneMessage, Toast.LENGTH_SHORT).show();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        });

        //    Negative Button
        alertBuilder.setNegativeButton("TIDAK", (dialogInterface, i) -> {
        });

        alertBuilder.show();
    }

//    End of MainActivity
}