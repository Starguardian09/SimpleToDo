package sg.edu.rp.c346.id21021646.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText ToDo;
Button Add;
Button Clear;
Button btnDlt;
Spinner spnAddDlt;
ListView List;
ArrayList<String>alToDo;
ArrayAdapter<String>aaToDo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToDo=findViewById(R.id.ToDo);
        Add=findViewById(R.id.Add);
        btnDlt=findViewById(R.id.Delete);
        spnAddDlt = findViewById(R.id.spinnerAddDlt);
        Clear=findViewById(R.id.clear);

        List=findViewById(R.id.List);

        alToDo=new ArrayList<>();
        aaToDo=new ArrayAdapter<>(this, R.layout.layout,alToDo);
        List.setAdapter(aaToDo);
        spnAddDlt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        ToDo.setHint("Type in a new task here");
                        btnDlt.setEnabled(false);
                        Add.setEnabled(true);
                        break;
                    case 1:
                        ToDo.setHint("Type in the index of the task to be removed");
                        Add.setEnabled(false);
                        btnDlt.setEnabled(true);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ToDo.getText().toString().length() != 0) {
                    String newTask = ToDo.getText().toString();
                    alToDo.add(newTask);
                    aaToDo.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Field is empty", Toast.LENGTH_LONG).show();
                }

            }

        });
        btnDlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(ToDo.getText().toString());

                if (alToDo.isEmpty() == true) {
                    Toast.makeText(MainActivity.this, "You don't have any task", Toast.LENGTH_LONG).show();
                } else if (position > alToDo.size()) {
                    Toast.makeText(MainActivity.this, "Wrong index number", Toast.LENGTH_LONG).show();
                } else {
                    alToDo.remove(position);
                    aaToDo.notifyDataSetChanged();
                }

            }
        });

        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alToDo.clear();
                aaToDo.notifyDataSetChanged();

            }

        });


    }
}