package exception;

// Custom exception class to handle cases where a resource is not found
public class ResourceNotFoundException extends RuntimeException {

	// Constructor that accepts a message to describe the exception
	public ResourceNotFoundException(String message) {
		// Passing the message to the superclass (RuntimeException) constructor
		super(message);
	}
}
