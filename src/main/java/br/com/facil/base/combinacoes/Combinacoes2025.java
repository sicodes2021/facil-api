package br.com.facil.base.combinacoes;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.opencsv.CSVReader;

import br.com.facil.base.Combinacoes;
import br.com.facil.base.regras.sequencia.RNS0105;
import br.com.facil.base.regras.sequencia.RNS0610;
import br.com.facil.base.regras.sequencia.RNS1115;
import br.com.facil.base.regras.sequencia.RNS1620;
import br.com.facil.base.regras.sequencia.RNS2125;
import br.com.facil.domain.enums.NumeroEnum;
import br.com.facil.domain.exception.LotoException;

public class Combinacoes2025 {
	
	public static void main(String[] args) throws URISyntaxException, IOException, LotoException {
		FileWriter arquivo2025 = new FileWriter("C:\\sicodes\\3125.csv");
		PrintWriter gravarArquivo2025 = new PrintWriter(arquivo2025);
		Combinacoes2025 combinacoes2025 = new Combinacoes2025();
		//combinacoes2025.gerar2025();
		List<String> lista2025 = combinacoes2025.get2025();
		//for (String linha : lista2025) {
			combinacoes2025.maisSaiu15(lista2025, gravarArquivo2025);
			//gravarArquivo2025.printf("%s%n", linha);
		//}
		System.out.println("RNP02: " + lista2025.size());
		arquivo2025.close();
		gravarArquivo2025.close();
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
			if (!rns0105.aplicar(saida) && !rns0610.aplicar(saida)
					&& !rns1115.aplicar(saida) && !rns1620.aplicar(saida)
					&& !rns2125.aplicar(saida)) {
				lista = saida[0] + "," + saida[1] + "," + saida[2] + "," + saida[3] + "," + saida[4] + "," + 
						saida[5] + "," + saida[6] + "," + saida[7] + "," + saida[8] + "," + saida[9] + "," + 
						saida[10] + "," + saida[11] + "," + saida[12] + "," + saida[13] + "," + saida[14] + "," + 
						saida[15] + "," + saida[16] + "," + saida[17] + "," + saida[18] + "," + saida[19];
				lista2025.add(lista);
			}
		}
		
		return lista2025;
	}
	
	public void maisSaiu15(List<String> lista, PrintWriter gravarArqSaiu) throws URISyntaxException, IOException, LotoException {
		int contLista = 0;
		int quinze = 0;
		for (String lista20 : lista) {
			String[] linha20 = lista20.split(",");
			contLista++;
			quinze = 0;
			int[] linha2025 = new int[linha20.length];
			for (int i = 0; i < linha20.length; i++) {
				linha2025[i] = Integer.parseInt(String.valueOf(linha20[i]));
			}
			
			compararResultado(gravarArqSaiu, linha2025, quinze);
		}
	}
	
	@SuppressWarnings({ "deprecation" })
	public static void compararResultado(PrintWriter gravarArqSaiu, int[] linha2025, int quinze) throws URISyntaxException, NumberFormatException, IOException {
		
		int contador = 0;
		URL resultado = Combinacoes2025.class.getClassLoader().getResource("resultado.csv");
		if (Objects.nonNull(resultado)) {
			
			Path caminho = Paths.get(resultado.toURI());
			CSVReader csvReader = new CSVReader(new FileReader(caminho.toFile()), ',');
			String[] linhaResultado;
			String lista = null;
			while (Objects.nonNull((linhaResultado = csvReader.readNext()))) {

				contador = 0;
				int[] resultado1525 = new int[linhaResultado.length];
				for (int i = 0; i < linhaResultado.length; i++) {
					resultado1525[i] = Integer.parseInt(String.valueOf(linhaResultado[i]));
				}

				for (int i = 0; i < resultado1525.length; i++) {
					for (int j = 0; j < linha2025.length; j++) {
						if (resultado1525[i] == linha2025[j]) {
							contador++;
						}
					}
				}
				
				if (contador == NumeroEnum.QUINZE.getValor()) {
					quinze++;
				}
			}
			lista = linha2025[0]+","+linha2025[1]+","+linha2025[2]+","+linha2025[3]+","+linha2025[4]+","+
					linha2025[5]+","+linha2025[6]+","+linha2025[7]+","+linha2025[8]+","+linha2025[9]+","+
					linha2025[10]+","+linha2025[11]+","+linha2025[12]+","+linha2025[13]+","+linha2025[14]+","+
					linha2025[15]+","+linha2025[16]+","+linha2025[17]+","+linha2025[18]+","+linha2025[19]+","+quinze;
			gravarArqSaiu.printf("%s%n", lista);
		} else {
			System.out.println("### Arquivo [resultado.csv] nao encontrado... ###");
		}
	}

}
