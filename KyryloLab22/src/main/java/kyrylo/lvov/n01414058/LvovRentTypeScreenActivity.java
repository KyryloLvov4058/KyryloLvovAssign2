// Kyrylo Lvov n01414058 section B
package kyrylo.lvov.n01414058;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class LvovRentTypeScreenActivity extends LvovActivityWithMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvov_rent_type);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        ImageButton imgbtn = findViewById(R.id.kyryloImageButton);
        RadioButton rb1 = findViewById(R.id.kyryloRadioButton1);
        RadioButton rb2 = findViewById(R.id.kyryloRadioButton2);
        RadioButton rb3 = findViewById(R.id.kyryloRadioButton3);

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rb1.isChecked()) {
                    Log.d("D", "1 Checked");
                } else if (rb2.isChecked()) {
                    Log.d("D", "2 Checked");
                } else if (rb3.isChecked()) {
                    Log.d("D", "3 Checked");
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.oneOptionError, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}