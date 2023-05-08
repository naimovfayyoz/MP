

package com.elbehiry.delish.presentation.vm

import app.delish.base.vm.MviViewModel
import app.delish.domain.usecases.OnBoardingCompletedUseCase
import app.delish.result.data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    private val onBoardingCompletedUseCase: OnBoardingCompletedUseCase
) : MviViewModel<ViewEvent, ViewResult, ViewState, ViewEffect>(ViewState()) {

    init {
        processEvent(ViewEvent.OnBoardingStatus)
    }

    override fun Flow<ViewEvent>.toResults(): Flow<ViewResult> {
        return merge(
            filterIsInstance<ViewEvent.OnBoardingStatus>().onBoardingToMainResult()
        )
    }

    private fun Flow<ViewEvent.OnBoardingStatus>.onBoardingToMainResult(): Flow<ViewResult> {
        return flatMapLatest {
            onBoardingCompletedUseCase(Unit).map { result ->
                delay(1000)
                ViewResult.OnBoardingShown(result.data ?: false)
            }
        }
    }

    override fun ViewResult.reduce(state: ViewState): ViewState {
        return when(this) {
            is ViewResult.OnBoardingShown -> state.copy(
                isOnBoardingShown = isShown
            )
        }
    }
}
