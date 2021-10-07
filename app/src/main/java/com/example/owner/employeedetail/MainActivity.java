package com.example.owner.employeedetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.os.Build.VERSION_CODES.N;
import static android.widget.Toast.makeText;


public class MainActivity extends AppCompatActivity {


    EditText ed_first, ed_last, ed_dsg, ed_email, ed_dob, ed_add, ed_dept;
    Button btn_add;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String datePattern="^(0[1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[0-2])\\/([12][0-9]{3})$";

    String url = "https://employee-data.000webhostapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ed_first = (EditText) findViewById(R.id.first_name);
        ed_last = (EditText) findViewById(R.id.last_name);
        ed_dsg = (EditText) findViewById(R.id.designation);
        ed_email = (EditText) findViewById(R.id.email);
        ed_dob = (EditText) findViewById(R.id.date_of_birth);
        ed_add = (EditText) findViewById(R.id.address);
        ed_dept = (EditText) findViewById(R.id.department);
        btn_add = (Button) findViewById(R.id.add_btn);


        btn_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (ed_first.getText().toString().isEmpty()) {

                    ed_first.requestFocus();
                    ed_first.setError("FIRST NAME CANNOT BE EMPTY");

                } else if(ed_first.length() > 10){

                    ed_first.requestFocus();
                    ed_first.setError("MAXIMUM LENGTH OF 10 ");

                }  else if (ed_last.getText().toString().isEmpty()) {

                    ed_last.requestFocus();
                    ed_last.setError("LAST NAME CANNOT BE EMPTY");

                } else if(ed_last.length() > 10){

                    ed_last.requestFocus();
                    ed_last.setError("MAXIMUM LENGTH OF 10 ");

                } else if(ed_dsg.getText().toString().isEmpty()){

                    ed_dsg.requestFocus();
                    ed_dsg.setError("DESIGNATION CANNOT BE EMPTY");

                } else if(ed_email.getText().toString().isEmpty()){

                    ed_email.requestFocus();
                    ed_email.setError("EMAIL NAME CANNOT BE EMPTY");

                }else if(!ed_email.getText().toString().trim().matches(emailPattern)){

                    ed_email.requestFocus();
                    ed_email.setError("INVALID EMAIL ADDRESS");

                }else if(ed_dob.getText().toString().isEmpty()){

                    ed_dob.requestFocus();
                    ed_dob.setError("DATE OF BIRTH CANNOT BE EMPTY");

                }else if (!ed_dob.getText().toString().trim().matches(datePattern)){

                    ed_dob.requestFocus();
                    ed_dob.setError("INVALID DATE OF BIRTH");

                } else if(ed_add.getText().toString().isEmpty()){

                    ed_add.requestFocus();
                    ed_add.setError("ADDRESS CANNOT BE EMPTY");

                } else if(ed_dept.getText().toString().isEmpty()){

                    ed_dept.requestFocus();
                    ed_dept.setError("DEPARTMENT CANNOT BE EMPTY");

                }else{

                    process();
                }


            }

        });

    }

    public void process() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);


        Call<Modal> call = apiInterface.addData(ed_first.getText().toString(),
                ed_last.getText().toString(), ed_dsg.getText().toString(),
                ed_email.getText().toString(), ed_dob.getText().toString(),
                ed_add.getText().toString(), ed_dept.getText().toString());

        call.enqueue(new Callback<Modal>() {
            @Override
            public void onResponse(Call<Modal> call, Response<Modal> response) {

                ed_first.setText("");
                ed_last.setText("");
                ed_dsg.setText("");
                ed_email.setText("");
                ed_dob.setText("");
                ed_add.setText("");
                ed_dept.setText("");


                makeText(MainActivity.this, response.toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Modal> call, Throwable t) {

                makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();

            }
        });

    }


}
