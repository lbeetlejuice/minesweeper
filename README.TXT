
PROJECT TITLE:			Lucky's Minesweeper
PURPOSE OF PROJECT:		Spiel
VERSION or DATE:		02.01.2010
HOW TO START THIS PROJECT:	Um das Spiel zu starten erstelle ein 
				Objekt der Klasse Minesweeper...
AUTHORS:			Lukas
USER INSTRUCTIONS:

------------------------------------------------------------------------
/**
 * Willkommen zu Lucky's Minesweeper!!
 *
 * Minesweeper (englisch mine sweeper: „Minenräumer“) ist ein simples 
 * Computerspiel, bei dem der Spieler durch logisches Denken heraus- 
 * finden muss, hinter welchen Feldern Minen versteckt sind. Das Ziel 
 * ist, möglichst alle Felder aufzudecken, hinter welchen keine
 * Minen verborgen sind.
 * 
 * @bluej-version 3.0.0
 * @author Lukas Buchter
 * @version 28.12.2010
 */
------------------------------------------------------------------------

Was ich noch gerne hinzugefügt hätte...
||: Folgende Änderungen konnte ich durch zu wenig Zeit/Wissen nicht 
implementieren :||

--> Anstatt die Zeilen und die Spalten durch Zahlen zu kennzeichnen, 
hätte ich gerne die Spalten mit Buchstaben beschriftet. Doch es war mir 
nicht möglich einen String in einen int umzuwandeln und gleichzeitig 
noch zu erörtern, ob es ein Gross- oder Kleinbuchstabe ist (und 
dementsprechend anzupassen), ob der User die letzte Spalte nicht 
überschritten hat oder was passiert, wenn er kein String eingibt. Eine 
Eingabe der Koordinaten mit Zahlen und Buchstaben hätte einen Klick noch 
etwas einfach gemacht und allfällige Verwirrungen mit Zeilen und Spalten 
behoben.

--> Wenn der User die Seitenlänge und/oder die Anzahl Minen falsch
eingibt, erhält er eine Fehlermeldung die zwar aussagt, dass die 
Eingabe falsch ist, aber nicht welche. Gerne hätte ich die Spielfeld-
grösse und Anzahl Minen getrennt analysiert, um dem User genau mitteilen
zu könne, was er falsch gemacht hat.

--> Zur besseren usability wären Schwierigkeitsstufen hilfreich gewesen.
Also das der User wählen kann zwischen leicht, mittel und schwierig, 
wobei leicht wenig Minen bedeutet (z.B. 10%), mittel etwas mehr (30%) 
und schwirig eine erhöhte Anzahl (50%).

--> Beim Windows-Minesweeper werden beim ersten Klick ins Feld einige
angrenzenden Felder aufgedeckt, die keine Bombe als unmittelbaren 
Nachbarn haben. Diese Funktion zu programmieren übersteigt meine 
Möglichkeiten. Leider muss nun jedes einzelne Feld einmal geklickt 
werden, auch wenn man schon alle Bomben gekennzeichnet hat. Das 
geht klar auf kosten des Fun-Faktors.

--> Mir fiel als Möglichkeit zum Klicken keine andere als das
Koordinatensystem ein. Gerne hätte ich hier noch weitere/benutzer-
freundlichere gesucht. Denn jede Eingabe die der User mehr machen
muss, senkt den Spielspass.

--> Die Übersichtlichkeit geht bei der Darstellung des Spielfelds
etwas verloren. Der User muss sich bei jedem Klick neu orientieren und
entspechende Zeile und Spalte suchen. Auch das ist eine Einschränkung
des Fun-Faktors.

--> Nach dem Game Over muss der User ein komplett neues Spiel starten,
er kann nicht im selben Objekt weiterspielen.

------------------------------------------------------------------------

Das passiert, wenn jemand spielt...
||: Ablauf eines optimalen Spielverlaufs :||

°° User:  öffnet die Datei "package.bluej" im Minesweeper Ordner
** BlueJ: Zeigt die Klassenübersicht mit der Hauptklasse "Minesweeper"
	  und den Hilfsklassen "Spielfeld" und "Zelle"
°° User:  rechtsklickt auf die Klasse "Minesweeper" und wählt "public 
	  Minesweeper(int seite, int minen, int leben)"
** BlueJ: öffnet ein Dialogfeld und fordert zur Eingabe auf
°° User:  gibt die Länge einer Seite, Anzahl Minen und Anzahl Leben ein, 
	  klickt dann OK
** BlueJ: generiert ein Objekt der Klasse "Minesweeper" und öffnet 
	  gleichzeitig die Konsole. Darin wird ein Willkommens-Text und
 	  das Spielfeld angezeigt.
