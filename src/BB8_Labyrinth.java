/* IMPORT */
import java.util.*;
/**/

/**
 * Ein Programm bei dem ein Bot, mithilfe der Rechten-Hand-Regel durch ein Labyrinth läuft.
 * @author Christian Clausen
 * @author Nick Scheib
 * @Version final 1.0
 */

/* CLASS */
public class BB8_Labyrinth {

    /* MAINMETHODE */
    public static void main(String[] args) {

        // Konstanten und Variablen
        final char RECHTS = '˃';    // Konstante Bot Blickrichtung rechts
        final char LINKS = '˂';     // Konstante Bot Blickrichtung links
        final char OBEN = '˄';      // Konstante Bot Blickrichtung oben
        final char UNTEN = '˅';     // Konstante Bot Blickrichtung unten
        char blickRichtung = '0';   // Variable zum abspeichern der aktuellen Blickrichtung

        int botPosY = 6;    // Bot StartPosition Y - Wert
        int botPosX = 0;    // Bot StartPosition X - Wert

        int schleifenzaehler = 0;           // Zählt die Anzahl der Schleifen durchläufe
        boolean ausgangGefunden = false;    // Variable zum beenden der Bot-Prüfe-WEG-Schleife
        final int verzoegerung = 400;       // Konstante für die Verzögerung der Schleife

        int ausgang = 0;        // Abbruchbedingung wenn der Ausgang gefunden wurde
        int machtFalle = 0;     // Abbruchbedingung wenn der Bot in eine Falle läuft

        int anzahlMachtFallen = (int)(Math.random() * 3)+1;   // Random Anzahl der Machtfallen

        final char WEG = ' ';       // Konstante für den Weg des Labyrinths
        final char WAND = '#';      // Konstante für die Wand des Labyrinths
        final char AUSGANG = 'A';   // Konstante für den Ausgang des Labyrinths

        char[][] labyrinth = null;        // Char Array zum abspeichern des gewählten Labyrinths

        // Einführungstext
        System.out.print("\n" + "Bei diesem kleinen Spiel kannst du zusehen, wie ein kleiner Roboter  Namens BB-8, \n" +
                "selbstständig ein Rätsel löst. \n" +
                "Alles was du dafür tun musst, ist eins von drei Labyrinthen zu wählen und dem kleinen Bot \n" +
                "zuzusehen wie der das Labyrinth eigenständig löst. \n");
        System.out.println("");

        labyrinth = labyrinthwahl(labyrinth, anzahlMachtFallen, verzoegerung);    // Methode zur Eingabe, Wahl und Zurückgabe des gewählten Labyrinths
        printLabyrinth(labyrinth);  // Ausgabe des gewählten Labyrinths
        wait(verzoegerung);
        wait(verzoegerung);
        wait(verzoegerung);
        char[][] botPositionsKarte = createCopyOfMap(labyrinth);
        blickRichtung = RECHTS;     // Setzt die Blickrichtung des Bots für den Start auf Rechts = '>'

        while( !ausgangGefunden ) {

            switch (blickRichtung) {
                case RECHTS:
                    if (labyrinth[botPosY + 1][botPosX] == WAND) {
                        blickRichtung = OBEN;
                        break;
                    } else {
                        blickRichtung = UNTEN;
                        if (labyrinth[botPosY + 1][botPosX] == AUSGANG){
                            ausgang = 1;
                            continue;
                        } else if (labyrinth[botPosY + 1][botPosX] == 'D'){
                            machtFalle = 1;
                        }
                        botPosY = botPosY + 1;
                        botPositionsKarte[botPosY][botPosX] = blickRichtung;
                        labyrinth[botPosY][botPosX] = blickRichtung;
                        printLabyrinth( labyrinth );
                        labyrinth[botPosY][botPosX] = WEG;
                        ++schleifenzaehler;
                        System.out.print("\n \n");
                        wait(verzoegerung);
                        break;
                    }
                case LINKS:
                    if (labyrinth[botPosY - 1][botPosX] == WAND) {
                        blickRichtung = UNTEN;
                        break;
                    } else {
                        blickRichtung = OBEN;
                        if (labyrinth[botPosY - 1][botPosX] == AUSGANG){
                            ausgang = 1;
                            continue;
                        } else if (labyrinth[botPosY - 1][botPosX] == 'D'){
                            machtFalle = 1;
                        }
                        botPosY = botPosY - 1;
                        botPositionsKarte[botPosY][botPosX] = blickRichtung;
                        labyrinth[botPosY][botPosX] = blickRichtung;
                        printLabyrinth( labyrinth );
                        labyrinth[botPosY][botPosX] = WEG;
                        ++schleifenzaehler;
                        System.out.print("\n \n");
                        wait(verzoegerung);
                        break;
                    }
                case OBEN:
                    if (labyrinth[botPosY][botPosX + 1] == WAND) {
                        blickRichtung = LINKS;
                        break;
                    } else {
                        blickRichtung = RECHTS;
                        if (labyrinth[botPosY][botPosX + 1] == AUSGANG){
                            ausgang = 1;
                            continue;
                        } else if (labyrinth[botPosY][botPosX + 1] == 'D'){
                            machtFalle = 1;
                        }
                        botPosX = botPosX + 1;
                        botPositionsKarte[botPosY][botPosX] = blickRichtung;
                        labyrinth[botPosY][botPosX] = blickRichtung;
                        printLabyrinth( labyrinth );
                        labyrinth[botPosY][botPosX] = WEG;
                        ++schleifenzaehler;
                        System.out.print("\n \n");
                        wait(verzoegerung);
                        break;
                    }
                case UNTEN:
                    if (labyrinth[botPosY][botPosX - 1] == WAND) {
                        blickRichtung = RECHTS;
                        break;
                    } else {
                        blickRichtung = LINKS;
                        if (labyrinth[botPosY][botPosX - 1] == AUSGANG){
                            ausgang = 1;
                            continue;
                        } else if (labyrinth[botPosY][botPosX - 1] == 'D'){
                            machtFalle = 1;
                        }
                        botPosX = botPosX - 1;
                        botPositionsKarte[botPosY][botPosX] = blickRichtung;
                        labyrinth[botPosY][botPosX] = blickRichtung;
                        printLabyrinth(labyrinth);
                        labyrinth[botPosY][botPosX] = WEG;
                        ++schleifenzaehler;
                        System.out.print("\n \n");
                        wait(verzoegerung);
                        break;
                    }
            } // END switch

            // Abbruchbedingung wenn der Bot in deine dunkle Machtfalle tappt
            if (machtFalle == 1) {
                ausgangGefunden = true;
                System.out.println(
                        "Der Bot kam ganze " + schleifenzaehler + " Schritte voran, bevor er durch eine der \n" +
                                anzahlMachtFallen + " Falle der dunklen Macht zerstört wurde.\n" );
                try {
                    printLabyrinth(botPositionsKarte);
                }
                catch(ArrayIndexOutOfBoundsException exception) {
                    continue;
                }
            }

            // Abbruchbedingung der Schleife für die Positionsprüfung und Ausgabe des gelaufen WEGs
            if (ausgang == 1) {
                ausgangGefunden = true;
                System.out.println(
                        "Der Bot BB-2 hat den " + AUSGANG + " nach " + schleifenzaehler +
                                " Schritten erreicht und hat diesen WEG benutzt: \n");
                try {
                    printLabyrinth(botPositionsKarte);
                }
                catch(ArrayIndexOutOfBoundsException exception) {
                    continue;
                }
            }
        } // END while - ausgangGefunden

    } // END MAINMETHODE


/* METHODEN ----------------------------------------------------------------------------------------------------------*/

