public class Album {

	private Sticker stickers[]; 
	private int friendId; 
	private int numTrades;

	Album(Sticker stickers[], int friendId, int numTrades) {

		this.friendId = friendId;
		this.stickers = new Sticker[stickers.length];
		this.numTrades = numTrades;
		this.stickers = new Sticker[stickers.length];

		for (int i = 0; i < stickers.length; i++) {

			this.stickers[i] = new Sticker();
			this.stickers[i] = stickers[i];

		}

	}

	public Sticker[] getCromosArray() {
		return this.stickers;
	}

	public Sticker getCromos(int i) {
		return this.stickers[i];
	}

	public void setNumTrocas(int numTrades) {
		this.numTrades = numTrades;
	}

	public int getNumTrocas() {
		return this.numTrades;
	}

	public int getNumCromos() {
		return stickers.length;
	}

	public void setNumAmigo(int friendId) {
		this.friendId = friendId;
	}

	public int getNumAmigo() {
		return this.friendId;
	}

}
