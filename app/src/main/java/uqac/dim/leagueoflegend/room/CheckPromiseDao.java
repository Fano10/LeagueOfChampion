package uqac.dim.leagueoflegend.room;

import androidx.room.Dao;

import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;

@Dao
public interface CheckPromiseDao {
    @Query("SELECT * FROM CheckPromise")
    List<CheckPromise> getAllCheckPromise();

    @Insert
    long addCheckPromise(CheckPromise checkPromise);
}
