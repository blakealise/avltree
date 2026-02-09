public class Main {

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(50);
        avlTree.insert(75);
        avlTree.insert(125);
        avlTree.insert(77);
        avlTree.insert(76);
        avlTree.delete(75);

        System.out.println("done");

    }
}
