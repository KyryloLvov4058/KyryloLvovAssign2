// Kyrylo Lvov n01414058 section B
package kyrylo.lvov.n01414058;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class LvovVisitScreenActivity extends LvovActivityWithMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvov_buildings_screen);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        TextView screenTextView = (TextView) findViewById(R.id.kyryloBuildingScreenText);
        CheckBox buildingText1 = findViewById(R.id.kyryloBuildingCheck1);
        CheckBox buildingText2 = findViewById(R.id.kyryloBuildingCheck2);
        CheckBox buildingText3 = findViewById(R.id.kyryloBuildingCheck3);
        ImageView buildingImage1 = findViewById(R.id.kyryloBuildingImage1);
        ImageView buildingImage2 = findViewById(R.id.kyryloBuildingImage2);
        ImageView buildingImage3 = findViewById(R.id.kyryloBuildingImage3);
        Button button = findViewById(R.id.kyryloVisitButton);

        String rentalType = getIntent().getStringExtra(getString(R.string.argument_rentalType));
        String rentalTypeFull = getIntent().getStringExtra("rentalTypeFull");
        String[] textDetached = getResources().getStringArray(R.array.text_detached);
        String[] textApartment = getResources().getStringArray(R.array.text_apartment);
        String[] textSemi = getResources().getStringArray(R.array.text_semi);

        screenTextView.setText(getResources().getString(R.string.rentalType_options, rentalTypeFull));

        if (rentalType.equals(getString(R.string.rentalTypeDetached))) {
            buildingText1.setText(textDetached[0]);
            buildingText2.setText(textDetached[1]);
            buildingText3.setText(textDetached[2]);

            buildingImage1.setImageResource(getResources().getIdentifier("detached1", "drawable", getPackageName()));
            buildingImage2.setImageResource(getResources().getIdentifier("detached2", "drawable", getPackageName()));
            buildingImage3.setImageResource(getResources().getIdentifier("detached3", "drawable", getPackageName()));
        } else if (rentalType.equals(getString(R.string.rentalTypeApartment))) {
            buildingText1.setText(textApartment[0]);
            buildingText2.setText(textApartment[1]);
            buildingText3.setText(textApartment[2]);

            buildingImage1.setImageResource(getResources().getIdentifier("apartment1", "drawable", getPackageName()));
            buildingImage2.setImageResource(getResources().getIdentifier("apartment2", "drawable", getPackageName()));
            buildingImage3.setImageResource(getResources().getIdentifier("apartment3", "drawable", getPackageName()));
        } else if (rentalType.equals(getString(R.string.rentalTypeSemi))) {
            buildingText1.setText(textSemi[0]);
            buildingText2.setText(textSemi[1]);
            buildingText3.setText(textSemi[2]);

            buildingImage1.setImageResource(getResources().getIdentifier("semi1", "drawable", getPackageName()));
            buildingImage2.setImageResource(getResources().getIdentifier("semi2", "drawable", getPackageName()));
            buildingImage3.setImageResource(getResources().getIdentifier("semi3", "drawable", getPackageName()));
        }

        button.setOnClickListener(v -> {
            if (buildingText1.isChecked() || buildingText2.isChecked() || buildingText3.isChecked()) {
                Intent intent = new Intent(LvovVisitScreenActivity.this, LvovPaymentScreenActivity.class);
                startActivity(intent);
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), R.string.oneOptionError, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

}