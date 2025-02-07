package com.library;

public class UserDefinedException {

	/*
	 * This is a class for UserDefined Exception
	 * Ramchandru-45
	 */
}

@SuppressWarnings("serial")
class BookNotFoundException extends Exception{
	public BookNotFoundException() {
		
	}
}

@SuppressWarnings("serial")
class UserNotFoundException extends Exception{
	public UserNotFoundException() {
		
	}
}

@SuppressWarnings("serial")
class MaxBooksAllowedException extends Exception{
	public MaxBooksAllowedException() {
		
	}
}