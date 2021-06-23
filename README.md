# SWE

## How to start
1. Clonen Sie das Repository oder laden Sie es als Zip-Datei herunter
2. Gehen Sie in den Ordner SWE
3. Öffnen Sie ein Terminal im Ordner SWE
4. Geben Sie Folgendes in die Console ein: `java -jar SWE.jar`
5. Schauen Sie bei Workflow um die Verwendung und Nutzung der Applikation nachzuvollziehen 


## Workflow

1. Starte die Applikation mit dem Ausführen der Main
2. Wählen Sie in der GUI über den Button "Load Data" ein Satelliten-File aus, dass geladen werden soll.
3. Wählen Sie ein Filteraggregat über den Explorer aus
3.1. Gehen Sie dazu in den SWE Projektordner <br />
3.2. Gehen Sie dann in den `FilterViewAggregat` Ordner <br />
3.3. Wählen Sie eine Klasse Ihrer Wahl aus<br />
4. Wählen Sie eine output-Variante aus<br />
4.1. Gehen Sie dazu in den SWE Projektordner <br />
4.2. Gehen Sie dann in den `OutputAggregat` Ordner
4.3. Wäheln Sie eine Klasse ihrer Wahl aus<br />
  (Wichtig: Bei der Ausgabe in der GUI sind zu große Datenmengen nicht anzeigbar da der Buffer von Java dafür zu klein ist. Wählen Sie dann JSON-Ausgabe [Bei Absturz muss der Prozess von vorne durchlaufen werden])<br />
5. Drücken Sie den Button Filter<br />
6. Drücken Sie den Button Save/Show<br />
    7.1 Beim Speichern im JSON-Format öffnet sich der File-Explorer wählen Sie den Speicherort und den Namen aus
    7.2 Bei der Ausgabe auf dem Display erscheint ein Pop-Up-Window

Ihr Ergebnis sollte jetzt je nach Output Methode als Datei vorliegen sein oder angezeigt werden

## Output-Aggregat
 Es liegen zwei mögliche Output-Aggregate vor
  1. Ausgabe in der GUI
  2. Ausgabe in ein JSON-File
Bei der Ausgabe in der GUI keine großen Filterergebnisse benutzen --> Nutzen Sie das Filter/View-Aggregat `SatellitTransponderAggregat.class` -> Kleines Filterergebnis

Es können variabel neue Aggregate erstellt werden, diese müssen einen BiConsumer implementieren welcher den JSON-String und das JFrame-Fenster für mögliche Anzeigen entgegennimmt.

## Filter/View-Aggregat
Es liegen zwei Filter vor:

1. Ein Filter der nach TV und HD Sendern filtert und dann die Ergebnisse in der View-Form: Satellit->Channel ausgibt
2. Ein Filter der nach dem Satellit "Eutelsat 3B" filtert,
    danach nach dem Transponder mit der Frequenz 4034HZ
    und das in der View-Form Satellit->Transponder->Channel ausgibt

Es können variabel neue Aggregate erstellt werden, diese müssen einen Supplier für Aggregate implementieren, welcher je nach ausgewählter Klasse das enthaltene Aggregat zurückgibt.

## Zusätzliche Informationen

Die Information welcher Sprache die Sender sind kann dem JSON nicht entnommen werden.

Teilnehmer: 4328112, 1319658, 1060449

