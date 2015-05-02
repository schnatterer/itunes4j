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

import com4j.itunes.IITFileOrCDTrack;

public class Track {
	private final IITFileOrCDTrack wrappedTrack;

	public Track(IITFileOrCDTrack wrappedTrack) {
		this.wrappedTrack = wrappedTrack;
	}

	public int getPlayedCount() throws ITunesException {
		return ITunesException.wrap(() -> wrappedTrack.playedCount());
	}

	public void setPlayedCount(int playedCount) throws ITunesException {
		ITunesException.wrap(() -> wrappedTrack.playedCount(playedCount));
	}

	public Date getPlayedDate() throws ITunesException {
		return ITunesException.wrap(() -> wrappedTrack.playedDate());
	}

	public void setPlayedDate(Date playedDate) throws ITunesException {
		ITunesException.wrap(() -> wrappedTrack.playedDate(playedDate));
	}

	public int getSkippedCount() throws ITunesException {
		return ITunesException.wrap(() -> wrappedTrack.skippedCount());
	}

	public void setSkippedCount(int skippedCount) throws ITunesException {
		ITunesException.wrap(() -> wrappedTrack.skippedCount(skippedCount));
	}

	public Date getSkippedDate() throws ITunesException {
		return ITunesException.wrap(() -> wrappedTrack.skippedDate());
	}

	public void setSkippedDate(Date skippedDate) throws ITunesException {
		ITunesException.wrap(() -> wrappedTrack.skippedDate(skippedDate));
	}

	public Rating getRating() throws ITunesException {
		return ITunesException.wrap(() -> Rating.fromInternalInt(wrappedTrack
				.rating()));
	}

	public void setRating(Rating rating) throws ITunesException {
		ITunesException.wrap(() -> wrappedTrack.rating(rating.toInt()));
	}

	public Date getDateAdded() throws ITunesException {
		return ITunesException.wrap(() -> wrappedTrack.dateAdded());
	}

	public Date getDateModified() throws ITunesException {
		return ITunesException.wrap(() -> wrappedTrack.modificationDate());
	}

	public String getName() throws ITunesException {
		return ITunesException.wrap(() -> wrappedTrack.name());
	}

	public String getArtist() throws ITunesException {
		return ITunesException.wrap(() -> wrappedTrack.artist());
	}

	/**
	 * Releases reference to COM object.
	 * 
	 * @throws ITunesException
	 */
	public void dispose() throws ITunesException {
		ITunesException.wrap(() -> wrappedTrack.dispose());
	}

	protected IITFileOrCDTrack getWrappedTrack() {
		return wrappedTrack;
	}
}
