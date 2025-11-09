package Bibliothek;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class HumanReadablePersistency implements Persistency {
    @Override
    public void save(Zettelkasten zk, String dateiname) throws IOException {
        if (zk == null) throw new IllegalArgumentException("Zettelkasten null");
        if (dateiname == null) throw new IllegalArgumentException("Dateiname null");

        try (FileOutputStream fos = new FileOutputStream(dateiname); OutputStreamWriter w = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {

            for (Medium m : zk) {
                String text = m.calculateRepresentation();
                w.write(text);
                w.write(System.lineSeparator());
                w.write(System.lineSeparator());
            }
            w.flush();
        }
    }

    @Override
    public Zettelkasten load(String dateiname) {
        throw new UnsupportedOperationException("load() nicht implementiert");
    }
}
