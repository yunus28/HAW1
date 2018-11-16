
class Klient
{
    public void benutzeFahrzeug()
    {
        Chassis c1 = new Chassis(42);
        Chassis c2 = new Chassis(1000);
        Motor m1 = new Motor(true);
        Motor m2 = new Motor(true);
        
        Fahrzeug f1 = new Fahrzeug(c1,m2);
        Fahrzeug f2 = new Fahrzeug(c2,m2);
        
        f1.naechsteFarbe();
        f2.naechsteFarbe();
        f2.zuendungstasteDruecken();
        
        int farbe1 = f1.gibFarbe();
        int farbe2 = f2.gibFarbe();
        boolean faehrt1 = f1.laeuft();
        boolean faehrt2 = f2.laeuft();
    }    
}
