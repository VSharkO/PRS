package PRSGame.UI.ViewController.UIModels;

import java.util.ArrayList;

public class GameUIModel {
    public String resultString;
    public ArrayList<GameButtonUIModel> gameButtons;

    public GameUIModel(String resultString,
                       ArrayList<GameButtonUIModel> gameButtons) {
        this.resultString = resultString;
        this.gameButtons = gameButtons;
    }
}


