package com.wjx.android.wanandroidmvvm.ui.home.repository

import androidx.lifecycle.MutableLiveData
import com.wjx.android.wanandroidmvvm.ui.common.repository.ArticleRepository
import com.wjx.android.wanandroidmvvm.ui.common.data.Article
import com.wjx.android.wanandroidmvvm.base.observer.BaseObserver
import com.wjx.android.wanandroidmvvm.network.response.BaseResponse
import com.wjx.android.wanandroidmvvm.common.state.State
import com.wjx.android.wanandroidmvvm.ui.home.data.BannerResponse
import com.wjx.android.wanandroidmvvm.ui.home.data.HomeArticleResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created with Android Studio.
 * Description:
 * @author: Wangjianxian
 * @date: 2020/02/26
 * Time: 10:53
 */
class HomeRepository (loadState : MutableLiveData<State>) : ArticleRepository(loadState) {
    fun loadBanner(liveData: MutableLiveData<BaseResponse<List<BannerResponse>>>) {
        apiService.loadBanner()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                BaseObserver(
                    liveData,
                    loadState,
                    this
                )
            )
    }

    suspend fun loadBannerData(liveData: MutableLiveData<BaseResponse<List<BannerResponse>>>) {
            apiService.loadBannerData()
            withContext(Dispatchers.Main) {
                BaseObserver(
                    liveData,
                    loadState,
                    this@HomeRepository
                )
            }
    }

    fun loadHomeArticle(pageNum : Int, liveData: MutableLiveData<BaseResponse<HomeArticleResponse>>) {
        apiService.loadHomeArticle(pageNum)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                BaseObserver(
                    liveData,
                    loadState,
                    this
                )
            )
    }

    fun loadTopArticle(liveData: MutableLiveData<BaseResponse<List<Article>>>) {
        apiService.loadTopArticle()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                BaseObserver(
                    liveData,
                    loadState,
                    this
                )
            )
    }
}