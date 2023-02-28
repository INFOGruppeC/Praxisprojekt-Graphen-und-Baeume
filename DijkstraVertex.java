import java.io.Serializable;

import abiturklassen.Vertex;

/**
 * Die Klasse DijkstraVertex ergaenzt die Klasse Vertex um Atribute.
 */

public class DijkstraVertex
        extends Vertex
        implements Serializable {
    private double distanz = -1.0;
    private DijkstraVertex vorgaenger = null;
    private int zustand = 0;
    private String name;

    /**
     * Erstellt ein neues Objekt der Klasse DijkstraVertex.
     * 
     * @param pID  die Id unter der der Knoten (hier: Stadt) in der Datenbank
     *             gespeichert wird
     * @param name Name der Stadt
     */
    public DijkstraVertex(String pID, String name) {
        super(pID);
        this.name = name;
    }

    /**
     * Liefert den Namen des Knotens.
     * 
     * @return den Namen des Knotens als String
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Zustand des Knotens.
     * 
     * @param pZustand Zustand des Knotens als int
     */
    public void setzeZustand(int pZustand) {
        this.zustand = pZustand;
    }

    /**
     * Liefert den Zustand des Knotens.
     * 
     * @return den Zustand des Knotens als int
     */
    public int gibZustand() {
        return this.zustand;
    }

    /**
     * Liefert die Distanz, die fuer den Knoten festgelegt ist.
     * 
     * @return die Distanz zum Knotens als double
     */
    public double gibDistanz() {
        return this.distanz;
    }

    /**
     * Setzt die Distanz vom Knoten zum Startknoten (durch Dijkstra erstellt).
     * 
     * @param pDistanz zum Knoten als double
     */
    public void setzeDistanz(double pDistanz) {
        this.distanz = pDistanz;
    }

    /**
     * Liefert den Vorgaengerknoten des aktuellen Knotens.
     * 
     * @return Vorgaengerknoten als DijkstraVertex
     */
    public DijkstraVertex gibVorgaenger() {
        return this.vorgaenger;
    }

    /**
     * Setzt den Vorgaenerknoten des aktuellen Knotens.
     *
     * @param pVorgaenger der Vorgaengerknoten als DijkstraVertex
     */
    public void setzeVorgaenger(DijkstraVertex pVorgaenger) {
        this.vorgaenger = pVorgaenger;
    }
}
