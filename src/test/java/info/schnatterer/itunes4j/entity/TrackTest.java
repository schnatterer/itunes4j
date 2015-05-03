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

import static org.mockito.Mockito.mock;
import info.schnatterer.itunes4j.exception.ITunesException;

import java.util.Date;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com4j.itunes.IITFileOrCDTrack;

public class TrackTest {
	/** Mocked iTunes COM Track that throws an exception on every method call. */
	@SuppressWarnings("rawtypes")
	private IITFileOrCDTrack iTunesTrackExceptionMock = mock(
			IITFileOrCDTrack.class, new Answer() {
				@Override
				public Object answer(InvocationOnMock invocation) {
					throw new RuntimeException("test exception");
				}
			});

	/**
	 * Asserts that {@link Track#getPlayedCount()} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test(expected = ITunesException.class)
	public void getPlayedCountException() throws ITunesException {
		Track.createTrack(iTunesTrackExceptionMock).getPlayedCount();
	}

	/**
	 * Asserts that {@link Track#setPlayedCount(int)} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test(expected = ITunesException.class)
	public void setPlayedCountException() throws ITunesException {
		Track.createTrack(iTunesTrackExceptionMock).setPlayedCount(1);
	}

	/**
	 * Asserts that {@link Track#getPlayedDate())} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test(expected = ITunesException.class)
	public void getPlayedDateException() throws ITunesException {
		Track.createTrack(iTunesTrackExceptionMock).getPlayedDate();
	}

	/**
	 * Asserts that {@link Track#setPlayedDate(java.util.Date)} properly wraps
	 * exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test(expected = ITunesException.class)
	public void setPlayedDateException() throws ITunesException {
		Track.createTrack(iTunesTrackExceptionMock).setPlayedDate(new Date());
	}

	/**
	 * Asserts that {@link Track#getSkippedCount()} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test(expected = ITunesException.class)
	public void getSkippedCountException() throws ITunesException {
		Track.createTrack(iTunesTrackExceptionMock).getSkippedCount();
	}

	/**
	 * Asserts that {@link Track#setSkippedCount(int)} properly wraps
	 * exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test(expected = ITunesException.class)
	public void setSkippedCountException() throws ITunesException {
		Track.createTrack(iTunesTrackExceptionMock).setSkippedCount(1);
	}

	/**
	 * Asserts that {@link Track#getSkippedDate()} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test(expected = ITunesException.class)
	public void getSkippedDateException() throws ITunesException {
		Track.createTrack(iTunesTrackExceptionMock).getSkippedDate();
	}

	/**
	 * Asserts that {@link Track#setSkippedDate(java.util.Date)} properly wraps
	 * exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test(expected = ITunesException.class)
	public void setSkippedDateException() throws ITunesException {
		Track.createTrack(iTunesTrackExceptionMock).setSkippedDate(new Date());
	}

	/**
	 * Asserts that {@link Track#getRating()} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test(expected = ITunesException.class)
	public void getRatingException() throws ITunesException {
		Track.createTrack(iTunesTrackExceptionMock).getRating();
	}

	/**
	 * Asserts that {@link Track#setRating(Rating)} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test(expected = ITunesException.class)
	public void setRatingException() throws ITunesException {
		Track.createTrack(iTunesTrackExceptionMock).setRating(Rating.One);
	}

	/**
	 * Asserts that {@link Track#getDateAdded()} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test(expected = ITunesException.class)
	public void getDateAddedException() throws ITunesException {
		Track.createTrack(iTunesTrackExceptionMock).getDateAdded();
	}

	/**
	 * Asserts that {@link Track#getDateModified()} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test(expected = ITunesException.class)
	public void getDateModifiedException() throws ITunesException {
		Track.createTrack(iTunesTrackExceptionMock).getDateModified();
	}

	/**
	 * Asserts that {@link Track#getName()} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test(expected = ITunesException.class)
	public void getNameException() throws ITunesException {
		Track.createTrack(iTunesTrackExceptionMock).getName();
	}

	/**
	 * Asserts that {@link Track#getArtist()} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test(expected = ITunesException.class)
	public void getArtistException() throws ITunesException {
		Track.createTrack(iTunesTrackExceptionMock).getArtist();
	}

	/**
	 * Asserts that {@link Track#dispose()} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test(expected = ITunesException.class)
	public void disposeException() throws ITunesException {
		Track.createTrack(iTunesTrackExceptionMock).dispose();
	}
}
