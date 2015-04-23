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
	 * @throws ITunesException
	 */
	public void addFile(String filePath) throws ITunesException {
		IITOperationStatus futureFile = wrappedPlaylist.addFile(filePath);
		if (futureFile == null) {
			throw new ITunesException("Unable to add file to iTunes");
		}
	}

	/**
	 * Releases reference to COM object.
	 */
	public void dispose() {
		wrappedPlaylist.dispose();
	}
}
