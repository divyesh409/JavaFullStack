package throwPackage;

public class Throws2  {
    
	public static void checkAge(int age) throws InvalidVotingAgeException {
		
	
		
		if(age<18) {
			throw new InvalidVotingAgeException("Enter a Valid Age");
		}
		else {
			System.out.println("You are Eligible to vote");
		}
		
	}
	
	public static void main(String[] args) {
	    try {
	        checkAge(78);  
	    } catch (InvalidVotingAgeException e) {
	        System.out.println("Exception caught: " + e.getMessage());
	    }
	}

}



class InvalidVotingAgeException extends Exception{
	public InvalidVotingAgeException(String msg) {
		super(msg);
	}

	
		
	}
