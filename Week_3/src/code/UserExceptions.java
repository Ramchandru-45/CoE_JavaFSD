package code;

public class UserExceptions {

}

class InvalidCredentialError extends Exception{

	private static final long serialVersionUID = 1L;
	
}

class DataBaseConnectionError extends Exception{
	
	private static final long serialVersionUID = 2L;
	
}

class InvalidInputError extends Exception{
	
	private static final long serialVersionUID = 3L;
}