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

import com4j.itunes.IITOperationStatus;
import com4j.itunes.IITUserPlaylist;

public class Playlist {

	private final IITUserPlaylist wrappedPlaylist;

	public Playlist(IITUserPlaylist wrappedPlaylist) {
		this.wrappedPlaylist = wrappedPlaylist;
	}

	/**
	 * Adds a file to the playlist. If it does not exist in iTunes, it is added
	 * to iTunes first (asynchronously!)
	 * 
	 * @param filePath
	 *            the absolute file path of the track to add
	 * @throws ITunesException
	 *             when iTunes is unable to add the track
	 */
	public void addFile(String filePath) throws ITunesException {
		IITOperationStatus futureFile = wrappedPlaylist.addFile(filePath);
		if (futureFile == null) {
			throw new ITunesException("Unable to add file to iTunes");
		}
	}

	/**
	 * Adds a track object to the playlist.
	 * 
	 * @param track
	 *            the track object to add
	 */
	public void addTrack(Track track) {
		wrappedPlaylist.addTrack(track.getWrappedTrack());
	}

	/**
	 * Releases reference to COM object.
	 */
	public void dispose() {
		wrappedPlaylist.dispose();
	}
}