    /**
     * Methode gibt das gewählte Labyrinth aus und je nach Länge des gewählten Labyrinths werden
     * die leeren Zeichen nicht mit kopiert, um auch nur das mit Variablen gefühllte Labyrinth auszugeben.
     * @param labyrinth ist das char Array des Labyrinth
     */
    public static void printLabyrinth( char[][] labyrinth) {
        for (int zeile = 0; zeile < labyrinth.length; zeile++) {
            for (int spalte = 0; spalte < labyrinth[0].length; spalte++) {
                System.out.print( labyrinth[zeile][spalte]);
                System.out.print(" ");
            }
            System.out.println();
        }
    } // END printLabyrinth

    /**
     * Methode, erstellt ein neues Array des Labyrinth nach jedem Positionswechsel, um nur die aktuelle Position anzuzeigen
     * @param map ist das char Array des Labyrinth
     * @return gibt das aktuelle Array des Labyrinths zurück
     */
    public static char[][] createCopyOfMap( char[][] map) {
        char[][] copy = new char[15][15];
        for (int i = 0; i < map.length; i++) {
            char[] line = new char[20];
            for (int j = 0; j < map[i].length; j++) {
                line[j] = map[i][j];
            }
            copy[i] = line;
        }
        return copy;
    } // END createCopyOfMap

