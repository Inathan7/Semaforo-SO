package Thread;

import java.util.concurrent.Semaphore;

public class ImpressoraThread extends Thread{
	
	private Semaphore impressora;
	private int count;
	
	public ImpressoraThread(Semaphore impressora, int count) {
		this.impressora = impressora;
		this.count = count;
	}
	
	@Override
	public void run() {
		
		pedirUsarImpressora();
		
		try {
			impressora.acquire();  //ADIQUIRIU A IMPRESSORA 
			Thread.sleep(3000);    //POR 3 SEGUNDOS
			System.out.println("Imprimindo...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		impressora.release();  //LIBERA IMPRESSORA
		fimDeUso();
		
		
	}
	
	public void pedirUsarImpressora() {
		System.out.println("Pediu para usar impressora!");
	}
	
	public void fimDeUso() {
		System.out.println("A impressora foi usada pela " + count +"º vez!");
	}

}
