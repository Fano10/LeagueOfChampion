package uqac.dim.leagueoflegend.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface PromiseDao {

    @Query("SELECT * FROM Promise")
    List<Promise> getAllPromise();

    @Insert
    long addPromise(Promise promise);

    @Update
    void updatePromise(Promise promise);

    @Delete
    void deletePromise(Promise promise);
}
