/**
 * Elektronisches Medium mit URL.
 * @author Valentyn Zhernovoiя
 * @since 2025-10-19
 * <p>Umgebung: IntelliJ IDEA, JDK 25, Windows 10</p>
 */
package Bibliothek;
import java.net.URL;

public class ElektronischesMedium extends Medium{

    /** URL des Mediums. */
    private String URL;

    /** Gibt die URL zurück.
     * @return URL */
    public String getURL() {
        return this.URL;
    }

    /** Setzt die URL (mit Prüfung).
     * @param URL URL */
    public void setURL(String URL) {
        if (checkURL(URL)){
            this.URL = URL;
            }
        else {
            System.out.println("Invalid URL: " + URL);
        }
    }

    /** URL-Prüfung
     * @param urlString Eingabe
     * @return boolean */
    public static boolean checkURL(String urlString)
    {
        try
        {
            URL url = new URL(urlString);
            url.toURI();
            return true;
        } catch (Exception exception)
        {
            return false;
        }
    }

    /** Liefert die Darstellung (Titel und URL).
     * @return Text */
    @Override
    public String calculateRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Titel: ").append(Titel).append("\n");
        sb.append("URL: ").append(URL);
        return sb.toString();
    }
}
