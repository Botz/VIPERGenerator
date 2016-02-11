package ##PACKAGENAME##.##MODULENAME_PACKAGE##;

/**
 * Created by ##USERNAME## on ##DATE##.
 */
public class ##MODULENAME##Interactor implements ##MODULENAME##InteractorInput {

    private ##MODULENAME##InteractorOutput mOutput;

    public ##MODULENAME##Interactor() {
    }

    @Override
    public void setInteractorOutput(##MODULENAME##InteractorOutput presenter) {
        mOutput = presenter;
    }
}
