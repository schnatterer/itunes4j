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
