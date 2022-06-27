package com.example.paging3.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paging3.network.ApiService
import com.example.paging3.network.RetrofitService
import com.example.paging3.paging.RickMortyDataSource
import com.example.paging3.response.ResultDAta
import com.example.paging3.response.newResponse.Result
import kotlinx.coroutines.flow.Flow


class PagingViewModel : ViewModel() {
    var apiService: ApiService
    init {
         apiService = RetrofitService.retrofitInstance().create(ApiService::class.java)
    }


    fun getList(): Flow<PagingData<Result>> {
        return Pager(config = PagingConfig(pageSize = 42, maxSize = 200 ),
            pagingSourceFactory = {RickMortyDataSource(apiService)}).flow.cachedIn(viewModelScope)

    }

}