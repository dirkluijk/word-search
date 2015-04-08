package WordSearch.CharGenerator;

import java.util.Random;

/**
 * This class returns a random char between a-z
 *
 * @author Dirk Luijk
 */
public class RandomCharGenerator implements GeneratorInterface {

    public char generateChar()
    {
        Random r = new Random();
        return (char)(r.nextInt(26) + 'a');
    }
}
