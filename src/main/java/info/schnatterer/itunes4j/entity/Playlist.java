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
