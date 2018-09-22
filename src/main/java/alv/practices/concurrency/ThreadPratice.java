package alv.practices.concurrency;
/*
 * Created by Alyson Vasconcelos - 20/05/2018
 */

import static alv.practices.concurrency.ThreadColor.ANSI_GREEN;
import static alv.practices.concurrency.ThreadColor.ANSI_PURPLE;

public class ThreadPratice {

    static String MAIN_MESSAGE = "Main Message here";
    static String SECONDARY_MESSAGE = "Secondary Message here";

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Main thread");

        Thread anotherThread = new AnotherThreadPratice();
        anotherThread.start();

        new Thread(() -> System.out.println(ANSI_GREEN + "Hello from the anonymous class thread")).run();

        System.out.println(ANSI_PURPLE + "Hello from main thread");
    }
}
