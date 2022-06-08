package kyrylo.lvov.n01414058;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class LvovPaymentScreenActivity extends LvovActivityWithMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvov_payment_screen);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        EditText cardNumber = findViewById(R.id.kyryloPaymentCardNumber);
        EditText cardName = findViewById(R.id.kyryloPaymentName);
        EditText cardExpiry = findViewById(R.id.kyryloPaymentExpiry);
        EditText cardCode = findViewById(R.id.kyryloPaymentCode);
        Button button = findViewById(R.id.kyryloPaymentButton);

        button.setOnClickListener(v -> {
            char[] cardNameArray = cardName.getText().toString().toCharArray();
            for (char c : cardNameArray) {
                if (Character.isDigit(c)) {
                    cardName.setError("This field cannot contain numbers");
                }
            }

            if (cardName.getText().toString().matches("")) {
                cardName.setError(getString(R.string.cannotBeEmpty));
            } else if (cardName.getText().toString().length() < 3) {
                cardName.setError("This field must contain at least 3 characters");
            } else if (cardNumber.getText().toString().matches("")) {
                cardNumber.setError(getString(R.string.cannotBeEmpty));
            } else if (cardNumber.getText().toString().length() != 16) {
                cardNumber.setError("This field must contain 16 characters");
            } else if (cardExpiry.getText().toString().matches("")) {
                cardExpiry.setError(getString(R.string.cannotBeEmpty));
            } else if (cardExpiry.getText().toString().length() != 4) {
                cardExpiry.setError("This field must contain 4 characters");
            } else if (cardCode.getText().toString().matches("")) {
                cardCode.setError(getString(R.string.cannotBeEmpty));
            } else if (cardCode.getText().toString().length() != 3) {
                cardCode.setError("This field must contain 3 characters");
            } else {
                Context context = this;
                new AlertDialog.Builder(context)
                        .setTitle("Success!")
                        .setMessage("Your request is being processed")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(LvovPaymentScreenActivity.this, KyryloActivity.class);
                                startActivity(intent);
                            }
                        })
                        .show();
            }
        });
    }
}