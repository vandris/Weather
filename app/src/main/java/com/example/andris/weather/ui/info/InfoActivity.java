package com.example.andris.weather.ui.info;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andris.weather.R;
import com.example.andris.weather.db.DBHelper;
import com.example.andris.weather.ui.main.MainActivity;
import com.example.andris.weather.ui.modify.ModifyActivity;

public class InfoActivity extends AppCompatActivity implements InfoScreen{

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    int id = -1;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        String[] str = message.split(";");

        TextView cityTw = (TextView)findViewById(R.id.cityinfoTextView);
        TextView coordTw = (TextView)findViewById(R.id.coordinfoTextView);
        TextView tempTw = (TextView)findViewById(R.id.tempinfoTextView);
        TextView humTw = (TextView)findViewById(R.id.humidinfoTextView);
        TextView pressureTw = (TextView)findViewById(R.id.pressureinfoTextView);

        if(str.length == 7){
            id = Integer.parseInt(str[0]);
            cityTw.setText(str[1]);
            coordTw.setText("N " +  str[2] + ", E " + str[3]);
            tempTw.setText(str[4] + " °C");
            humTw.setText(str[5] + " %");
            pressureTw.setText(str[6] + " hPa");
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    public void sendButton(View view){
        Intent intent;
        switch(view.getId()) {
            case R.id.modifyButton:
                intent = new Intent(this, ModifyActivity.class);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                break;
            case R.id.deleteButton:
                DBHelper.getInstance(this).deleteCity(id);
                intent = new Intent(this, MainActivity.class);
                intent.putExtra(EXTRA_MESSAGE, "");
                startActivity(intent);
                break;
        }
    }
}
