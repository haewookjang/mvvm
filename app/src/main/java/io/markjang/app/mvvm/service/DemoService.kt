package io.markjang.app.mvvm.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import dagger.hilt.android.AndroidEntryPoint
import io.markjang.app.mvvm.domain.SearchRepositoriesUseCase
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consume
import kotlinx.coroutines.flow.*
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class DemoService : Service(), CoroutineScope {

    val job = Job()
    val channel = BroadcastChannel<String>(Channel.BUFFERED)
    var count = 0

    init {
    }

    @Inject
    lateinit var searchRepositoriesUseCase: SearchRepositoriesUseCase

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        doWork()
        return START_STICKY
    }

    @ExperimentalCoroutinesApi
    private fun doWork() {

        launch {
//            searchRepositoriesUseCase("mvvm")
//                .collect { }
        }
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

}