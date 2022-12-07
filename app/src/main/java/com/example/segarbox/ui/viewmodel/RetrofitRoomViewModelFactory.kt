package com.example.segarbox.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.data.RoomRepository
import com.example.segarbox.ui.home.MainViewModel
import com.example.segarbox.ui.shipping.ShippingViewModel

class RetrofitRoomViewModelFactory private constructor(
    private val roomRepository: RoomRepository,
    private val retrofitRepository: com.example.core.data.RetrofitRepository,
) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(roomRepository, retrofitRepository) as T
            modelClass.isAssignableFrom(ShippingViewModel::class.java) -> ShippingViewModel(roomRepository, retrofitRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel Class : ${modelClass.name}")
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: RetrofitRoomViewModelFactory? = null

        @JvmStatic
        fun getInstance(roomRepository: RoomRepository, retrofitRepository: com.example.core.data.RetrofitRepository): RetrofitRoomViewModelFactory {
            if (INSTANCE == null) {
                synchronized(RetrofitRoomViewModelFactory::class.java) {
                    INSTANCE = RetrofitRoomViewModelFactory(roomRepository, retrofitRepository)
                }
            }
            return INSTANCE as RetrofitRoomViewModelFactory
        }
    }

}