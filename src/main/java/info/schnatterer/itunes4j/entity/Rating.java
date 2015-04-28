/**
 * Copyright (C) 2015 Johannes Schnatterer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package info.schnatterer.itunes4j.entity;

public enum Rating {

	Zero(0), One(20), Two(40), Three(60), Four(80), Five(100);

	private int internalInt;

	private Rating(int rating) {
		this.internalInt = rating;
	}

	/**
	 * Return rating object for a 0-5 "stars" rating (as displayed in the iTunes
	 * Application).
	 * 
	 * @param stars
	 *            the number of "stars"
	 * @return the rating object belonging to the number of "stars"
	 */
	public static Rating fromStars(int stars) {
		if (stars <= 0) {
			return Zero;
		}
		switch (stars) {
		case 1:
			return One;
		case 2:
			return Two;
		case 3:
			return Three;
		case 4:
			return Four;
		default:
			return Five;
		}
	}

	/**
	 * Return rating object for an integer value stored in itunes (0..100).
	 * 
	 * @param internalRating
	 *            a integer extracted from internal storage in iTunes.
	 * @return the rating object belonging to the integer
	 */
	public static Rating fromInternalInt(int internalRating) {
		if (internalRating <= 0) {
			return Zero;
		} else if (internalRating < 20) {
			return One;
		} else if (internalRating < 40) {
			return Two;
		} else if (internalRating < 60) {
			return Three;
		} else if (internalRating < 80) {
			return Four;
		} else {
			return Five;
		}
	}

	/**
	 * Returns the internal rating integer belonging to a rating instance.
	 * 
	 * @return value for internal storing of a rating
	 * @see #fromInternalInt(int)
	 */
	public int toInt() {
		return this.internalInt;
	}
}
