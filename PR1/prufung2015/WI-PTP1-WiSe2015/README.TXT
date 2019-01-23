Laborprüfung zu WI-PRP1, WiSe 2015/2016
========================================

Vorbereitung: Am besten BlueJ einmal umstellen auf die deutsche Oberfläche,
falls nicht bereits geschehen.

Die Prüfung besteht aus vier Teilaufgaben. Es empfiehlt sich, die
Aufgaben in der genannten Reihenfolge zu bearbeiten. Zu jeder Aufgabe
gibt es eine Testklasse, die euch Feedback darüber gibt, ob eure 
Implementation vollständig ist. Die Implementationen werden auch 
bewertet, wenn sie nur einen Teil der Tests erfolgreich bestehen.
Es ist also möglicherweise besser, zur nächsten Aufgabe zu wechseln, 
wenn eine Teilaufgabe im Detail zu viel Zeit kostet.


Aufgabe 1: Implementiere die Rümpfe der Methoden in der Klasse 
ServiceMixImpl.

Hinweise:
Setze als erstes Deinen Namen und Deine Matrikelnummer hinter das
@author-Tag.
In dieser Klasse muss nicht auf null-Parameter geprüft werden.
Die Methode enthaeltZiffer soll rekursiv bleiben und lediglich
so umgeschrieben werden, dass sie nur eine return-Anweisung enthält.
Die Methode nurVokale soll rekursiv implementiert werden.


Aufgabe 2: Implementiere eine Klasse GeldboerseImpl, die das Interface
Geldboerse implementiert.

Hinweise:
Unbedingt darauf achten, dass die neue Klasse genauso heißt wie hier 
vorgegeben.
Setze Deinen Namen und Deine Matrikelnummer hinter das @author-Tag.
Die Klasse muss einen parameterlosen Konstruktor anbieten.
Die Testklasse enthält Positiv- und Negativtests. Wenn explizit 
spezifiziert ist, dass eine Exception geworfen werden soll, wird dies 
auch überprüft.

Tipps:
Im Doku-Ordner stehen Folien zu Enums in Java.
Die Operationen zum Einstecken sind leichter als die zum Entnehmen.
die Operationen ohne Sammlungen als Parameter sind einfacher als die mit 
Sammlungen.
Die Methode geldPassendVorhanden ist anspruchsvoll - nicht zu viel Zeit 
mit der Implementierung verbringen und lieber zur nächsten Aufgabe!


Aufgabe 3: In dieser Aufgabe geht es um Zuege, die aus Zugelementen
(einer Lokomotive und beliebig vielen Waggons) bestehen.
Unter einem Zugteil wird im Folgenden ein beliebiger zusammenhaengender
Teil eines Zuges verstanden, der aus mindestens einem Zugelement besteht.

Implementiere eine Klasse Lokomotive, die das Interface KannEtwasAnhaengen
implementiert. Die Klasse muss einen parameterlosen Konstruktor anbieten.

Implementiere eine Klasse Waggon, die die beiden Interfaces
KannEtwasAnhaengen und Anhaengbar implementiert. Ein Waggon soll bei
seiner Erzeugung die Anzahl der Passagiere erhalten, die in genau
diesem Waggon sitzen.

Wenn beide Klassen ihre Interfaces korrekt implementieren, kann für 
einen Zug (bestehend aus einer Lok und beliebig vielen Waggons) die
Anzahl der Zugelemente und der Passagiere im gesamten Zug ermittelt werden.

Hinweise:
Unbedingt darauf achten, dass die neuen Klassen genauso heißen wie hier
vorgegeben.
Setze Deinen Namen und Deine Matrikelnummer hinter das @author-Tag.
Die Klasse Lokomotive muss einen parameterlosen Konstruktor anbieten,
der public ist.


Aufgabe 4: Implementiere das Interface ServiceMix2 mit einer Klasse
ServiceMix2Impl. Die Klasse muss einen parameterlosen Konstruktor anbieten,
der public ist.

Hinweise:
Unbedingt darauf achten, dass die neue Klasse genauso heißt wie hier
vorgegeben.
Setze Deinen Namen und Deine Matrikelnummer hinter das @author-Tag.