°° User:  rechtsklickt auf das erstellte Objekt und wählt "public void 
	  klick(int zeile, int spalte, boolean fahne)". User gibt Zeile
	  (Zahl), Spalte (Zahl) und Fahne ja/nein (true/false) ein und 
	  bestätigt mit OK
** BlueJ: stellt das Spielfeld mit geklickter Zelle als " " (Leerschlag)
	  oder Zahl dar
°° User:  wiederholt diesen Vorgang (klicken) so lange, bis alle Zellen
	  ohne Bombe aufgedeckt und Zellen mit Bombe mit einer 
	  Fahne gekennzeichnet sind
** BlueJ: zeigt Meldung, dass User das Spiel gewonnen hat (dargestellt 
	  durch "Juheee!"
°° User:  freut sich...

------------------------------------------------------------------------

Das passiert, wenn jemand etwas macht, das er nicht sollte...
||: Mögliche "Fehler", die der User machen kann :||

--> User wählt eine zu kurze (<5) oder zu lange (>10) Seite des 
    Spielfelds 
    @ es erscheint eine Fehlermeldung in der Konsole

--> User wählt eine zu kleine (0) oder zu grosse (> als seite*seite-1)
    Anzahl Minen
    @ es erscheint eine Fehlermeldung in der Konsole

--> User gibt keinen Wert ein
    @ nicht möglich, BlueJ verlangt einen Wert

--> User wählt eine Zelle ausserhalb des Spielfelds
    @ es erscheint eine Fehlermeldung in der Konsole

--> User gibt ein ungültiges Zeichen ein (z.B. Buchstabe statt Zahl)
    @ nicht möglich, der Typ der Eingabe ist definiert

--> User klickt auf ein Feld mit Bombe
    @ dem User wird ein Leben abgezogen und er wird darauf hingewiesen,
    dass er eine Bombe getroffen hat

--> User setzt eine Fahne auf eine Zelle ohne Bombe
    @ gezwungenermassen klickt User irgendwann auf eine Bombe, wobei
    ihm ein Leben abgezogen wird

--> User klickt auf Feld mit Bombe bis alle Leben aufgebraucht sind
    @ Spiel ist beendet, User hat verloren, Meldung wird auf Konsole 
    angezeigt

--> User klickt auf ein Feld, auf dem bereits eine Fahne gesetzt worden
    ist
    @ no problem, wird danach als geklickt dargestellt

------------------------------------------------------------------------

Was ziemlich tricky war...
||: Folgende Schwierigkeiten tauchten beim programmieren auf :||

--> verteilen der Minen
    Obwohl es im nachhinein einfach aussieht, brauchte es einige Fehl-
    versuche, bis es klappte. Es galt zu verhindern, dass sich alle
    Bomben in der gleichen Zelle sammeln, was theoretisch möglich
    wäre.

	01. private void platziereMinen() {
	02. Random r = new Random();
	03. while (minen != 0) {
	04. int zufallszahl = r.nextInt(spielFeld.length);
	05. if (!spielFeld[zufallszahl].hatBombe()) {
	06. spielFeld[zufallszahl].setzeBombe(true);
	07. minen--;}}}

	01. die interne Methode "platziereMinen" wird aufgerufen
	02. es wird ein neuer random r generiert (Klasse Random wurde 
	    zu Beginn importiert)
	03. While-Schleife mit Abbruch-Bedingung !=0. D.h. die Schleife
	    setzt bei jedem Durchgang eine Mine und läuft so lange bis
	    keine Minen mehr vorhanden sind, die zu setzen wären.
	04. es wird eine zufällige Zelle ausgewählt, abhängig von der 
	    Länge des Arrays
	05. es wird überprüft, ob die Zelle schon eine Bombe hat
	06. hat sie keine, wird eine Bombe gesetzt
	07. und von den übrigen eine abgezogen

--> erörtern der Nachbar-Minen
    es gibt zwei Möglichkeiten die Anzahl Minen in einer Zelle auszu-
    geben: entweder man durchläuft jedes Feld des Arrays und wenn es
    keine Mine hat zählt man ob und wie viele Nachbarfelder Minen 
    haben oder man durchläuft jedes Feld und wenn es eine Mine hat,
    erhöht man jedes Nachbarfeld um 1. Ich entschied mich für die 
    zweite Möglichkeit...
    Hier in erster Linie entscheidend herauszufinden, wie ich auf die     
    umliegenden Nachbar-Zellen zugreifen konnte. Vor allem diagonal und 
    vertikal stellte eine Herausforderung dar. Die Lösung ergab sich 
    mir, als ich mich darauf konzentrierte, dass es sich hier 
    eigentlich nicht um eine "Tabelle", sondern nur um eine 
    Zeile handelt.

    | | | | | |
    | | | | | |
    | |b| | | |
    | | |a| | |
    | | | | | |

    In der Tabellenartigen Darstellung ist es mit (vielleicht) 
    überwindbaren Hürden verbunden von a auf b zuzugreifen. 

    | | | | | | | | | | | |b| | | | | |a| | | | | | | |

    Wird hingegen der Array als einzelne Zeile gesehen, bietet sich 
    folgende Lösung an: gehe von der aktuellen Position (a) sechs
    Felder zurück (auf b) und erhöhe diesen Wert um 1.
    Da nun der User zwischen mehreren Seitenlängen wählen kann, 
    verändern sich auch je nach dem der Wert zwischen a und b. 
    Deshalb greife ich auf die Eingabe des Users zurück. Zieht man 
    von der momentanen Position eine Seitenlänge ab, befindet man 
    sich genau ein Feld über der aktuellen Position. Danach wird 
    noch eine Zelle minus gerechnet und b ist gefunden.
    
    |a|b|c|
    |d|X|e|
    |f|g|h|

    von X nach ... :

    a --> minus eine Seite minus ein Feld
    b --> minus eine Seite
    c --> minus eine Seite plus ein Feld
    d --> minus ein Feld
    e --> plus ein Feld
    f --> Plus eine Seite minus ein Feld
    g --> Plus eine Seite
    h --> Plus eine Seite plus ein Feld

    Doch diese Variante bringt auch Probleme mit sich:

    | | | | | |
    | | | | | |
    | | | | |b|
    |a| | | | |
    | | | | | |

    Angenommen i (aktuelle Position) befindet sich bei a und ist
    eine Mine, würde b natürlich automatisch erhöht werden, denn 
    im Array ohne Unterbrüche ist b eine Nachbarzelle von a: 

    | | | | | | | | | | | | | | |b|a| | | | | | | | | |

    deshalb braucht es eine weitere Bedingung, um eine Nachbar-
    zelle zu erhöhen.

	01. private void setzeNachbarn(){
	02. for (int i = 0; i < spielFeld.length; i++){
	03. if (spielFeld[i].hatBombe()){ 
	04. if (i - seite -1 >= 0 && i % seite != 0){
	05. spielFeld[i-seite-1].erhoeheNachbarn();}
	06. if (i - seite >= 0) {
	07. spielFeld[i-seite].erhoeheNachbarn();}
	08. if (i - seite +1 >= 0 && (i+1) % seite != 0){
	09. spielFeld[i-seite+1].erhoeheNachbarn();}
	10. if (i -1 >= 0 && i % seite != 0) {
	11. spielFeld[i-1].erhoeheNachbarn();}
	12. if (i +1 < spielFeld.length && (i+1) % seite != 0){
	13. spielFeld[i+1].erhoeheNachbarn();}
	14. if (i + seite -1 < spielFeld.length && i % seite != 0){
	15. spielFeld[i+seite-1].erhoeheNachbarn();}
	16. if (i + seite < spielFeld.length) {
	17. spielFeld[i+seite].erhoeheNachbarn();}
	18. if (i + seite +1 < spielFeld.length && (i+1) % seite != 0){
	19. spielFeld[i+seite+1].erhoeheNachbarn();}}}}

	01. interne Methode setzeNachbarn wird aufgerufen
	02. eine for-Schleife fragt jede Zelle des Spielfeldes ab
	03. und führt folgende Anweisungen aus, wenn die Zelle eine
	    Mine hat (wenn nicht springt sie weiter zur nächsten)
	04. Feld links oben:
	    wenn aktuelle Position minus eine Seitenlänge minus eine 
	    Zelle grösser gleich 0 ist (trifft zu solange i innerhalb 
	    des Spielfelds ist) und aktuelle Position geteilt durch die 
	    Seitenlänge nicht einen Rest von Null ergibt (das wiederum 
	    trifft zu wenn sich i nicht links am Rand des Spielfelds 
	    befindet*), 
	05. dann führe die methode erhoeheNachbarn an der Position 
	    i-seite-1 aus
	06. Feld oben:
	    wenn aktuelle Position minus eine Seitenlänge grösser oder 
	    gleich 0 ist
	07. führe diese Methode aus
	08. Feld rechts oben:
	    zweiter Teil der Bedingung: ein Feld weiter als aktuelle 
	    Position geteilt durch Seitenlänge soll keinen Rest 0 
	    ergeben (trifft zu wenn sich i nicht rechts am Rand des 
	    Spielfelds befindet**)
	09. führe diese Methode aus
	10. Feld links: siehe oben
	11. führe diese Methode aus
	12. Feld rechts: siehe oben
	    diese Bedingung wird erfüllt, solange sich die aktuelle 
	    Position noch im Spielfeld befindet
	13. führe diese Methode aus
	14. Feld links unten: siehe oben
	15. führe diese Methode aus
	16. Feld unten: siehe oben
	17. führe diese Methode aus
	18. Feld rechts unten: siehe oben
	19. führe diese Methode aus

 *  |0|1|2|3|4| --> wenn die aktuelle Position auf 5 befindet, beträgt 
    |5| | | | |	    die Seitenlänge ebenfalls 5. 5 geteilt durch 5 
    | | | | | |     ergibt 1 Rest 0 => Bedingung nicht erfüllt...
 ** | | | | |a|
    |b|c|d|e|f| --> die aktuelle Position befindet sich auf a und die
		    Seitenlänge beträgt 5. a + 1 = Position b (Wert
		    25), 25 geteilt durch 5 ergibt 5 Rest 0
		    => Bedingung nicht erfüllt...

--> Spielfeld generieren
    die wahrscheinlich schwierigste Methode in diesem Spiel. Die 
    Zeilen- und Spaltenbezeichnungen müssen variabel sein, sobald sie 
    zwei Stellen hat muss ein Leerschlag weniger dargestellt werden, 
    nach der letzen Spalte muss ein Abtrennungszeichen gesetz werden, 
    usw...

	01. public void zeichneSpielfeld(){
	02. int zeile = 1;
	03. System.out.println();
	04. System.out.println();
	05. System.out.print("   ");
	06. for ( int i = 1; i <= seite; i++){
	07. System.out.print("  " + i + " ");}
	08. System.out.println();
	09. System.out.print(zeile + " ");
	10. for ( int i = 0; i < spielFeld.length; i++){
	11. if ( (i+1) % seite == 0) {
	12. System.out.println(" | "+spielFeld[i].zeigeZustand()+" |");
	13. if (i < spielFeld.length-1) {
	14. zeile ++;    
	15. if (zeile < 10) {
	16. System.out.print(zeile + " ");}
	17. else {
	18. System.out.print(zeile);}}}
	19. else {
	20. System.out.print(" | " + spielFeld[i].zeigeZustand());}}
	21. System.out.println();
	22. System.out.println();}}

	01. wenn die öffentliche Methode zeichneSpielfeld aufgerufen 
	    wird, passiert folgendes:
	02. die Zahl 1 wird in die Variable "zeile" geschrieben
	03. es folgen zwei Zeilenumbrüche
	05. die erste Zeile hat drei Leerschläge um die 
	    Splaltenbezeichnungen richtig zu Positionieren

  ***1 2 3 4 5 
  1 | | | | | |
  2 | | | | | |
  3 | | | | | |
  4 | | | | | |
  5 | | | | | |

	06. eine for-Schleife, beginnend mit 1 läuft so lange, wie 
	    i kleiner oder gleich gross ist wie die Seitenlänge
	07. mit den entsprechenen Abständen werden die Spaltennummern 
	    ausgegeben
	08. auf der nächsten Zeile
	09. werden die Zeilennummern und danach ein Leerschlag 
	    ausgegeben.
	10. dann wird das Spielfeld gezeichnet: eine for-Schleife 
	    durchläuft jede Zelle des Arrays und
	11. in jedes Feld das sich rechts am Rand befindet einen "|".
	12. 
	13. dabei wird bis zur vorletzen Zelle 
	14. die Zeilennummer erhöht.
	15. und solange die Zeilennummer weniger als zwei Stellen 
	    beträgt, wird noch ein Leerschlag hinzugefügt.
	17. bei der zehnten Zeile 
	18. wird kein Leerschlag mehr geschrieben
	20. jetzt werden die restlichen Felder gezeichnet
	21. es folgen zwei Zeilenumbrüche 

--> Spielfeld vor dem ersten Klick anzeigen
    Ein im nachhinein "kleines" Problem war für mich, dass der User beim
    ersten Klick sehen muss wo er hin klickt. In einer frühen Version
    des Spiels musste der Spieler den ersten Klick blind tätigen, also
    ohne Konsole. 
    Durch einen Methodenaufruf im Konstruktor wird nun gleich nach der 
    Eingabe von Grösse und Minen ein Spielfeld gezeichnet.

------------------------------------------------------------------------
