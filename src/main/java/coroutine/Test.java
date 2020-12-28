package coroutine;

import kotlin.Unit;

public class Test {

    public static void main(String[] args) throws Throwable{
        RunSuspend runSuspend = new RunSuspend();
        ContinuationImpl table = new ContinuationImpl(runSuspend);
        table.resumeWith(Unit.INSTANCE);
        runSuspend.await();
        LogKt.log(5);
    }
}
