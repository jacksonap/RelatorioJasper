package Visao;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JButton;

import net.sf.jasperreports.engine.JRException;
import Controle.FixedLengthDocument;
import Controle.GerarRelatorio;
import Model.Relatorio;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Toolkit;

public class Tela {

	public JFrame frame;
	private JTextField textDisciplina;
	private JTextField textSemana;
	private JTextField textTurma;
	private JTextField textProfessor;
	GerarRelatorio gerar = new GerarRelatorio();
	int control = 0;


	/**
	 * Launch the application.
	 */
	public void AbrirTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela window = new Tela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ParseException 
	 */
	public Tela() throws ParseException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		frame = new JFrame();
		frame.setTitle("Colégio Módulo - Relatório");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Tela.class.getResource("/Images/icon.jpg")));
		frame.setBounds(100, 100, 731, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);


		//Acão fechar para ao acessar Arquivo > Sair
		JMenuItem mntmFechar = new JMenuItem("Sair");
		mntmFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnArquivo.add(mntmFechar);
		frame.getContentPane().setLayout(null);

		JLabel lblRelatrioQuinzenal = new JLabel("Relat\u00F3rio Quinzenal");
		lblRelatrioQuinzenal.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblRelatrioQuinzenal.setBounds(225, 11, 278, 36);
		frame.getContentPane().add(lblRelatrioQuinzenal);

		final JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setBounds(41, 92, 61, 14);
		frame.getContentPane().add(lblDisciplina);

		// Campo Data da "Segunda Tela"

		final JLabel lblAula = new JLabel("1\u00BA Aula");
		lblAula.setBounds(339, 75, 46, 14);
		frame.getContentPane().add(lblAula);
		lblAula.setVisible(false);

		final JLabel lblData = new JLabel("Data");
		lblData.setBounds(41, 121, 46, 14);
		frame.getContentPane().add(lblData);
		lblData.setVisible(false);



		final JLabel lblConteudo = new JLabel("Conte\u00FAdo");
		lblConteudo.setBounds(41, 173, 61, 14);
		frame.getContentPane().add(lblConteudo);
		lblConteudo.setVisible(false);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(112, 173, 564, 196);
		frame.getContentPane().add(scrollPane);
		scrollPane.setVisible(false);

		final JTextArea textConteudo = new JTextArea();
		textConteudo.setLineWrap(true);
		textConteudo.setWrapStyleWord(true);
		scrollPane.setViewportView(textConteudo);
		textConteudo.setVisible(false);


		MaskFormatter mascraFormat = new MaskFormatter("##/##");

		final JFormattedTextField formattedTextField = new JFormattedTextField(mascraFormat);
		formattedTextField.setText("00000000");
		formattedTextField.setBounds(110, 118, 72, 20);
		frame.getContentPane().add(formattedTextField);
		formattedTextField.setVisible(false);


		textDisciplina = new JTextField();
		textDisciplina.setBounds(110, 89, 566, 20);
		frame.getContentPane().add(textDisciplina);
		textDisciplina.setColumns(10);

		final JLabel lblSemana = new JLabel("Semana");
		lblSemana.setBounds(41, 152, 61, 14);
		frame.getContentPane().add(lblSemana);

		textSemana = new JTextField();
		textSemana.setBounds(110, 149, 566, 20);
		frame.getContentPane().add(textSemana);
		textSemana.setColumns(10);

		final JLabel lblTurma = new JLabel("Turma");
		lblTurma.setBounds(41, 212, 61, 14);
		frame.getContentPane().add(lblTurma);

		textTurma = new JTextField();
		textTurma.setBounds(110, 209, 566, 20);
		frame.getContentPane().add(textTurma);
		textTurma.setColumns(10);

		final JLabel lblProfessor = new JLabel("Professor");
		lblProfessor.setBounds(41, 271, 61, 14);
		frame.getContentPane().add(lblProfessor);

		textProfessor = new JTextField();
		textProfessor.setBounds(110, 268, 566, 20);
		frame.getContentPane().add(textProfessor);
		textProfessor.setColumns(10);

		//Botão Voltar
		final JButton btnVoltar = new JButton("Anterior");
		btnVoltar.setEnabled(false);

		//Botão Gerar Relatório
		final JButton btnGerarRelatrio = new JButton("Gerar Relatório");


		// Ação do botão Proximo
		final JButton btnProximo = new JButton("Próximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(control == 0){	
					gerar.pegaDados(textDisciplina.getText(), textSemana.getText(), textTurma.getText(), textProfessor.getText());

					//trocando os labels e textareas
					textDisciplina.setVisible(false);
					lblDisciplina.setVisible(false);
					textSemana.setVisible(false);
					lblSemana.setVisible(false);
					textTurma.setVisible(false);
					lblTurma.setVisible(false);
					textProfessor.setVisible(false);
					lblProfessor.setVisible(false);
					btnGerarRelatrio.setVisible(false);


					lblAula.setVisible(true);
					lblData.setVisible(true);
					formattedTextField.setVisible(true);
					lblConteudo.setVisible(true);
					scrollPane.setVisible(true);
					textConteudo.setVisible(true);
					formattedTextField.selectAll();
					btnVoltar.setEnabled(true);

					control++;


					/*
					try {
						gerar.gerarRelatorio();
					} catch (JRException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/

				}else if(control == 1){

					gerar.pegarDados2(control, formattedTextField.getText(), textConteudo.getText());

					if(gerar.Data2() == null|| gerar.Conteudo2() == null ){
						formattedTextField.setText("0000");
						textConteudo.setText("");
					}else{
						formattedTextField.setText(gerar.Data2());
						textConteudo.setText(gerar.Conteudo2());
					}
					lblAula.setText("2º Aula");
					control++;	
				}else if(control == 2){

					gerar.pegarDados2(control, formattedTextField.getText(), textConteudo.getText());

					if(gerar.Data3() == null|| gerar.Conteudo3() == null ){
						formattedTextField.setText("0000");
						textConteudo.setText("");
					}else{
						formattedTextField.setText(gerar.Data3());
						textConteudo.setText(gerar.Conteudo3());
					}
					lblAula.setText("3º Aula");
					control++;	
				}else if(control == 3){

					gerar.pegarDados2(control, formattedTextField.getText(), textConteudo.getText());

					if(gerar.Data4() == null|| gerar.Conteudo4() == null ){
						formattedTextField.setText("0000");
						textConteudo.setText("");
					}else{
						formattedTextField.setText(gerar.Data4());
						textConteudo.setText(gerar.Conteudo4());
					}
					lblAula.setText("4º Aula");
					control++;	
				}else if(control == 4){

					gerar.pegarDados2(control, formattedTextField.getText(), textConteudo.getText());

					if(gerar.Data5() == null|| gerar.Conteudo5() == null ){
						formattedTextField.setText("0000");
						textConteudo.setText("");
					}else{
						formattedTextField.setText(gerar.Data5());
						textConteudo.setText(gerar.Conteudo5());
					}
					lblAula.setText("5º Aula");
					control++;	


				}else if(control == 5){

					gerar.pegarDados2(control, formattedTextField.getText(), textConteudo.getText());
					
					if(gerar.Data2() == null|| gerar.Conteudo6() == null ){
						formattedTextField.setText("0000");
						textConteudo.setText("");
					}else{
						formattedTextField.setText(gerar.Data6());
						textConteudo.setText(gerar.Conteudo6());
					}
					lblAula.setText("6º Aula");
					btnProximo.setVisible(false);
					btnGerarRelatrio.setVisible(true);
					control++;
				}
			}
		});

		btnProximo.setBounds(434, 380, 89, 23);
		frame.getContentPane().add(btnProximo);


		btnGerarRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGerarRelatrio.setEnabled(false);
				gerar.pegarDados2(control, formattedTextField.getText(), textConteudo.getText());


				try {
					gerar.gerarRelatorio();
					
					
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnGerarRelatrio.setEnabled(true);
			}
		});
		btnGerarRelatrio.setBounds(414, 380, 120, 23);
		frame.getContentPane().add(btnGerarRelatrio);

		// Botão voltar
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(control == 6){
					gerar.pegarDados2(control, formattedTextField.getText(), textConteudo.getText());
					lblAula.setText("5º Aula");
					formattedTextField.setText("0000");

					btnProximo.setVisible(true);
					btnGerarRelatrio.setVisible(false);

					control--;

					formattedTextField.setText(gerar.Data5());
					textConteudo.setText(gerar.Conteudo5());

				}else if(control == 5){
					gerar.pegarDados2(control, formattedTextField.getText(), textConteudo.getText());
					lblAula.setText("4º Aula");
					formattedTextField.setText("0000");

					control--;

					formattedTextField.setText(gerar.Data4());
					textConteudo.setText(gerar.Conteudo4());
				}else if(control == 4){
					gerar.pegarDados2(control, formattedTextField.getText(), textConteudo.getText());
					lblAula.setText("3º Aula");
					formattedTextField.setText("0000");

					control--;

					formattedTextField.setText(gerar.Data3());
					textConteudo.setText(gerar.Conteudo3());
				}else if(control == 3){
					gerar.pegarDados2(control, formattedTextField.getText(), textConteudo.getText());
					lblAula.setText("2º Aula");
					formattedTextField.setText("0000");

					control--;

					formattedTextField.setText(gerar.Data2());
					textConteudo.setText(gerar.Conteudo2());
				}else if(control == 2){
					gerar.pegarDados2(control, formattedTextField.getText(), textConteudo.getText());
					lblAula.setText("1º Aula");
					formattedTextField.setText("0000");

					control--;

					formattedTextField.setText(gerar.Data1());
					textConteudo.setText(gerar.Conteudo1());

				}else if(control == 1){
					gerar.pegarDados2(control, formattedTextField.getText(), textConteudo.getText());
					System.out.println("Primeira aula");
					
					textDisciplina.setVisible(true);
					lblDisciplina.setVisible(true);
					textSemana.setVisible(true);
					lblSemana.setVisible(true);
					textTurma.setVisible(true);
					lblTurma.setVisible(true);
					textProfessor.setVisible(true);
					lblProfessor.setVisible(true);
					btnGerarRelatrio.setVisible(true);


					btnProximo.setVisible(true);
					btnGerarRelatrio.setVisible(false);
					
					lblAula.setVisible(false);
					lblData.setVisible(false);
					formattedTextField.setVisible(false);
					lblConteudo.setVisible(false);
					scrollPane.setVisible(false);
					textConteudo.setVisible(false);
					btnVoltar.setEnabled(false);

					control--;
				}

			}
		});
		btnVoltar.setBounds(271, 380, 89, 23);
		frame.getContentPane().add(btnVoltar);
		btnGerarRelatrio.setVisible(false);

	}
}