    /**
     * Methode nimmt die Auswahl des Nutzers auf und gibt das gewählte Labyrinth zurück
     *
     * @return des Labyrinths zum speichern im Array des Labyrinths
     */
    public static char[][] labyrinthwahl(char [][] labyrinth, int anzahlMachtFallen, int verzoegerung) {
        int wahlDesLabyrinths;      // Variable in der die Wahl des Labyrinths gespeichert wird
        boolean richtig = false;    // für die Schleife der Eingabeprüfung
        final char WAND = '#';      // Konstante Wand des Labyrinths
        final char AUSGANG = 'A';   // Variable für den Ausgang des Labyrinths
        final char START = 'S';     // Variable für den Start des Labyrinths
        final char WEG = ' ';       // Variable für den WEG des Labyrinths
        Scanner scanner = new Scanner(System.in);   // Scanner für die Eingabe

        while (true){
            try {
                System.out.print("Es stehen drei Labyrinthe zur Auswahl. Gib 1, 2 oder 3 ein, um ein Labyrinth zu wählen: ");
                wahlDesLabyrinths = scanner.nextInt();
                System.out.println("");
                break;
            } catch (InputMismatchException e) {
                String errorEingabe = scanner.next();
                System.out.println("Fehler: " + errorEingabe + " ist keine Zahl! Wiederholen Sie die Eingabe: ");
            }
        }

        // Auswahl des Labyrinths 1 bis 3
        switch(wahlDesLabyrinths) {
            case 1:
                labyrinth = new char[][]{
                        {WAND, WAND, WAND, WAND, WAND, AUSGANG, WAND, WAND, WAND, WAND, WAND},
                        {WAND, WEG, WEG, WEG, WAND, WEG, WEG, WEG, WEG, WEG, WAND},
                        {WAND, WAND, WEG, WAND, WAND, WEG, WAND, WEG, WAND, WEG, WAND},
                        {WAND, WEG, WEG, WAND, WEG, WEG, WAND, WEG, WAND, WEG, WAND},
                        {WAND, WEG, WEG, WEG, WEG, WEG, WAND, WEG, WAND, WEG, WAND},
                        {WAND, WEG, WAND, WEG, WAND, WEG, WAND, WEG, WEG, WEG, WAND},
                        {START, WEG, WAND, WEG, WAND, WAND, WAND, WEG, WAND, WEG, WAND},
                        {WAND, WEG, WAND, WEG, WEG, WEG, WAND, WEG, WAND, WEG, WAND},
                        {WAND, WEG, WAND, WAND, WAND, WEG, WAND, WEG, WEG, WEG, WAND},
                        {WAND, WAND, WAND, WEG, WAND, WAND, WAND, WAND, WAND, WAND, WAND}};
                labyrinth = dunkleMacht(labyrinth, anzahlMachtFallen);
                break;
            case 2:
                labyrinth = new char[][]{
                        {WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND},
                        {WAND, WEG, WEG, WEG, WAND, WEG, WEG, WEG, WEG, WEG, WEG, WEG, WEG, WEG, WAND, WAND},
                        {WAND, WAND, WEG, WAND, WAND, WEG, WAND, WEG, WAND, WEG, WAND, WEG, WAND, WEG, WEG, WAND},
                        {WAND, WEG, WEG, WAND, WEG, WEG, WAND, WEG, WAND, WEG, WAND, WEG, WAND, WEG, WAND, WAND},
                        {WAND, WEG, WEG, WEG, WEG, WEG, WAND, WEG, WAND, WEG, WAND, WEG, WAND, WEG, WEG, AUSGANG},
                        {WAND, WEG, WAND, WEG, WAND, WEG, WAND, WEG, WEG, WEG, WEG, WEG, WAND, WAND, WEG, WAND},
                        {START, WEG, WAND, WEG, WAND, WAND, WAND, WEG, WAND, WEG, WAND, WAND, WAND, WAND, WAND, WAND},
                        {WAND, WEG, WAND, WEG, WEG, WEG, WAND, WEG, WAND, WEG, WAND, WEG, WEG, WEG, WAND, WAND},
                        {WAND, WEG, WAND, WAND, WAND, WEG, WAND, WEG, WAND, WEG, WAND, WEG, WAND, WEG, WAND, WAND},
                        {WAND, WEG, WAND, WEG, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WEG, WAND, WEG, WEG, WAND},
                        {WAND, WEG, WAND, WEG, WAND, WAND, WAND, WEG, WEG, WEG, WEG, WEG, WAND, WEG, WAND, WAND},
                        {WAND, WEG, WAND, WEG, WEG, WEG, WEG, WAND, WEG, WAND, WEG, WEG, WAND, WEG, WAND, WAND},
                        {WAND, WEG, WEG, WEG, WAND, WAND, WEG, WEG, WEG, WAND, WAND, WAND, WEG, WEG, WEG, WAND},
                        {WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WAND}};
                labyrinth = dunkleMacht(labyrinth, anzahlMachtFallen);
                break;
            case 3:
                labyrinth = new char[][]{
                        {WAND, WAND, WEG, WEG, WEG, WEG, WAND, WAND, WAND, WEG, WEG, WEG, WEG, WAND, WAND},
                        {WAND, WEG, WEG, WEG, WEG, WAND, WEG, WEG, WEG, WAND, WEG, WEG, WEG, WEG, WAND},
                        {WEG, WEG, WEG, WEG, WAND, WEG, WEG, WAND, WEG, WEG, WAND, WEG, WEG, WEG, WEG},
                        {WEG, WEG, WEG, WAND, WEG, WEG, WAND, WAND, WAND, WEG, WEG, WAND, WEG, WEG, WEG},
                        {WEG, WEG, WAND, WEG, WEG, WAND, WEG, WAND, WEG, WAND, WEG, WEG, WAND, WEG, WEG},
                        {WAND, WAND, WEG, WEG, WAND, WEG, WEG, WAND, WEG, WEG, WAND, WEG, WEG, WAND, WAND},
                        {START, WEG, WEG, WAND, WEG, WAND, WAND, WAND, WAND, WAND, WAND, WAND, WEG, WEG, AUSGANG},
                        {WAND, WAND, WEG, WEG, WAND, WEG, WEG, WAND, WEG, WEG, WAND, WEG, WEG, WAND, WAND},
                        {WEG, WEG, WAND, WEG, WEG, WAND, WEG, WAND, WEG, WAND, WEG, WEG, WAND, WEG, WEG},
                        {WEG, WEG, WEG, WAND, WEG, WEG, WAND, WAND, WAND, WEG, WEG, WAND, WEG, WEG, WEG},
                        {WEG, WEG, WEG, WEG, WAND, WEG, WEG, WAND, WEG, WEG, WAND, WEG, WEG, WEG, WEG},
                        {WAND, WEG, WEG, WEG, WEG, WAND, WEG, WAND, WEG, WAND, WEG, WEG, WEG, WEG, WAND},
                        {WAND, WAND, WEG, WEG, WEG, WEG, WAND, WAND, WAND, WEG, WEG, WEG, WEG, WAND, WAND}};
                labyrinth = dunkleMacht(labyrinth, anzahlMachtFallen);
                break;
            default:
                System.out.println("Fehler! Gib eine Zahl zwischen 1 und 3 ein!");
                wahlDesLabyrinths = scanner.nextInt();
                break;
        }
        System.out.println("Die Dunkle Macht ist stark und hat " + anzahlMachtFallen + " dunkle Fallen platziert ");
        System.out.println("");
        wait(verzoegerung);
        wait(verzoegerung);
        return labyrinth;
    } // END labyrinthwahl

