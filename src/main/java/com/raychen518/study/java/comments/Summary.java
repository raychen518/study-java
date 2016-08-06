/*
 * <COPYRIGHT INFORMATION IS PUT HERE>
 * Copyright (c) 2010, 2015, RayChen518. All rights reserved.
 * ...
 */

package com.raychen518.study.java.comments;

/**
 * <CLASS COMMENT IS PUT HERE>
 * 
 * <pre>
 * Xxxxx xxxxx xxxxx.
 * Xxxxx <p>xxxxx</p> xxxxx.
 * Xxxxx <code>xxxxx</code> xxxxx.
 * Xxxxx <blockquote>xxxxx</blockquote> xxxxx.
 * Xxxxx <cite>xxxxx</cite> xxxxx.
 * Xxxxx <em>xxxxx</em> xxxxx.
 * Xxxxx <strong>xxxxx</strong> xxxxx.
 * Xxxxx <tt>xxxxx</tt> xxxxx.
 * Xxxxx <ol>xxxxx</ol> xxxxx.
 * Xxxxx <ul>xxxxx</ul> xxxxx.
 * Xxxxx <li>xxxxx</li> xxxxx.
 * Xxxxx <img /> xxxxx.
 * Xxxxx NO <h1 /> OR <hr /> xxxxx.
 * </pre>
 * 
 * @param PARAMETER-1-NAME
 *            PARAMETER-1-DESCRIPTION
 * @param PARAMETER-2-NAME
 *            PARAMETER-2-DESCRIPTION
 * @author GUY-1
 * @author GUY-2
 * @version VERSION
 * @see REFERENCE-1
 * @see REFERENCE-2
 * @since INITIAL-VERSION
 * 
 */
public class Summary {

	/**
	 * <FIELD COMMENT IS PUT HERE>
	 */
	public static final int SOME_CONSTANT = 1;

	/**
	 * <FIELD COMMENT IS PUT HERE (OPTIONAL)>
	 */
	private int someVariable = 1;

	/**
	 * <METHOD COMMENT IS PUT HERE>
	 * 
	 * @param parameter1
	 *            PARAMETER-1-DESCRIPTION
	 * @param parameter2
	 *            PARAMETER-2-DESCRIPTION
	 * @param parameter3
	 *            PARAMETER-3-DESCRIPTION
	 * @return RETURN-DESCRIPTION
	 * @throws NullPointerException
	 *             EXCEPTION-1-DESCRIPTION
	 * @throws IndexOutOfBoundsException
	 *             EXCEPTION-2-DESCRIPTION
	 */
	public Object doSomething(int parameter1, boolean parameter2, Object parameter3)
			throws NullPointerException, IndexOutOfBoundsException {
		// ...
		return null;
	}

	/**
	 * <METHOD COMMENT IS PUT HERE>
	 */
	public int getSomeVariable() {
		return someVariable;
	}

	/**
	 * <METHOD COMMENT IS PUT HERE>
	 */
	public void setSomeVariable(int someVariable) {
		this.someVariable = someVariable;
	}

	/**
	 * <METHOD COMMENT IS PUT HERE (OPTIONAL)>
	 */
	@SuppressWarnings("unused")
	private void doSomething2() {
		//
	}

}
