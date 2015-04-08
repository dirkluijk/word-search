package wordsearch;

import java.util.Random;

/**
 * @author Dirk Luijk
 */
public class CharGenerator {

    public char generateChar()
    {
        Random r = new Random();
        return (char)(r.nextInt(26) + 'a');
    }
}
