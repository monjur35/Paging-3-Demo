package com.example.paging3.paging

import android.net.Uri
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging3.network.ApiService
import com.example.paging3.response.ResultDAta
import java.lang.Exception

class RickMortyDataSource(val apiService: ApiService) : PagingSource<Int,ResultDAta>() {
    override fun getRefreshKey(state: PagingState<Int, ResultDAta>): Int? {
       return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultDAta> {

        return try {
            val nextPage=params.key?: FIRST_PAGE_INDEX
            val response=apiService.callApi(nextPage)
            Log.d("TAG", "load: "+response.resultsss.toString())
            var nextPageNumber:Int?= null

            if (response != null){
                val uri=Uri.parse(response?.info?.next!!)
                nextPageNumber=uri.getQueryParameter("page")?.toInt()
                Log.d("TAG", "load: "+nextPageNumber.toString())
            }
            LoadResult.Page(data = response.resultsss,
            prevKey = null,
            nextKey = nextPageNumber)
        }
        catch (e:Exception){
            LoadResult.Error(e)
        }
    }

    companion object{
        private const val FIRST_PAGE_INDEX=1
    }
}