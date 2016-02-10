package ##PACKAGENAME##.##MODULENAME##;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.jochen_schweizer.jsnow.common.baseui.BaseDaggerActivity;

/**
 * Created by ##USERNAME## on ##DATE##.
 */
public class ##MODULENAME##Activity extends BaseDaggerActivity implements ##MODULENAME##PresenterOutput {
    @Inject ##MODULENAME##PresenterInput presenter;

    @Override
    protected void onInjected(Bundle savedInstanceState) {
        presenter.setPresenterOutput(this);
        ButterKnife.inject(this);
    }

    @Override
    protected List<Object> getActivityModules() {
        return Arrays.<Object>asList(new ##MODULENAME##Module(this));
    }

    @Override
    protected void onDestroyDaggerInjector() {
        super.onDestroyDaggerInjector();
        presenter.onDestroy();
    }

    @Override
    protected void customizeActionBar(ActionBar actionBar) {
        super.customizeActionBar(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


    @Override
    protected void customizeToolbar(Toolbar toolbar) {
        super.customizeToolbar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ico_navi_back);
        toolbar.setTitle(R.string.activity_checkout_title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
