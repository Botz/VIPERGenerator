package ##PACKAGENAME##;

import de.jochen_schweizer.jsnow.module.common.tickets.TicketsPersistence;

/**
 * Created by ##USERNAME## on ##DATE##.
 */
public class ##MODULENAME##Interactor implements ##MODULENAME##InteractorInput {

    private ##MODULENAME##PresenterOutput mOutput;

    public ##MODULENAME##Interactor(TicketsPersistence ticketsPersistence) {

    }

    @Override
    public void setInteractorOutput(##MODULENAME##PresenterOutput presenter) {
        mOutput = presenter;
    }
}
