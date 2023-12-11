package UI.ViewModel;

import UI.ViewController.UIModels.GameUIModel;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public interface GameViewModel {
    public Disposable bind();
    public PublishSubject<GameViewModelInput> getInput();
    public PublishSubject<GameUIModel> getOutput();
}
