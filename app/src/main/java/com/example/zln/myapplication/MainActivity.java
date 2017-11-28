package com.example.zln.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.zln.myapplication.R;


public class MainActivity extends Activity {
    private String[] res = new String[]{"shanghai","beijing","hangzhou","guangzhuo","shenzhen"};
    private MultiAutoCompleteTextView macTextview;
    private ToggleButton toggleButton;
    private CheckBox checkbox;
    private RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        macTextview= (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,res);
        macTextview.setAdapter(adapter);
        //设置分隔符
        macTextview.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        checkbox = (CheckBox) findViewById(R.id.checkBox);
        //监听当前checkbox是否被选中
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    String info = checkbox.getText().toString();
                    Log.i("tag",info);
                }
            }
        });
        rg = (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Toast.makeText(MainActivity.this,"text",Toast.LENGTH_SHORT);
            }
        });
    }
}
