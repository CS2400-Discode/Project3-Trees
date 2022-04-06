import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * The postorderTraverse Tests only pass when the line Separator for the IDE is set to LF (Unix/macOS).
 * If not then it fails and says "Contents have differences only in line separators" even though the Content is the exact same and should pass.
 */

class BinaryTreeTest {
    /**
     * Tests to see if postorderTraverse method works with a full tree
     */
    @Test
    void postorderTraverseFull() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        BinaryTree<String> bTree = new BinaryTree<>("B");
        BinaryTree<String> cTree = new BinaryTree<>("C");
        BinaryTree<String> aTree = new BinaryTree<>("A", bTree, cTree);
        aTree.postorderTraverse();

        String expectedOutput  = "B\nC\nA\n";                   // This is why it needs to be LF. For CRLF (Windows) The expectedOutput should be:
                                                                // "B\r\nC\r\nA\r\n"
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Tests to see if postorderTraverse method works with a complete but not full tree
     */
    @Test
    void postorderTraverseComplete() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        BinaryTree<String> bTree = new BinaryTree<>("B");
        BinaryTree<String> aTree = new BinaryTree<>("A", bTree, null);
        aTree.postorderTraverse();

        String expectedOutput  = "B\nA\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Tests to see if postorderTraverse method works with an incomplete tree
     */
    @Test
    void postorderTraverseIncomplete() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        BinaryTree<String> cTree = new BinaryTree<>("C");
        BinaryTree<String> aTree = new BinaryTree<>("A", null, cTree);
        aTree.postorderTraverse();

        String expectedOutput  = "C\nA\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Tests to see if postorderTraverse_callBinaryNode method works with a full tree
     */
    @Test
    void postorderTraverse_callBinaryNodeMethodFull() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        BinaryTree<String> bTree = new BinaryTree<>("B");
        BinaryTree<String> cTree = new BinaryTree<>("C");
        BinaryTree<String> aTree = new BinaryTree<>("A", bTree, cTree);
        aTree.postorderTraverse_callBinaryNodeMethod();

        String expectedOutput  = "B\nC\nA\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Tests to see if postorderTraverse_callBinaryNode method works with a complete but not full tree
     */
    @Test
    void postorderTraverse_callBinaryNodeMethodComplete() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        BinaryTree<String> bTree = new BinaryTree<>("B");
        BinaryTree<String> aTree = new BinaryTree<>("A", bTree, null);
        aTree.postorderTraverse_callBinaryNodeMethod();

        String expectedOutput  = "B\nA\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Tests to see if postorderTraverse_callBinaryNode method works with an incomplete tree
     */
    @Test
    void postorderTraverse_callBinaryNodeMethodIncomplete() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        BinaryTree<String> cTree = new BinaryTree<>("C");
        BinaryTree<String> aTree = new BinaryTree<>("A", null, cTree);
        aTree.postorderTraverse_callBinaryNodeMethod();

        String expectedOutput  = "C\nA\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Tests to see if postorderTraverse_binaryNode method works with a full tree
     */
    @Test
    void postorderTraverse_binaryNodeMethodFull() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        BinaryNode<String> bTree = new BinaryNode<>("B");
        BinaryNode<String> cTree = new BinaryNode<>("C");
        BinaryNode<String> aTree = new BinaryNode<>("A", bTree, cTree);
        aTree.postorderTraverse_binaryNodeMethod();

        String expectedOutput  = "B\nC\nA\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Tests to see if postorderTraverse_binaryNode method works with a complete but not full tree
     */
    @Test
    void postorderTraverse_binaryNodeMethodComplete() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        BinaryNode<String> bTree = new BinaryNode<>("B");
        BinaryNode<String> aTree = new BinaryNode<>("A", bTree, null);
        aTree.postorderTraverse_binaryNodeMethod();

