package edu.allegheny.gatortweet;

import java.util.Date;


public class Tweet {
		/**this method is responsible solely for formating a tweet and checking the validity of a tweet
		*to do this the method uses the Date class and will use a boolean method isValidMessage
		*which will return true if the tweet meets the requirements of a tweet
		*the requirements of a tweet will be that it must be under 140 characters, and is not identical to the previous tweet
		*/
    private Date currentDate;

    private String message;

    private static final int MAX_LENGTH = 140;

    public Tweet() {
        currentDate = new Date();
    }

    public static boolean isValidMessage(String message) {
		int messageLength = message.length();
		if (messageLength >= 0 && messageLength <= 140){
			return true;
		}
		else {
			return false;
		}

           }

    public void setMessage(String message) {
        this.message = message;
	//if the string is valid, then set message to array list for valid tweets
    }

    public String toString() {
        return "(" + currentDate.toString() + ", " + message + ")";
    }




}
