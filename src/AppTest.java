import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class AppTest {

	@SuppressWarnings("static-access")
	@Test
	void testReadInput1() {
		App c1 = new App();

		File file = new File("..\\data\\input1.txt");
		assertTrue(file.exists());

		c1.readInput("..\\data\\input1.txt");

		assertEquals(App.friends.length, 5);

		assertEquals(App.user.getNumCromos(), App.friends[0].getNumCromos());

		assertEquals(App.user.getNumCromos(), App.friends[1].getNumCromos());

		assertEquals(App.user.getNumCromos(), App.friends[2].getNumCromos());

		assertEquals(App.user.getNumCromos(), App.friends[3].getNumCromos());

		assertEquals(App.user.getNumCromos(), App.friends[4].getNumCromos());

	}

	@SuppressWarnings("static-access")
	@Test
	void testReadInput2() {
		App c1 = new App();

		File file = new File("..\\data\\input2.txt");

		assertTrue(file.exists());
		c1.readInput("..\\data\\input2.txt");

		assertEquals(App.friends.length, 5);

		assertEquals(App.user.getNumCromos(), App.friends[0].getNumCromos());

		assertEquals(App.user.getNumCromos(), App.friends[1].getNumCromos());

		assertEquals(App.user.getNumCromos(), App.friends[2].getNumCromos());

		assertEquals(App.user.getNumCromos(), App.friends[3].getNumCromos());

		assertEquals(App.user.getNumCromos(), App.friends[4].getNumCromos());

	}

	@SuppressWarnings("static-access")
	@Test
	void testReadInput3() {
		App c1 = new App();

		File file = new File("..\\data\\input3.txt");

		assertTrue(file.exists());

		c1.readInput("..\\data\\input3.txt");

		assertEquals(App.friends.length, 5);

		assertEquals(App.user.getNumCromos(), App.friends[0].getNumCromos());

		assertEquals(App.user.getNumCromos(), App.friends[1].getNumCromos());

		assertEquals(App.user.getNumCromos(), App.friends[2].getNumCromos());

		assertEquals(App.user.getNumCromos(), App.friends[3].getNumCromos());

		assertEquals(App.user.getNumCromos(), App.friends[4].getNumCromos());

	}

	@SuppressWarnings("static-access")
	@Test
	void testProcessamento1() {

		App c1 = new App();
		c1.readInput("..\\data\\input1.txt");
		c1.process();

		assertEquals(c1.friends[0].getNumTrocas(), 5);

		assertEquals(c1.friends[1].getNumTrocas(), 1);

		assertEquals(c1.friends[2].getNumTrocas(), 1);

		assertEquals(c1.friends[3].getNumTrocas(), 0);

		assertEquals(c1.friends[4].getNumTrocas(), 0);

	}

	@SuppressWarnings("static-access")
	@Test
	void testProcessamento2() {

		App c1 = new App();
		c1.readInput("..\\data\\input2.txt");
		c1.process();

		assertEquals(c1.friends[0].getNumTrocas(), 44);

		assertEquals(c1.friends[1].getNumTrocas(), 12);

		assertEquals(c1.friends[2].getNumTrocas(), 7);

		assertEquals(c1.friends[3].getNumTrocas(), 3);

		assertEquals(c1.friends[4].getNumTrocas(), 1);

	}

	@SuppressWarnings("static-access")
	@Test
	void testProcessamento3() {

		App c1 = new App();
		c1.readInput("..\\data\\input3.txt");
		c1.process();

		assertEquals(c1.friends[0].getNumTrocas(), 81);

		assertEquals(c1.friends[1].getNumTrocas(), 33);

		assertEquals(c1.friends[2].getNumTrocas(), 18);

		assertEquals(c1.friends[3].getNumTrocas(), 11);

		assertEquals(c1.friends[4].getNumTrocas(), 2);

	}

	@SuppressWarnings({ "static-access" })
	@Test
	void testOutput1() {
		String tempStr = new String();
		App c1 = new App();
		File fileOut = new File("..\\data\\output1.txt");

		assertTrue(fileOut.exists());

		Scanner sc;
		try {
			sc = new Scanner(fileOut);

			while (sc.hasNext()) {
				tempStr += sc.nextLine() + "\n";
			}

			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		c1.readInput("..\\data\\input1.txt");
		c1.process();
		c1.output();

		assertEquals(c1.response, tempStr);

	}

	@SuppressWarnings({ "static-access" })
	@Test
	void testOutput2() {
		String tempStr = new String();
		App c1 = new App();
		File fileOut = new File("..\\data\\output2.txt");

		assertTrue(fileOut.exists());

		Scanner sc;
		try {
			sc = new Scanner(fileOut);

			while (sc.hasNext()) {
				tempStr += sc.nextLine() + "\n";
			}

			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		c1.readInput("..\\data\\input2.txt");
		c1.process();
		c1.output();

		assertEquals(c1.response, tempStr);

	}

	@SuppressWarnings({ "static-access" })
	@Test
	void testOutput3() {
		String tempStr = new String();
		App c1 = new App();
		File fileOut = new File("..\\data\\output3.txt");

		assertTrue(fileOut.exists());

		Scanner sc;
		try {
			sc = new Scanner(fileOut);

			while (sc.hasNext()) {
				tempStr += sc.nextLine() + "\n";
			}

			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		c1.readInput("..\\data\\input3.txt");
		c1.process();
		c1.output();

		assertEquals(c1.response, tempStr);

	}

}
