package Controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Model.Relatorio;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class GerarRelatorio {

	Relatorio relatorio = new Relatorio();

	public void gerarRelatorio() throws JRException, SQLException{

		System.out.println("Gerando Relatório...");

		List lista = new ArrayList<>();

		/*		 relatorio.setDisciplina("Matematica");
		relatorio.setSemana("1");
		relatorio.setTurma("4º série A");
		relatorio.setProfessor("João");
		relatorio.setData1("11/11/1900");
		relatorio.setData2("11/11/1900");
		relatorio.setData3("11/11/1900");
		relatorio.setData4("11/11/1900");
		relatorio.setData5("11/11/1900");
		relatorio.setData6("11/11/1900");
		relatorio.setConteudo1("teset Tela te ste te ste ts tets et st ets te t ets te ");
		relatorio.setConteudo2("te et ete t et et et et et te te t ete t et et etet te et te");
		relatorio.setConteudo3("te t et et te te t et et et et tete te te te t ete t et et et et et");
		relatorio.setConteudo4("tete t et ete t st et ts te t st et ste te ts te t st et st t et st t ");
		relatorio.setConteudo5("te ste ts et st et stg ets t et st te ts te ts te t st et st te t t");
		relatorio.setConteudo6("test  t ets te t st et st et ts te ts t t tetste t st et ts te te");
		 */
		lista.add(relatorio);


		//Compilando o jrmlx

		JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("relatorioQuinzenal.jrxml"));
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));


		JFileChooser chooserArquivo = new JFileChooser();
		int escolha = chooserArquivo.showOpenDialog(chooserArquivo.getParent());
		String arquivo = chooserArquivo.getSelectedFile().getAbsolutePath();



		System.out.println(arquivo);

		JasperExportManager.exportReportToPdfFile(print,arquivo+".pdf");


		JOptionPane.showMessageDialog(null, "Relatório Gerado!!");

	}

	//Método para pegar dados da tela
	public void pegaDados(String disciplina, String semana, String turma, String professor){


		relatorio.setDisciplina(disciplina);
		relatorio.setSemana(semana);
		relatorio.setTurma(turma);
		relatorio.setProfessor(professor);


	}

	public void pegarDados2(int controle, String data, String conteudo){
		if(controle == 1){
			relatorio.setData1(data);
			relatorio.setConteudo1(conteudo);
		}else if(controle == 2){
			relatorio.setData2(data);
			relatorio.setConteudo2(conteudo);

		}else if(controle == 3){
			relatorio.setData3(data);
			relatorio.setConteudo3(conteudo);

		}else if(controle == 4){
			relatorio.setData4(data);
			relatorio.setConteudo4(conteudo);

		}else if(controle == 5){
			relatorio.setData5(data);
			relatorio.setConteudo5(conteudo);

		}else if(controle == 6){
			relatorio.setData6(data);
			relatorio.setConteudo6(conteudo);

		}
	}

	//Métodos para retornar dados para o botão voltar

	public String Data6(){

		return relatorio.getData6();

	}

	public String Conteudo6(){

		return relatorio.getConteudo6();
	}

	public String Data5(){

		return relatorio.getData5();

	}

	public String Conteudo5(){

		return relatorio.getConteudo5();
	}

	public String Data4(){

		return relatorio.getData4();

	}

	public String Conteudo4(){

		return relatorio.getConteudo4();
	}

	public String Data3(){

		return relatorio.getData3();

	}

	public String Conteudo3(){

		return relatorio.getConteudo3();
	}

	public String Data2(){

		return relatorio.getData2();

	}

	public String Conteudo2(){

		return relatorio.getConteudo2();
	}

	public String Data1(){

		return relatorio.getData1();

	}

	public String Conteudo1(){

		return relatorio.getConteudo1();
	}
}

