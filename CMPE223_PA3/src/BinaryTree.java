import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

    public class BinaryTree {
        Node root;
        class Node{
            int ID;
            String name;
            int piece;
            Node left;
            Node right;

            Node(int ID, String name, int piece) {
                this.ID = ID;
                this.name = name;
                this.piece = piece;
                right = null;
                left = null;
            }    
        }
        
        public void add(int ID, String name, int piece) {                       // Starts the tree from the root node.
            root = addElement(root, ID, name, piece);
        }

        private Node addElement(Node current, int ID, String name, int piece) {                      // Recursive method to do the insertions.
            if (current == null) return new Node(ID, name, piece);
            
            if (ID < current.ID)
                current.left = addElement(current.left, ID, name, piece);
            else if (ID > current.ID) 
                current.right = addElement(current.right, ID, name, piece);
            
            return current;  
        }
        
        public boolean contains(int ID) {                                    // Method to start the recursive method that searches the value in the BT.
            return containsElement(root, ID);
        }
        
        private boolean containsElement(Node current,  int value) {             // Recursive method to do the searching in the BT.
            if (current == null) return false;
            
            if (value == current.value) return true;
            
            if (value < current.value && current.left != null && containsElement(current.left, value))
                return true;
            if (value > current.value && current.right != null && containsElement(current.right, value))
                return true;
            else return false;
        }      
    
    public static ArrayList readFileToArrayList(String fileName) {
        File file = new File(fileName);
        Scanner scan;
        ArrayList<Cloths> clothsList = new ArrayList<>();
            try {
                scan = new Scanner(file);
                while (scan.hasNextLine()) {
        //            arrayList.add(scan.nextLine());
                    String line = scan.nextLine();
                    
                    
                    
                    if ( line.startsWith("Add_product") ) {
                        String[] add = new String[4];
                            add = line.split("\\s+");                           // With \\s+ it would treat multiple spaces the same as a single space. It returns an array of strings (String[]).
                            clothsList.add(add[1]);
                            
                    } else if ( line.startsWith("Is_Available") ) {
                        
                    } else if ( line.startsWith("Quit") ) {
                        System.err.println("Thank you for using ITS, Good Bye!");
                        System.exit(0);
                    } else {
                        System.out.println("Incorrect input!!!");
                    }
 {
                    }
{
                    }
                    
                }
                scan.close();
            } catch (FileNotFoundException ex) {
                System.out.println("File Not Found!!!");
            }
            return arrayList;
    }
        
    private static BinaryTree createBinaryTree(String fileName) {
        BinaryTree bt = new BinaryTree();
        ArrayList arrayList = readFileToArrayList(fileName);
        return bt;
    }

    public static void main(String[] args) {

        createBinaryTree("input_Q1.txt");
    }
}



