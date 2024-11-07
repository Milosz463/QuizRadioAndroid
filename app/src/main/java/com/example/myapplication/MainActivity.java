package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
private ArrayList<Pytanie>pytania=new ArrayList<>();
private RadioButton[] radioButtons=new RadioButton[3];
int pytaniel;
private Button buttonSprawdz;
private Button buttonDalej;
TextView textView;
private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pytania.add(new Pytanie("Na jakim systemie operacyjnum zostal zbudowany android", "Windows", "Linux", "IOS",1));
        pytania.add(new Pytanie("Nazwa wersji androida to czesto", "ciasteczko","owoc","tort",0));
        pytania.add(new Pytanie("Jaki jezyk jest rekomendowany do pisania aplikacji na androida przez google","Java","Kotlin","HTML",1));

   textView=findViewById(R.id.textView2);
   buttonSprawdz=findViewById(R.id.button);
   buttonDalej=findViewById(R.id.button2);
   radioGroup=findViewById(R.id.radiogroup);
   radioButtons[0]=findViewById(R.id.radioButton);
   radioButtons[1]=findViewById(R.id.radioButton2);
   radioButtons[2]=findViewById(R.id.radioButton3);
        wyswietlPytanie(0);

   buttonSprawdz.setOnClickListener(
           new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   int idZaznaczone=radioGroup.getCheckedRadioButtonId();
                   for (int i = 0; i < radioButtons.length; i++) {
                       if (radioButtons[i].getId() == idZaznaczone) {
                           pytania.get(pytaniel).sprawdzOdpowiedz(i);
                           radioButtons[i].setChecked(false);
                           if (pytania.get(pytaniel).isCzyUdzielonoPoprawnaOdpowiedz()) {
                               Toast.makeText(MainActivity.this, "dobraOdpowiedz", Toast.LENGTH_SHORT).show();
                               radioButtons[i].setBackgroundColor(Color.GREEN);
                               buttonDalej.setVisibility(View.VISIBLE);

                           } else {
                               Toast.makeText(MainActivity.this, "zlaOdpowiedz", Toast.LENGTH_SHORT).show();
                               radioButtons[i].setBackgroundColor(Color.RED);
                               buttonDalej.setVisibility(View.VISIBLE);
                           }
                       }
                   }
               }
           }
   );

   buttonDalej.setOnClickListener(
           new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   pytaniel++;


                   if(pytaniel == pytania.size()){
                       buttonDalej.setVisibility(View.INVISIBLE);
                       pytaniel--;
                       radioGroup.setVisibility(View.INVISIBLE);
                       buttonDalej.setVisibility(View.INVISIBLE);
                       buttonSprawdz.setVisibility(View.INVISIBLE);
                       textView.setText("Ukonczyles test, twoja liczba punktow wynosi: "+liczPunkty());
                   }else
                   {
                       wyswietlPytanie(pytaniel);
                       for (int i = 0; i < radioButtons.length; i++) {
                           radioButtons[i].setBackgroundColor(Color.WHITE);
                       }
                   }
               }
           }
   );


    }

    private void wyswietlPytanie(int i){
        textView.setText(pytania.get(i).getTrescPytania());
        for (int j = 0; j < radioButtons.length; j++) {
            radioButtons[j].setText(pytania.get(i).getOdpowiedz()[j]);
            buttonDalej.setVisibility(View.INVISIBLE);
        }

        }
    private int liczPunkty() {
        int sumaPunktow=0;
        for(Pytanie pytanie : pytania) {
            if (pytanie.isCzyUdzielonoPoprawnaOdpowiedz()) {
                sumaPunktow++;
            }
        }
        return sumaPunktow;
    }
    };
