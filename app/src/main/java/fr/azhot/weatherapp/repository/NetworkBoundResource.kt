package fr.azhot.weatherapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import fr.azhot.weatherapp.network.util.ApiEmptyResponse
import fr.azhot.weatherapp.network.util.ApiErrorResponse
import fr.azhot.weatherapp.network.util.ApiResponse
import fr.azhot.weatherapp.network.util.ApiSuccessResponse
import fr.azhot.weatherapp.util.DataState
import kotlinx.coroutines.*

abstract class NetworkBoundResource<ResponseObject, ViewStateType> {

    protected val result = MediatorLiveData<DataState<ViewStateType>>()

    init {
        result.value = DataState.loading(true)
        GlobalScope.launch(Dispatchers.IO) {

            // todo : fake delay -> to be eventually deleted
            delay(1000L)

            withContext(Dispatchers.Main) {
                val apiResponse = createCall()
                result.addSource(apiResponse) { response ->
                    result.removeSource(apiResponse)
                    handleNetworkCall(response)
                }
            }
        }
    }

    abstract fun createCall(): LiveData<ApiResponse<ResponseObject>>
    abstract fun handleApiSuccessResponse(response: ApiSuccessResponse<ResponseObject>)

    private fun handleNetworkCall(response: ApiResponse<ResponseObject>) {
        when (response) {
            is ApiSuccessResponse -> {
                handleApiSuccessResponse(response)
            }
            is ApiErrorResponse -> {
                onReturnedError(response.errorMessage)
            }
            is ApiEmptyResponse -> {
                onReturnedError("HTTP 204. Returned NOTHING!")
            }
        }
    }

    private fun onReturnedError(message: String) {
        result.value = DataState.error(message)
    }

    fun asLiveData() = result as LiveData<DataState<ViewStateType>>
}