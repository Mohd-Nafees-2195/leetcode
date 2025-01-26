class FooBar {
    private int n;
    private CountDownLatch fooLatch;
    private CountDownLatch barLatch;

    public FooBar(int n) {
        this.n = n;
        fooLatch = new CountDownLatch(0);
        barLatch = new CountDownLatch(1); 
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            fooLatch.await();  // Wait until foo is allowed
            printFoo.run();
            barLatch.countDown();  // Allow bar to proceed
            fooLatch = new CountDownLatch(1);  //Reset foo to wait again
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            barLatch.await();  // Wait until bar is allowed
            printBar.run();
            fooLatch.countDown();  // Allow foo to proceed
            barLatch = new CountDownLatch(1);  // Reset bar to wait again
        }
    }
}