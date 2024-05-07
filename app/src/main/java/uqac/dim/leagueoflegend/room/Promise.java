package uqac.dim.leagueoflegend.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Promise")
public class Promise {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name="name")
    public String name;

    public Promise(@NonNull String name){
        this.name = name;
    }



}
