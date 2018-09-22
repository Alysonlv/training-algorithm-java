package alv.practices.concurrency;
/*
 * Created by Alyson Vasconcelos - 20/05/2018
 */

import static alv.practices.concurrency.ThreadColor.ANSI_BLUE;

public class AnotherThreadPratice extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE +  ThreadPratice.SECONDARY_MESSAGE);
    }

    public static void main(String[] args) {

    }
}
