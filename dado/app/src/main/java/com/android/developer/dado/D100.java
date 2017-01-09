package com.android.developer.dado;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Random;


/**
 * Created by rodrigo.rufino on 09/01/2017.
 */

public class D100 extends Fragment{
    Button randomButton;
    NumberPicker numberPicker;
    TextView numberTextView;
    Random random = new Random();
    int randomLimit = 100;
    int randomNumber;
    int numberPickerValue;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.d4, container, false);

        randomButton = (Button) view.findViewById(R.id.roll_button);
        numberPicker = (NumberPicker) view.findViewById(R.id.number_picker);
        numberTextView = (TextView)view.findViewById(R.id.textView);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(30);
        numberPicker.setEnabled(true);
        numberPicker.setWrapSelectorWheel(true);
        numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomButton.setEnabled(false);
                numberPickerValue = numberPicker.getValue();
                new CountDownTimer(500, 10) {
                    public void onTick(long millisUntilFinished) {
                        numberTextView.setText(String.valueOf(random.nextInt(randomLimit*numberPickerValue)+1));
                    }
                    public void onFinish() {
                        numberPickerValue = numberPicker.getValue();
                        for(int i = 0; i<numberPickerValue; i++){
                            randomNumber = randomNumber + random.nextInt(randomLimit)+1;
                        }
                        numberTextView.setText(String.valueOf(randomNumber));
                        randomNumber = 0;
                        randomButton.setEnabled(true);
                    }
                }.start();
            }
        });
        return view;
    }
}
