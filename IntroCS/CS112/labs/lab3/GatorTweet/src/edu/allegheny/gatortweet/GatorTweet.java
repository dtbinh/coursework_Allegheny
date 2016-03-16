package edu.allegheny.gatortweet;


import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Iterator;

public class GatorTweet {

    public static void main (String []args) throws IOException{

        File file = new File("tweets/Tweets.txt");
        Scanner scan = new Scanner (file);
        ArrayList<Tweet> ValidTweets = new ArrayList<Tweet>();
        ArrayList<String> InvalidTweets = new ArrayList<String>();
        while (scan.hasNext() == true){
            String testTweet = scan.nextLine();
            Tweet TweetCheck = new Tweet();//import class
            if (TweetCheck.isValidMessage(testTweet) == true){
               TweetCheck.setMessage(testTweet);
                ValidTweets.add(TweetCheck);
            }
            else {
              // TweetCheck.toString(testTweet);
               InvalidTweets.add(testTweet);
            }
        }

        Iterator ValidTweetsIterator = ValidTweets.iterator();
        while (ValidTweetsIterator.hasNext() == true){
                Tweet currentTweet = (Tweet)ValidTweetsIterator.next();
                System.out.println("Valid Tweet: "+currentTweet);
        }
        Iterator InvalidTweetsIterator = InvalidTweets.iterator();
        while (InvalidTweetsIterator.hasNext()){
                String currentTweet = (String)InvalidTweetsIterator.next();
                System.out.println("Invalid Tweet: "+currentTweet);
        }
    }
}
