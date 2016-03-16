package edu.allegheny.gatortweet;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public final class CreateProperties {

    public static void main(String[] args) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey("rPtRCCRqdDyoxHS3E2UARA")
            .setOAuthConsumerSecret("hhDnR4NETStvN4F84km2xuBy3eXJ8l2FnjdL23YPs");
        try {
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
            try {
                RequestToken requestToken = twitter.getOAuthRequestToken();
                System.out.println("Got request token.");
                System.out.println("Request token: " + requestToken.getToken());
                System.out.println("Request token secret: " + requestToken.getTokenSecret());

                AccessToken accessToken = null;
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                while (null == accessToken) {
                    System.out.println("Open the following URL and grant access to your account:");
                    System.out.println(requestToken.getAuthorizationURL());
                    System.out.print("Enter the PIN and hit enter after you granted access. [PIN]:");
                    String pin = br.readLine();
                    try {
                        if (pin.length() > 0) {
                            accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                        } else {
                            accessToken = twitter.getOAuthAccessToken(requestToken);
                        }
                    } catch (TwitterException te) {
                        if (401 == te.getStatusCode()) {
                            System.out.println("Unable to get the access token.");
                        } else {
                            te.printStackTrace();
                        }
                    }
                }
                System.out.println("Got access token.");
                System.out.println("Access token: " + accessToken.getToken());
                System.out.println("Access token secret: " + accessToken.getTokenSecret());
                try {
                    System.out.println("Writing the properties file");
                    BufferedWriter out = new BufferedWriter(new FileWriter("twitter4j.properties"));
                    out.write("debug=true\n");
                    out.write("oauth.consumerKey=rPtRCCRqdDyoxHS3E2UARA\n");
                    out.write("oauth.consumerSecret=hhDnR4NETStvN4F84km2xuBy3eXJ8l2FnjdL23YPs\n");
                    out.write("oauth.accessToken=" + accessToken.getToken() + "\n");
                    out.write("oauth.accessTokenSecret=" + accessToken.getTokenSecret() + "\n");
                    out.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            catch (IllegalStateException ie) {
                if (!twitter.getAuthorization().isEnabled()) {
                    System.out.println("OAuth consumer key/secret is not set.");
                    System.exit(-1);
                }
            }
        }
        catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Failed to read the system input.");
            System.exit(-1);
        }
    }
}
