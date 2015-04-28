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
package info.schnatterer.itunes4j.exception;

import com4j.ComException;

/**
 * Is thrown for example when a track exists and is edited but iTunes for some
 * reasons won't accept editing because the track is still processed right after
 * editing.
 * 
 * Also known as "Unknown error".
 * 
 * @author schnatterer
 *
 */
public class NotModifiableException extends ITunesException {
	private static final long serialVersionUID = 1L;
	public static final int ERROR_CODE = 0xa0040203;

	NotModifiableException(ComException e) {
		super(e);
	}

	@Override
	public Integer getiTunesErrorCode() {
		return ERROR_CODE;
	}
}
