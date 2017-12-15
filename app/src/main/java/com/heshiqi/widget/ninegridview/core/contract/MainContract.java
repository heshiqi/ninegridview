package com.heshiqi.widget.ninegridview.core.contract;

import com.heshiqi.widget.ninegridview.core.presenter.IBasePresenter;
import com.heshiqi.widget.ninegridview.entity.MainEntity;

import java.util.List;

/**
 * Created by heshiqi on 17/12/13.
 */

public interface MainContract {

    interface View extends IBaseView {

        void onResultData(List<MainEntity> datas, boolean isSuccess, boolean isLoadMore);


    }

    interface Presenter extends IBasePresenter {

        /**
         * 加载数据
         *
         * @param isLoadMore 是否加载更多
         */
        void loadDatas(boolean isLoadMore);


        /**
         * 获取列表项数据
         *
         * @param position
         * @return
         */
        MainEntity getItem(int position);

        /**
         * 获取列表数据
         *
         * @return
         */
        List<MainEntity> getDatas();
    }
}
