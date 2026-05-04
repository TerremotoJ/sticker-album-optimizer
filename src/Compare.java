public class Compare {

	public static int compare(Album A, Album B) {
		int numCromosAReceber = 0;
		int numCromosAEnviar = 0;

		for (int i = 0; i < A.getCromosArray().length; i++) {

			if ((A.getCromos(i).getNumRepetidos() == 0) && (B.getCromos(i).getNumRepetidos() > 1)) {
				numCromosAReceber++;
				A.getCromos(i).setRecebeCromo(true);
				B.getCromos(i).setEnviaCromo(true);
			}

		}

		for (int i = 0; i < A.getCromosArray().length; i++) {

			if ((B.getCromos(i).getNumRepetidos() == 0) && (A.getCromos(i).getNumRepetidos() > 1)) {
				numCromosAEnviar++;
				B.getCromos(i).setRecebeCromo(true);
				A.getCromos(i).setEnviaCromo(true);
			}
		}

		if (numCromosAEnviar <= numCromosAReceber) {
			B.setNumTrocas(numCromosAEnviar);
			return numCromosAEnviar;
		} else {
			B.setNumTrocas(numCromosAReceber);
			return numCromosAReceber;
		}

	}

	public static String checkMissingStickers(Album A) {

		String temporaria = new String();

		temporaria += "\ncartas em falta: ";
		for (int i = 0; i < A.getCromosArray().length; i++) {

			if ((A.getCromos(i).getNumRepetidos()) < 1) {

				temporaria += A.getCromos(i).getPais() + A.getCromos(i).getNumCromo() + " ";
			}

		}

		return temporaria;

	}

}
