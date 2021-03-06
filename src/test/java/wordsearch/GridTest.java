package WordSearch;

import WordSearch.CharGenerator.GeneratorInterface;
import WordSearch.CharGenerator.StaticCharGenerator;
import junit.framework.TestCase;

/**
 * @author Dirk Luijk
 */
public class GridTest extends TestCase {
    private GeneratorInterface charGenerator;

    @Override
    public void setUp() throws Exception {
        this.charGenerator = new StaticCharGenerator('x');
    }

    public void testEmptyGrid() throws Exception {
        Grid grid = new Grid(charGenerator, 0, 0);

        String output = grid.build(new String[]{});
        assertEquals("", output);
    }

    public void testSmallWithoutWords() throws Exception {

        Grid grid = new Grid(charGenerator, 4, 4);

        String output = grid.build(new String[]{});
        assertEquals(
                "xxxx\n" +
                "xxxx\n" +
                "xxxx\n" +
                "xxxx",
                output
        );
    }

    public void testAnotherWithoutWords() throws Exception
    {
        Grid grid = new Grid(charGenerator, 3, 3);

        String output = grid.build(new String[]{});
        assertEquals(
                "xxx\n" +
                "xxx\n" +
                "xxx",
                output
        );
    }

    public void testWithOneWord() throws Exception {
        Grid grid = new Grid(charGenerator, 4, 4);

        String output = grid.build(new String[] {"hoi"});
        assertEquals(
                "hoix\n" +
                "xxxx\n" +
                "xxxx\n" +
                "xxxx",
                output
        );
    }

    public void testWithTwoWords() throws Exception {
        Grid grid = new Grid(charGenerator, 4, 4);

        String output = grid.build(new String[] {"hoi", "doei"});
        assertEquals(
                "hxxx\n" +
                "oxxx\n" +
                "ixxx\n" +
                "doei",
                output
        );
    }
}