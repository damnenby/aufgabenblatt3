/**
 * Zeitschrift mit ISSN, Volume und Nummer.
 * @author Valentyn Zhernovoi
 * @since 2025-10-19
 * <p>Umgebung: IntelliJ IDEA, JDK 25, Windows 10</p>
 */
package Bibliothek;
public class Zeitschrift extends Medium{
    /** ISSN der Zeitschrift. */
    private String ISSN;
    /** Heftband (Volume). */
    private int Volume;
    /** Heftnummer. */
    private int Nummer;

    /** Gibt die ISSN zurück.
     * @return ISSN */
    public String getISSN() {
        return this.ISSN;
    }

    /** Setzt die ISSN.
     * @param ISSN ISSN */
    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    /** Gibt das Volume zurück.
     * @return Volume */
    public int getVolume() {
        return this.Volume;
    }

    /** Setzt das Volume.
     * @param Volume Volume */
    public void setVolume(int Volume) {
        this.Volume = Volume;
    }

    /** Gibt die Nummer zurück.
     * @return Nummer */
    public int getNummer() {
        return this.Nummer;
    }

    /** Setzt die Nummer.
     * @param Nummer Nummer */
    public void setNummer(int Nummer) {
        this.Nummer = Nummer;
    }

    /** Liefert die Darstellung (Titel, ISSN, Volume, Nummer).
     * @return Text */
    @Override
    public String calculateRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Titel: ").append(Titel).append("\n");
        sb.append("ISSN: ").append(ISSN).append("\n");
        sb.append("Volume: ").append(Volume).append("\n");
        sb.append("Nummer: ").append(Nummer);
        return sb.toString();
    }
}
