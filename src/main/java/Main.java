import wordsearch.CharGenerator;
import wordsearch.Grid;

/**
 * @author Dirk Luijk <dirk.luijk@ordina.nl>
 */
public class Main {
    public static void main(String[] args)
    {
        CharGenerator generator = new CharGenerator();

        Grid g = new Grid(generator, 10, 5);

        String[] words = new String[] { "Lorem", "Ipsum", "Dolor", "Sid", "Amed", "Aap", "Noot" };
        String output = g.build(words);

        System.out.print(output);
    }
}
