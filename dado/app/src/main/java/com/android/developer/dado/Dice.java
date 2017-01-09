package com.android.developer.dado;

/**
 * Created by rodrigo.rufino on 06/01/2017.
 */
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

public class Dice extends Fragment {


    Button randomButton;
    NumberPicker numberPicker;
    TextView numberTextView;
    Random random = new Random();
    int randomLimit;
    int randomNumber;
    int numberPickerValue;

    public Dice(int randomLimit) {
        this.randomLimit = randomLimit;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.d4, container, false);
        switch(randomLimit){
            case 4:  view = inflater.inflate(R.layout.d4, container, false); break;
            case 6:  view = inflater.inflate(R.layout.d6, container, false); break;
            case 8:  view = inflater.inflate(R.layout.d8, container, false); break;
            case 10:  view = inflater.inflate(R.layout.d10, container, false); break;
            case 12:  view = inflater.inflate(R.layout.d12, container, false); break;
            case 20:  view = inflater.inflate(R.layout.d20, container, false); break;
            case 100:  view = inflater.inflate(R.layout.d100, container, false); break;
        }

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