package teladecadastro;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaDeEntrada extends JPanel{
	
	private List<Cadastro> cadastros = new ArrayList<>();
	
	public TelaDeEntrada() {
		
		this.setLayout(new GridLayout(0, 2, 30, 30));
		
		JLabel nome = new JLabel("Nome: ");
		this.add(nome);
		
		JTextField nomeField = new JTextField();
		this.add(nomeField);
		
		JLabel endereco = new JLabel("Endereço: ");
		this.add(endereco);
		
		JTextField enderecoField = new JTextField();
		this.add(enderecoField);
		
		JLabel numero = new JLabel("Numero: ");
		this.add(numero);
		
		JTextField numeroField = new JTextField();
		this.add(numeroField);
		
		JButton btnSalvar = new JButton("Salvar");
		this.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nome = nomeField.getText();
				String endereco = enderecoField.getText();
				int numero = Integer.parseInt(numeroField.getText());
				
				Cadastro cadastro = new Cadastro(nome, endereco, numero);
				
				cadastros.add(cadastro);
				
				System.out.println("Cadastros: "+ cadastros.size());
				
				nomeField.setText("");
				enderecoField.setText("");
				numeroField.setText("");
				
			}
			
		});
		
		JButton btnMostrarTodos = new JButton("Mostrar Todos");
		this.add(btnMostrarTodos);
		btnMostrarTodos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (int i=0; i<cadastros.size(); i++) {
					System.out.println(cadastros.get(i));
				}
				
				Object[] titulos = {"Nome", "Endereço", "Numero"};
				
				Object[][] linhas = new Object[cadastros.size()][2];
				
				for (int i=0; i<cadastros.size(); i++) {
					Object[] linha = new Object[] {cadastros.get(i).getNome(), cadastros.get(i).getEndereco(), cadastros.get(i).getNumero()};
					linhas[i] = linha;
				}
				
				JTable table = new JTable(linhas, titulos);
				
				JOptionPane.showMessageDialog(null, new JScrollPane(table));
			}
			
		});
		
	}
	

}
