package Thread;

import java.util.concurrent.Semaphore;

public class ImpressoraThread extends Thread{
	
	private Semaphore impressora;
	
	public ImpressoraThread(Semaphore impressora) {
		this.impressora = impressora;
	}
	
	@Override
	public void run() {
		
		pedirUsarImpressora();
		
		try {
			impressora.acquire();  //ADIQUIRIU A IMPRESSORA 
			System.out.println("Imprimindo...");
			Thread.sleep(3000);    //POR 3 SEGUNDOS
			
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
		System.out.println("A impressora foi usada!");
	}

}
