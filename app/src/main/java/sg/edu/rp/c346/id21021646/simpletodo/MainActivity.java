package sg.edu.rp.c346.id21021646.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText ToDo;
Button Add;
Button Clear;
ListView List;
ArrayList<String>alToDo;
ArrayAdapter<String>aaToDo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToDo=findViewById(R.id.ToDo);
        Add=findViewById(R.id.Add);
        Clear=findViewById(R.id.clear);
        List=findViewById(R.id.List);

        alToDo=new ArrayList<>();
        aaToDo=new ArrayAdapter<>(this
        , android.R.layout.simple_list_item_1,alToDo);
        List.setAdapter(aaToDo);

        Add.setOnClickListener((view) ->{
            String newTodo=ToDo.getText().toString();
            alToDo.add(newTodo);
            aaToDo.notifyDataSetChanged();
            ToDo.setText(null);
        });
        Clear.setOnClickListener((view) ->{
            alToDo.clear();
            aaToDo.notifyDataSetChanged();
        });
    }
}