/**
 * CD mit Label und Künstler.
 * @author Valentyn Zhernovoi
 * @since 2025-10-19
 * <p>Umgebung: IntelliJ IDEA, JDK 25, Windows 10</p>
 */
package Bibliothek;
public class CD extends Medium{

    /** Label der CD. */
    private String Label;

    /** Künstlername. */
    private String Kuenstler;

    /** Gibt den Künstler zurück.
     * @return Künstler */
    public String getKuenstler() {
        return this.Kuenstler;
    }

    /** Setzt den Küsntler.
     * @param kuenstler Künstler */
    public void setKuenstler(String kuenstler) {
        this.Kuenstler = kuenstler;
    }

    /** Gibt das Label zurück.
     * @return Label */
    public String getLabel() {
        return this.Label;
    }

    /** Setzt das Label.
     * @param label Label */
    public void setLabel(String label) {
        this.Label = label;
    }

    /** Liefert die Darstellung (Titel, Label, Künstler).
     * @return Text */
    @Override
    public String calculateRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Titel: ").append(Titel).append("\n");
        sb.append("Label: ").append(Label).append("\n");
        sb.append("Künstler: ").append(Kuenstler);
        return sb.toString();
    }

}
