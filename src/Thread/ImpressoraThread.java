package Thread;

import java.util.concurrent.Semaphore;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import view.ViewImpressora;

public class ImpressoraThread extends Thread{
	
	private Semaphore impressora;
	private JTextArea area;
	private JTextField campo;
	private int ordem;
	public ImpressoraThread(Semaphore impressora, JTextArea area, JTextField campo,int ordem) {
		this.impressora = impressora;
		this.area = area;
		this.ordem = ordem;
		this.campo = campo;
	}
	@Override
	public void run() {
		try {
			impressora.acquire();
			campo.setText("Impressão " + ordem);
			area.setText(area.getText()+"Impresão " + ordem +" Imprimindo...\n");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		fimDeUso();
		impressora.release();
	}
	
	public void fimDeUso() {
		area.setText(area.getText()+"IMPRESSÃO "+ordem+": impresso com sucesso!\n");
		ViewImpressora.GetLista().remove(0);
		campo.setText(campo.getText());
		campo.repaint();
		
	}

}