        String expectedOutput  = "B\nA\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Tests to see if postorderTraverse_binaryNode method works with an incomplete tree
     */
    @Test
    void postorderTraverse_binaryNodeMethodIncomplete() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        BinaryNode<String> cTree = new BinaryNode<>("C");
        BinaryNode<String> aTree = new BinaryNode<>("A", null, cTree);
        aTree.postorderTraverse_binaryNodeMethod();

        String expectedOutput  = "C\nA\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * Tests to see if getHeight_callBinaryNodeMethod works with a full tree
     */
    @Test
    void getHeight_callBinaryNodeMethodFull() {
        BinaryTree<String> bTree = new BinaryTree<>("B");
        BinaryTree<String> cTree = new BinaryTree<>("C");
        BinaryTree<String> aTree = new BinaryTree<>("A", bTree, cTree);

        assertEquals(2, aTree.getHeight_callBinaryNodeMethod());
    }

    /**
     * Tests to see if getHeight_callBinaryNodeMethod works with a complete but not full tree
     */
    @Test
    void getHeight_callBinaryNodeMethodComplete() {
        BinaryTree<String> bTree = new BinaryTree<>("B");
        BinaryTree<String> aTree = new BinaryTree<>("A", bTree, null);

        assertEquals(2, aTree.getHeight_callBinaryNodeMethod());
    }

    /**
     * Tests to see if getHeight_callBinaryNodeMethod works with an incomplete tree
     */
    @Test
    void getHeight_callBinaryNodeMethodIncomplete() {
        BinaryTree<String> cTree = new BinaryTree<>("C");
        BinaryTree<String> aTree = new BinaryTree<>("A", null, cTree);

        assertEquals(2, aTree.getHeight_callBinaryNodeMethod());
    }

    /**
     * Tests to see if getHeight_binaryNodeMethod works with a full tree
     */
    @Test
    void getHeight_binaryNodeMethodFull() {
        BinaryNode<String> bTree = new BinaryNode<>("B");
        BinaryNode<String> cTree = new BinaryNode<>("C");
        BinaryNode<String> aTree = new BinaryNode<>("A", bTree, cTree);

        assertEquals(2, aTree.getHeight_binaryNodeMethod());
    }

    /**
     * Tests to see if getHeight_binaryNodeMethod works with a complete but not full tree
     */
    @Test
    void getHeight_binaryNodeMethodComplete() {
        BinaryNode<String> bTree = new BinaryNode<>("B");
        BinaryNode<String> aTree = new BinaryNode<>("A", bTree, null);

        assertEquals(2, aTree.getHeight_binaryNodeMethod());
    }

    /**
     * Tests to see if getHeight_binaryNodeMethod works with an incomplete tree
     */
    @Test
    void getHeight_binaryNodeMethodIncomplete() {
        BinaryNode<String> cTree = new BinaryNode<>("C");
        BinaryNode<String> aTree = new BinaryNode<>("A", null, cTree);

        assertEquals(2, aTree.getHeight_binaryNodeMethod());
    }

    /**
     * Tests to see if getNumberOfNodes works with a full tree
     */
    @Test
    void getNumberOfNodesFull() {
        BinaryTree<String> bTree = new BinaryTree<>("B");
        BinaryTree<String> cTree = new BinaryTree<>("C");
        BinaryTree<String> aTree = new BinaryTree<>("A", bTree, cTree);

        assertEquals(3, aTree.getNumberOfNodes());
    }

    /**
     * Tests to see if getNumberOfNodes works with a complete but not full tree
     */
    @Test
    void getNumberOfNodesComplete() {
        BinaryTree<String> bTree = new BinaryTree<>("B");
        BinaryTree<String> aTree = new BinaryTree<>("A", bTree, null);

        assertEquals(2, aTree.getNumberOfNodes());
    }

    /**
     * Tests to see if getNumberOfNodes works with an incomplete tree
     */
    @Test
    void getNumberOfNodesIncomplete() {
        BinaryTree<String> cTree = new BinaryTree<>("C");
        BinaryTree<String> aTree = new BinaryTree<>("A", null, cTree);

        assertEquals(2, aTree.getNumberOfNodes());
    }
}
