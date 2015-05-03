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

import info.schnatterer.itunes4j.exception.ITunesException;

import java.util.Date;
import java.util.Optional;

import com4j.itunes.IITFileOrCDTrack;

public class Track {

	private final IITFileOrCDTrack wrappedTrack;

	protected Track(IITFileOrCDTrack wrappedTrack) {
		this.wrappedTrack = wrappedTrack;
	}

	/**
	 * Factory method for creating Tracks.
	 * 
	 * @param wrappedTrack
	 *            the COM object wrapped by this {@link Track}
	 * 
	 * @return a new instance
	 */
	public static Track createTrack(IITFileOrCDTrack wrappedTrack) {
		return ITunesException.createWrapperProxy(Track.class,
				Optional.of(new Class<?>[] { IITFileOrCDTrack.class }),
				Optional.of(new Object[] { wrappedTrack }));
	}

	public int getPlayedCount() throws ITunesException {
		return wrappedTrack.playedCount();
	}

	public void setPlayedCount(int playedCount) throws ITunesException {
		wrappedTrack.playedCount(playedCount);
	}

	public Date getPlayedDate() throws ITunesException {
		return wrappedTrack.playedDate();
	}

	public void setPlayedDate(Date playedDate) throws ITunesException {
		wrappedTrack.playedDate(playedDate);
	}

	public int getSkippedCount() throws ITunesException {
		return wrappedTrack.skippedCount();
	}

	public void setSkippedCount(int skippedCount) throws ITunesException {
		wrappedTrack.skippedCount(skippedCount);
	}

	public Date getSkippedDate() throws ITunesException {
		return wrappedTrack.skippedDate();
	}

	public void setSkippedDate(Date skippedDate) throws ITunesException {
		wrappedTrack.skippedDate(skippedDate);
	}

	public Rating getRating() throws ITunesException {
		return Rating.fromInternalInt(wrappedTrack.rating());
	}

	public void setRating(Rating rating) throws ITunesException {
		wrappedTrack.rating(rating.toInt());
	}

	public Date getDateAdded() throws ITunesException {
		return wrappedTrack.dateAdded();
	}

	public Date getDateModified() throws ITunesException {
		return wrappedTrack.modificationDate();
	}

	public String getName() throws ITunesException {
		return wrappedTrack.name();
	}

	public String getArtist() throws ITunesException {
		return wrappedTrack.artist();
	}

	/**
	 * Releases reference to COM object.
	 */
	public void dispose() throws ITunesException {
		wrappedTrack.dispose();
	}

	protected IITFileOrCDTrack getWrappedTrack() {
		return wrappedTrack;
	}
}
