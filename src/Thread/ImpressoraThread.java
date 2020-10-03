package Thread;

import java.util.concurrent.Semaphore;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ImpressoraThread extends Thread{
	
	private Semaphore impressora;
	private JTextArea area;
	private int ordem;
	public ImpressoraThread(Semaphore impressora,JTextArea area,int ordem) {
		this.impressora = impressora;
		this.area = area;
		this.ordem = ordem;
	}
	@Override
	public void run() {
		try {
			impressora.acquire();
			area.setText(area.getText()+"Imprimindo...\n");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		fimDeUso();
		impressora.release();
	}
	
	public void fimDeUso() {
		area.setText(area.getText()+"IMPRESSÃO "+ordem+": impresso com sucesso!\n");
	}

}
