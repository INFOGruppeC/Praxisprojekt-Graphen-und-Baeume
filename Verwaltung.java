// Praxisprojekt zu nicht linearen Datenstrukturen 


public class Verwaltung {
    /* Funktionen 
     * 1. Abfrage nach gewünstem Algorithmus über einen Binärbaum 
     */
    public Verwaltung(){
        // Konstruktor
        Graph graph = new Graph ();
        Netzwerkgerät meineGeräte [] = new Netzwerkgerät [10];
        // Netzwerkgerät 1  
        meineGeräte [0] = new Netzwerkgerät("Lukas-Mac", "00:22:3c:45:86", "192.168.1.1", "Apfle") ;
        meineGeräte [1] = new Netzwerkgerät("Alex-Mac", null, "192.168.1.2", "Apfle") ;
        meineGeräte [2] = new Netzwerkgerät("Wardemanns-Backdoor", null, "192.168.1.3", "Microsoft") ;
        meineGeräte [3] = new Netzwerkgerät("Bastis-Thinkpad", null, "192.168.1.4", "Lenovo") ;
        meineGeräte [4] = new Netzwerkgerät("Lennarts-Surface", null, "192.168.1.5", "Minimalsoft") ;
        //lukas

    }
}  