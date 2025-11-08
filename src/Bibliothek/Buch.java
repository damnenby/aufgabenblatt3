package Bibliothek;

/**
 * Buch mit Erscheinungsjahr, Verlag, ISBN und Verfasser.
 * Erbt den Titel aus {@link Medium} und prüft die ISBN im Setter.
 * @author Valentyn Zhernovoi
 * @since 2025-10-19
 * <p>Umgebung: IntelliJ IDEA, JDK 25, Windows 10</p>
 */
public class Buch extends Medium{
    /** Erscheinungsjahr des Buches. */
    private int erscheinungsjahr;

    /** Verlag des Buches. */
    private String verlag;

    /** ISBN des Buches */
    private String isbn;

    /** Verfasser/Autor des Buches. */
    private String verfasser;

    /** to be updated */
    private int auflage;

    /** to be updated */
    private int seitenanzahl;

    /** to be updated */
    private boolean ausgeliehen;


    /** Gibt das Erscheinngsjahr zurück.
     * @return Erscheinngsjahr */
    public int getErscheinungsjahr() {
        return this.erscheinungsjahr;
    }

    /** Setzt das Erscheinungsjahr.
     * @param Erscheinungsjahr Erscheinungsjahr */
    public void setErscheinungsjahr(int Erscheinungsjahr) {
        this.erscheinungsjahr = Erscheinungsjahr;
    }

    /** Gibt den Verlag zurück.
     * @return Verlag */
    public String getVerlag() {
        return this.verlag;
    }


    /** Setzt den Verlag.
     * @param Verlag Verlag */
    public void setVerlag(String Verlag) {
        this.verlag = Verlag;
    }

    /** Gibt die ISBN zurück.
     * @return ISBN */
    public String getIsbn() {
        return this.isbn;
    }

    /** to be updated */
    public int getAuflage() {
        return this.auflage;
    }

    /** to be updated */
    public void setAuflage(int auflage) {
        this.auflage = auflage;
    }

    /** to be updated */
    public int getSeitenanzahl() {
        return this.seitenanzahl;
    }

    /** to be updated */
    public void setSeitenanzahl(int seitenanzahl) {
        this.seitenanzahl = seitenanzahl;
    }

    /** to be updated */
    public boolean isAusgeliehen() {
        return this.ausgeliehen;
    }

    /** to be updated */
    public void setAusgeliehen(boolean ausgeliehen) {
        this.ausgeliehen = ausgeliehen;
    }

    /** to be updated */
    public void ausgeleihen(){
        this.ausgeliehen = true;
    }

    /** to be updated */
    public void rueckgabe(){
        this.ausgeliehen = false;
    }

    /** to be updated */
    public void verlaengern(){
        /* to be updated */
    }

    /** Setzt die ISBN nach Prüfung.
     * Entfernt Nichtziffern.
     * @param isbn Eingabe */
    public void setIsbn(String isbn) {
        if (isbn == null) {
            System.out.println("Invalid ISBN: null");
            return;
        }


        String onlyNumbers = isbn.replaceAll("\\D", "");
        if (onlyNumbers.isEmpty()) {
            System.out.println("Invalid ISBN: empty");
            return;
        }

        int[] a = toDigits(onlyNumbers);


        boolean valid = false;

        if (a.length == 10) {
            valid = checkISBN10(a);
        }
        else if (a.length == 13) {
            valid = checkISBN13(a);
        }

        if (valid) {
            this.isbn = isbn;
        }

        else {
            System.out.println("Invalid ISBN: " + isbn);
        }

    }

    /** Gibt den Verfasser zurück.
     * @return Verfasser */
    public String getVerfasser() {
        return this.verfasser;
    }

    /** Setzt den Verfasser.
     * @param Verfasser Verfasser */
    public void setVerfasser(String Verfasser) {
        this.verfasser = Verfasser;
    }

    /** String → int[].
     * @param s Ziffenr-String
     * @return Integer-Array */
    private int[] toDigits(String s) {
        int[] a = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            a[i] = Character.getNumericValue(s.charAt(i));
        }
        return a;
    }


    /** Liefert die Darstellung (Titel, Jahr, Verlag, ISBN, Verfasser).
     * @return Text */
    @Override
    public String calculateRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Titel: ").append(Titel).append("\n");
        sb.append("Erscheinungsjahr: ").append(erscheinungsjahr).append("\n");
        sb.append("Verlag: ").append(verlag).append("\n");
        sb.append("ISBN: ").append(isbn).append("\n");
        sb.append("Verfasser: ").append(verfasser);
        return sb.toString();
    }


    // ---------------------------------------------------

/** Prüft ISBN10
 * @return valid */
    public static boolean checkISBN10(int[] isbn) {
        int sum = 0;
        for (int i = 1; i <= isbn.length; i++) {
            sum += i * isbn[i - 1];
        }
        if (sum % 11 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /** Prüft ISBN13
     * @return valid */
    public static boolean checkISBN13(int[] isbn) {
        int sum = 0;
        for (int i = 1; i < isbn.length; i++) {
            if (i % 2 == 0) {
                sum += isbn[i - 1] * 3;
            } else {
                sum += isbn[i - 1];
            }
        }
        int lastDigit = sum % 10;
        int check = (10 - lastDigit) % 10;
        if (isbn[isbn.length - 1] == check) {
            return true;
        } else {
            return false;
        }
    }

}
