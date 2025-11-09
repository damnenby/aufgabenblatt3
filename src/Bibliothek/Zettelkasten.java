package Bibliothek;

import java.util.ArrayList;
import java.util.Iterator;

public class Zettelkasten implements Iterable<Medium> {

    private final ArrayList<Medium> items = new ArrayList<>();

    public void addMedium(Medium m) {
        if (m == null) throw new IllegalArgumentException("Medium null");
        String t = m.getTitel();
        if (t == null || t.isBlank()) throw new IllegalArgumentException("Titel leer");
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

    public boolean removeMedium(String titel) {
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

    @Override
    public Iterator<Medium> iterator() {
        ArrayList<Medium> itemsCopy = new ArrayList<Medium>(items);
        return itemsCopy.iterator();
    }
}
