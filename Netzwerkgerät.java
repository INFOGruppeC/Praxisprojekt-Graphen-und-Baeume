import lombok.Data;

@Data
public class Netzwerkgerät extends Vertex {

    public String hostname, macAdress, ip, vendor;

    public Netzwerkgerät(String pHostname, String pMacAdress, String pIp, String pVendor) {
        // Konstruktor
        super(pHostname);
        hostname = pHostname;
        macAdress = pMacAdress;
        ip = pIp;
        vendor = pVendor;

    }

}
