package serdar.oz.loodostestapp.ui.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import serdar.oz.loodostestapp.R;


public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_activty);
    }


}
