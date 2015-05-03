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

import info.schnatterer.itunes4j.entity.Playlist;
import info.schnatterer.itunes4j.entity.Track;
import info.schnatterer.itunes4j.exception.ITunesException;

import com4j.itunes.IITOperationStatus;
import com4j.itunes.IITUserPlaylist;

class Com4jPlaylist implements Playlist {

	private final IITUserPlaylist wrappedPlaylist;

	protected Com4jPlaylist(IITUserPlaylist wrappedPlaylist) {
		this.wrappedPlaylist = wrappedPlaylist;
	}

	@Override
	public void addFile(String filePath) throws ITunesException {
		IITOperationStatus futureFile = wrappedPlaylist.addFile(filePath);
		if (futureFile == null) {
			throw new ITunesException("Unable to add file to iTunes");
		}
	}

	@Override
	public void addTrack(Track track) throws ITunesException {
		if (track instanceof Com4jTrack) {
			wrappedPlaylist.addTrack(((Com4jTrack) track).getWrappedTrack());
		} else {
			// This must be some kind of programming error
			throw new IllegalArgumentException("Incopatible implemenations "
					+ Com4jPlaylist.class.getName() + " and "
					+ track.getClass().getName() + ". Can't add to playlist");
		}
	}

	/**
	 * Releases reference to COM object.
	 * 
	 * @throws Throwable
	 *             the Exception raised by this method
	 */
	@Override
	public void finalize() throws Throwable {
		wrappedPlaylist.dispose();
		super.finalize();
	}
}
