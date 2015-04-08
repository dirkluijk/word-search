package WordSearch.CharGenerator;

/**
 * Just a char generator which always returns the same character.
 * For testing purposes only.
 *
 * @author Dirk Luijk
 */
public class StaticCharGenerator implements GeneratorInterface {
    private char staticChar;

    public StaticCharGenerator(char staticChar) {
        this.staticChar = staticChar;
    }

    public char generateChar() {
        return staticChar;
    }
}
