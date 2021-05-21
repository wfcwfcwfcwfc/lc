package io.fengchao.multithreading;

/**
 * L15
 */
public class NonAtomicOperation {
    public static void main(String[] args) throws InterruptedException{
        InventoryFactory inventoryFactory = new InventoryFactory();
        IncrementThread incrementThread = new IncrementThread(inventoryFactory);
        DecrementThread decrementThread = new DecrementThread(inventoryFactory);
        incrementThread.start();

        decrementThread.start();
        incrementThread.join();
        incrementThread.join();
        System.out.print("The count is: " + inventoryFactory.getCounter());

    }

    public static class IncrementThread extends Thread {
        private InventoryFactory inventoryFactory;

        public IncrementThread(InventoryFactory inventoryFactory) {
            this.inventoryFactory = inventoryFactory;
        }

        @Override
        public void run() {
            for(int i = 0; i < 10000; i++) {
                inventoryFactory.increment();
            }
        }
    }

    public static class DecrementThread extends Thread {
        private InventoryFactory inventoryFactory;

        public DecrementThread(InventoryFactory inventoryFactory) {
            this.inventoryFactory = inventoryFactory;
        }

        @Override
        public void run() {
            for(int i = 0; i < 10000; i++) {
                inventoryFactory.decrement();
            }
        }
    }


    private static class InventoryFactory {
        int counter = 0;
        private void increment() {
            synchronized (this) {
                counter++;
            }

        }
        private synchronized void increment2() {
            counter++;
        }
        private  void decrement() {
            synchronized (this) {
                counter--;
            }
        }
        private synchronized void decrement2() {
            counter--;
        }
        public int getCounter() {
            return this.counter;
        }
    }

}
