public class Trade {

	static String resultado;

	public static void sortTradeOrder(Album[] friends) {

		for (int i = 0; i < friends.length; i++) {

			friends[i].setNumAmigo(i); 
		}

		for (int i = 0; i < friends.length; i++) {
			for (int k = i + 1; k < friends.length; k++) {

				if ((friends[k].getNumTrocas() > friends[i].getNumTrocas())) {

					Album Clone = friends[i];
					friends[i] = friends[k];
					friends[k] = Clone;

				}
			}
		}

	}

	public static String executeTrade(Album user, Album friends) {
		int enviadoUtilizador = 0;
		int enviadoAmigo = 0;
		int p = 0;
		int m = 0;

		for (int k = 0; k < friends.getNumCromos(); k++) {
			friends.getCromos(k).setRecebeCromo(false);
			friends.getCromos(k).setEnviaCromo(false);
		}

		Compare.compare(user, friends);

		String obterCromo[] = new String[friends.getNumTrocas()];
		String darCromo[] = new String[friends.getNumTrocas()];

		for (int k = 0; k < user.getCromosArray().length; k++) {

			if ((user.getCromos(k).sendSticker == true) && (friends.getCromos(k).receiveSticker == true)
					&& (enviadoUtilizador < friends.getNumTrocas())) {
				if ((user.getCromos(k).getNumRepetidos() > 1) && (friends.getCromos(k).getNumRepetidos() == 0)) {
					user.getCromos(k).setNumRepetidos(user.getCromos(k).getNumRepetidos() - 1);

					friends.getCromos(k).setNumRepetidos(friends.getCromos(k).getNumRepetidos() + 1);
					enviadoUtilizador++;

					darCromo[p] = user.getCromos(k).getPais() + user.getCromos(k).getNumCromo();
					p++;

				}
			} else if ((user.getCromos(k).receiveSticker == true) && (friends.getCromos(k).sendSticker == true)
					&& (enviadoAmigo < friends.getNumTrocas())) {
				if ((friends.getCromos(k).getNumRepetidos() > 1) && (user.getCromos(k).getNumRepetidos() == 0)) {
					user.getCromos(k).setNumRepetidos(user.getCromos(k).getNumRepetidos() + 1);

					friends.getCromos(k).setNumRepetidos(friends.getCromos(k).getNumRepetidos() - 1);
					enviadoAmigo++;

					obterCromo[m] = friends.getCromos(k).getPais() + friends.getCromos(k).getNumCromo();

					m++;

				}

			}

		}

		resultado = new String();

		if (friends.getNumTrocas() != 0) {
			resultado += "\n" + "amigo " + friends.getNumAmigo();
			resultado += "\nobtive:";
			for (int i = 0; i < friends.getNumTrocas(); i++) {
				resultado += " " + obterCromo[i];
			}
			resultado += "\ndei:";
			for (int i = 0; i < friends.getNumTrocas(); i++) {
				resultado += " " + darCromo[i];
			}

		}

		return resultado;
	}

}
