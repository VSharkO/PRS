package UI.ViewController;

import UI.View.OnButtonClickListener;
import UI.ViewController.UIModels.GameUIModel;
import javafx.scene.layout.Pane;

public interface GameView {
    void configureView(GameUIModel uiModel);
    Pane getView();
    void setOnButtonClickListener(OnButtonClickListener listener);
}
