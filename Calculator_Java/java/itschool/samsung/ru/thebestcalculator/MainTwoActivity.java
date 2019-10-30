package itschool.samsung.ru.thebestcalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import static itschool.samsung.ru.thebestcalculator.R.id.NextString;
import static itschool.samsung.ru.thebestcalculator.R.id.button;
import static itschool.samsung.ru.thebestcalculator.R.id.numberField;

public class MainTwoActivity extends AppCompatActivity {
    public void Nazad(View view) {
        Intent intent = new Intent(MainTwoActivity.this, MainActivity.class);
        startActivity(intent);
    }

    EditText firsta; //вводим число А
    EditText secondb; //вводим число В
    EditText thirdc; //вводим число С


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);

        firsta = (EditText) findViewById(R.id.firsta);
        secondb = (EditText) findViewById(R.id.secondb);
        thirdc = (EditText) findViewById(R.id.thirdc);


    }

    public void onbuttonClick(View view) {
        Button button = (Button) view;
        firsta.append(button.getText());

    }
    public void NextString (View view){



            }
        }
































