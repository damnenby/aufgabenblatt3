package Bibliothek;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Zettelkasten implements Iterable<Medium>, Serializable {

    private final ArrayList<Medium> items = new ArrayList<>();

    public void addMedium(Medium m) {
        if (m == null) throw new IllegalArgumentException("Medium null");
        if (m.getTitel() == null || m.getTitel().trim().isEmpty()) throw new IllegalArgumentException("Titel leer");

        if (m instanceof Buch b) {
            if (b.getVerfasser() == null || b.getVerfasser().trim().isEmpty()) throw new IllegalArgumentException("Verfasser leer");
            if (b.getVerlag() == null || b.getVerlag().trim().isEmpty()) throw new IllegalArgumentException("Verlag leer");
            if (b.getIsbn() == null || b.getIsbn().trim().isEmpty()) throw new IllegalArgumentException("ISBN leer");
            if (b.getErscheinungsjahr() <= 0) throw new IllegalArgumentException("Jahr ungültig: " + b.getErscheinungsjahr());
        } else if (m instanceof CD c) {
            if (c.getKuenstler() == null || c.getKuenstler().trim().isEmpty()) throw new IllegalArgumentException("Kuenstler leer");
            if (c.getLabel() == null || c.getLabel().trim().isEmpty()) throw new IllegalArgumentException("Label leer");
        } else if (m instanceof Zeitschrift z) {
            if (z.getIssn() == null || z.getIssn().trim().isEmpty()) throw new IllegalArgumentException("ISSN leer");
            if (z.getVolume() <= 0) throw new IllegalArgumentException("Volume <= 0");
            if (z.getNummer() <= 0) throw new IllegalArgumentException("Nummer <= 0");
        } else if (m instanceof ElektronischesMedium e) {
            if (e.getURL() == null || e.getURL().trim().isEmpty()) throw new IllegalArgumentException("URL leer");
            if (!ElektronischesMedium.checkURL(e.getURL())) throw new IllegalArgumentException("URL ungültig: " + e.getURL());
        } else {
            throw new IllegalArgumentException("Unbekannter Medientyp");
        }

        items.add(m);
    }

    public Medium findMedium(String titel) {
        if (titel == null) return null;
        for (Medium m : items) {
            String t = m.getTitel();
            if (t != null && t.equalsIgnoreCase(titel)) return m;
        }
        return null;
    }

    public boolean dropMedium(String titel) {
        if (titel == null) return false;
        for (int i = 0; i < items.size(); i++) {
            String t = items.get(i).getTitel();
            if (t != null && t.equalsIgnoreCase(titel)) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    public void sort(String order) {
        if (order == null) throw new IllegalArgumentException("order null");
        String o = order.trim().toLowerCase();

        if (o.equals("asc")) {
            Collections.sort(items);
        } else if (o.equals("desc")) {
            Collections.sort(items);
            Collections.reverse(items);
        } else {
            throw new IllegalArgumentException("order ungültig, use asc or desc: " + order);
        }
    }

    @Override
    public Iterator<Medium> iterator() {
        ArrayList<Medium> itemsCopy = new ArrayList<Medium>(items);
        return itemsCopy.iterator();
    }
}
