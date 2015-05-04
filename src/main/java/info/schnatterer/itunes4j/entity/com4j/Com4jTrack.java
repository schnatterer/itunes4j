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
package info.schnatterer.itunes4j.entity.com4j;

import info.schnatterer.itunes4j.entity.Rating;
import info.schnatterer.itunes4j.entity.Track;
import info.schnatterer.itunes4j.exception.ITunesException;

import java.util.Date;

import com4j.itunes.IITFileOrCDTrack;

class Com4jTrack implements Track {

	private final IITFileOrCDTrack wrappedTrack;

	protected Com4jTrack(IITFileOrCDTrack wrappedTrack) {
		this.wrappedTrack = wrappedTrack;
	}

	@Override
	public int getPlayedCount() throws ITunesException {
		return wrappedTrack.playedCount();
	}

	@Override
	public void setPlayedCount(int playedCount) throws ITunesException {
		wrappedTrack.playedCount(playedCount);
	}

	@Override
	public Date getPlayedDate() throws ITunesException {
		return wrappedTrack.playedDate();
	}

	@Override
	public void setPlayedDate(Date playedDate) throws ITunesException {
		wrappedTrack.playedDate(playedDate);
	}

	@Override
	public int getSkippedCount() throws ITunesException {
		return wrappedTrack.skippedCount();
	}

	@Override
	public void setSkippedCount(int skippedCount) throws ITunesException {
		wrappedTrack.skippedCount(skippedCount);
	}

	@Override
	public Date getSkippedDate() throws ITunesException {
		return wrappedTrack.skippedDate();
	}

	@Override
	public void setSkippedDate(Date skippedDate) throws ITunesException {
		wrappedTrack.skippedDate(skippedDate);
	}

	@Override
	public Rating getRating() throws ITunesException {
		return Rating.fromInternalInt(wrappedTrack.rating());
	}

	@Override
	public void setRating(Rating rating) throws ITunesException {
		wrappedTrack.rating(rating.toInt());
	}

	@Override
	public Date getDateAdded() throws ITunesException {
		return wrappedTrack.dateAdded();
	}

	@Override
	public Date getDateModified() throws ITunesException {
		return wrappedTrack.modificationDate();
	}

	@Override
	public String getName() throws ITunesException {
		return wrappedTrack.name();
	}

	@Override
	public String getArtist() throws ITunesException {
		return wrappedTrack.artist();
	}

	/**
	 * Releases reference to COM object.
	 * 
	 * @throws Throwable
	 *             the Exception raised by this method
	 */
	@Override
	public void finalize() throws Throwable {
		wrappedTrack.dispose();
		super.finalize();
	}

	protected IITFileOrCDTrack getWrappedTrack() {
		return wrappedTrack;
	}

	@Override
	public String getLocation() throws ITunesException {
		return wrappedTrack.location();
	}
}
