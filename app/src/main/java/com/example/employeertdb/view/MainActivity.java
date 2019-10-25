package com.example.employeertdb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.employeertdb.R;
import com.example.employeertdb.model.Employee;
import com.google.firebase.database.DatabaseReference;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;


    @BindView(R.id.edit_text_name)
    private EditText editName;
    @BindView(R.id.edit_text_tech)
    private EditText editTech;
    @BindView(R.id.edit_text_position)
    private EditText editPosition;
    @BindView(R.id.button_add_employee)
    private Button buttonAddEmployee;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employee = new Employee(
                        editName.toString(),
                        editTech.toString(),
                        editPosition.toString());

                databaseReference.push().setValue(employee);

            }
        });
    }
}
