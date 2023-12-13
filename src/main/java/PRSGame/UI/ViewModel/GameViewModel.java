package PRSGame.UI.ViewModel;

import PRSGame.UI.ViewController.UIModels.GameUIModel;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public interface GameViewModel {
    Disposable bind();
    PublishSubject<GameViewModelInput> getInput();
    PublishSubject<GameUIModel> getOutput();
}


