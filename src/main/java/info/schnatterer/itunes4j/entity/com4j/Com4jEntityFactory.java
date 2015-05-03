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

import com4j.itunes.IITFileOrCDTrack;
import com4j.itunes.IITUserPlaylist;

public class Com4jEntityFactory {

	/**
	 * Factory method for creating Tracks.
	 * 
	 * @param wrappedTrack
	 *            the COM object wrapped by this {@link Com4jTrack}
	 * 
	 * @return a new instance
	 */
	public static Track createTrack(IITFileOrCDTrack wrappedTrack) {
		return ITunesException.createWrapperProxy(Track.class, new Com4jTrack(
				wrappedTrack));
	}

	/**
	 * Factory method for creating Playlists.
	 * 
	 * @param wrappedPlaylist
	 *            the COM object wrapped by this {@link Com4jPlaylist}
	 * 
	 * @return a new instance
	 */
	public static Playlist createPlaylist(IITUserPlaylist wrappedPlaylist) {
		return ITunesException.createWrapperProxy(Playlist.class,
				new Com4jPlaylist(wrappedPlaylist));
	}
}
