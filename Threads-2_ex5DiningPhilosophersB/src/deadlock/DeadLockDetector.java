/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 *
 * @author simon
 */
public class DeadLockDetector implements Runnable {
    
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
                System.out.println("Deadlocked threads! Aborting...");
                System.exit(1);
            }
            
        }
    }
}

