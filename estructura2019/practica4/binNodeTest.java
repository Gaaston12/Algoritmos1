public class binNodeTest{
    public static void main(String[] args) {
        binNode<Character> n = new binNode<Character>('H');
        n.insert('D');
        n.insert('L');
        n.insert('B');
        n.insert('F');
        n.insert('J');
        n.insert('M');
        n.insert('A');
        n.insert('C');
        n.insert('G');
        n.insert('I');
        n.insert('K');
        n.insert('N');

        n.inOrder();
        System.out.println("\n");

        n.delete('q');
        n.inOrder();

    }
}