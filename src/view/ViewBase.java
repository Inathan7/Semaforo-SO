package view;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public abstract class ViewBase extends JFrame{

    public ViewBase(){
    	templateMethod();
//    	setExtendedState(JFrame.MAXIMIZED_BOTH);
    	repaint();
    }
    public void templateMethod(){
    	setTitle("Impressora");
//    	setIconImage(new ImageIcon(getClass().getResource("/icons8-hotel-de-3-estrelas-80.png")).getImage());
    	setLayout(null);
    	setSize(700,700);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setResizable(false);
     	setLocationRelativeTo(null);
     	
     	try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			    if ("Nimbus".equals(info.getName())) {
			        UIManager.setLookAndFeel(info.getClassName());
			        break;
			    }
			}
			} catch (Exception e) {
			}
     	
     	adicionarBotoes();
     	adicionarJLabel();
     	adicionarTextField();
     	adicionarTabela();
     	adicionarMenu();
     	adicionarRadioButton();
     	adicionarJComboBox();
     	setVisible(true);
    }
    public abstract void adicionarBotoes();
    
    public void adicionarTextField(){
    	
    }
    public abstract void adicionarJLabel();
    
    public void adicionarLabel(String usuario){
    	
    }
    public void adicionarMenu(){
    	
    }
    public void adicionarTabela(){
    	
    }
    public void adicionarRadioButton(){
    	
    }
    public void adicionarJComboBox(){
    	
    }
}
