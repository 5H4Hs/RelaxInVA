package com.example.relaxinva;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView checkInDateTextView;
    private TextView checkOutDateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner citiesSpinner = findViewById(R.id.cities_spinner);
        Button checkInDateButton = findViewById(R.id.check_in_date_button);
        Button checkOutDateButton = findViewById(R.id.check_out_date_button);
        checkInDateTextView = findViewById(R.id.check_in_date_textview);
        checkOutDateTextView = findViewById(R.id.check_out_date_textview);
        Button searchButton = findViewById(R.id.search_button);

        checkInDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(checkInDateTextView);
            }
        });

        checkOutDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(checkOutDateTextView);
            }
        });

        // TODO: Set up logic for the searchButton here
    }

    private void showDatePicker(final TextView dateTextView) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                dateTextView.setText(date);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }
}
