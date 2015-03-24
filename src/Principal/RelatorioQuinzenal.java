package Principal;

import java.sql.SQLException;
import java.text.ParseException;

import Visao.Tela;
import net.sf.jasperreports.engine.JRException;



public class RelatorioQuinzenal {

	public static void main(String[] args) throws JRException, SQLException, ParseException {
		// TODO Auto-generated method stub
		
		//COmando gerar relatório - coloca ele no local correto depois
		/*GerarRelatorio relatorio = new GerarRelatorio();
		relatorio.gerarRelatorio();
		*/
		//chamar a janela
		Tela tela = new Tela();
		tela.AbrirTela();
			
	}

}
