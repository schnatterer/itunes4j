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
