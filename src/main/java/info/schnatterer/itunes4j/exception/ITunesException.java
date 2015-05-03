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

import java.lang.reflect.Method;
import java.util.Optional;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

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

	//
	// @SuppressWarnings("unchecked")
	// public static <T> T createWrapperProxy(T t) {
	// Object proxy = Proxy.newProxyInstance(t.getClass().getClassLoader(),
	// new Class[] { t.getClass() }, new WrappingInvocationHandler(t));
	// return (T) proxy;
	// }

	/**
	 * Creates a proxy object that wraps all {@link RuntimeException} thrown by
	 * any method of an subject into {@link ITunesException}s. Make sure to
	 * provide the proper method signature on the subject's methods!
	 * 
	 * @param subject
	 *            class to be proxied. An instance of this class is created by
	 *            invoking the constructor with the arguments passed as second
	 *            and third parameters. Make sure a suitable constructor is
	 *            visible (i.e. at least <code>protected</code>)
	 * @param argumentTypes
	 *            constructor signature. If {@link Optional#empty()}, the no-arg
	 *            constructor is called.
	 * @param arguments
	 *            compatible wrapped arguments to pass to constructor.If
	 *            {@link Optional#empty()}, the no-arg constructor is called.
	 * 
	 * @return a new proxied instance that throws {@link ITunesException}s
	 *         instead of {@link RuntimeExceptions}
	 * 
	 * @see #createITunesException(RuntimeException)
	 */
	@SuppressWarnings("unchecked")
	public static <T> T createWrapperProxy(Class<?> subject,
			Optional<Class<?>[]> argumentTypes, Optional<Object[]> arguments) {
		Enhancer e = new Enhancer();
		e.setClassLoader(subject.getClassLoader());
		e.setSuperclass(subject);
		e.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] args,
					MethodProxy proxy) throws Throwable {
				try {
					return proxy.invokeSuper(obj, args);
				} catch (RuntimeException e) {
					throw ITunesException.createITunesException(e);
				}
			}
		});
		if (argumentTypes.isPresent() && arguments.isPresent()) {
			return (T) e.create(argumentTypes.get(), arguments.get());
		} else {
			// Invoke no-arg constructor
			return (T) e.create();
		}
	}
}
