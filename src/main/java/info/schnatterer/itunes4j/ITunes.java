package info.schnatterer.itunes4j;

import info.schnatterer.itunes4j.entity.Playlist;
import info.schnatterer.itunes4j.entity.Track;

import com4j.itunes.ClassFactory;
import com4j.itunes.IITFileOrCDTrack;
import com4j.itunes.IITOperationStatus;
import com4j.itunes.IITPlaylist;
import com4j.itunes.IITTrack;
import com4j.itunes.IITUserPlaylist;
import com4j.itunes.ITPlaylistKind;
import com4j.itunes.ITTrackKind;
import com4j.itunes.IiTunes;

/**
 * Convenience wrapper to iTunes interface.
 * 
 * @author schnatterer
 *
 */
public class ITunes {
	private final IiTunes iTunes;

	public ITunes() {
		iTunes = ClassFactory.createiTunesApp();
	}

	// /**
	// * Returns the track that is currently played in iTues.
	// *
	// * @return a reference to the currently played track if present.
	// */
	// public Optional<IITTrack> getCurrentTrack() {
	// return Optional.ofNullable(iTunes.currentTrack());
	// }

	/**
	 * Synchronously add a single file. Blocking operation! When a file at the
	 * same path is already present, a reference to the existing object is
	 * returned. This will not resul in duplicate tracks.
	 * 
	 * @param filePath
	 * @return waits for file to be added and returns reference to the file
	 * @throws ITunesException
	 *             when iTunes returns an unexpected type of track
	 */
	public Track addFile(String filePath) throws ITunesException {

		IITOperationStatus futureTrack = iTunes.libraryPlaylist().addFile(
				filePath);
		if (futureTrack == null) {
			throw new ITunesException(
					"Error adding file to iTunes. Invalid path? Path="
							+ filePath);
		}

		while (futureTrack.inProgress()) {
			try {
				Thread.sleep(50);
				System.out.println("Slept 50ms");
			} catch (InterruptedException e) {
				throw new RuntimeException(
						"Error waiting for iTunes to finish adding file", e);
			}
		}
		IITTrack track = futureTrack.tracks(1);
		if (ITTrackKind.ITTrackKindFile.equals(track.kind())) {
			// Cast to File Track
			return new Track(track.queryInterface(IITFileOrCDTrack.class));
		} else {
			throw new ITunesException(
					"Created playlist was of unexpected type \"" + track.kind()
							+ "\". Expected \""
							+ ITTrackKind.ITTrackKindFile.name() + "\"");
		}
	}

	/**
	 * Creates a playlist. When a playlist with the same name is already
	 * present, another one with the same name will be created.
	 * 
	 * @param playlistName
	 * @return
	 * @throws ITunesException
	 *             when itunes returns an unexpected type of playlist
	 */
	public Playlist createPlaylist(String playlistName) throws ITunesException {
		IITPlaylist playlist = iTunes.createPlaylist(playlistName);

		if (ITPlaylistKind.ITPlaylistKindUser.equals(playlist.kind())) {
			return new Playlist(playlist.queryInterface(IITUserPlaylist.class));
		} else {
			throw new ITunesException(
					"Created playlist was of unexpected type \""
							+ playlist.kind() + "\". Expected \""
							+ ITPlaylistKind.ITPlaylistKindUser.name() + "\"");
		}
	}
}
