package coroutine

import kotlin.concurrent.thread
import kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED
import kotlin.coroutines.intrinsics.suspendCoroutineUninterceptedOrReturn
import kotlin.coroutines.resume

suspend fun returnSuspended() = suspendCoroutineUninterceptedOrReturn<String>{
    continuation ->
    thread {
        Thread.sleep(1000)
        continuation.resume("Return suspended.")
    }
    COROUTINE_SUSPENDED
}

suspend fun returnImmediately() = suspendCoroutineUninterceptedOrReturn<String>{
    log(1)
    "Return immediately."
}