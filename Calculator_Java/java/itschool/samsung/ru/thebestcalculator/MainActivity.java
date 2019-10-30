package itschool.samsung.ru.thebestcalculator;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView resultField; // текстовое поле для вывода результата
    EditText numberField; // поле для ввода числа
    TextView operationField; // текстовое поле для вывода знака операции
    Double operand= null ; // операнд операции
    String lastOperation = "="; // последняя операция

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // получаем все поля по id из activity_main
        resultField = (TextView) findViewById(R.id.resultField);
        numberField = (EditText) findViewById(R.id.numberField);
        operationField = (TextView) findViewById(R.id.operationField);}
     // сохранение состояния
     @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("OPERATION", lastOperation);
        if (operand != null)
            outState.putDouble("OPERAND", operand);
        super.onSaveInstanceState(outState);}

    // получение ранее сохраненного состояния
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lastOperation = savedInstanceState.getString("OPERATION");
        operand = savedInstanceState.getDouble("OPERAND");
        resultField.setText(operand.toString());
        operationField.setText(lastOperation);}

    // обработка нажатия на числовую кнопку
    public void onNumberClick(View view) {
        Button button = (Button) view;
        numberField.append(button.getText());
        if (lastOperation.equals("=") && operand != null) {
        }}

    // обработка нажатия на кнопку операции
    public void onOperationClick(View view) {
        Button button = (Button) view;
        String op = button.getText().toString();
        String number = numberField.getText().toString();

// если введенно что-нибудь
        if (number.length() > 0) {
            number = number.replace(',', '.');
            try {
                performOperation(Double.valueOf(number), op);
            } catch (NumberFormatException ex) {
                numberField.setText("");
            }}
        lastOperation = op;
        operationField.setText(lastOperation);}


    private void performOperation(Double number, String operation) {
// если операнд ранее не был установлен ,то есть при вводе самой первой операции)
        if (operand == null) {
            operand = number;}
        else {
            if (lastOperation.equals("=")) {
                lastOperation = operation;}
            switch (lastOperation) {
                case "=":
                    operand = number;
                    break;
                case "/":
                    operand /= number;
                    break;
                case "*":
                    operand *= number;
                    break;
                case "+":
                    operand += number;
                    break;
                case "-":
                    operand -= number;
                    break;
                case "^":
                    operand = Math.pow(operand,number);
                    break;
                case "√":
                    operand = Math.sqrt(number);
                    break;
            }
        }

        resultField.setText(operand.toString().replace('.', ','));
        numberField.setText("");

    }

//обработка нажатия на кнопку удаление

    public void onDeleteClick(View view) {
        operand=null;
        numberField.setText(""+"");
        resultField.setText(" ");
        operationField.setText(" ");
    }

//Переход из одной активности(MainActivity) в другую (MainTwoActivity)




    //Выход из программы
    @Override
    public void onBackPressed() {
        openQuitDialog();}

    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(this);
        quitDialog.setTitle("Выход:"+"Вы уверены?");
        quitDialog.setPositiveButton("Да!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            // TODO Auto-generated method stub
                finish();}
        });
        quitDialog.setNegativeButton("Нет!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
        // TODO Auto-generated method stub
            }
        });
        quitDialog.show();}



    public void Next(View view) {
        Intent intent = new Intent(MainActivity.this,MainTwoActivity.class);
        startActivity(intent);
    }
}
