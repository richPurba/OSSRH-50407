import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.net.MalformedURLException;

public class RandomNumberGeneratorTest {
    @Mock
    RandomNumberGenerator randomNumberGenerator;

    @Mock
    RandomNumber randomNumber;

    @Before
    public void makingClasses(){
        randomNumberGenerator = new RandomNumberGenerator();
    }


    @Test()
    public void expectingResponseToBeOk() throws MalformedURLException, IOException{
        try{
            randomNumber = randomNumberGenerator.getRandomNumber();
            Assert.assertNotNull(randomNumber);
        }
        catch( MalformedURLException me){
            throw new MalformedURLException("throwing malformed exception" + me);
        }
        catch( IOException io){
            throw new IOException("throwing IOexception" + io);
        }
    }

}
