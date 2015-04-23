package info.schnatterer.itunes4j.exception;

import com4j.ComException;

/**
 * Is thrown for example when a track is added that can not be added to iTunes
 * but must be converted (WMA).
 * 
 * @author schnatterer
 *
 */
public class WrongParameterException extends ITunesException {
	private static final long serialVersionUID = 1L;
	public static final int ERROR_CODE = 0x80070057;

	WrongParameterException(ComException e) {
		super(e);
	}

	@Override
	public Integer getiTunesErrorCode() {
		return ERROR_CODE;
	}
}
