import abiturklassen.Vertex;
import abiturklassen.List;
import lombok.Data;

@Data
public class Netzwerkgerät extends Vertex {

    public String hostname, macAdress, ip, vendor;
    private BinaryConverter converter;

    //Konstruktor
    public Netzwerkgerät(String pHostname, String pMacAdress, String pIp, String pVendor) {
        // Konstruktor

        super(pHostname);
        hostname = pHostname;
        macAdress = pMacAdress;
        ip = pIp;
        vendor = pVendor;

    }
    
    /**
     * Senden an einer Nachicht das nächste Element der Liste an Netzwerkgeräten 
     * 
     *
     * @param pGraph      der Graph, in welchem die Verbindung gesucht wird, im
     *                    Format Graph
     * @param startKnoten der Startknoten, vom welchem aus die Distanz berechnt
     *                    wird, im Format DijkstraVertex
     */
    public void sendeNachrichtAn(String pNachicht, List<Netzwerkgerät> pWegKnoten) {
        if(pWegKnoten.hasAccess()){
            
            Netzwerkgerät ziel=pWegKnoten.getContent();
            pWegKnoten.remove();
            pWegKnoten.toFirst();// optional
            ziel.sendeNachrichtAn(pNachicht, pWegKnoten);
        }else{
            System.out.println("Gerät "+hostname+" had die Nachricht empfangen");
            System.out.println(converter.binaryToString(pNachicht));
        }

    }

}
