package com.ozancanguz.stock_market.data

import com.ozancanguz.stock_market.data.remotedatasource.RemoteDataSource
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
@ViewModelScoped
class Repository@Inject constructor(remoteDataSource: RemoteDataSource) {


    val remote=remoteDataSource
}