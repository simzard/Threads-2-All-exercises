package deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * @author Lars Mortensen
 */
class DeadLockDetector implements Runnable {

    ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();
    boolean doRun = true;

    public void stop() {
        this.doRun = false;
    }

    @Override
    public void run() {
        while (doRun) {
            long[] threadIds = tmxb.findDeadlockedThreads();
            //...
            if (threadIds != null) {
                for (int i = 0; i < threadIds.length; ++i) {
                    System.out.println("Deadlocked id: " + threadIds[i]);
                }
                return;
            }
        }
    }
}
