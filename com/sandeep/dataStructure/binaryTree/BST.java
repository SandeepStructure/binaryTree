package com.sandeep.dataStructure.binaryTree;

public class BST {
    private Node root;
    BST(){
        this.root = null;
    }

    public void printSpiral(Node node){
        int h = height(node);
        System.out.println("Height "+h);
        int i;
        boolean ltr = false;
        for(i=1;i<=h;i++){
            printGivenLevel(node,i,ltr);
            ltr = !ltr;
        }
    }

  private void printGivenLevel(Node node, int level,boolean ltr){
        if(level == 1){
            System.out.println("Key "+node.key + "Value "+node.value);
        }else if (level > 1){
            if(ltr != false){
                printGivenLevel(node.leftChild,level-1,ltr);
                printGivenLevel(node.rightChild,level-1,ltr);
            }else{
                printGivenLevel(node.rightChild,level-1,ltr);
                printGivenLevel(node.leftChild,level-1,ltr);
            }
        }
  }

  public int height(Node node){
        if(node == null){
            return 0;
        }else{
            int lHeight = height(node.leftChild);
            int rHeight = height(node.rightChild);

            if(lHeight > rHeight){
                return lHeight +1;
            }else{
                return rHeight + 1;
            }
        }
  }
    public void insert(int key,String value){
        Node newNode = new Node(key,value);
        if(root == null){
            root = newNode;
        }else{
            Node current = root;
            Node parent;
            while(true){
                parent=current;
                if(key < current.key){
                    current = current.leftChild;
                    if(current==null){
                        parent.leftChild=newNode;
                        return;
                    }
                }else{
                    current=current.rightChild;
                    if(current==null){
                        parent.rightChild=newNode;
                        return;
                    }
                }
            }
        }
    }

    static void preOrderShow(Node node){
        if(null != node){
            System.out.println(node.key);
            preOrderShow(node.leftChild);
            preOrderShow(node.rightChild);
        }
    }

    static void inOrderShow(Node node){
        if(null != node){
            inOrderShow(node.leftChild);
            System.out.println(node.key);
            inOrderShow(node.rightChild);
        }
    }

    static void postOrderShow(Node node){
        if(null != node) {
            postOrderShow(node.leftChild);
            postOrderShow(node.rightChild);
            System.out.println(node.key);
        }
    }
    public void showPreOrder(){
       preOrderShow(root);
    }

    public void showInOrder(){
        inOrderShow(root);
    }

    public void showPostOrder(){
       postOrderShow(root);
    }
    public void showSpiral(){
        printSpiral(root);
    }
}
