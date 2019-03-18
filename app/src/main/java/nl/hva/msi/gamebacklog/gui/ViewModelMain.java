package nl.hva.msi.gamebacklog.gui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import nl.hva.msi.gamebacklog.itemmodel.Game;
import nl.hva.msi.gamebacklog.localdatabase.GameDAO;
import nl.hva.msi.gamebacklog.localdatabase.GameRepo;

public class ViewModelMain extends AndroidViewModel implements GameDAO {

    private GameRepo gameRepo;
    private LiveData<List<Game>> gameList;

    public ViewModelMain(@NonNull Application application) {
        super(application);
        gameRepo = new GameRepo(application.getApplicationContext());
        gameList = gameRepo.getAllGames();
    }


    @Override
    public LiveData<List<Game>> getAllGames() {
        return gameList;
    }

    @Override
    public void insertGame(Game game) {
        gameRepo.insertGame(game);
    }

    @Override
    public void deleteGame(Game game) {
        gameRepo.deleteGame(game);
    }

    @Override
    public void updateGame(Game game) {
        gameRepo.updateGame(game);
    }
}
