package lesson11;

public class G_ThreadCommunication {

    public static void main(String[] args) {
        DataContainer dataContainer = new DataContainer();

        Thread producerThread = new Thread(new Producer(dataContainer));
        Thread consumerThread = new Thread(new Consumer(dataContainer));

        producerThread.start();
        consumerThread.start();
    }
}

class DataContainer {
    private int data;
    private boolean isDataProduced = false;

    public synchronized void produce(int newData) {
        while (isDataProduced) {
            try {
                wait(); // Wait for the consumer to consume the data
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        data = newData;
        isDataProduced = true;
        System.out.println("Produced: " + data);

        notify(); // Notify the consumer that data is available
    }

    public synchronized int consume() {
        while (!isDataProduced) {
            try {
                wait(); // Wait for the producer to produce data
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        int consumedData = data;
        isDataProduced = false;
        System.out.println("Consumed: " + consumedData);

        notify(); // Notify the producer that data has been consumed
        return consumedData;
    }
}

class Producer implements Runnable {
    private final DataContainer dataContainer;

    public Producer(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            dataContainer.produce(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable {
    private final DataContainer dataContainer;

    public Consumer(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            dataContainer.consume();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
