import java.io.File;

import java.util.Scanner;

public class App {

	static Album user;
	static Album friends[];
	static String response = new String();
	static String inputName;

	public static void main(String[] args) {

		inputName = "..\\data\\input1.txt";

		readInput(inputName);

		process();

		output();

	}

	public static void readInput(String inputName) {

		try {

			Scanner sc = new Scanner(new File(inputName));

			int NumCromos = sc.nextInt();
			Sticker auxStickers[] = new Sticker[NumCromos];
			for (int i = 0; i < NumCromos; i++) {

				String tempStr = sc.next();
				int tempInt = sc.nextInt();

				auxStickers[i] = new Sticker(tempStr.substring(0, 3), Integer.parseInt(tempStr.substring(3)),
						tempInt, false, false);

			}

			user = new Album(auxStickers, 0, 0);

			int a = sc.nextInt();
			friends = new Album[a];
			for (int i = 0; i < a; i++) {
				NumCromos = sc.nextInt();
				for (int k = 0; k < NumCromos; k++) {

					String tempStr = sc.next();
					int tempInt = sc.nextInt();

					auxStickers[k] = new Sticker(tempStr.substring(0, 3), Integer.parseInt(tempStr.substring(3)),
							tempInt, false, false);
				}
				friends[i] = new Album(auxStickers, 1, 0);

			}
			sc.close();

		} catch (Exception e) {
			System.out.println("There was an error loading the file");
			System.exit(1);
		}

	}

	public static void process() {

		response = new String();
		try {

			for (int i = 0; i < friends.length; i++) {

				friends[i].setNumTrocas(Compare.compare(user, friends[i]));

			}

			Trade.sortTradeOrder(friends);

			for (int i = 0; i < friends.length; i++) {

				response += Trade.executeTrade(user, friends[i]);

			}
		} catch (Exception e) {
			System.out.println("Houve um erro no process");
			System.exit(1);
		}
	}

	public static void output() {
		try {
			response += Compare.checkMissingStickers(user) + "\n";
			System.out.print(response);
		} catch (Exception e) {
			System.out.println("Houve um erro a imprimir a response");
		}

	}

}
