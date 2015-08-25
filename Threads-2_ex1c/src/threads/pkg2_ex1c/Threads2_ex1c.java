/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.pkg2_ex1c;

/**
 *
 * @author simon
 */
public class Threads2_ex1c {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());

        ImageLoader img1 = new ImageLoader(
                "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");
        ImageLoader img2 = new ImageLoader(
                "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png");
        ImageLoader img3 = new ImageLoader(
                "https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png");

        Thread t1 = new Thread(img1);
        Thread t2 = new Thread(img2);
        Thread t3 = new Thread(img3);

        long start = System.nanoTime();
        t1.run();
        t2.run();
        t3.run();
        int totalSum = img1.getByteSum() + img2.getByteSum() + img3.getByteSum();
        System.out.println("Sum is " + totalSum);
        long end = System.nanoTime();
        System.out.println("Time Sequential: " + (end - start));

        start = System.nanoTime();        
        t1.start();
        t2.start();
        t3.start();
        while (t1.isAlive() || t2.isAlive() || t3.isAlive())
            ;
        totalSum = img1.getByteSum() + img2.getByteSum() + img3.getByteSum();
        System.out.println("Sum is " + totalSum);
        end = System.nanoTime();
        System.out.println("Time Parallel:  " + (end - start));
    }

}
