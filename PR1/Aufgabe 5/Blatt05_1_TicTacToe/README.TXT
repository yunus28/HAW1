M�gliche Enums:

Gewinner: OFFEN SP1 SP2 KEINER
Besitzer: KEINER SP1 SP2
Spieler : EINS ZWEI

zwei private Ops in GUI f�r Einf�hrung von Enums relevant:

zeichenFuer(int besitzer)

beschriftungFuer(int spieler)

Die erste mit enum Besitzer unproblematisch zu �ndern.

Die zweite wird f�r gewinner und spieler verwendet!
Kein Problem, wenn beides int ist.
Spieler ist eigentlich ein Subtyp von Gewinner.
Wenn einer von beiden ein Enum wird, muss das
ber�cksichtigt werden.

Weitere Details in den einzelnen L�sungen.