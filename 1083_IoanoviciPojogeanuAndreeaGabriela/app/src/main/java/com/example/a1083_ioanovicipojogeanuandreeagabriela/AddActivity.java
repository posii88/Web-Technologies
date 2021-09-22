package com.example.a1083_ioanovicipojogeanuandreeagabriela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TimePicker;

public class AddActivity extends AppCompatActivity {
private Button button;
private EditText editTextMagazin;
private EditText editTextTip;
private TimePicker timePickerData;
private SeekBar seekBarBuget;
private CheckBox cb;
public static final String CHEIE="cheie";

private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editTextMagazin=findViewById(R.id.editTextMagazin);
        editTextTip=findViewById(R.id.editTextTipObiect);
        timePickerData=findViewById(R.id.time_picker_data);
        seekBarBuget=findViewById(R.id.seekBarBuget);
        cb=findViewById(R.id.checkBoxNeaaparat);
        button=findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         if(validate()){
                                             ListaCumparaturi listaCumparaturi = creatreLista();
                                             Bundle bundle=new Bundle();
                                             bundle.putSerializable(CHEIE, listaCumparaturi);
                                             intent = new Intent(getApplicationContext(), MainActivity.class);
                                             //intent.putExtra(ADD_REVIZIE_KEY, revizieNoua);
                                             intent.putExtras(bundle);
                                             setResult(RESULT_OK,intent);
                                             //Toast.makeText(getApplicationContext(),personal.toString(),Toast.LENGTH_LONG).show();
                                             finish();
                                         }}
                                 });
        intent=getIntent();
        if(intent.hasExtra(CHEIE)){

        }
    }

    private void adaugaInLista(ListaCumparaturi listaCumparaturi) {
        if(listaCumparaturi==null){
            return;
        }
        editTextMagazin.setText(listaCumparaturi.getMagazin());
        editTextTip.setText(listaCumparaturi.getGenObiecte());
        timePickerData.setHour(listaCumparaturi.getOraCumparaturi());
        if(cb.isChecked()){
            cb.setChecked(true);
        }
        seekBarBuget.setProgress(listaCumparaturi.getBuget());

    }

    private boolean validate() {
        if (editTextTip.getText() == null || editTextMagazin.getText().length() == 0) {
            editTextMagazin.setError("introduceti un nume valid");
            return false;
        }
        return true;
    }

    private ListaCumparaturi creatreLista() {
        String magazin = editTextMagazin.getText().toString();
        String tip = editTextTip.getText().toString();
        int moment = timePickerData.getHour();
        int buget = seekBarBuget.getProgress();
        int neaaparat=0;
        if(cb.isChecked())
            neaaparat=1;
        else
            neaaparat=0;

        return new ListaCumparaturi(buget,magazin,tip,moment,neaaparat);
    }

}