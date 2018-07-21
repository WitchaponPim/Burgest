package com.example.ptwitchapon.burgest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.Callback.UpdateStockCallback;
import com.example.ptwitchapon.burgest.Model.UpdateStockResponse;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.squareup.okhttp.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit.Retrofit;

public class EditStockActivity extends AppCompatActivity {
    TextView id,name;
    EditText exp,amount;
    Date date;
    String TAG="Stockkk";
    private DatePickerDialog mDatePicker;
    private Calendar mCalendar;
    private DatePickerDialog.OnDateSetListener onDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {

                    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
                    mCalendar.set(year, month, day);
                    date = mCalendar.getTime();
                    Date current = Calendar.getInstance().getTime();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String textDate = sdf.format(date);
                    if (current.compareTo(date)>0){
                        Utils.toast(getApplicationContext(),"Let them past dude");
                    }else{
                        exp.setText(textDate);
                    }
                }
            };
    ConnectManager connect = new ConnectManager();
    UpdateStockCallback updateStockCallback = new UpdateStockCallback() {
        @Override
        public void onResponse(UpdateStockResponse response, Retrofit retrofit) {
            Utils.toast(getApplicationContext(),response.getUpdate().getDescription());
            finish();
        }

        @Override
        public void onFailure(Throwable t) {
            Log.d(TAG, "onFailure: ");

        }

        @Override
        public void onBodyError(ResponseBody responseBody) {
            Log.d(TAG, "onFailure: ");
        }

        @Override
        public void onBodyErrorIsNull() {
            Log.d(TAG, "onFailure: ");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_stock);
        id = (TextView) findViewById(R.id.ID);
        name = (TextView) findViewById(R.id.name);
        exp = (EditText) findViewById(R.id.exp);
        amount = (EditText) findViewById(R.id.amount);

        mCalendar = Calendar.getInstance();

        id.setText(Utils.stock_edit.getStocks().get(0).getId_stock());
        name.setText(Utils.stock_edit.getStocks().get(0).getName());

        mDatePicker = DatePickerDialog.newInstance(onDateSetListener,
                mCalendar.get(Calendar.YEAR),       // ปี
                mCalendar.get(Calendar.MONTH),      // เดือน
                mCalendar.get(Calendar.DAY_OF_MONTH),// วัน (1-31)
                false);



    }

    public void date(View view){
        mDatePicker.setYearRange(2018, 2030);
        mDatePicker.show(getSupportFragmentManager(), "datePicker");
    }
    public void end(View view){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        connect.updatestock(updateStockCallback,id.getText().toString(),amount.getText().toString(),sdf.format(date));
    }
}
