package org.example.prs;

import PRSGame.Feature.MoveService.MoveService;
import org.example.prs.Decorators.AnalyticsGameUseCaseDecorator;
import PRSGame.Feature.GameUseCase.GameUseCase;
import PRSGame.Feature.GameUseCaseImpl;
import PRSGame.UI.View.GameViewImpl;
import PRSGame.UI.ViewController.GameViewController;
import PRSGame.UI.ViewModel.GameViewModelImpl;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import javafx.stage.Stage;
import org.example.prs.Decorators.SaveMoveServiceDecorator;
import org.example.prs.MoveRepository.CompositMoveRepository;
import org.example.prs.MoveRepository.DatabaseMoveRepository;
import org.example.prs.MoveRepository.LocalMoveRepository;
import org.example.prs.MoveRepository.MoveRepository;

public class Application extends javafx.application.Application {
    //This can be moved to factory

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final GameUseCase gameUseCase = new AnalyticsGameUseCaseDecorator(new GameUseCaseImpl(this.moveServiceFactory()));
    private final GameViewModelImpl viewModel = new GameViewModelImpl(
            gameUseCase,
            PublishSubject.create(),
            PublishSubject.create());

    private final GameViewController viewController = new GameViewController(viewModel, new GameViewImpl(), compositeDisposable);
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        viewController.showViewOn(primaryStage);
    }

    private MoveService moveServiceFactory(){
        MoveService originalMoveService = new MoveServiceImpl();
        MoveRepository localRepo = new LocalMoveRepository();
        MoveRepository dbRepo = new DatabaseMoveRepository();

        CompositMoveRepository compositeRepo = new CompositMoveRepository();
        compositeRepo.addRepository(localRepo);
        compositeRepo.addRepository(dbRepo);

        return new SaveMoveServiceDecorator(originalMoveService, compositeRepo);
    }
}



