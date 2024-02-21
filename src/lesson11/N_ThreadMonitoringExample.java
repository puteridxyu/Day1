package lesson11;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class N_ThreadMonitoringExample {

    public static void main(String[] args) {
        // Get the ThreadMXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        // Print thread states
        printThreadStates(threadMXBean);

        // Simulate some work in multiple threads
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // Print thread states after starting new threads
        printThreadStates(threadMXBean);
    }

    private static void printThreadStates(ThreadMXBean threadMXBean) {
        long[] threadIds = threadMXBean.getAllThreadIds();
        ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadIds);

        System.out.println("Thread States:");
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadName() + ": " + threadInfo.getThreadState());
        }
        System.out.println("--------------");
    }
}
