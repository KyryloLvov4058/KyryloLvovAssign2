// Kyrylo Lvov n01414058 section B
package kyrylo.lvov.n01414058;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class LvovActivityWithMenu extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.kyryloRent:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+14373452002"));
                startActivity(intent);
                return true;

            case R.id.kyryloHelp:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.website_link)));
                startActivity(intent);
                return true;

            case R.id.kyryloHome:
            case android.R.id.home:
                intent = new Intent(LvovActivityWithMenu.this, KyryloActivity.class);
                startActivity(intent);
                return true;

            default:
                return false;
        }
    }
}