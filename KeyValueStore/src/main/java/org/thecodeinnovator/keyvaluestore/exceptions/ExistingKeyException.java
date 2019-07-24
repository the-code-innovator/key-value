package org.thecodeinnovator.keyvaluestore.exceptions;

public class ExistingKeyException extends Exception {
	private static final long serialVersionUID = 1L;
	String error;
	ExistingKeyException(String error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return new String(this.error);
	}
	
}