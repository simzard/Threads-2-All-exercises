package deadlock;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Tester {

    public static void main(String[] args) {
        Thread monitor = new Thread(new DeadLockDetector());
        monitor.start();
        try {

            ResourceContainer resources = new ResourceContainer();
            ResourceUser1 t1 = new ResourceUser1(resources);
            ResourceUser2 t2 = new ResourceUser2(resources);
            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("Done");
            System.out.println("Words produced: " + resources.getResourceWords().size());
            System.out.println("Numbers produced: " + resources.getResourceNumbers().size());
            monitor.join(); // an attempt to stop the monitor thread - it is not working however!
        } catch (InterruptedException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
