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

	String getLocation() throws ITunesException;

}