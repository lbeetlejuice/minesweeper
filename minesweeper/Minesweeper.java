/**
 * Diese Klasse Minesweeper ist die Hauptklasse des Games.
 * Mit dieser wird das Spiel gestartet und gespielt und beendet.
 * Sie enthaellt folgende Methoden: Neues Spiel starten, User 
 * klickt und es wird ueberprueft ob alle Bomben gefunden wurden.
 */

public class Minesweeper
{
    private int seite;                                                                                      // Anzahl Zellen pro Seite (bestimmt wo das Array umgebrochen wird)
    private Spielfeld spielfeld;                                                                            // Spielfeldobjekt
    private int leben;                                                                                      // Anzahl Leben des Spielers
    private int minen;                                                                                      // Anzahl Minen auf Spielfeld


    /**
     * Mit diesem Konstuktor werden die Laenge der Seite, 
     * die Anzahl der Minen und die Anzahl der Leben bestimmt.
     * 
     * Laenge der Seite: Zahl >= 5 und <= 10 
     * Anzahl Minen: Zahl >= 1 und <= 24 bis <= 99
     * Empf. des Autors --> max. 80% der Anzahl Felder
     * --> 5 Felder = 20 Minen, 6 = 28, 7 = 39, 8 = 51, 9 = 64, 10 = 80
     * Anzahl der Leben: Zahl >= 1
     */
    
    public Minesweeper(int seite, int minen, int leben)
    {
        this.seite = seite;
        this.minen = minen;
        this.leben = leben;
        neuesSpiel();                                                                                       // Methode neuesSpiel wird aufgerufen
    }
    
    /**
     * Diese Methode startet automatisch beim erstellen 
     * eines Objekts der Klasse Minesweeper.
     * Hier wird ueberprueft, ob die Seitenlaenge 
     * zwischen 5 und 10 Feldern und die Minen
     * zwischen 1 und 24 bzw. 99 liegt.
     */

    private void neuesSpiel()
    {
        System.out.println("Willkommen bei Lucky's Minesweeper!");
        System.out.println();
        if (seite < 5 || seite > 10 || minen < 1 || minen > seite*seite-1)                                  // || bedeutet "ODER"
        {                                                                                                   // wenn eine Seite kleiner ist als 5 ODER grösser als 10 ODER es weniger 
                System.out.println("Entschuldige, das geht leider nicht...");                               // Minen als 1 ODER mehr als Anzahl Felder minus 1 hat, dann gib folgende Meldung aus
                System.out.println("Bitte gib eine Seitenlaenge zwischen 5 und 10 ein");
                System.out.println("und waehle die Anzahl Minen zwischen 1 und 24 bis 99");                 //+ seite*seite); funktioniert nicht wenn Laenge falsch angegeben wurde...
                System.out.println("Empfehlung des Autors: max. 80% der gewaehlten Anzahl Felder");
                System.out.println("--> 5 Felder = 20 Minen, 6 = 28, 7 = 39, 8 = 51, 9 = 64, 10 = 80");
        }
        else
        {
                System.out.println("OK, let's go!");
                spielfeld = new Spielfeld(seite, minen);                                                    // ein Objekt der Klasse Spielfeld wird erstellt und in der Konsole angezeigt
        }
    }

    
    /**
      * Mit dieser Methode klickt der Benutzer.
      * 
      * Waehle die gewuenschte Zeile (Zahl zwischen 1 und 5 bzw. 10)
      * Waehle die gewuenschte Spalte (Zahl zwischen 1 und 5 bzw. 10)
      * Fahne oder nicht? (Fahne ja = true, Fahne nein = false)
      */

