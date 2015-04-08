
import WordSearch.CharGenerator.GeneratorInterface;
import WordSearch.CharGenerator.RandomCharGenerator;
import WordSearch.Grid;

/**
 * @author Dirk Luijk <dirk.luijk@ordina.nl>
 */
public class Main {
    public static void main(String[] args)
    {
        GeneratorInterface charGenerator = new RandomCharGenerator();

        Grid g = new Grid(charGenerator, 10, 10);

        String[] words = new String[] { "Lorem", "Ipsum", "Dolor", "Sid", "Amed", "Aap", "Noot" };
        String output = g.build(words);

        System.out.print(output);
    }
}
