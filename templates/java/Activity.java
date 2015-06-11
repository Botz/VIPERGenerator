package ##PACKAGENAME##;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import de.jochen_schweizer.jsnow.common.baseui.BaseDaggerActivity;

/**
 * Created by ##USERNAME## on ##DATE##.
 */
public class ##MODULENAME##Activity extends BaseDaggerActivity implements##MODULENAME##PresenterOutput {
    @Inject ##MODULENAME##PresenterInput mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected List<Object> getActivityModules() {
        return Arrays.<Object>asList(new ##MODULENAME##Module(this));
    }
}