    /**
     * Methode, gibt eine Verzögerung nach jedem neuen Aufruf aus
     *
     * @param verzoegerung ist das char Array des Labyrinth
     */
    public static void wait(int verzoegerung) {
        try{
            Thread.sleep(verzoegerung);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }// END wait

    /**
     * Methode setzt dunkle Machtfallen in das Labyrinth, das den Bot zerstört, wenn er diese berührt
     * @param labyrinth ist das Hauptarray in dem das Labyrinth gespeichert wird
     * @param anzahlMachtFallen gibt die Anzahl der Fallen im Labyrinth an
     * @return gibt das manipulierte labyrinth zurück
     */
    public static char[][] dunkleMacht(char[][] labyrinth, int anzahlMachtFallen) {
        final char START = 'S';
        final char AUSGANG = 'A';
        final char WAND = '#';
        final char DUNKLEMACHT = 'D';
        boolean fallengesetzt = false;
        int abbruch = 0;

        while (!fallengesetzt && anzahlMachtFallen != abbruch) {
            int random1 = (int)(Math.random() * 10);
            int random2 = (int)(Math.random() * 10);

            if (labyrinth[random1][random2] == WAND || labyrinth[random1][random2] == START || labyrinth[random1][random2] == AUSGANG) {
                continue;
            } else {
                labyrinth[random1][random2] = DUNKLEMACHT;
                abbruch++;
            }
            if (abbruch == anzahlMachtFallen) {
                fallengesetzt = true;
            }
        }
        return labyrinth;
    }// END dunkleMacht

} // END CLASS