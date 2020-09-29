package main;

import java.util.concurrent.Semaphore;

import Thread.ImpressoraThread;

public class Main {
	
	public static void main(String[] args) {
		
		Semaphore impressora = new Semaphore(1);  // APENAS UMA PESSOA PODE USAR A IMPRESSORA POR VEZ
		
		for (int i = 0; i < 2; i++) {
			Thread impressoraThread = new ImpressoraThread(impressora);
			impressoraThread.start();
		}
		
	}

}
