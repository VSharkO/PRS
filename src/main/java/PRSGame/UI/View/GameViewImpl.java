package PRSGame.UI.View;

import PRSGame.UI.ViewController.UIModels.GameButtonUIModel;
import PRSGame.UI.ViewController.UIModels.GameUIModel;
import PRSGame.UI.ViewController.GameView;
import PRSGame.UI.ViewController.UIModels.OnButtonClickListener;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
public class GameViewImpl implements GameView {
    private OnButtonClickListener buttonClickListener;
    Text resultText = new Text();
    HBox buttonBox = new HBox(10);
    public VBox vbox = new VBox(10, buttonBox, resultText);

    public GameViewImpl() {
        buttonBox.setPadding(new Insets(20));
        vbox.setPadding(new Insets(20));
    }

    public void configureView(GameUIModel uiModel) {
        buttonBox.getChildren().clear();
        for (GameButtonUIModel gameButton : uiModel.gameButtons) {
            Button button = new Button(gameButton.buttonTitle); // Use the label property
            button.setFocusTraversable(false);
            button.setOnAction(event -> {
                if (buttonClickListener != null) {
                    buttonClickListener.clickedButton(gameButton.buttonId);
                }
            });
            buttonBox.getChildren().add(button);
        }
        resultText.textProperty().set(uiModel.resultString);
    }

    @Override
    public Pane getView() {
        return vbox;
    }

    @Override
    public void setOnButtonClickListener(OnButtonClickListener listener) {
        this.buttonClickListener = listener;
    }
}




