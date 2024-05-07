package uqac.dim.leagueoflegend;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import uqac.dim.leagueoflegend.room.AppDatabase;
import uqac.dim.leagueoflegend.room.Promise;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getInstance(this);
    }

    public void addPromise(View v){
        AlertDialog.Builder builder  = new AlertDialog.Builder(this); // pop up qu'on veut afficher pour ajouter des promesses
        EditText editText = new EditText(this); // EditText qu'on va mettre dans le pop up
        editText.setHint("nouvelle promesse");
        builder.setTitle("Ajouter une nouvelle promesse");
        builder.setView(editText);

        builder.setPositiveButton("Ajouter", (dialog, which) -> {
            Toast.makeText(this,editText.getText(),Toast.LENGTH_SHORT).show();
            String stringPromise = String.valueOf(editText.getText());
            Promise promise = new Promise(stringPromise);
            db.promiseDao().addPromise(promise);
            dialog.cancel();
        });
        builder.setNegativeButton("Annuler", (dialog, which) -> {
            dialog.cancel();
        });

        builder.show();
    }
}