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