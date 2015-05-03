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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
	 * Creates a new {@link ITunesException} from a {@link RuntimeException}
	 * (typically a {@link ComException}). This might either be a more concrete
	 * sub type of {@link ITunesException} or a generic {@link ITunesException}.
	 * 
	 * @param e
	 *            the {@link RuntimeException} to wrap.
	 * @return a new instance of {@link ITunesException} or one of its
	 *         subclasses
	 */
	public static ITunesException createITunesException(RuntimeException e) {
		if (e instanceof ComException) {
			ComException comException = (ComException) e;
			switch (comException.getHRESULT()) {
			case NotModifiableException.ERROR_CODE:
				return new NotModifiableException(comException);
			case WrongParameterException.ERROR_CODE:
				return new WrongParameterException(comException);
			default:
				break;
			}
		}
		// Generic solution
		return new ITunesException(e);
	}

	/**
	 * Creates a proxy object that wraps all {@link RuntimeException} thrown by
	 * any method of a subject into {@link ITunesException}s. Make sure to
	 * provide the proper method signature on the subject's methods!
	 * 
	 * @param subjectInterface
	 *            the <b>interface</b> of the subject. Does not work with
	 *            classes!
	 * @param subject
	 *            the instance of the subject to be proxied
	 * @return a new instance that proxies <code>subject</code>
	 */
	@SuppressWarnings("unchecked")
	public static <I, T> I createWrapperProxy(
			Class<? super T> subjectInterface, T subject) {
		InvocationHandler handler = new WrappingInvocationHandler(subject);
		Object proxy = Proxy.newProxyInstance(
				subjectInterface.getClassLoader(),
				new Class[] { subjectInterface }, handler);
		return (I) proxy;
	}

	/**
	 * {@link InvocationHandler} that is used by the wrapper proxy. This handler
	 * just delegates to the proxied method but wraps any
	 * {@link RuntimeException}s into {@link ITunesException}s.
	 * 
	 * @author schnatterer
	 * @see ITunesException#createWrapperProxy(Class, Object)
	 *
	 */
	private static class WrappingInvocationHandler implements InvocationHandler {
		Object subject;

		public WrappingInvocationHandler(Object subject) {
			this.subject = subject;
		}

		@Override
		public Object invoke(Object proxy, Method meth, Object[] args)
				throws Throwable {
			try {
				return meth.invoke(subject, args);
			} catch (InvocationTargetException ex) {
				if (ex.getTargetException() instanceof RuntimeException) {
					throw ITunesException
							.createITunesException((RuntimeException) ex
									.getTargetException());
				} else {
					throw ex.getTargetException();
				}
			}
		}
	}
}
