package Bibliothek;

import java.util.ArrayList;

/**
 * Erstellt verschiedene {@link Medium}-Objekte (Buch, CD, Zeitschrift, ElektronischesMedium),
 * speichert sie in einem Array und gibt deren textuelle Repräsentationen aus, testet {@link #parseBibTex(String)}.
 * @author Valentyn Zhernovoi
 * @since 2025-10-19
 * <p>Umgebung: IntelliJ IDEA, JDK 25, Windows 10</p>
 */
public class Bibliothek {
    /**
     * Hauptmethode: erzeugt mehrere Medienobjekte, speichert sie in einem Array
     * und gibt deren Darstellung über {@code toString()} auf der Konsole aus.
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {

        ArrayList<Medium> list = new ArrayList<>();

        Buch b = new Buch();
        b.setTitel("Duden 01. Die deutsche Rechtschreibung");
        b.setErscheinungsjahr(2004);
        b.setVerlag("Bibliographisches Institut, Mannheim");
        b.setISBN("3-411-04013-0");
        b.setVerfasser("-");

        CD cd = new CD();
        cd.setTitel("1");
        cd.setLabel("Apple (Bea (EMI))");
        cd.setKuenstler("The Beatles");

        Zeitschrift z = new Zeitschrift();
        z.setTitel("Der Spiegel");
        z.setISSN("ISSN 0038-7452");
        z.setVolume(54);
        z.setNummer(6);

        ElektronischesMedium em = new ElektronischesMedium();
        em.setTitel("Hochschule Stralsund");
        em.setURL("http://www.hochschule-stralsund.de");

        list.add(b);
        list.add(cd);
        list.add(z);
        list.add(em);

        for (Medium m : list) {
            System.out.println(m);
            System.out.println();
        }

        System.out.println("\n----------------------------------------------------------\n\n");

        String[] test = {
                "@book{author = {-}, title = {Duden 01. Die deutsche Rechtschreibung}, publisher = {Bibliographisches Institut, Mannheim}, year={2004}, isbn={3-411-04013-0}}",
                "@journal{title={Der Spiegel}, issn={0038-7452}, volume={54}, number={6}}",
                "@cd{title={1}, artist={The Beatles}, label={Apple (Bea (EMI))}}",
                "@elMed{title={Hochschule Stralsund}, url={http://www.hochschule-stralsund.de}}",
                "@book{title={X}, publisher={Y}, year={2000}, isbn={1234567890}",
                "@magazine{title={X}, issn={1234-5678}, volume={1}, number={1}}",
        };



        for (String s : test) {
            try {
                Medium m = Bibliothek.parseBibTex(s);
                System.out.println("SUCCESS: " + s);
                System.out.println(m);
                System.out.println("\n");
            } catch (Exception e) {
                System.out.println("FAIL: " + s);
                System.out.println(e);
                System.out.println("\n");
            }
        }


    }

    /**
     * Parst eine Zeile und erstellt das passende {@link Medium}.
     * Format: @type{key = {value}, ...}
     * @param inputText Eingabe
     * @return Medium (Buch/CD/Zeitschrift/ElektronischesMedium)
     * @throws IllegalArgumentException bei Fehlern
     * @throws NumberFormatException Zahlenfehlern
     */
    public static Medium parseBibTex(String inputText) {
        if (inputText == null) {
            throw new IllegalArgumentException("null");
        }

        String trimmedString = inputText.trim();
        if (!trimmedString.startsWith("@") || !trimmedString.endsWith("}")) {
            throw new IllegalArgumentException("Format");
        }

        int typeEndIndex = trimmedString.indexOf('{', 1);
        if (typeEndIndex < 0) {
            throw new IllegalArgumentException("Klammer");
        }

        String typeNameLower = trimmedString.substring(1, typeEndIndex).trim().toLowerCase();
        String bodyText = trimmedString.substring(typeEndIndex + 1, trimmedString.length() - 1).trim();

        if (typeNameLower.equals("book")) {
            String title = getField(bodyText, "title");
            if (title.isEmpty()) throw new IllegalArgumentException("Feld fehlt: title");

            String author = getField(bodyText, "author");
            if (author.isEmpty()) author = "-";

            String publisher = getField(bodyText, "publisher");
            if (publisher.isEmpty()) throw new IllegalArgumentException("Feld fehlt: publisher");

            String yearText = getField(bodyText, "year");
            if (yearText.isEmpty()) throw new IllegalArgumentException("Feld fehlt: year");
            int year = Integer.parseInt(yearText.trim());

            String isbn = getField(bodyText, "isbn");
            if (isbn.isEmpty()) throw new IllegalArgumentException("Feld fehlt: isbn");

            Buch buch = new Buch();
            buch.setTitel(title);
            buch.setVerfasser(author);
            buch.setVerlag(publisher);
            buch.setErscheinungsjahr(year);
            buch.setISBN(isbn);
            return buch;
        } else if (typeNameLower.equals("journal")) {
            String title = getField(bodyText, "title");
            if (title.isEmpty()) throw new IllegalArgumentException("Feld fehlt: title");

            String issn = getField(bodyText, "issn");
            if (issn.isEmpty()) throw new IllegalArgumentException("Feld fehlt: issn");

            String volumeText = getField(bodyText, "volume");
            if (volumeText.isEmpty()) throw new IllegalArgumentException("Feld fehlt: volume");
            int volume = Integer.parseInt(volumeText.trim());

            String numberText = getField(bodyText, "number");
            if (numberText.isEmpty()) throw new IllegalArgumentException("Feld fehlt: number");
            int number = Integer.parseInt(numberText.trim());

            Zeitschrift zeitschrift = new Zeitschrift();
            zeitschrift.setTitel(title);
            zeitschrift.setISSN(issn);
            zeitschrift.setVolume(volume);
            zeitschrift.setNummer(number);
            return zeitschrift;
        } else if (typeNameLower.equals("cd")) {
            String title = getField(bodyText, "title");
            if (title.isEmpty()) throw new IllegalArgumentException("Feld fehlt: title");

            String artist = getField(bodyText, "artist");
            if (artist.isEmpty()) throw new IllegalArgumentException("Feld fehlt: artist");

            String label = getField(bodyText, "label");
            if (label.isEmpty()) throw new IllegalArgumentException("Feld fehlt: label");

            CD cd = new CD();
            cd.setTitel(title);
            cd.setKuenstler(artist);
            cd.setLabel(label);
            return cd;
        } else if (typeNameLower.equals("elmed")) {
            String title = getField(bodyText, "title");
            if (title.isEmpty()) throw new IllegalArgumentException("Feld fehlt: title");

            String url = getField(bodyText, "url");
            if (url.isEmpty()) throw new IllegalArgumentException("Feld fehlt: url");

            ElektronischesMedium elektronischesMedium = new ElektronischesMedium();
            elektronischesMedium.setTitel(title);
            elektronischesMedium.setURL(url);
            return elektronischesMedium;
        } else {
            throw new IllegalArgumentException("Typ: " + typeNameLower);
        }
    }


    /**
     * Schlüsselsuche
     * @param bodyText Textbereich innerhalb der Klammern
     * @param key gesuchter Name
     * @return Wert
     */
    private static String getField(String bodyText, String key) {
        if (bodyText == null || key == null) return "";
        String lower = bodyText.toLowerCase();
        String k = key.toLowerCase();

        int kPos = lower.indexOf(k);
        if (kPos < 0) return "";

        int eqPos = lower.indexOf('=', kPos + k.length());
        if (eqPos < 0) return "";

        int openPos = lower.indexOf('{', eqPos + 1);
        if (openPos < 0) return "";

        int closePos = bodyText.indexOf('}', openPos + 1);
        if (closePos < 0) return "";

        return bodyText.substring(openPos + 1, closePos).trim();
    }


}
