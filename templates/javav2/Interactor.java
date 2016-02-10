package ##PACKAGENAME##.##MODULENAME##;

/**
 * Created by ##USERNAME## on ##DATE##.
 */
public class ##MODULENAME##Interactor implements ##MODULENAME##InteractorInput {

    private ##MODULENAME##InteractorOutput presenter;

    public ##MODULENAME##Interactor() {
    }

    @Override
    public void setInteractorOutput(##MODULENAME##InteractorOutput presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onDestroy() {

    }
}
