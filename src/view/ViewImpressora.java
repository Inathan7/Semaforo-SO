package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Thread.ImpressoraThread;

public class ViewImpressora extends ViewBase{
	private JTextArea area;
	private JTextArea areaDeImpressao;
	private JTextField campo;
	private int ordem = 0;
	private static ArrayList<String> lista = new ArrayList<>();
	private Semaphore impressora = new Semaphore(1);
	/**
	 * O semaphore foi salvo para que acionar o botão ele nunca crie um semaphore novo
	 * porque se não cada Thread vai ficar em semaphore diferentes
	 * por isso impressora é um atributo, para que só exista uma.
	 */
	public void adicionarBotoes() {
		OuvinteCriar ouvinteCriar = new OuvinteCriar();
		JButton  criarImpressora = new JButton("Criar");
		criarImpressora.setBounds(600, 250, 80, 30);
		criarImpressora.addActionListener(ouvinteCriar);
		add(criarImpressora);
	}

	public void adicionarJLabel() {
		JLabel Fila = new JLabel("Fila");
		Fila.setBounds(85, 150, 50, 30);
		Fila.setFont(new Font("Arial",Font.BOLD,22));
		
		JLabel imprimindo = new JLabel("Imprimindo");
		imprimindo.setBounds(360, 60, 120, 30);
		imprimindo.setFont(new Font("Arial",Font.BOLD,22));
		add(imprimindo);
		
		JLabel imagem = new JLabel(new ImageIcon(getClass().getResource("/pngwing.com.png")));
		imagem.setBounds(250, 150, 260, 260);
		add(imagem);
		add(Fila);
	}
	@Override
	public void adicionarTextField() {
		area = new JTextArea();
		area.setBounds(10,190,180,400);
		area.setEditable(false);
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		add(area);
		
		areaDeImpressao = new JTextArea();
		areaDeImpressao.setBounds(270,430,260,280);
		areaDeImpressao.setEditable(false);
		areaDeImpressao.setLineWrap(true);
		areaDeImpressao.setWrapStyleWord(true);
		add(areaDeImpressao);
		
		campo = new JTextField();
		campo.setBounds(290, 100, 250, 30);
		campo.setEditable(false);
		add(campo);
		
	}
	
	public class OuvinteCriar implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			ordem+=1;
			lista.add("Impressão "+ordem);
			//campo.setText(Arrays.toString(lista.toArray()));
			//Formata a lista para que seja exibita em sequencia
			area.setText(ordenarString(ViewImpressora.GetLista()));
			Thread impressoraThread = new ImpressoraThread(impressora,areaDeImpressao,campo,ordem);
			impressoraThread.start();
		}
		
	}
	
	public static ArrayList<String> GetLista() {
		
		return lista;
	}
	
	public String ordenarString(ArrayList<String> frase) {
		String  n ="";
		for(int i =0 ; i < frase.size();i++) {
			n = n + frase.get(i) + "\n";
		}
		return n;
	}

}
