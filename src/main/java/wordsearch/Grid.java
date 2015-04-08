package wordsearch;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;

/**
 * @author Dirk Luijk
 */
public class Grid {
    private CharGenerator charGenerator;

    private final int width;
    private final int height;

    private String[][] chars;

    private Direction currentDirection;

    private enum Direction {
        HORIZONTAL, DIAGONAL
    }


    public Grid(CharGenerator charGenerator, int width, int height) {
        this.charGenerator = charGenerator;
        this.width = width;
        this.height = height;
        this.chars = new String[width][height];
        this.currentDirection = Direction.HORIZONTAL;
    }

    public String build(String[] words) {

        for (String word : words) {
            try {
                placeWord(word);
            } catch (Exception e) {
                // todo
                e.printStackTrace();
            }
            flipGrid();
        }

        fillEmptySpaces();

        String output = renderOutput();
        clear();

        return output;
    }

    public void clear() {
        chars = new String[width][height];
    }

    private String renderOutput() {
        String output = "";

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                output += chars[x][y].toUpperCase();
            }

            output += "\n";
        }

        // remove last line break
        output = StringUtils.stripEnd(output, "\n");

        return output;
    }

    private void fillEmptySpaces() {
        // fill every cell with a generated char
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (chars[x][y] == null) {
                    chars[x][y] = String.valueOf(charGenerator.generateChar());
                }
            }
        }
    }

    private void placeWord(String word) throws Exception {
        // correct word first
        word = word.toLowerCase();

        // try every possibility till it fits, exception if not possible
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                // from this point, check availability and place it if possible
                if (!wordFits(word, x, y)) {
                    // if it does not fit, change direction once
                    changeDirection();
                }

                if (wordFits(word, x, y)) {
                    // it fits, so
                    placeWordAt(word, x, y);
                    changeDirection();
                    return;
                } else {
                    changeDirection();
                }
            }
        }

        // todo: improve exceptions
        throw new Exception("Word does not fit: " + word);
    }

    private void changeDirection() {
        // flip direction
        if (currentDirection == Direction.HORIZONTAL) {
            currentDirection = Direction.DIAGONAL;
        } else if (currentDirection == Direction.DIAGONAL) {
            currentDirection = Direction.HORIZONTAL;
        }
    }

    private void placeWordAt(String word, int startX, int startY) {
        int x = startX, y = startY;
        for (int i = 0; i < word.length(); i++) {
            chars[x][y] = String.valueOf(word.charAt(i));

            if (currentDirection == Direction.HORIZONTAL) {
                x++;
            } else if (currentDirection == Direction.DIAGONAL) {
                x++;
                y++;
            }
        }
    }

    private boolean wordFits(String word, int startX, int startY) {

        // check bounds first
        boolean inBounds = true;

        if (currentDirection == Direction.HORIZONTAL) {
            // check breedte
            inBounds = word.length() <= width - startX;
        } else if (currentDirection == Direction.DIAGONAL) {
            // check zowel breedte als hoogte
            inBounds = (word.length() <= width - startX) && (word.length() <= height - startY);
        }

        if (!inBounds) {
            return false;
        }

        // now check existing chars
        int x = startX, y = startY;
        for (int i = 0; i < word.length(); i++) {
            // if char in field, check if it matches
            if (chars[x][y] != null && chars[x][y] != String.valueOf(word.charAt(i))) {
                return false;
            }

            // otherwise, go to next
            if (currentDirection == Direction.HORIZONTAL) {
                x++;
            } else if (currentDirection == Direction.DIAGONAL) {
                x++;
                y++;
            }
        }

        return true;
    }

    private void flipGrid() {
        // decide with random number between 0 - 2 whether to flip vertical, horizontal or both
        Random r = new Random();
        int i = r.nextInt(3);

        boolean flipHorizontal = (i == 0 || i == 2);
        boolean flipVertical = (i == 1 || i == 2);

        String[][] newChars = chars.clone();

        if (flipHorizontal) {
            // flip columns (first dimension)
            ArrayUtils.reverse(newChars);
        }

        if (flipVertical) {
            // for each column, flip rows
            for (int column = 0; column < width; column++) {
                ArrayUtils.reverse(newChars[column]);
            }
        }

        chars = newChars;
    }
}