    public void klick(int zeile, int spalte, boolean fahne)
    {    
        int i = (zeile-1)*seite + spalte-1;
        
        if ( i < 0 || i > seite*seite-1)                                                                    // ungueltige Eingabe
        {                                          
            System.out.println("Bitte gib einen gueltigen Wert ein!");
        }
        else {
            if (fahne) {                                                                                    // User setzt Fahne
                spielfeld.zugriffZelle(i).setzeFahne(fahne);
                spielfeld.zeichneSpielfeld();
            }
            else {
                if (spielfeld.zugriffZelle(i).hatBombe()) {                                                 // User setzt keine Fahne -> Zelle hat Bombe
                    System.out.println("                      Kawum, explodiert, hehe... :)");
                    System.out.println("_____________________________________________________________________________________");
                    System.out.println("_____________________________________________________________________________________");
                    System.out.println("__###___________________________________________________________________________###__");
                    System.out.println("__###___________________________________________________________________________###__");
                    System.out.println("__#########___#########___#########___#########___#########___###############___###__");
                    System.out.println("__###___###___###___###___###___###___###___###___###___###___###___###___###___###__");
                    System.out.println("__###___###___###___###___###___###___###___###___###___###___###___###___###________");
                    System.out.println("__#########___#########___#########___#########___#########___###___###___###___###__");
                    System.out.println("_____________________________________________________________________________________");
                    System.out.println("");
                    
                    leben--;                                                                                // minus ein Leben
                    if (leben == 0) {
                        System.out.println("Game Over!");                                                   // User hat keine Leben mehr -> verloren (es wird kein neues Spielfeld mehr generiert)
                    }
                    else {
                        System.out.println("Mist, du hast eine Bombe getroffen!");                          // User hat noch Leben, aber eins weniger
                        System.out.println("Dir bleiben noch " + leben + " Leben...");                      // Anzeige wieviele Leben er noch hat
                        spielfeld.zeichneSpielfeld();                                                       // neues, ungeklicktes Spielfeld wird generiert
                    }
                }
                else {
                    spielfeld.zugriffZelle(i).setzeGeklickt(true);                                          // keine Fahne, keine Bombe -> Zelle wird geklickt
                    System.out.println("Glueck gehabt!! :)");                                               // Anzeige dass es nur Glück war
                    spielfeld.zeichneSpielfeld();                                                           // neues Spielfeld wird generiert, Klick wird angezeigt
                }
            }
            istsFertig();
        }
    }

    /**
     * Diese Methode ueberprueft, ob das Spiel fertig ist.
     * Sie wird bei jedem "Klick" aufgerufen.
     */

    private void istsFertig()
    {
        int anzahlZuUeberpruefendeZellen = seite*seite;                                                     // die Anzahl der Felder wird in anzahlZuUeberpruefendeZellen geschrieben
        for (int i = 0; i < seite*seite; i++)                                                               // for-Schleife laueft durch alle Zellen und
        {
            if (spielfeld.zugriffZelle(i).istRichtig()) {                                                   // ueberprueft ob die Zelle richtig geklickt wurde
                anzahlZuUeberpruefendeZellen--;                                                             // ist dies so, dann wird aus anzahlZuUeberpruefendeZellen eine Zelle abgezogen
            }
            }
        if (anzahlZuUeberpruefendeZellen == 0)                                                              // hat anzahlZuUeberpruefendeZellen 0 erreicht sind alle Zellen ueberprueft worden
        {                                                                                                   // und alle richtig geklickt worden, somit wird folgende Meldung ausgegeben
            System.out.println("                       Cool, gewonnen!! :-)");
            System.out.println("_______________________________________________________________________________");
            System.out.println("_______________________________________________________________________________");
            System.out.println("________###_______________###_____________________________________________###__");
            System.out.println("________###_______________###_____________________________________________###__");
            System.out.println("________###___###___###___#########___#########___#########___#########___###__");
            System.out.println("________###___###___###___###___###___###__####___###__####___###__####___###__");
            System.out.println("__###___###___###___###___###___###___###_________###_________###______________");
            System.out.println("__#########___#########___###___###___#########___#########___#########___###__");
            System.out.println("_______________________________________________________________________________");
            System.out.println("");
        }
    }
}