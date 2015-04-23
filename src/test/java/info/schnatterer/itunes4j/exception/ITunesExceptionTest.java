package info.schnatterer.itunes4j.exception;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com4j.ComException;

/**
 * @author Hannes
 *
 */
public class ITunesExceptionTest {

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	@Mock
	private ComException comExceptionMock;

	/**
	 * Test if an unspecified error code leads to the creation of an
	 * {@link ITunesException}.
	 */
	@Test
	public void testCreatGenericException() {
		when(comExceptionMock.getHRESULT()).thenReturn(0);
		assertEquals("createITunesException() create unexpected class",
				ITunesException.class,
				ITunesException.createITunesException(comExceptionMock)
						.getClass());
	}

	/**
	 * Straighten out once and for all that this also works with decimal
	 * numbers. The other exceptions are tested with hex (as these are the
	 * numbers printed by iTunes).
	 */
	@Test
	public void testCreateWrongParameterExceptionDecimal() {
		when(comExceptionMock.getHRESULT()).thenReturn(-2147024809);
		assertEquals("createITunesException() create unexpected class",
				WrongParameterException.class, ITunesException
						.createITunesException(comExceptionMock).getClass());
	}

	/**
	 * Test if the hex number returned by iTunes leads to the creation of the
	 * proper Exception class.
	 */
	@Test
	public void testCreateWrongParameterException() {
		when(comExceptionMock.getHRESULT()).thenReturn(0x80070057);
		assertEquals("createITunesException() create unexpected class",
				WrongParameterException.class, ITunesException
						.createITunesException(comExceptionMock).getClass());
	}

	/**
	 * Test if the hex number returned by iTunes leads to the creation of the
	 * proper Exception class.
	 */
	@Test
	public void testCreateNotModifiableException() {
		when(comExceptionMock.getHRESULT()).thenReturn(0xa0040203);
		assertEquals("createITunesException() create unexpected class",
				NotModifiableException.class, ITunesException
						.createITunesException(comExceptionMock).getClass());
	}

}
