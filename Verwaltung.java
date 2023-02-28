import abiturklassen.Graph;

// Praxisprojekt zu nicht linearen Datenstrukturen 

public class Verwaltung {
    /*
     * Funktionen
     * 1. Abfrage nach gewünstem Algorithmus über einen Binärbaum
     */
    public Verwaltung() {
        // Konstruktor
        Graph graph = new Graph();
        // Netzwerkgeräte
        // Insert new network devices with this format: {"hostname": "vendor"}
        // IP and MAC address are generated randomly / iterative
        String devices[][] = {
                { "Lukas-Mac", "Apfle" },
                { "Alex-Mac", "Apfle" },
                { "Wardemanns-Backdoor", "Microsoft" },
                { "Bastis-Thinkpad", "Lenovo" },
                { "Lennarts-Surface", "Minimalsoft" }
        };
        System.out.println("Adding " + devices.length + " devices to Graph");
        for (int i = 0; i < devices.length; i++) {
            graph.addVertex(
                    new Netzwerkgerät(devices[i][0], generateRandomMac(), "192.168.1." + (i + 1), devices[i][1]));
        }

        BinaryConverter converter = new BinaryConverter();
        converter.convertStringToBinary("Bababui");

    }

    public String getAdjacencyMatrix() {
        return getAdjacencyMatrix("");
    }

    public String getAdjacencyMatrix(String weightUnit) {
        return "";
    }

    private String generateRandomMac() {
        String mac = "";
        for (int i = 0; i < 6; i++) {
            mac += Integer.toHexString((int) (Math.random() * 16));
        }
        return mac;
    }

    public static void main(String[] args) {
        Verwaltung verwaltung = new Verwaltung();
        System.out.print("Das ist das Netzwerk: ");
        System.out.println(verwaltung.getAdjacencyMatrix());
    }
}