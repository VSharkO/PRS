package UI.ViewController;

import UI.View.OnButtonClickListener;
import UI.ViewController.UIModels.GameUIModel;
import javafx.scene.layout.Pane;

public interface GameView {
    public void configureView(GameUIModel uiModel);
    public Pane getView();
    void setOnButtonClickListener(OnButtonClickListener listener);
}
