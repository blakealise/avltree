public class Main {

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(50);
        avlTree.insert(75);
        avlTree.insert(125);
        avlTree.insert(77);
        avlTree.insert(76);
        avlTree.insert(79);
        avlTree.insert(120);
        System.out.println("Max is: " + avlTree.getMax());
        System.out.println("Min is: " + avlTree.getMin());

        avlTree.insert(8);


        System.out.println(avlTree.getSize());


    }
}
