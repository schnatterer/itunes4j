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
import info.schnatterer.itunes4j.exception.ITunesException;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com4j.itunes.IITUserPlaylist;

public class Com4jPlaylistTest {
	/**
	 * Mocked iTunes COM Playlist that throws an exception on every method call.
	 */
	@SuppressWarnings("rawtypes")
	private IITUserPlaylist iTunesPlaylistExceptionMock = mock(
			IITUserPlaylist.class, new Answer() {
				@Override
				public Object answer(InvocationOnMock invocation) {
					throw new RuntimeException("test exception");
				}
			});

	/**
	 * Asserts that
	 * {@link Com4jPlaylist#addTrack(info.schnatterer.itunes4j.entity.Track)}
	 * properly wraps exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test(expected = ITunesException.class)
	public void addTrackException() throws ITunesException {
		Com4jEntityFactory.createPlaylist(iTunesPlaylistExceptionMock)
				.addTrack(null);
	}

	/**
	 * Asserts that {@link Com4jPlaylist#addFile(String)} properly wraps
	 * exceptions.
	 * 
	 * @throws ITunesException
	 *             the expected exception
	 */
	@Test(expected = ITunesException.class)
	public void addFileException() throws ITunesException {
		Com4jEntityFactory.createPlaylist(iTunesPlaylistExceptionMock).addFile(
				"");
	}

	// TODO finalize()
}
