package info.schnatterer.itunes4j.entity;

public enum Rating {

	One(20), Two(40), Three(60), Four(80), Five(100);

	private int rating;

	private Rating(int rating) {
		this.rating = rating;
	}

	public static Rating fromInt(int rating) {
		if (rating < 20) {
			return One;
		} else if (rating < 40) {
			return Two;
		} else if (rating < 60) {
			return Three;
		} else if (rating < 80) {
			return Four;
		} else {
			return Five;
		}
	}

	public int toInt() {
		return this.rating;
	}
}
