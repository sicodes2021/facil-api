package br.com.facil.base.combinacoes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import br.com.facil.base.Combinacoes;
import br.com.facil.base.regras.sequencia.RNS0105;
import br.com.facil.base.regras.sequencia.RNS0610;
import br.com.facil.base.regras.sequencia.RNS1115;
import br.com.facil.base.regras.sequencia.RNS1620;
import br.com.facil.base.regras.sequencia.RNS2125;
import br.com.facil.domain.exception.LotoException;

public class Combinacoes2025 {
	
	public static void main(String[] args) throws URISyntaxException, IOException, LotoException {
		Combinacoes2025 combinacoes2025 = new Combinacoes2025();
		//combinacoes2025.gerar2025();
		List<String> lista2025 = combinacoes2025.get2025();
		System.out.println("RNP02: " + lista2025.size());
	}
	
	/**
	 * Metodo responsavel por gerar as combinacoes 2025 = 53130
	 * 
	 * @return List<String>
	 * @throws IOException 
	 */
	public void gerar2025() throws IOException {
		FileWriter arquivo2025 = new FileWriter("C:\\projetos\\18_25\\facil-core\\src\\main\\resources\\combinacoes\\20_25-53130.csv");
		PrintWriter gravarArquivo2025 = new PrintWriter(arquivo2025);
		int cont = 0;
		int[] str = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
		int[] saida;
		Combinacoes comb1 = new Combinacoes(str, 20);
		while (comb1.hasNext()) {
			cont++;
			String lista = null;
			saida = comb1.next();
			lista = saida[0] + "," + saida[1] + "," + saida[2] + "," + saida[3] + "," + saida[4] + "," + 
					saida[5] + "," + saida[6] + "," + saida[7] + "," + saida[8] + "," + saida[9] + "," + 
					saida[10] + "," + saida[11] + "," + saida[12] + "," + saida[13] + "," + saida[14] + "," + 
					saida[15] + "," + saida[16] + "," + saida[17] + "," + saida[18] + "," + saida[19];
			gravarArquivo2025.printf("%s%n", lista);
		}
		arquivo2025.close();
		gravarArquivo2025.close();
		System.out.println("TOTAL DE LINHAS NO ARQUIVO 20_25: " + cont);
	}
	
	/**
	 * Metodo responsavel por gerar a lista de combinacoes 2025 = 53130
	 * 
	 * @return List<String>
	 */
	public List<String> get2025() throws LotoException {
		List<String> lista2025 = new ArrayList<String>();
		RNS0105 rns0105 = new RNS0105();
		RNS0610 rns0610 = new RNS0610();
		RNS1115 rns1115 = new RNS1115();
		RNS1620 rns1620 = new RNS1620();
		RNS2125 rns2125 = new RNS2125();
		int[] str = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
		int[] saida;
		Combinacoes comb1 = new Combinacoes(str, 20);
		while (comb1.hasNext()) {
			String lista = null;
			saida = comb1.next();
			if (rns0105.aplicar(saida) && rns0610.aplicar(saida)
					&& rns1115.aplicar(saida) && rns1620.aplicar(saida)
					&& rns2125.aplicar(saida)) {
				lista = saida[0] + "," + saida[1] + "," + saida[2] + "," + saida[3] + "," + saida[4] + "," + 
						saida[5] + "," + saida[6] + "," + saida[7] + "," + saida[8] + "," + saida[9] + "," + 
						saida[10] + "," + saida[11] + "," + saida[12] + "," + saida[13] + "," + saida[14] + "," + 
						saida[15] + "," + saida[16] + "," + saida[17] + "," + saida[18] + "," + saida[19];
				lista2025.add(lista);
			}
		}
		
		return lista2025;
	}

}
