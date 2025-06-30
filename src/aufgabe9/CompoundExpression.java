package aufgabe9;

import java.util.Map;

public abstract class CompoundExpression implements Expression{
    private static class Node{
        Expression data;
        Node left;
        Node right;
        Node (Expression x){
            data = x;
            left = null;
            right = null;
        }
        private Node root = null;

        public void insert(Expression x){
            root = insertR(x,root);
        }

        private Node insertR(Expression x, Node p){
            if(p == null){
                p = new Node(x);
            }

            return null;
        }
    }
}
