package de.jochen_schweizer.jsnow.module.##MODULENAME##;


/**
 * Created by ##USERNAME## on ##DATE##.
 */
public class ##MODULENAME##Presenter implements ##MODULENAME##PresenterInput, ##MODULENAME##InteractorOutput{
    private final ##MODULENAME##InteractorInput mInteractor;
    private final ##MODULENAME##PresenterOutput mOutput;

    public ##MODULENAME##Presenter(##MODULENAME##PresenterOutput output, ##MODULENAME##InteractorInput interactor) {
        mOutput = output;
        mInteractor = interactor;
    }
}
