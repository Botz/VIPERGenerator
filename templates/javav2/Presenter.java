package ##PACKAGENAME##.##MODULENAME_PACKAGE##;


/**
 * Created by ##USERNAME## on ##DATE##.
 */
public class ##MODULENAME##Presenter implements ##MODULENAME##PresenterInput, ##MODULENAME##InteractorOutput {
    private final ##MODULENAME##InteractorInput interactor;
    private ##MODULENAME##PresenterOutput view;

    public ##MODULENAME##Presenter(##MODULENAME##InteractorInput interactor) {
        this.interactor = interactor;
    }

    @Override
    public void setPresenterOutput(##MODULENAME##PresenterOutput view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        interactor.onDestroy();
    }
}
