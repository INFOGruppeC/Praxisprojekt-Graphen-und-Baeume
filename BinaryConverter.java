import java.util.Map;
import stopwatch;
import java.security.Key;

import abiturklassen.BinarySearchTree;
import abiturklassen.BinaryTree;

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
    BinarySearchTree<Zeichenkette> tree = new BinarySearchTree<Zeichenkette>();
    public void convertBinaryToString(String pEingabe) {
        // Konstruktor
        // split the pEingabe into 8 bit blocks which arent seperated by spaces
        String[] blocks = pEingabe.split(" ");
        String binary = "";

       for(String block : blocks){
              binary = block;
              
       }
k
    }

    

    private BinaryTree<String> createTree() {
        return new BinaryTree<String>("", createNode(true, 0, ""), createNode(false, 0, ""));
    }

    private BinaryTree<String> createNode(boolean isLeft, int depth, String binaryContent) {
        if (depth == 8) {
            char c = (char) Integer.parseInt(binaryContent, 2);
            return new BinaryTree<String>(String.valueOf(c));
        } else {
            BinaryTree<String> left = createNode(true, depth + 1, binaryContent + "0");
            BinaryTree<String> right = createNode(false, depth + 1, binaryContent + "1");
            return new BinaryTree<String>(isLeft ? "0" : "1", left, right);
        }
        
    }


}
