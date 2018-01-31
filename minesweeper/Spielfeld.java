import java.util.Random;                                                            // Klasse Random wird importiert

/**
 * Diese Klasse stellt das Spielfeld
 * mit den Zustaenden der Zellen dar.
 */

public class Spielfeld
{
    int minen;                                                                      // Anzahl Minen
    int seite;                                                                      // Anzahl Felder pro Seite
    Zelle[] spielFeld;                                                              // Array von Zellen, mit Name spielFeld

    /**
     * Im Konstruktor werden die Zellen je nach Laenge der Spielfeldseite 
     * generiert und ruft die nachfolgenden Methoden auf.
     * 
     * Minen: werden durch die Eingabe des Users uebernommen
     * Seitenlaenge: wird durch die Eingabe des Users uebernommen
     */

    public Spielfeld(int seite, int minen)
    {
        this.minen = minen;
        this.seite = seite;
        spielFeld = new Zelle[seite*seite];                                         // Arraygroesse wird durch die Seite im Quadrat berechnet
    
        for (int i = 0; i < spielFeld.length; i++)
        {
            spielFeld[i] = new Zelle();                                             // i (aktuelle Position) wird als neue Zelle dargestellt   
        }
        
        platziereMinen();                                                           // Methode platziereMinen wird aufgerufen
        setzeNachbarn();                                                            // Methode setzeNachbarn wird aufgerufen
        zeichneSpielfeld();                                                         // Methode zeichneSpielfeld wird aufgerufen
    }

    /**
     * Diese Methode wird gebraucht, wenn die Klasse 
     * Minesweeper auf einzelne Zellen zugreifen will.
     */

    public Zelle zugriffZelle(int index)
    {
        return spielFeld[index];
    }
    
    /**
     * Plaziert die vorgegebene Anzahl Minen zufaellig auf dem Spielfeld.
     * Wird nur einmalig beim Erstellen des Spielfeldes aufgerufen.
     */

    private void platziereMinen()
    {
        Random r = new Random();
        
        while (minen != 0)                                                          // != bedeutet "NICHT GLEICH"
        {
            int zufallszahl = r.nextInt(spielFeld.length);
            
            if (!spielFeld[zufallszahl].hatBombe())
            {
                spielFeld[zufallszahl].setzeBombe(true);
                minen--;
            }
            
        }
    }
    
    /**
     * Schaut aufgrund der gesetzten Bomben (bei platziereMinen()) 
     * ob und wieviele Nachbarfelder mit Bombe vorhanden sind.
     * Dazu wird jede Zelle betrachtet und deren Anzahl 
     * Nachbarn mit Bombe gezählt.
     * Wird nur einmalig beim Erstellen des Spielfeldes aufgerufen.
     */

    private void setzeNachbarn()
    {
        for (int i = 0; i < spielFeld.length; i++)                                  // for-Schleife durchlaeuft jedes Feld
        {
            if (spielFeld[i].hatBombe())                                            // wenn Bombe vorhanden werden folgende Felder um 1 erhoeht
            { 
                if (i - seite -1 >= 0 && i % seite != 0)                            // links oben
                {
                    spielFeld[i-seite-1].erhoeheNachbarn();
                }
                if (i - seite >= 0)                                                 // Feld oben
                {
                    spielFeld[i-seite].erhoeheNachbarn();
                }
                if (i - seite +1 >= 0 && (i+1) % seite != 0)                        // Feld rechts oben
                {
                    spielFeld[i-seite+1].erhoeheNachbarn();
                }
                if (i -1 >= 0 && i % seite != 0)                                    // Feld links
                {
                    spielFeld[i-1].erhoeheNachbarn();
                }
                if (i +1 < spielFeld.length && (i+1) % seite != 0)                  // Feld rechts
                {
                    spielFeld[i+1].erhoeheNachbarn();
                }
                if (i + seite -1 < spielFeld.length && i % seite != 0)              // Feld links unten
                {
                    spielFeld[i+seite-1].erhoeheNachbarn();
                }
                if (i + seite < spielFeld.length)                                   // Feld unten
                {
                    spielFeld[i+seite].erhoeheNachbarn();
                }
                if (i + seite +1 < spielFeld.length && (i+1) % seite != 0)          // Feld rechts unten
                {
                    spielFeld[i+seite+1].erhoeheNachbarn();
                }
            }
        }
    }
    
    /**
     * In Konsole dargestelltes Spielfeld wird gezeichnet 
     * oder aktualisiert (bei klick auf Zelle ohne Bombe, 
     * bei klick auf Zelle mit Bombe aber noch genŸgend Leben, 
     * bei klick auf Zelle mit gesetzer Fahne).
     */

    public void zeichneSpielfeld()
    {
        int zeile = 1;                                                              // Zahl 1 wird in "zeile" geschrieben

        System.out.println();
        System.out.println();
        System.out.print("   ");                                                    // die ersten drei Leerschläge
        
        // Spaltenbezeichnung
        
        for ( int i = 1; i <= seite; i++)
        {
            System.out.print("  " + i + " ");                                       // zwei Leerschläge, aktuelle Spalte, ein Leerschlag
        }
            System.out.println();
            System.out.print(zeile + " ");                                          // Zeilennummer plus Leerschlag wird ausgegeben
            
        // das eigentliche Spielfeld

        for ( int i = 0; i < spielFeld.length; i++)
        {
            if ( (i+1) % seite == 0) {                                              // zeichnet die letzte Spalte
                System.out.println(" | " + spielFeld[i].zeigeZustand() + " |");
                
                // Zeilenbezeichnung

                if (i < spielFeld.length-1) {                                       // solange letzte Zelle minus 1 nicht erreicht ist
                   zeile ++;                                                        // erhoehe die Zeile
                   if (zeile < 10) {
                       System.out.print(zeile + " ");                               // solange die Zeilenanzahl unter 10 bleibt braucht es einen Leerschlag mehr
                   }
                   else {
                       System.out.print(zeile);
                   }
                }
            }
            else {
                 System.out.print(" | " + spielFeld[i].zeigeZustand());             // zeichnet alle anderen Zellen
            } 
        }
        
        System.out.println();
        System.out.println();
    }
}