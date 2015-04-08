package wordsearch;

/**
 * @author Dirk Luijk
 */
public class FakeCharGenerator extends CharGenerator {

    private char fakeChar;

    public FakeCharGenerator(char fakeChar) {
        this.fakeChar = fakeChar;
    }

    @Override
    public char generateChar() {
        return fakeChar;
    }
}
