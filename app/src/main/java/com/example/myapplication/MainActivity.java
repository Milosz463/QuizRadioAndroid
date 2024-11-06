package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ArrayList<Pytanie>pytania=new ArrayList<>();
private RadioButton[] radioButtons=new RadioButton[3];
int pytaniel;
private Button buttonSprawdz;
private Button buttonDalej;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pytania.add(new Pytanie("Na jakim systemie operacyjnum zostal zbudowany android", "Windows", "Linux", "IOS",1));
        pytania.add(new Pytanie("Nazwa wersji androida to czesto", "ciasteczko","owoc","tort",0));
        pytania.add(new Pytanie("Jaki jezyk jest rekomendowany do pisania aplikacji na androida przez google","Java","Kotlin","HTML",1));

   textView=findViewById(R.id.textView2);
   buttonDalej=findViewById(R.id.button2);
   radioButtons[0]=findViewById(R.id.radioButton);
   radioButtons[1]=findViewById(R.id.radioButton2);
   radioButtons[2]=findViewById(R.id.radioButton3);
        wyswietlPytanie(0);

   buttonDalej.setOnClickListener(
           new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   pytaniel++;
                   if(pytaniel == pytania.size()){
                       buttonDalej.setVisibility(View.INVISIBLE);
                   }
                   wyswietlPytanie(pytaniel);
               }
           }
   );


    }

    private void wyswietlPytanie(int i){
        textView.setText(pytania.get(i).getTrescPytania());
        for (int j = 0; j < radioButtons.length; j++) {
            radioButtons[j].setText(pytania.get(i).getOdpowiedz()[j]);
        }
    }
}