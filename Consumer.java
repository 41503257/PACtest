package com.luoleo.program2;

public class Consumer implements Runnable{
    private Storage storage;
    public Consumer(Storage storage){
        this.storage=storage;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
                this.storage.consumer();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
