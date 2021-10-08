package com.luoleo.program2;

public class Producer implements Runnable{
    private Storage storage;
    public Producer(Storage storage){
        this.storage=storage;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
                this.storage.produce();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
