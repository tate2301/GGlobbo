package io.globbo.home;

import java.util.List;

import io.globbo.abs.BasePresenter;
import io.globbo.abs.BaseView;
import io.globbo.home.models.AppInfo;

/**
 * @author Lody
 * @version 1.0
 */
/*package*/ class ListAppContract {
    interface ListAppView extends BaseView<ListAppPresenter> {

        void startLoading();

        void loadFinish(List<AppInfo> infoList);
    }

    interface ListAppPresenter extends BasePresenter {

    }
}
