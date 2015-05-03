package info.schnatterer.itunes4j.entity;

import info.schnatterer.itunes4j.exception.ITunesException;

import java.util.Date;

public interface Track {

	int getPlayedCount() throws ITunesException;

	void setPlayedCount(int playedCount) throws ITunesException;

	Date getPlayedDate() throws ITunesException;

	void setPlayedDate(Date playedDate) throws ITunesException;

	int getSkippedCount() throws ITunesException;

	void setSkippedCount(int skippedCount) throws ITunesException;

	Date getSkippedDate() throws ITunesException;

	void setSkippedDate(Date skippedDate) throws ITunesException;

	Rating getRating() throws ITunesException;

	void setRating(Rating rating) throws ITunesException;

	Date getDateAdded() throws ITunesException;

	Date getDateModified() throws ITunesException;

	String getName() throws ITunesException;

	String getArtist() throws ITunesException;

}