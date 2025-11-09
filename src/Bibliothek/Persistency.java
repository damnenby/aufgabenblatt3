package Bibliothek;
import java.io.IOException;

public interface Persistency {
    void save(Zettelkasten zk, String dateiname) throws IOException;
    Zettelkasten load(String dateiname) throws IOException, ClassNotFoundException;
}
