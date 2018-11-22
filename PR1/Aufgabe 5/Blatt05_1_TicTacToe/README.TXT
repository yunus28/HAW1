Mögliche Enums:

Gewinner: OFFEN SP1 SP2 KEINER
Besitzer: KEINER SP1 SP2
Spieler : EINS ZWEI

zwei private Ops in GUI für Einführung von Enums relevant:

zeichenFuer(int besitzer)

beschriftungFuer(int spieler)

Die erste mit enum Besitzer unproblematisch zu ändern.

Die zweite wird für gewinner und spieler verwendet!
Kein Problem, wenn beides int ist.
Spieler ist eigentlich ein Subtyp von Gewinner.
Wenn einer von beiden ein Enum wird, muss das
berücksichtigt werden.

Weitere Details in den einzelnen Lösungen.