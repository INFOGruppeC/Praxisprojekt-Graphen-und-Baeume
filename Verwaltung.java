import abiturklassen.Graph;
import abiturklassen.List;
import abiturklassen.Vertex;
import abiturklassen.Edge;

// Praxisprojekt zu nicht linearen Datenstrukturen 

public class Verwaltung {
    /*
     * Funktionen
     * 1. Abfrage nach gewünstem Algorithmus über einen Binärbaum
     */
    Graph graph;
    BinaryConverter converter;

    public Verwaltung() {
        // Konstruktor
        graph = new Graph();
        converter = new BinaryConverter();
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

        System.out.println("Adding random latencys between " + devices.length + " devices");
        // Netzwerkverbindungen
        // Insert new network connections with this format: {"device1": "device2"}
        // Latency is generated randomly
        String connections[][] = {
                { "Lukas-Mac", "Alex-Mac" },
                { "Lukas-Mac", "Wardemanns-Backdoor" },
                { "Lukas-Mac", "Bastis-Thinkpad" },
                { "Lukas-Mac", "Lennarts-Surface" },
                { "Alex-Mac", "Wardemanns-Backdoor" },
                { "Alex-Mac", "Bastis-Thinkpad" },
                { "Alex-Mac", "Lennarts-Surface" },
                { "Wardemanns-Backdoor", "Bastis-Thinkpad" },
                { "Wardemanns-Backdoor", "Lennarts-Surface" },
                { "Bastis-Thinkpad", "Lennarts-Surface" }
        };
        for (int i = 0; i < connections.length; i++) {
            Edge edge = new Edge(graph.getVertex(connections[i][0]), graph.getVertex(connections[i][1]),
                    (int) (Math.random() * 100));
            graph.addEdge(edge);
        }

        BinaryConverter converter = new BinaryConverter();
        converter.convertStringToBinary("Bababui");

    }

    public void printAdjacencyList() {
        printAdjacencyList("");
    }

    public void printAdjacencyList(String weightUnit) {
        printAdjacencyList(graph, weightUnit);
    }

    public void printAdjacencyList(Graph graph, String weightUnit) {
        // String leftAlignFormat = "| %-15s | %-4d |%n";
        // System.out.format("+---------+------+%n");
        // String header = "| Knoten ";
        // List<Vertex> vertices = graph.getVertices();
        // vertices.toFirst();
        // while (vertices.hasAccess()) {
        //     Netzwerkgerät device = (Netzwerkgerät) vertices.getContent();
        //     header += " | " + device.getHostname();
        //     vertices.next();
        // }
        // System.out.format(header + "%n");
        // System.out.format("+---------+------+%n");
        // vertices.toFirst();
        // while (vertices.hasAccess()) {
        //     List<Vertex> geraete = graph.getVertices();
        //     geraete.toFirst();
        //     String weights = "";
        //     while (geraete.hasAccess()) {
        //         //weights += " | " + graph.getEdge(vertices.getContent(), geraete.getContent()).getWeight() + weightUnit;
        //         geraete.next();
        //     }
        //     System.out.format(leftAlignFormat, ((Netzwerkgerät) vertices.getContent()).getHostname(), weights);
        //     vertices.next();

        // }
        // System.out.format("+-----------------+------+%n");
        List<Vertex> vertices = graph.getVertices();
        String result = "";
        vertices.toFirst();
        while(vertices.hasAccess()){
            result += ((Netzwerkgerät)(vertices.getContent())).getHostname();
            // Iterate all connected devices and list them with their weight
            List<Vertex> temp = graph.getNeighbours(vertices.getContent());
            temp.toFirst();
            int length = 0;
            while(temp.hasAccess()){
                length++;
                temp.next();
            }
            result += " (Anzahl Nachbarn: " + length + ")";
            List<Vertex> connectedDevices = graph.getNeighbours(vertices.getContent());
            connectedDevices.toFirst();
            while(connectedDevices.hasAccess()){
                result += " -> " + ((Netzwerkgerät)(connectedDevices.getContent())).getHostname() + " (" + graph.getEdge(vertices.getContent(), connectedDevices.getContent()).getWeight() + weightUnit + ")";
                connectedDevices.next();
            }
            result += "\n";
            vertices.next();
        }
        System.out.println("Here we go, that's your network: ");
        System.out.println(result);
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
        verwaltung.printAdjacencyList("ms");
        verwaltung.sendeNachricht("Bababui", "Lennarts-Surface", "Lukas-Mac");
    }

    public void sendeNachricht(String pNachricht, String pEmpfaengerName, String pAbsenderName) {
        Netzwerkgerät empfaenger = (Netzwerkgerät) graph.getVertex(pEmpfaengerName);
        Netzwerkgerät absender = (Netzwerkgerät) graph.getVertex(pAbsenderName);

        String binary=converter.convertStringToBinary(pNachricht);

        // Dijkstra from absender to empfaenger
        List<Edge> pfad = new Dijkstra(graph, pAbsenderName, pEmpfaengerName).runDijkstra();

        List<Netzwerkgerät> pfad2 = new List<>();
        pfad.toFirst();
        while(pfad.hasAccess()) {
            if (pfad2.getContent() == null) {
                if (pfad.getContent().getVertices()[0].equals(absender))
                    pfad2.append((Netzwerkgerät)pfad.getContent().getVertices()[1]);
                else
                    pfad2.append((Netzwerkgerät)pfad.getContent().getVertices()[0]);
                    
                pfad.next();
                continue;
            }

            if (pfad2.getContent().equals((Netzwerkgerät)pfad.getContent().getVertices()[0])) {
                pfad2.append((Netzwerkgerät)pfad.getContent().getVertices()[1]);
            } else {
                pfad2.append((Netzwerkgerät)pfad.getContent().getVertices()[0]);
            }

            pfad.next();
        }
        absender.sendeNachrichtAn(binary, pfad2);
        
    }
}