import abiturklassen.*;

/**
 * Die Klasse Dijkstra findet die kuertseste Verbindung zwischen zwei Knoten
 * eines Graphen,
 * unter Beruecksichtigung der Gewichtung der verbindenden Kanten.
 */
public class Dijkstra {
    private Graph graph;
    private String startKnoten;
    private String zielKnoten;

    /**
     * Ein Objekt der Klasse Dijkstra wird erzeugt.
     *
     * @param pGraph der Graph, in welchem nach einer Verbindung gesucht wird, im
     *               Format Graph
     * @param pStart der Startknoten der gesuchten Strecke als String
     * @param pZiel  der Endknoten der gesuchten Strecke als String
     */
    public Dijkstra(Graph pGraph, String pStart, String pZiel) {
        this.graph = pGraph;
        this.startKnoten = pStart;
        this.zielKnoten = pZiel;
    }

    /**
     * Die Distanz aller Knoten vom Startknoten, sowie die Vorgaengerknoten und die
     * Makierung werden
     * zurueck gesetzt.
     *
     * @param pGraph der Graph, der die Knoten enthaelt
     */
    public void zuruecksetzenDijkstraVertices(Graph pGraph) {
        List<Vertex> knoten = pGraph.getVertices();
        while (knoten.hasAccess()) {
            DijkstraVertex djk = (DijkstraVertex) knoten.getContent();
            djk.setzeDistanz(-1.0);
            ((DijkstraVertex) knoten.getContent()).setzeVorgaenger(null);
            ((DijkstraVertex) knoten.getContent()).setMark(false);
            knoten.next();
        }
    }

    /**
     * Es wird die Distanz jedes Knotens vom Startknoten berechnet und an diesen
     * angeheftet.
     * Jeder Knoten, zu dem schon die Distanz ermittelt wurde, wird makiert.
     *
     * @param pGraph      der Graph, in welchem die Verbindung gesucht wird, im
     *                    Format Graph
     * @param startKnoten der Startknoten, vom welchem aus die Distanz berechnt
     *                    wird, im Format DijkstraVertex
     */
    public void berechneDijkstra(Graph pGraph, DijkstraVertex startKnoten) {
        this.zuruecksetzenDijkstraVertices(pGraph);
        List<DijkstraVertex> aktuelleKnoten = new List<DijkstraVertex>();
        aktuelleKnoten.append(startKnoten);
        startKnoten.setzeDistanz(0.0);
        while (!aktuelleKnoten.isEmpty()) {
            aktuelleKnoten.toFirst();
            DijkstraVertex aktuell = (DijkstraVertex) aktuelleKnoten.getContent();
            while (aktuelleKnoten.hasAccess()) {
                if (((DijkstraVertex) aktuelleKnoten.getContent()).gibDistanz() < aktuell.gibDistanz()) {
                    aktuell = (DijkstraVertex) aktuelleKnoten.getContent();
                }
                aktuelleKnoten.next();
            }
            List<Vertex> nachbarn = pGraph.getNeighbours(aktuell);
            nachbarn.toFirst();
            while (nachbarn.hasAccess()) {
                DijkstraVertex nachbar = (DijkstraVertex) nachbarn.getContent();
                if (!nachbar.isMarked()) {
                    aktuelleKnoten.append(nachbar);
                    Edge kante = pGraph.getEdge(aktuell, nachbar);
                    if (nachbar.gibDistanz() == -1.0
                            || aktuell.gibDistanz() + kante.getWeight() < nachbar.gibDistanz()) {
                        nachbar.setzeDistanz(aktuell.gibDistanz() + kante.getWeight());
                        nachbar.setzeVorgaenger(aktuell);
                    }
                }
                nachbarn.next();
            }
            aktuelleKnoten.toFirst();
            while (aktuelleKnoten.hasAccess()) {
                if (aktuelleKnoten.getContent() == aktuell) {
                    aktuelleKnoten.remove();
                }
                aktuelleKnoten.next();
            }
            aktuell.setMark(true);
        }
    }

    /**
     * Ein Dijkstra-Algorithmus wird gestartet, welcher die Kanten
     *
     * @return eine Liste aller Kanten als Objekte der Klasse DijkstraEdge als Lists
     */
    public List<Edge> runDijkstra() {
        List<Edge> verbindungen = new List<>();
        /* DijkstraVertex zk; */
        Vertex peter = this.graph.getVertex(this.startKnoten);
        System.out.println("Starte Dijkstra...");
        DijkstraVertex sk = (DijkstraVertex) peter;
        this.berechneDijkstra(this.graph, sk);
        DijkstraVertex alt = /* zk = */(DijkstraVertex) this.graph.getVertex(this.zielKnoten);
        while (alt != sk) {
            DijkstraVertex vorgaenger = alt.gibVorgaenger();
            Edge kante = this.graph.getEdge(vorgaenger, alt);
            verbindungen.append(kante);
            if (kante == null) {
                System.err.println(
                        "Mission impossible - Es wurde keine Verbindung zwischen diesen Knoten gefunden! Sag es nicht Tom Cruise...");
                System.exit(0);
            }
            kante.setMark(true);
            alt = vorgaenger;
        }
        this.graph.setAllVertexMarks(false);
        return verbindungen;
    }
}
