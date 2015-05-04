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

import static org.mockito.Mockito.mock;
import info.schnatterer.itunes4j.entity.Rating;
import info.schnatterer.itunes4j.exception.ITunesException;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com4j.itunes.IITFileOrCDTrack;

public class Com4jTrackTest {
	private static final String TEST_EXCEPTION_MSG = Com4jTrackTest.class
			.getSimpleName() + "test exception";

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	/** Mocked iTunes COM Track that throws an exception on every method call. */
	@SuppressWarnings("rawtypes")
	private IITFileOrCDTrack iTunesTrackExceptionMock = mock(
			IITFileOrCDTrack.class, new Answer() {
				@Override
				public Object answer(InvocationOnMock invocation) {
					throw new RuntimeException(TEST_EXCEPTION_MSG);
				}
			});

	/**
	 * Asserts that {@link Com4jTrack#getPlayedCount()} properly wraps
	 * exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test
	public void getPlayedCountException() throws ITunesException {
		expectedEx.expect(ITunesException.class);
		expectedEx.expectMessage(TEST_EXCEPTION_MSG);

		Com4jEntityFactory.createTrack(iTunesTrackExceptionMock)
				.getPlayedCount();
	}

	/**
	 * Asserts that {@link Com4jTrack#setPlayedCount(int)} properly wraps
	 * exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test
	public void setPlayedCountException() throws ITunesException {
		expectedEx.expect(ITunesException.class);
		expectedEx.expectMessage(TEST_EXCEPTION_MSG);

		Com4jEntityFactory.createTrack(iTunesTrackExceptionMock)
				.setPlayedCount(1);
	}

	/**
	 * Asserts that {@link Track#getPlayedDate())} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test
	public void getPlayedDateException() throws ITunesException {
		expectedEx.expect(ITunesException.class);
		expectedEx.expectMessage(TEST_EXCEPTION_MSG);

		Com4jEntityFactory.createTrack(iTunesTrackExceptionMock)
				.getPlayedDate();
	}

	/**
	 * Asserts that {@link Com4jTrack#setPlayedDate(java.util.Date)} properly
	 * wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test
	public void setPlayedDateException() throws ITunesException {
		expectedEx.expect(ITunesException.class);
		expectedEx.expectMessage(TEST_EXCEPTION_MSG);

		Com4jEntityFactory.createTrack(iTunesTrackExceptionMock).setPlayedDate(
				new Date());
	}

	/**
	 * Asserts that {@link Com4jTrack#getSkippedCount()} properly wraps
	 * exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test
	public void getSkippedCountException() throws ITunesException {
		expectedEx.expect(ITunesException.class);
		expectedEx.expectMessage(TEST_EXCEPTION_MSG);

		Com4jEntityFactory.createTrack(iTunesTrackExceptionMock)
				.getSkippedCount();
	}

	/**
	 * Asserts that {@link Com4jTrack#setSkippedCount(int)} properly wraps
	 * exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test
	public void setSkippedCountException() throws ITunesException {
		expectedEx.expect(ITunesException.class);
		expectedEx.expectMessage(TEST_EXCEPTION_MSG);

		Com4jEntityFactory.createTrack(iTunesTrackExceptionMock)
				.setSkippedCount(1);
	}

	/**
	 * Asserts that {@link Com4jTrack#getSkippedDate()} properly wraps
	 * exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test
	public void getSkippedDateException() throws ITunesException {
		expectedEx.expect(ITunesException.class);
		expectedEx.expectMessage(TEST_EXCEPTION_MSG);

		Com4jEntityFactory.createTrack(iTunesTrackExceptionMock)
				.getSkippedDate();
	}

	/**
	 * Asserts that {@link Com4jTrack#setSkippedDate(java.util.Date)} properly
	 * wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test
	public void setSkippedDateException() throws ITunesException {
		expectedEx.expect(ITunesException.class);
		expectedEx.expectMessage(TEST_EXCEPTION_MSG);

		Com4jEntityFactory.createTrack(iTunesTrackExceptionMock)
				.setSkippedDate(new Date());
	}

	/**
	 * Asserts that {@link Com4jTrack#getRating()} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test
	public void getRatingException() throws ITunesException {
		expectedEx.expect(ITunesException.class);
		expectedEx.expectMessage(TEST_EXCEPTION_MSG);

		Com4jEntityFactory.createTrack(iTunesTrackExceptionMock).getRating();
	}

	/**
	 * Asserts that {@link Com4jTrack#setRating(Rating)} properly wraps
	 * exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test
	public void setRatingException() throws ITunesException {
		expectedEx.expect(ITunesException.class);
		expectedEx.expectMessage(TEST_EXCEPTION_MSG);

		Com4jEntityFactory.createTrack(iTunesTrackExceptionMock).setRating(
				Rating.One);
	}

	/**
	 * Asserts that {@link Com4jTrack#getDateAdded()} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test
	public void getDateAddedException() throws ITunesException {
		expectedEx.expect(ITunesException.class);
		expectedEx.expectMessage(TEST_EXCEPTION_MSG);

		Com4jEntityFactory.createTrack(iTunesTrackExceptionMock).getDateAdded();
	}

	/**
	 * Asserts that {@link Com4jTrack#getDateModified()} properly wraps
	 * exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test
	public void getDateModifiedException() throws ITunesException {
		expectedEx.expect(ITunesException.class);
		expectedEx.expectMessage(TEST_EXCEPTION_MSG);

		Com4jEntityFactory.createTrack(iTunesTrackExceptionMock)
				.getDateModified();
	}

	/**
	 * Asserts that {@link Com4jTrack#getName()} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test
	public void getNameException() throws ITunesException {
		expectedEx.expect(ITunesException.class);
		expectedEx.expectMessage(TEST_EXCEPTION_MSG);

		Com4jEntityFactory.createTrack(iTunesTrackExceptionMock).getName();
	}

	/**
	 * Asserts that {@link Com4jTrack#getArtist()} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test
	public void getArtistException() throws ITunesException {
		expectedEx.expect(ITunesException.class);
		expectedEx.expectMessage(TEST_EXCEPTION_MSG);

		Com4jEntityFactory.createTrack(iTunesTrackExceptionMock).getArtist();
	}

	/**
	 * Asserts that {@link Com4jTrack#getLocation()} properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test
	public void getLocationException() throws ITunesException {
		expectedEx.expect(ITunesException.class);
		expectedEx.expectMessage(TEST_EXCEPTION_MSG);

		Com4jEntityFactory.createTrack(iTunesTrackExceptionMock).getLocation();
	}
	// TODO finalize()
}
