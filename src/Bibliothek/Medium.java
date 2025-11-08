/**
 * Basisklasse mit Titel.
 * @author Valentyn Zhernovoi
 * @since 2025-10-19
 * <p>Umgebung: IntelliJ IDEA, JDK 25, Windows 10</p>
 */
package Bibliothek;
public abstract class Medium {
    /** Titel des Mediums. */
    protected String Titel;

    /** Gibt den Titel zurück.
     * @return Titel */
    public String getTitel() {
        return this.Titel;
    }

    /** Setzt den Titel.
     * @param Titel Titel */
    public void setTitel(String Titel) {
        this.Titel = Titel;
    }


    /** Liefert die Darstellung.
     * @return Text */
    public abstract String calculateRepresentation();

    /** Gibt {@link #calculateRepresentation()} zurück.
     * @return Text */
    @Override
    public String toString(){
        return calculateRepresentation();
    }

}
