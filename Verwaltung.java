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
        meineGeräte [0] = new Netzwerkgerät("Lukas-Mac", "00:01:04:05:06:07" , "192.168.1.12", "Apfle") ;
        meineGeräte [1] = new Netzwerkgerät("Alex-Mac", "AA:BB:CC:DD:EE:FF", "192.168.1.24", "Apfle") ;
        meineGeräte [2] = new Netzwerkgerät("Wardemanns-Backdoor", "1d:c0:08:bf:8f:65", "8.8.8.8", "Windows") ;
        //lukas

        System.out.println("Schommal was von Kopfhörern gehört?");

    }
    public static void main(String[] args) {
        Verwaltung meineVerwaltung = new Verwaltung();
    }
}