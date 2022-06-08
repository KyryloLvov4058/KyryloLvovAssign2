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

        imgbtn.setOnClickListener(v -> {
            if (rb1.isChecked()) {
                viewBuildings(getString(R.string.type_apartament));
            } else if (rb2.isChecked()) {
                viewBuildings(getString(R.string.type_detached));
            } else if (rb3.isChecked()) {
                viewBuildings(getString(R.string.type_semi));
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), R.string.oneOptionError, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    public void viewBuildings(String rentalType) {
        Intent intent = new Intent(LvovRentTypeScreenActivity.this, LvovBuildingsScreenActivity.class);
        intent.putExtra(getString(R.string.argument_rentalType), rentalType);
        startActivity(intent);
    }
}