package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewImpressora extends ViewBase{

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
		JTextArea area = new JTextArea();
		area.setBounds(10,190,180,400);
		area.setEditable(false);
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		add(area);
		
		JTextArea areaDeImpressao = new JTextArea();
		areaDeImpressao.setBounds(270,430,260,100);
		areaDeImpressao.setEditable(false);
		areaDeImpressao.setLineWrap(true);
		areaDeImpressao.setWrapStyleWord(true);
		add(areaDeImpressao);
		
		JTextField campo = new JTextField();
		campo.setBounds(290, 100, 250, 30);
		campo.setEditable(false);
		add(campo);
	}
	
	public class OuvinteCriar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}

}
