package uqac.dim.leagueoflegend.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import uqac.dim.leagueoflegend.adapter.PromiseAdapter;
import uqac.dim.leagueoflegend.room.Promise;
import uqac.dim.leagueoflegend.room.AppDatabase;
import uqac.dim.leagueoflegend.room.Promise;

public class ActivityPromise extends Activity {
    private ArrayList<Promise> promiseArrayList;
    private PromiseAdapter promiseAdapter;

    public static List<Integer> integers;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        promiseArrayList = new ArrayList<>();
        integers = new ArrayList<>();
        db = AppDatabase.getInstance(this);
        promiseArrayList = (ArrayList<Promise>) db.promiseDao().getAllPromise();
        promiseAdapter = new PromiseAdapter(this,promiseArrayList);


        ListView listView = new ListView(this);
        listView.setAdapter(promiseAdapter);

        //afficher dans un dialogue les promises
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Liste des promesses");
        builder.setView(listView);

        builder.setPositiveButton("Ok", (dialog, which) -> {
            dialog.cancel();
        });
        builder.show();
    }
}
