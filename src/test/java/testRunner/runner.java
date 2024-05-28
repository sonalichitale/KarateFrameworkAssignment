package testRunner;

import com.intuit.karate.junit5.Karate;

public class runner {

    String my_projectpath = System.getProperty("user.dir").toString();

    @Karate.Test

    Karate testSample_REST() {
        return Karate.run(my_projectpath+"/src/test/featurefile/assignment1.feature");
    }
}
