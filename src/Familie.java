import java.util.ArrayList;

public class Familie implements Iterable<String> {

    private ArrayList<String> mitglieder = new ArrayList<>();

    private void check(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("Name ist leer!");
        }
    }

    public Familie(String vater, String mutter) {
        check(vater);
        check(mutter);
        mitglieder.add(vater);
        mitglieder.add(mutter);
    }

    public Familie(Familienmitglied elternteil, String name) {
        check(name);
        if (elternteil == Familienmitglied.Vater) {
            mitglieder.add(name);
            mitglieder.add("");
        } else if (elternteil == Familienmitglied.Mutter) {
            mitglieder.add("");
            mitglieder.add(name);
        } else {
            throw new IllegalArgumentException("Nur Vater oder Mutter erlaubt.");
        }
    }


    public void addKind(String kind) {
        check(kind);
        mitglieder.add(kind);
    }

    public enum Familienmitglied {
        Vater,
        Mutter,
        Kinder
    }

    public String getMitglied(Familienmitglied f) {
        if (f == Familienmitglied.Vater) {
            return mitglieder.get(0);
        }
        else if (f == Familienmitglied.Mutter) {
            return mitglieder.get(1);
        }
        else if (f == Familienmitglied.Kinder) {
            if (mitglieder.size() <= 2) return "";
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i < mitglieder.size(); i++) {
                if (!sb.isEmpty()) {
                    sb.append(", ");
                        }
                sb.append(mitglieder.get(i));
            }
            return sb.toString();
        }
        return "";
    }

    @Override
    public java.util.Iterator<String> iterator() {
        ArrayList<String> copy = mitglieder;
        return copy.iterator();
    }
}
