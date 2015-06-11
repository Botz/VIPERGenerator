package ##PACKAGENAME##;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.jochen_schweizer.jsnow.application.JSNowModule;
import de.jochen_schweizer.jsnow.module.common.tickets.TicketsPersistence;

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

    public TicketDetailModule(##MODULENAME##PresenterOutput output) {
        mOutput = output;
    }

    @Provides
    @Singleton
    public ##MODULENAME##InteractorInput provide##MODULENAME##InteractorInput(TicketsPersistence ticketsPersistence) {
        return new ##MODULENAME##Interactor(ticketsPersistence);
    }

    @Provides @Singleton public ##MODULENAME##PresenterInput provide##MODULENAME##PresenterInput(##MODULENAME##InteractorInput interactor) {
        ##MODULENAME##Presenter presenter = new TicketDetailPresenter(mOutput, interactor);
        interactor.setInteractorOutput(presenter);
        return presenter;
    }
}
