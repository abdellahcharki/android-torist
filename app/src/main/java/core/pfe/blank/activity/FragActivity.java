package core.pfe.blank.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import core.pfe.blank.R;
import core.pfe.blank.serves.PlaceServes;

public class FragActivity extends AppCompatActivity {

    PlaceServes placeServes;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);

        result= findViewById(R.id.result);




    }
}