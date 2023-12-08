package br.com.facil.base.regras.pares;

import java.io.IOException;
import java.net.URISyntaxException;

import br.com.facil.base.regras.RegraNegocio;
import br.com.facil.domain.enums.NumeroEnum;
import br.com.facil.domain.exception.LotoException;

public class RNP04 implements RegraNegocio<int[], Boolean> {

	public Boolean aplicar(int[] entrada) throws LotoException {

		boolean retorno = false;
		int contLinha = 0;

		for (int i = 0; i < entrada.length; i++) {
			if (entrada[i] % NumeroEnum.DOIS.getValor() == NumeroEnum.ZERO.getValor()) {
				contLinha++;
			}
		}

		if (contLinha == NumeroEnum.QUATRO.getValor()) {
			retorno = true;
		}

		return retorno;

	}

	public Boolean verificar(int[] entrada) throws LotoException, URISyntaxException, IOException {
		return null;
	}

}
