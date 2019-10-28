package ru.startandroid.p0011noteseditorsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btCreate;
    EditText etInput;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCreate = (Button) findViewById(R.id.btCreate);
        etInput = findViewById(R.id.etInput);

        // получаем экземпляр элемента ListView
        ListView lvData = (ListView) findViewById(R.id.lvData);
        final EditText etInput = findViewById(R.id.etInput);

        // Создаём пустой массив для хранения заметок
        final ArrayList<String> notes = new ArrayList<>();


        // Создаём адаптер ArrayAdapter, чтобы привязать массив к ListView
        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,
                R.layout.item, notes);

        // Привяжем массив через адаптер к ListView
        lvData.setAdapter(adapter);

        // Обработка нажатия кнопки +
        View.OnClickListener oclBtCreate = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notes.add(0, etInput.getText().toString());
                adapter.notifyDataSetChanged();

                // Очищаем поле ввода
                etInput.setText("");
            }
        };

        // Присваиваем обработчик кнопке
        btCreate.setOnClickListener(oclBtCreate);

    };

}
