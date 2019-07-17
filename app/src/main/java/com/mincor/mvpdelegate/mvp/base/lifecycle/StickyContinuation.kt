package com.mincor.mvpdelegate.mvp.base.lifecycle

import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * This class designed for change configuration handling
 */
class StickyContinuation<ReturnType> constructor(
    private val continuation: Continuation<ReturnType>,
    private val presenter: IBaseLifecyclePresenter<*>
) : Continuation<ReturnType> by continuation {

    private var _resumeValue: ReturnType? = null
    val resumeValue: ReturnType?
        get() = _resumeValue

    private var _resumeException: Throwable? = null
    val resumeException: Throwable?
        get() = _resumeException

    override fun resumeWith(result: Result<ReturnType>) {
        when(true) {
            result.isSuccess -> {
                result.getOrNull()?.let { value ->
                    resume(value)
                }
            }
            result.isFailure -> {
                result.exceptionOrNull()?.let { exception ->
                    resumeWithException(exception)
                }
            }
        }
    }

    private fun resume(value: ReturnType) {
        _resumeValue = value
        presenter.removeStickyContinuation(this)
        continuation.resume(value)
    }

    private fun resumeWithException(exception: Throwable) {
        _resumeException = exception
        presenter.removeStickyContinuation(this)
        continuation.resumeWithException(exception)
    }
}