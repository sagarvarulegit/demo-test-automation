package examples.imdb;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;

public class IMDBRunner {
    
    @Karate.Test
    Karate testIMDBRunner(){
        return Karate.run("imdb").relativeTo(getClass());
    }

}
