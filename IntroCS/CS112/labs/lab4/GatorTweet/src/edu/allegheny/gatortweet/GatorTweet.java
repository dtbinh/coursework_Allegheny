package edu.allegheny.gatortweet;


import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Iterator;
import java.util.List;

import twitter4j.*;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import twitter4j.conf.ConfigurationBuilder;



public class GatorTweet {  //This is the class with the main method

    private static ArrayList<Tweet> ValidTweets = new ArrayList<Tweet>();

    public static void main (String []args) throws IOException{ //main method, throws exception

        Scanner s = new Scanner (System.in);
        int choice= 0;

        while (choice!=4){ //while loop that keeps user in program until they choose to exit
            System.out.println("Welcome to GatorTweet, home of the tweeting Gators!");
            System.out.println("GatorTweet invites you to perform any of the following functions: ");
            System.out.println("1. Show the home timeline \n2. Update status from list of valid tweets");
            System.out.println("3. Create a tweet \n4. exit GatorTweet");
            System.out.println("Enter the number of the desired action: ");
            choice = s.nextInt();
            //the following if-else statements use the condition just entered to perform the desired action
            if(choice ==1){ //display home timeline of the user
                try {
                    ConfigurationBuilder cb = new ConfigurationBuilder();
                    cb.setDebugEnabled(true)
                        .setOAuthConsumerKey("rPtRCCRqdDyoxHS3E2UARA")
                        .setOAuthConsumerSecret("hhDnR4NETStvN4F84km2xuBy3eXJ8l2FnjdL23YPs");
                    // gets Twitter instance with default credentials
                    TwitterFactory tf = new TwitterFactory(cb.build());
                    Twitter twitter = tf.getInstance();
                    /* Twitter twitter = new TwitterFactory().getInstance(); */
                    User user = twitter.verifyCredentials();
                    List<Status> statuses = twitter.getHomeTimeline();
                    System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
                    for (Status status : statuses) {
                        System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
                    }
                } catch (TwitterException te) {
                    te.printStackTrace();
                    System.out.println("Failed to get timeline: " + te.getMessage());
                    System.exit(-1);
                }
            }
            else if(choice ==2){ //update timeline from the array list of valid tweets
                GatorTweet.ValidTweetstoTimeline();
            }
            else if(choice ==3){ //user can update status by typing in a line of code in terminal
                GatorTweet.PostTweet();
            }
            else {//exit the program
                choice = 4;
                //break;
            }
        }

    }

    public static void TweetstoArrays() {  //takes in a list of tweets from a file and stores them to either a valid tweet array or invalid tweet array
      File file = null;
        try{
        file = new File("tweets/Tweets.txt");

        Scanner scan = new Scanner (file);

        ArrayList<String> InvalidTweets = new ArrayList<String>();
        while (scan.hasNext() == true){
            String testTweet = scan.nextLine();
            Tweet TweetCheck = new Tweet();//import class
            if (TweetCheck.isValidMessage(testTweet) == true){
                TweetCheck.setMessage(testTweet);
                ValidTweets.add(TweetCheck);
            }
            else {
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
       catch (FileNotFoundException e){

       }
    }

    public static void PostTweet(){ //scans in a line and verifies if it is a valid tweet and either posts to timeline or returns a message to the user
        try{
            Scanner scanTweet = new Scanner(System.in);
            System.out.println("Please enter a 140 character tweet to be posted now: ");
            String tweetStatus= scanTweet.nextLine();
            Tweet TweetCheck = new Tweet();
            if (TweetCheck.isValidMessage(tweetStatus)==true){
                TweetCheck.setMessage(tweetStatus);
               //Tweet tweetStatusReady = (Tweet)tweetStatus.setMessage();
               // tweetStatusNow = TweetCheck.setMessage(tweetStatus);
              // String tweetStatusNow = tweetStatus.getMessage();
                Twitter twitter = TwitterFactory.getSingleton();
                Status status = twitter.updateStatus(tweetStatus);
                System.out.println("You just successfully updated your status to [" +status.getText() +"].");
            }
            else {
                System.out.println("Not a valid tweet, thanks for trying!");
            }
            }
        catch(TwitterException te){
             te.printStackTrace();
             System.out.println("Failed to update status " + te.getMessage());
             System.exit(-1);
        }
        }



    public static void ValidTweetstoTimeline(){ //method takes the array list of valid tweets and posts them to the timeline
        TweetstoArrays();
        Iterator ValidTweetsIterator = ValidTweets.iterator();
        while(ValidTweetsIterator.hasNext()==true){
            try {
                Tweet currentTweet = (Tweet)ValidTweetsIterator.next();
                String currentTweetMessage = currentTweet.getMessage();
                Twitter twitter = TwitterFactory.getSingleton();
                Status status = twitter.updateStatus(currentTweetMessage);
                System.out.println("Successfully updated the statuses to [" + status.getText() + "].");
            }catch (TwitterException te) {
                    te.printStackTrace();
                    System.out.println("Failed to get timeline: " + te.getMessage());
                    System.exit(-1);
                } //catch (IOException ioe) {
                  //  ioe.printStackTrace();
                  //  System.out.println("Failed to read the system input.");
                  //  System.exit(-1);
                //}
            }}//iterator valid tweets iterator return value of a string, currently a tweet value
}
