package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
private Button btnspeak;
private EditText txt;
TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.editText);
        btnspeak = findViewById(R.id.button);
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS)
                    int result = textToSpeech.setLanguage(Locale.ENGLISH)
                if (result == TextToSpeech.LANG_MISSING_DATA)
                    (result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Toast.makeText(MainActivity.this, "Not Supported Language", Toast.LENGTH_LONG);
                }
                else
                btnspeak.setEnabled(true);
                textToSpeech.setPitch(0.6f);
                textToSpeech.setSpeechRate(1.0f);

                    btnspeak.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           speak();
                       }



private void speak() {
    String text = txt.getText().toString();
     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
         textToSpeech.speak(text,textToSpeech.QUEUE_FLUSH,null,null);
     else
         textToSpeech.speak(text,textToSpeech.QUEUE_FLUSH,null);
}

    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        MainActivity.super.onDestroy();

