package com.luoleo.program2;
//await和signalAll实现
public class Main {
    public static void main(String[] args) throws Exception{
        Storage storage=new Storage();
        for(int i=0;i<30;i++){
            new Thread(new Producer(storage)).start();
        }
        for(int i=0;i<30;i++){
            new Thread(new Consumer(storage)).start();
        }


    }
}
