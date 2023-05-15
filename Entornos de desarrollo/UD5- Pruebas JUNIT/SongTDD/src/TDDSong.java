import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

public class TDDSong {

    private static final String ONE = """
                There was an old lady who swallowed a 1.
                I don't know why she swallowed a 1 - perhaps she'll die!
                
                """;

    private static final String TWO = ONE + """
                There was an old lady who swallowed a 2;
                That wriggled and wiggled and tickled inside her.
                She swallowed the 2 to catch the 1;
                I don't know why she swallowed a 1 - perhaps she'll die!
                
                """;

    private static final String THREE = TWO + """ 
                There was an old lady who swallowed a 3;
                How absurd to swallow a 3.
                She swallowed the 3 to catch the 2,
                She swallowed the 2 to catch the 1;
                I don't know why she swallowed a 1 - perhaps she'll die!
                                
                """;

    public static String song(List<String> lista){
        if (lista.size() == 0){
            return "";
        } else if (lista.size() == 1) {
            return ONE.replaceAll("1", lista.get(0));
        } else if (lista.size() == 2) {
            return TWO.replaceAll("1", lista.get(0)).replaceAll("2", lista.get(1));
        } else {
            return THREE.replaceAll("1", lista.get(0)).replaceAll("2", lista.get(1)).replaceAll("3", lista.get(2));
        }
    }
}
