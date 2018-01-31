/**
 * Diese Klasse ist verantwortlich fuer den Zustand 
 * der Zelle und wie sie angezeigt wird.
 */

public class Zelle
{
    // Zustand der Zelle

    private boolean geklickt;                                                       // Zelle ist "geklickt"
    private boolean bombe;                                                          // Zelle ist eine Bombe
    private boolean fahne;                                                          // User hat Fahne gesetzt
    private int nachbar;                                                            // Anzahl Nachbarzellen mit Bombe
    private boolean richtig;                                                        // gibt an, ob Zelle bereits korrekt deklariert wurde

    /**
      * Der Konstruktor setzt alle Zellen auf false bzw. 0.
      */

    public Zelle()
    {
        geklickt = false;                                                           // Urspungszustand nicht geklickt
        bombe = false;                                                              // Urspungszustand keine Bombe
        fahne = false;                                                              // Urspungszustand keine Fahne
        richtig = false;                                                            // Urspungszustand nicht "richtig" geklickt
        nachbar = 0;                                                                // Urspungszustand keinen Nachbarn mit Bombe
    }

    /**
     * Legt fest, ob Zelle eine Bombe hat oder nicht.
     * Wird nur beim Erstellen des Spielfeldes gebraucht.
     */

    public void setzeBombe(boolean bombe)
    {
        this.bombe = bombe;
    }

    /**
     * Erhöht pro Aufruf die Anzahl Nachbarn.
     * Wird nur beim Erstellen des Spielfeldes gebraucht.
     */

    public void erhoeheNachbarn()
    {
        nachbar += 1;
    }
    
    /**
     * zeigt Anzahl Nachbarn
     * Gibt Anzahl Nachbarn zurueck.
     */

    public int hatNachbarn()
    {
        return nachbar;
    }
    
    /**
     * Hat Zelle eine Bombe?
     * Gibt das Vorhandensein einer Bombe an.
     */

    public boolean hatBombe()
    {
        return bombe;
    }
    
    /**
     * Wenn Benutzer der Zelle eine Fahne zuweist, wird dieses Feld aufgerufen.
     */

    public void setzeFahne(boolean fahne)
    {
        this.fahne = fahne;
        setzeRichtig();                                                             // User setzt Fahne -> es wird ueberprueft ob Zelle richtig geklickt wurde
    }
    
    /**
     * Wenn Zelle richtig geklickt wurde - 
     * d.h. wenn Zelle eine Bombe hat und Spieler setzt Fahne
     * oder wenn Zelle keine Bombe ist und Spieler "klickt" - 
     * wird richtig auf true gesetzt.
     * So kann festgestellt werden ob Spiel gewonnen wurde.
     */

    private void setzeRichtig()
    {
        if ((fahne && bombe) || (geklickt && !bombe))                               // richtig ist wenn die Zelle eine Fahne und eine Bombe hat ODER geklickt wurde und keine Bombe hat
        {
            richtig = true;
        }
        else                                                                        // alle anderen Möglichkeiten sind falsch
        {
            richtig = false;
        }
    }
    
    /**
     * Gibt an, ob Zelle richtig angeklickt wurde.
     */

    public boolean istRichtig()
    {
        return richtig;
    }
    
    /**
     * Gibt an, ob Spieler auf diese Zelle eine Fahne gelegt hat.
     */

    public boolean hatFahne()
    {
        return fahne;
    }

    /**
     * Mit dieser Methode wird ein Klick getätigt.
     */

    public void setzeGeklickt(boolean geklickt)
    {
        this.geklickt = geklickt;
        setzeRichtig();                                                             // User hat geklickt -> es wird ueberprueft ob Zelle richtig geklickt wurde
    }
    
    /**
     * Zeigt an, ob Zelle geklickt wurde.
     */

    public boolean istGeklickt()
    {
        return geklickt;
    }
    
    /**
     * Gibt den Zustand der Zelle als String aus
     */

    public String zeigeZustand()
    {
        String zustand;
        
        if (geklickt)                                                               // User klickt
        {
            if (nachbar > 0)                                                        // und es hat eine Bombe nebenan (mehr als 0),
            {
                zustand = "" + nachbar;                                             // zeig diese an. (""+nachbar; war nötig weil der Nachbar ein integer ist --> kein Text plus eine Zahl = eine Zahl) 
            }
            else 
            {
                zustand = " ";                                                      // oder es hat keine Bombe nebenan stell ein Leerzeichen dar
            }
        }
        else if (fahne)                                                             // User setzt eine Fahne
        {
            zustand = "F";                                                          // schreib ein F in die Zelle
        }
        else 
        {
            zustand = "?";                                                          // Zelle wurde noch nicht geklickt
        }
        return zustand;                                                             // gib den Zustand zurück
    }
}