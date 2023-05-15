import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TDDSongTest {

    private static List<String> lista = new ArrayList<>();

    @BeforeEach
    void clearLista(){
        lista.clear();
    }

    @Test
    void listaVacia(){
        String expected = "";
        assertEquals(expected, TDDSong.song(lista));
    }

    @Test
    void listaFly(){
        lista.add("fly");
        String expected = """
                There was an old lady who swallowed a fly.
                I don't know why she swallowed a fly - perhaps she'll die!
                
                """;
        assertEquals(expected, TDDSong.song(lista));
    }

    @Test
    void listaSpider(){
        lista.add("spider");
        String expected = """
                There was an old lady who swallowed a spider.
                I don't know why she swallowed a spider - perhaps she'll die!
                
                """;
        assertEquals(expected, TDDSong.song(lista));
    }

    @Test
    void listaFlyAndSpider(){
        lista.add("fly");
        lista.add("spider");
        String expected = """
                There was an old lady who swallowed a fly.
                I don't know why she swallowed a fly - perhaps she'll die!
                
                There was an old lady who swallowed a spider;
                That wriggled and wiggled and tickled inside her.
                She swallowed the spider to catch the fly;
                I don't know why she swallowed a fly - perhaps she'll die!
                
                """;
        assertEquals(expected, TDDSong.song(lista));
    }

    @Test
    void listaSpiderAndFly(){
        lista.add("spider");
        lista.add("fly");
        String expected = """
                There was an old lady who swallowed a spider.
                I don't know why she swallowed a spider - perhaps she'll die!
                
                There was an old lady who swallowed a fly;
                That wriggled and wiggled and tickled inside her.
                She swallowed the fly to catch the spider;
                I don't know why she swallowed a spider - perhaps she'll die!
                                                                          
                """;
        assertEquals(expected, TDDSong.song(lista));
    }

    @Test
    void listaFlySpiderAndBird(){
        lista.add("fly");
        lista.add("spider");
        lista.add("bird");
        String expected = """
                There was an old lady who swallowed a fly.
                I don't know why she swallowed a fly - perhaps she'll die!
                
                There was an old lady who swallowed a spider;
                That wriggled and wiggled and tickled inside her.
                She swallowed the spider to catch the fly;
                I don't know why she swallowed a fly - perhaps she'll die!
                 
                There was an old lady who swallowed a bird;
                How absurd to swallow a bird.
                She swallowed the bird to catch the spider,
                She swallowed the spider to catch the fly;
                I don't know why she swallowed a fly - perhaps she'll die!
                                
                """;
        assertEquals(expected, TDDSong.song(lista));
    }

    @Test
    void listaBirdFlyAndSpider(){
        lista.add("bird");
        lista.add("fly");
        lista.add("spider");
        String expected = """
                There was an old lady who swallowed a bird.
                I don't know why she swallowed a bird - perhaps she'll die!
                
                There was an old lady who swallowed a fly;
                That wriggled and wiggled and tickled inside her.
                She swallowed the fly to catch the bird;
                I don't know why she swallowed a bird - perhaps she'll die!
                
                There was an old lady who swallowed a spider;
                How absurd to swallow a spider.
                She swallowed the spider to catch the fly,
                She swallowed the fly to catch the bird;
                I don't know why she swallowed a bird - perhaps she'll die!

                """;
        assertEquals(expected, TDDSong.song(lista));
    }
}