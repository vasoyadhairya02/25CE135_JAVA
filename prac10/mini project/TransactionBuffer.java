package Practical_10.Practical_10B;

public class TransactionBuffer {

    private Transaction[] buffer;
    private int count = 0;

    public TransactionBuffer(int size) {

        buffer = new Transaction[size];
    }

    public synchronized void add(Transaction transaction)
            throws InterruptedException {

        while (count == buffer.length) {

            wait();
        }

        buffer[count] = transaction;

        count++;

        System.out.println(
                "Produced transaction: "
                + transaction.getType());

        notify();
    }

    public synchronized Transaction remove()
            throws InterruptedException {

        while (count == 0) {

            wait();
        }

        Transaction transaction =
                buffer[0];

        for (int i = 1; i < count; i++) {

            buffer[i - 1] = buffer[i];
        }

        count--;

        notify();

        return transaction;
    }
}