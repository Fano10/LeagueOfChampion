package uqac.dim.leagueoflegend.room;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CheckPromise")
public class CheckPromise {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "idPromise")
    public int idPromise;

    @ColumnInfo(name = "check")
    public boolean check;

    public CheckPromise(int idPromise, boolean check){
        this.idPromise = idPromise;
        this.check = check;
    }

}
