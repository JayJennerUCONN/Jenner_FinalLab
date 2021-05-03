package me.pgb.a2021_04_20_room.db;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface PortfolioDao {

    @Insert //(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Stock stock);

    @Delete
    public void delete(Stock stock);

    @Update
    public void update(Stock stock);

    @Query("SELECT * FROM stock WHERE name = :name")
    public Stock getStock(String name);

    @Query("SELECT * FROM stock")
    LiveData<List<Stock>> getAll();

    @Query("DELETE FROM stock WHERE id NOT IN (SELECT MIN(id) FROM stock GROUP BY name)")
    void deleteDuplicates();

    @Query("DELETE FROM stock")
    void deleteAll();

}
