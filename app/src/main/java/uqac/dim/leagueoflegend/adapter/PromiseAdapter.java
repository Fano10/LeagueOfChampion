package uqac.dim.leagueoflegend.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import uqac.dim.leagueoflegend.R;
import uqac.dim.leagueoflegend.activity.ActivityPromise;
import uqac.dim.leagueoflegend.room.Promise;

public class PromiseAdapter extends ArrayAdapter<Promise> {
    private final Context context;

    public  PromiseAdapter(Context context, List<Promise> promises){
        super(context,0,promises);
        this.context = context;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent){
        //obtenir la promesse dans la liste de promesse dans la classe parent
        final Promise promise = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.promise_layout, parent,false);
        }
        //obtenir les view dans le layout
        TextView textView = convertView.findViewById(R.id.textPromiseLayout);
        CheckBox checkBox = convertView.findViewById(R.id.checkboxPromiseLayout);
        assert promise != null;
        textView.setId(promise.id); // doit etre un nombre positive
        textView.setText(promise.name);
        return convertView;
    }
}
