package core.pfe.blank.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import core.pfe.blank.R;

public class ErroreActivity extends AppCompatActivity {

    TextView msg;
    ImageView icon;
    Button tryBtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_errore);
        msg=findViewById(R.id.err_msg);
        icon=findViewById(R.id.err_icon);
        tryBtn = findViewById(R.id.try_agin);

        msg.setText("something wrong");




        tryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}