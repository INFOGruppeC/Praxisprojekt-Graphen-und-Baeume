import abiturklassen.BinarySearchTree;
import abiturklassen.BinaryTree;
import abiturklassen.List;

public class BinaryConverter {
    public String convertStringToBinary(String pEingabe) {
        // Konstruktor
        String binary = "";
        for (int i = 0; i < pEingabe.length(); i++) {
            int val = pEingabe.charAt(i);
            binary += "";
            for (int j = 0; j < 8; j++) {
                binary += (val & 128) == 0 ? 0 : 1;
                val <<= 1;
            }
            // binary += " ";
        }
        return binary;
    }

    public String binaryToString(String pBinaer) {
        List<String> blocks = new List<String>();
        for (int i = 0; i < (int) (pBinaer.length() / 8); i++) {
            String block = pBinaer.substring(i * 8, (i + 1) * 8);
            blocks.append(block);
        }
        String nonBinary = "";
        blocks.toFirst();

        while (blocks.hasAccess()) {
            BinaryTree<String> tree = createTree();
            String block = blocks.getContent();
            for (int i = 0; i < block.length(); i++) {
                if (block.charAt(i) == '0') {
                    tree = tree.getLeftTree();
                } else if (block.charAt(i) == '1') {
                    tree = tree.getRightTree();
                }
            }

            nonBinary += tree.getContent();
            blocks.next();
        }
        return nonBinary;

    }

    BinarySearchTree<Zeichenkette> tree = new BinarySearchTree<Zeichenkette>();

    private BinaryTree<String> createTree() {
        return new BinaryTree<String>("", createNode(true, 0, ""), createNode(false, 0, ""));
    }

    private BinaryTree<String> createNode(boolean isLeft, int depth, String binaryContent) {
        if (depth == 7) {
            char c = (char) Integer.parseInt(binaryContent, 2);
            return new BinaryTree<String>(String.valueOf(c));

        } else {
            BinaryTree<String> left = createNode(true, depth + 1, binaryContent + "0");
            BinaryTree<String> right = createNode(false, depth + 1, binaryContent + "1");
            return new BinaryTree<String>(isLeft ? "0" : "1", left, right);
        }

    }

    public static void main(String[] args) {
        BinaryConverter bn = new BinaryConverter();
        String lol = bn.convertStringToBinary("Man bitte, die Scheisse soll einfach mal klappen mehr will ich doch garnicht");
        System.out.println(lol);
        System.out.println("--------------------------------------------------");
        System.out.println(bn.binaryToString(lol));
    }

}
