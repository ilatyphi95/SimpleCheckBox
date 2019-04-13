package com.ilatyphi95.simplecheckboxes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> mList;
    private CheckBox mCheckOne;
    private CheckBox mCheckTwo;
    private CheckBox mCheckThree;
    private CheckBox mCheckFour;
    private String[] mArrayCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tvDisplayMsg = findViewById(R.id.tv_display_msg);

        mArrayCheck = new String[]{
                getResources().getString(R.string.check_one_string),
                getResources().getString(R.string.check_two_string),
                getResources().getString(R.string.check_three_string),
                getResources().getString(R.string.check_four_string)
        };

        mCheckOne = findViewById(R.id.checkBox);
        mCheckTwo = findViewById(R.id.checkBox2);
        mCheckThree = findViewById(R.id.checkBox3);
        mCheckFour = findViewById(R.id.checkBox4);

        Button btnDisplay = findViewById(R.id.button);
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplayMsg.setText(generateOutputString());

            }
        });
    }

    private String generateOutputString() {
        mList = new ArrayList<>();
        if(mCheckOne.isChecked()) {
            mList.add(mArrayCheck[0]);
        }
        if(mCheckTwo.isChecked()) {
            mList.add(mArrayCheck[1]);
        }
        if(mCheckThree.isChecked()) {
            mList.add(mArrayCheck[2]);
        }
        if(mCheckFour.isChecked()) {
            mList.add(mArrayCheck[3]);
        }

        final int size = mList.size();
        List<String> tempArray = new ArrayList<>();

        String message;
        if(size > 1) {
            for (int count = 0; count < (size - 1); count++) {
                tempArray.add(mList.get(count));
            }
            message = String.join(", ", tempArray);
            message += " and " + mList.get(size - 1);

        } else if( size == 1) {
            message = mList.get(0);
        } else {
            message = "nothing";
        }
        return message += " selected";
    }
}
