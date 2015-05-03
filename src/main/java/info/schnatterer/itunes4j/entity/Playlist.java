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

public interface Playlist {

	/**
	 * Adds a file to the playlist. If it does not exist in iTunes, it is added
	 * to iTunes first (asynchronously!)
	 * 
	 * @param filePath
	 *            the absolute file path of the track to add
	 * @throws ITunesException
	 *             when iTunes is unable to add the track
	 */
	public abstract void addFile(String filePath) throws ITunesException;

	/**
	 * Adds a track object to the playlist.
	 * 
	 * @param track
	 *            the track object to add
	 * @throws ITunesException
	 */
	public abstract void addTrack(Track track) throws ITunesException;

}