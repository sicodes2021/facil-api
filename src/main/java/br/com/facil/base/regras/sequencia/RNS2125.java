package br.com.facil.base.regras.sequencia;

import java.io.IOException;
import java.net.URISyntaxException;

import br.com.facil.base.regras.RegraNegocio;
import br.com.facil.domain.enums.NumeroEnum;
import br.com.facil.domain.exception.LotoException;

/**
 * RN05: Regra Negocial para retirar todas as sequencias de combinacoes entre os
 * numeros de 21 a 25.
 * 
 * @author Santunis.Oliveira
 *
 */
public class RNS2125 implements RegraNegocio<String[], Boolean> {

	boolean retorno = false;
	int[] regraCinco = { 21, 22, 23, 24, 25 };

	public Boolean aplicar(String[] entrada) throws LotoException {

		retorno = false;
		int contRegra = 0;
		int[] linhaEntrada = new int[entrada.length];
		for (int i = 0; i < entrada.length; i++) {
			linhaEntrada[i] = Integer.parseInt(String.valueOf(entrada[i]));
		}

		for (int i = 0; i < regraCinco.length; i++) {
			for (int j = 0; j < linhaEntrada.length; j++) {
				if (regraCinco[i] == linhaEntrada[j]) {
					contRegra++;
				}
			}
		}

		if (contRegra == NumeroEnum.CINCO.getValor()) {
			retorno = true;
		}

		return retorno;
	}

	public Boolean aplicar(int[] entrada) throws LotoException {

		retorno = false;
		int contRegra = 0;
		for (int i = 0; i < regraCinco.length; i++) {
			for (int j = 0; j < entrada.length; j++) {
				if (regraCinco[i] == entrada[j]) {
					contRegra++;
				}
			}
		}

		if (contRegra == NumeroEnum.CINCO.getValor()) {
			retorno = true;
		}

		return retorno;
	}

	public Boolean verificar(String[] entrada) throws LotoException, URISyntaxException, IOException {
		return null;
	}

}
