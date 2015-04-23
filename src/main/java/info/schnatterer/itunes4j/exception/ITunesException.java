package info.schnatterer.itunes4j.exception;

import com4j.ComException;

public class ITunesException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new exception with the specified detail message. The cause
	 * is not initialized, and may subsequently be initialized by a call to
	 * {@link #initCause}.
	 *
	 * @param message
	 *            the detail message. The detail message is saved for later
	 *            retrieval by the {@link #getMessage()} method.
	 */
	public ITunesException(String message) {
		super(message);
	}

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * <p>
	 * Note that the detail message associated with {@code cause} is <i>not</i>
	 * automatically incorporated in this exception's detail message.
	 *
	 * @param message
	 *            the detail message (which is saved for later retrieval by the
	 *            {@link #getMessage()} method).
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            {@link #getCause()} method). (A <tt>null</tt> value is
	 *            permitted, and indicates that the cause is nonexistent or
	 *            unknown.)
	 * @since 1.4
	 */
	public ITunesException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new exception with the specified cause and a detail message
	 * of <tt>(cause==null ? null : cause.toString())</tt> (which typically
	 * contains the class and detail message of <tt>cause</tt>). This
	 * constructor is useful for exceptions that are little more than wrappers
	 * for other throwables (for example,
	 * {@link java.security.PrivilegedActionException}).
	 *
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            {@link #getCause()} method). (A <tt>null</tt> value is
	 *            permitted, and indicates that the cause is nonexistent or
	 *            unknown.)
	 * @since 1.4
	 */
	public ITunesException(Throwable cause) {
		super(cause);
	}

	/**
	 * @return the error code returned by itunes. Might be <code>null</code>.
	 */
	public Integer getiTunesErrorCode() {
		return null;
	}

	/**
	 * Creates a new {@link ITunesException} from a {@link ComException}. This
	 * might either be a more concrete sub type of {@link ITunesException} or a
	 * generic {@link ITunesException}.
	 * 
	 * @param e
	 *            the {@link ComException} to wrap.
	 * @return a new instance of {@link ITunesException} or one of its
	 *         subclasses
	 */
	public static ITunesException createITunesException(ComException e) {
		switch (e.getHRESULT()) {
		case NotModifiableException.ERROR_CODE:
			return new NotModifiableException(e);
		case WrongParameterException.ERROR_CODE:
			return new WrongParameterException(e);
		default:
			// Generic solution
			return new ITunesException(e);
		}
	}
}
