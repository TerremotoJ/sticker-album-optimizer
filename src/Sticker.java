public class Sticker {

	private int stickerNum;
	private int numDuplicates;
	private String country;
	boolean sendSticker;
	boolean receiveSticker;

	Sticker(String country, int stickerNum, int numDuplicates, boolean sendSticker, boolean receiveSticker) {
		this.stickerNum = stickerNum;
		this.numDuplicates = numDuplicates;
		this.country = country;
		this.sendSticker = sendSticker;
		this.receiveSticker = receiveSticker;
	}

	Sticker() {

	}

	public void setPais(String country) {
		this.country = country;
	}

	public String getPais() {
		return this.country;
	}

	public void setNumCromo(int stickerNum) {
		this.stickerNum = stickerNum;
	}

	public int getNumCromo() {
		return this.stickerNum;
	}

	public void setNumRepetidos(int numDuplicates) {
		this.numDuplicates = numDuplicates;
	}

	public int getNumRepetidos() {
		return this.numDuplicates;
	}

	public boolean getEnviaCromo() {
		return this.sendSticker;
	}

	public void setEnviaCromo(boolean sendSticker) {
		this.sendSticker = sendSticker;

	}

	public boolean getRecebeCromo() {
		return this.receiveSticker;
	}

	public void setRecebeCromo(boolean receiveSticker) {
		this.receiveSticker = receiveSticker;

	}

}
