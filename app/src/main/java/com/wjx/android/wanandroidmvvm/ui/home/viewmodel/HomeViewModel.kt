package com.wjx.android.wanandroidmvvm.ui.home.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.wjx.android.wanandroidmvvm.base.BaseArticle.viewmodel.BaseArticleViewModel
import com.wjx.android.wanandroidmvvm.base.https.BaseResponse
import com.wjx.android.wanandroidmvvm.ui.home.data.bean.BannerResponse
import com.wjx.android.wanandroidmvvm.ui.home.data.bean.HomeArticleResponse
import com.wjx.android.wanandroidmvvm.ui.home.data.repository.HomeRepository

/**
 * Created with Android Studio.
 * Description:
 * @author: Wangjianxian
 * @date: 2020/02/26
 * Time: 10:49
 */
class HomeViewModel(application: Application) :
    BaseArticleViewModel<HomeRepository>(application) {
    val mBannerData : MutableLiveData<BaseResponse<List<BannerResponse>>> = MutableLiveData()
    val mHomeArticleData : MutableLiveData<BaseResponse<HomeArticleResponse>> = MutableLiveData()

    fun loadBanner() {
        mRepository.loadBanner(mBannerData)
    }

    fun loadHomeArticleData(pageNum : Int) {
        mRepository.loadHomeArticle(pageNum, mHomeArticleData)
    }
}