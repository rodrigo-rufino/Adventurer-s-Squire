package com.android.developer.dado;

/**
 * Created by rodrigo.rufino on 06/01/2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Random;

public class D4 extends Fragment {
    Button randomButton;
    NumberPicker numberPicker;
    TextView numberTextView;

    int randomNumber;
    int numberPickerValue;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.d4, container, false);
        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes

        randomButton = (Button) view.findViewById(R.id.roll_button);
        numberPicker = (NumberPicker) view.findViewById(R.id.number_picker);
        numberTextView = (TextView)view.findViewById(R.id.textView);



        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(20);
        numberPicker.setEnabled(true);
        numberPicker.setWrapSelectorWheel(true);
        numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                numberPickerValue = numberPicker.getValue();
                for(int i = 0; i<numberPickerValue; i++){
                    randomNumber = randomNumber + random.nextInt(4)+1;

                }
                numberTextView.setText(String.valueOf(randomNumber));
                randomNumber = 0;
            }
        });


        return view;
    }
}
