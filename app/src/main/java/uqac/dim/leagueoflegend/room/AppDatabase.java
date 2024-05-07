package uqac.dim.leagueoflegend.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import android.content.Context;
import androidx.room.Room;


@Database(entities = {Promise.class, CheckPromise.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract PromiseDao promiseDao();
    public abstract CheckPromiseDao checkPromiseDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
