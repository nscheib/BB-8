Dieses Repo clonen:  `git clone git@github.com:ccclausen/BB-8.git`

#### Programmieren 1 - Stehgreifprojekt 2
![](https://github.com/ccclausen/BB-8/blob/master/bb8.jpg)



Array - labyrinth [Zeile][Spalte] ([] -> zeigt die Dimension)

Var:

Karte für Ausgabe
Blickrichtung U+02C2 , U+02C3 , U+02C4 , U+02C5 (Blickrichtung in Unicode)
BotPosition [boty][botx]
AusgangGefunden
Eingang
Schleife (!ausgangGefunden){ Prüfung wo es hingeht: botPosition [x][y] wenn ^ prüfe [botx][boty+1]; wenn > prüfe [botx+1][boty]; wenn unten prüfe [botx][boty-1]; wenn < prüfe [botx-1][boty]; Karte[boty][botx] (Speichern der Blickrichtung)

laufen: wenn wandRechts dann gerade aus weiter wenn keineWandRechts dann laufe rechts blickrichtung anpassen

PrüfungAusgang: karte[botx][boty] == 'A' AusgangGefunden = true; }




# BB-8
### BB-8 / Aufgabe

BB-8 hat sich auf den Weg gemacht, um seinen Freund R2-D2
zu suchen. Dummerweise hat er sich verlaufen und sucht
nun nach dem Ausgang.

Sie als Medieninformatikerin bzw. Medieninformatiker
können ihm natürlich helfen, indem Sie ihm beibringen
durch ein Labyrinth zu laufen, so dass er immer den Ausgang
findet.

#### Schreiben Sie ein Java-Programm, das ein zweidimensionales Labyrinth verwaltet und BB-8 den Weg durch das Labyrinth suchen lässt.

- Verwenden Sie für die Lösung ein zweidimensionales Array mit geeignetem Datentyp, in dem
  die Wände des Labyrinths, die Startposition von BB-8 und der Ausgang platziert werden.
  Zusätzlich hat BB-8 noch eine weitere Karte, in der er sich immer merken kann, wo er bereits war
  und was er an dieser Stelle gemacht hat.
- Um den Weg zu finden, verwendet BB-8 die von Ihnen programmierte Strategie der Rechten-
  Hand-Regel.
- BB-8 soll nach dieser Strategie Schritt für Schritt gehen, so dass man seine Suche nachvollziehen
  kann. Sobald BB-8 das Ziel erreicht hat, soll sein Weg in die Freiheit dargestellt werden.
  
### BB-8 / Rechte-Hand-Regel

- Die Rechte-Hand-Regel ist die wohl bekannteste Regel, um
  aus einem Labyrinth zu kommen. Hierbei versucht man
  sich immer mit der rechten Hand an der Wand entlang zu
  tasten. D.h. sobald man rechts abbiegen kann, macht man
  dies auch.
- Soweit die Mauern zusammenhängen und die
  Außenwände geschlossen sind, kommt man mit diesem
  Prinzip an den Ausgang.
- Um BB-8 dieses Vorgehen zu ermöglichen, muss er natürlich immer eine Blickrichtung besitzen,
  so dass er auch immer weiß, ob er rechts eine Wand hat oder ob er seine Richtung ändern muss,
  um der Wand zu folgen.
- Am Anfang soll BB-8 immer eine Position und Ausrichtung innerhalb des Labyrinths besitzen
- Selbstverständlich hat das Labyrinth einen Ausgang, zu dem es auch einen oder mehrere Wege
  gibt, so dass BB-8 auch eine Change hat den Ausgang zu finden.
- BB-8 zählt die Schritte, die er gebraucht hat mit, um hinterher von seinem Erfolg – den Weg in x
  Schritten gefunden zu haben – erzählen zu können.
- Zusätzlich merkt er sich alle Stellen, an denen er vorbeigekommen ist, in einer eigenen Karte.
  Am Ausgang angekommen, kann er dann gleich von seinem zurückgelegten Weg berichten.

### BB-8 / Labyrinth
#### Auswahl von Labyrinthen

- BB-8 soll als Spezialist für Labyrinthe natürlich durch unterschiedliche Labyrinthe laufen können.
  Daher sollen in dem Programm neben dem vorgegebenen Labyrinth zwei weitere frei durch Sie
  zu definierende Labyrinthe definiert werden, die unterschiedlich groß sein sollen.
- Der Nutzer hat am Anfang des Programms die Möglichkeit, eines der angebotenen Labyrinthe
  auszuwählen.

#### Kodierung / Labyrinth

- Alle Labyrinthe sind durch eine einheitliche Kodierung beschrieben, so dass beliebige
  Labyrinthe definiert werden können. Neben den Wänden mit ´.´ werden die Startposition von
  BB-8 mit ´B´ und der Ausgang des Labyrinths mit ´A´ als Zeichen kodiert.
- Zu Beginn des Programms muss somit zunächst die Position von BB-8 aus der Labyrinth-
  Definition ermittelt werden, damit er dann Schritt für Schritt weitergehen kann. Auch den
  Ausgang kann man entsprechend aus der Karte lesen oder bei jedem Schritt überprüfen, ob
  man den Ausgang gefunden hat.
  
#### Kodierung / Laufweg

- Um den Laufweg von BB-8 auch noch am Ende nachvollziehen zu können, soll BB-8 seinen Weg
  Schritt für Schritt in einer zweiten Karte (Array) markieren. Hierbei soll seine jeweilige
  Laufrichtung, die seiner aktuellen Blickrichtung entspricht, festgehalten werden.
- Die Blickrichtung von BB-8 soll durch die Zeichen ^, >, v, < dargestellt werden.

### BB-8 / Anzeige

- Das Labyrinth soll nach jedem Schritt von BB-8 angezeigt werden, so dass man den Weg von BB-8
  verfolgen kann. Die Blickrichtung von BB-8 soll durch die Zeichen ^, >, v, < dargestellt werden.
- Sobald BB-8 den Ausgang gefunden hat, hat er natürlich viel über seine Abenteuer zu erzählen
  und berichtet von seinem Weg durch das Labyrinth, indem er seine protokollierte Karte vorzeigt.
  
### BB-08 / Verzögerung

- Um die Suche des Ausgangs etwas zu animieren, können Sie in Ihrer Schleife eine kleine
  Verzögerung einbauen. Wenn Sie diese Verzögerung um n Millisekunden am Ende der Schleife
  platzieren, gibt es jeweils eine entsprechende Verzögerung bevor der nächste Schritt von BB-8
  berechnet und angezeigt wird.
```java
try {
Thread.sleep(250);
} catch (InterruptedException e) {
e.printStackTrace();
}
```

- Alternativ können Sie selbstverständlich auch auf eine Benutzereingabe warten, um den
  nächsten Schritt zu berechnen.
