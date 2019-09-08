# Bowling

Dieses Programm berechnet die Gesamtsumme eines Bowlingspiels anhand
der vom Spieler erzielten Punktzahlen einzelner Würfe.

Ziel ist _nicht_ die Ausgabe des Spielplans bzw. der Zwischenschritte.

## Ausführen des Programms

Das Programm kann durch `./gradlew --console=plain clean run` im Hauptverzeichnis
ausgeführt werden.

Die Anzahl der Würfe werden nacheinander auf Anforderung eingegeben und
mit der Eingabetaste bestätigt.

Die Zahlenfolge aus der Aufgabe lautet:

```
1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6
```

Das Ergebnis ist `133`.

Es dürfen nur die tatsächlichen Würfe eingegeben werden. Dies betrifft
insbesondere das 10. Frame. Wird in diesem Frame kein Spare oder Strike
geworfen, können gemäß der Regeln nur zwei Würfe ausgeführt werden.

## Ausführen der Tests

Die gesamte Test-Suit kann mittels `./gradlew clean test` im 
Hauptverzeichnis ausgeführt werden.

Die Klasse `de.roamingthings.bowling.SystemTests` enthält verschiedene
Testfälle, die gesamte Spiele abbildet.

## Verwendete Sprache

Da die meisten Fachbegriffe englisch sind, habe ich mich für englische
Variablenbezeichnungen entschieden.

## Regeln

* Pro Wurf (_Roll_) müssen wenigstens 0 Punkte erreicht werden.
* Pro Wurf können maximal 10 Punkte erreicht werden.
* Ein Spiel besteht aus 10 _Frames_
* Für die Frames 1-9 gilt:
  * Es können maximal zwei Würfe ausgeführt werden.
  * Die maximal zu erreichende Punktzahl aus den Würfe eines Frames ist 10.
* Ein _Spare_ liegt vor, wenn die Summe der Punktzahlen beider Würfe eines Frames den Wert  10 erreicht.
* Ein _Strike_ liegt vor, wenn mit einem Wurf zehn Punkt erreicht werden. 
* Für das 10. Frame gilt:
  * Wird mit dem ersten oder zweiten Wurf ein Spare oder Strike erreicht,
  wird ein dritter Wurf ausgeführt
  * Es ist möglich, dass mehrere Strikes geworfen werden.
* Die Punktzahl eines Frames berechnet sich wie folgt:
  * Punktzahl des vorherigen Frames. Im Falle des ersten Frames wird 0 verwendet.
  * Punktzahl der Würfe des Frames.
  * Bei einem Spare Punktzahl des nächsten Wurfs, auch wenn dieser
  sich im nächsten Frame befindet.
  * Bei einem Strike Punktzahl der nächsten beiden Würfe, auch wenn sich
  diese im nächsten und übernächsten Frame befinden.
 
