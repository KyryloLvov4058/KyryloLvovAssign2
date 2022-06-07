// Kyrylo Lvov n01414058 section B
package kyrylo.lvov.n01414058;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LvovSplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(LvovSplashScreenActivity.this, KyryloActivity.class));
        finish();
    }
}