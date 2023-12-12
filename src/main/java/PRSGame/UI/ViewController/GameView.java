package PRSGame.UI.ViewController;

import PRSGame.UI.ViewController.UIModels.OnButtonClickListener;
import PRSGame.UI.ViewController.UIModels.GameUIModel;
import javafx.scene.layout.Pane;

public interface GameView {
    void configureView(GameUIModel uiModel);
    Pane getView();
    void setOnButtonClickListener(OnButtonClickListener listener);
}
