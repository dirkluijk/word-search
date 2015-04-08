package wordsearch;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Dirk Luijk
 */
public class Grid {
    private CharGenerator charGenerator;

    private final int width;
    private final int height;

    private char[][] chars;

    public Grid(CharGenerator charGenerator, int width, int height) {
        this.charGenerator = charGenerator;
        this.width = width;
        this.height = height;
    }

    public String build(String[] words) {
        String output = "";

        // TODO: insert code here

        // fill every cell with a generated char
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                //output += charGenerator.generateChar();
                // try to place a word!
            }

            output += "\n";
        }

        // remove last line break
        output = StringUtils.stripEnd(output, "\n");

        return output;
    }
}
