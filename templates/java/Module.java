package ##PACKAGENAME##.##MODULENAME_PACKAGE##;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.jochen_schweizer.jsnow.application.JSNowModule;

/**
 * Created by ##USERNAME## on ##DATE##.
 */
@Module(
        injects = ##MODULENAME##Activity.class,
        addsTo = JSNowModule.class,
        complete = false
)
public class ##MODULENAME##Module {

    private ##MODULENAME##PresenterOutput mOutput;

    public ##MODULENAME##Module(##MODULENAME##PresenterOutput output) {
        mOutput = output;
    }

    @Provides
    @Singleton
    public ##MODULENAME##InteractorInput provide##MODULENAME##InteractorInput() {
        return new ##MODULENAME##Interactor();
    }

    @Provides @Singleton public ##MODULENAME##PresenterInput provide##MODULENAME##PresenterInput(##MODULENAME##InteractorInput interactor) {
        ##MODULENAME##Presenter presenter = new ##MODULENAME##Presenter(mOutput, interactor);
        interactor.setInteractorOutput(presenter);
        return presenter;
    }
}
