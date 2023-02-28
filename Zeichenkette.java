import abiturklassen.ComparableContent;
import lombok.Data;

@Data
public class Zeichenkette implements ComparableContent<Zeichenkette> {
    String eingabe;

    public Zeichenkette(String pEingabe) {
        // Konstruktor
        eingabe = pEingabe;
    }

    @Override
    public boolean isEqual(Zeichenkette pContent) {
        return pContent.getEingabe().equals(eingabe);
    }

    @Override
    public boolean isGreater(Zeichenkette pContent) {
        return pContent.getEingabe().compareTo(eingabe) > 0;
    }

    @Override
    public boolean isLess(Zeichenkette pContent) {
        return pContent.getEingabe().compareTo(eingabe) < 0;
    }
}