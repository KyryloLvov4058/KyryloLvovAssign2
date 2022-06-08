package kyrylo.lvov.n01414058;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Objects;

public class LvovBuildingsScreenActivity extends LvovActivityWithMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvov_buildings_screen);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        String rentalType = getIntent().getStringExtra(getString(R.string.argument_rentalType));

    }
}