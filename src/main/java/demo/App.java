package demo;
import java.net.MalformedURLException;

import main.java.demo.Automate_image_urls;
import main.java.demo.Automate_imdb_ratings;
import main.java.demo.Automate_nested_frames_text;
import main.java.demo.Automate_post_on_linkedin;
import main.java.demo.Automate_window_handle;
import main.java.demo.BookMyShow;


public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
        
        // This is to remove unnecessary warnings from your console
        System.setProperty("java.util.logging.config.file", "logging.properties");
        
        // TestCases tests = new TestCases(); // Initialize your test class
        // AmazonSearch amazon = new AmazonSearch();
        // BookMyShow bms = new BookMyShow();
        Automate_post_on_linkedin l = new Automate_post_on_linkedin();
        // Automate_image_urls imgUrl = new Automate_image_urls();
        // Automate_nested_frames_text nstFrames = new Automate_nested_frames_text();
        // Automate_imdb_ratings imdb = new Automate_imdb_ratings();
        // Automate_window_handle wHandle = new Automate_window_handle();
        // TODO: call your test case functions one after other here

        // tests.testCase01();
        // amazon.testCase01();
        // bms.findlinks();
        l.linkedinPost();
        // imgUrl.automate_image_urls();
        // nstFrames.nested_frames();
        // imdb.imdb_rating();
        // wHandle.window_handle();
        // END Tests


    // tests.endTest(); // End your test by clearning connections and closing browser
        // amazon.endTest();
        // bms.endTest();
        l.endTest();   
        // imgUrl.endTest();
        // nstFrames.endTest();
        // imdb.endTest(); 
        // wHandle.endTest();
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}
