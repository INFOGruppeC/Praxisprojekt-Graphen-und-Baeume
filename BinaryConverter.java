public class BinaryConverter {
    public void convertStringToBinary(String pEingabe) {
        // Konstruktor
        String binary = "";
        for (int i = 0; i < pEingabe.length(); i++) {
            int val = pEingabe.charAt(i);
            binary += "";
            for (int j = 0; j < 8; j++) {
                binary += (val & 128) == 0 ? 0 : 1;
                val <<= 1;
            }
            binary += " ";
        }
        System.out.println(binary);

    }
    public BinaryConverter

}

