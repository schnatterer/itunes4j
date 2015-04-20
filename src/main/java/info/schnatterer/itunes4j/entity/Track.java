package info.schnatterer.itunes4j.entity;

import java.util.Date;

import com4j.itunes.IITFileOrCDTrack;

public class Track {

	private final IITFileOrCDTrack wrappedTrack;

	public Track(IITFileOrCDTrack wrappedTrack) {
		this.wrappedTrack = wrappedTrack;
	}

	public int getPlayedCount() {
		return wrappedTrack.playedCount();
	}

	public void setPlayedCount(int playedCount) {
		wrappedTrack.playedCount(playedCount);
	}

	public Date getPlayedDate() {
		return wrappedTrack.playedDate();
	}

	public void setPlayedDate(Date playedDate) {
		wrappedTrack.playedDate(playedDate);
	}

	public int getSkippedCount() {
		return wrappedTrack.skippedCount();
	}

	public void setSkippedCount(int skippedCount) {
		wrappedTrack.skippedCount(skippedCount);
	}

	public Date getSkippedDate() {
		return wrappedTrack.skippedDate();
	}

	public void setSkippedDate(Date skippedDate) {
		wrappedTrack.skippedDate(skippedDate);
	}

	public Rating getRating() {
		return Rating.fromInternalInt(wrappedTrack.rating());
	}

	public void setRating(Rating rating) {
		wrappedTrack.rating(rating.toInt());
	}

	public Date getDateAdded() {
		return wrappedTrack.dateAdded();
	}

	public Date getDateModified() {
		return wrappedTrack.modificationDate();
	}

	public String getName() {
		return wrappedTrack.name();
	}

	public String getArtist() {
		return wrappedTrack.artist();
	}
}
