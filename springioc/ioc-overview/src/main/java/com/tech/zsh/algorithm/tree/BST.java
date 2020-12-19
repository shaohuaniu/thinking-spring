package com.tech.zsh.algorithm.tree;

/**
 * 描述：二叉树的实现
 * 需要泛型是可比较的，也就是泛型必须实现Comparable接口
 *
 * @Author shf
 * @Date 2019/7/22 9:53
 * @Version V1.0
 **/
public class BST<E extends Comparable> {

    /**
     * BST的根节点
     */
    private Node root;
    /**
     * 记录BST的 size
     */
    private int size;
    public BST(){
        root = null;
        size = 0;
    }

    /**
     * 对外提供的获取 size 的方法
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 二分搜索树是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 节点内部类
     */
    private class Node{
        private E e;
        /**左右孩子节点**/
        private Node left;
        private Node right;
        public Node(E e){
            this.e = e;
        }
    }

//    /**
//     * 添加一个节点
//     * @param e
//     */
//    public void add(E e){
//        root = addNode(root,e);
//    }
//
//    private Node addNode(Node node ,E e){
//        if(node == null){
//            size++;
//            return new Node(e);
//        }
//        if(e.compareTo(node.e)<0){
//            node.left = addNode(node.left,e);
//        }else if(e.compareTo(node.e)>0){
//            node.right = addNode(node.right,e);
//        }else{
//           Node  newNode =new Node(e);
//           newNode.left = node.left;
//           newNode.right = node.right;
//           node = newNode;
//        }
//        return node;
//    }


    public void add(E e){
        Node newNode = new Node(e);
        Node node = root;
        Node pNode = null;
        while(node != null){
            if(e.compareTo(node.e)<0){
                pNode = node.left;
                if(node.left == null){
                    node.left = newNode;
                    size++;
                    break;
                }else{
                    node = node.left;
                }
            }else if(e.compareTo(node.e)>0){
                pNode = node.right;
                if(node.right == null){
                    node.right = newNode;
                    size++;
                    break;
                }else {
                    node = node.right;
                }
            }else{
                newNode.left = node.left;
                newNode.right = node.right;
                if(pNode==null){
                    size++;
                    root = newNode;
                }else if (pNode.left == node){
                    pNode.left = newNode;
                }else if (pNode.right == node){
                    pNode.right = newNode;
                }

            }
        }

    }

    public boolean contains(E e){
        return containsNode(root,e);
    }

    private boolean containsNode(Node node, E e) {

        if(node == null ){
            return false;
        }
        if(e.compareTo(node.e)<0){
            return containsNode(node.left,e);
        }else if(e.compareTo(node.e)>0){
            return containsNode(node.right,e);
        }
        return true;
    }

    public void remove(E e){
        if(root == null){
            return;
        }
        //找到要删除的节点，和待删除节点的父节点
        Node node=root,pNode=null;
        while(node!=null){
            if(e.compareTo(node.e)<0){
                pNode = node;
                node = node.left;
            }else if(e.compareTo(node.e)>0){
                pNode = node;
                node = node.right;
            }else{
                break;
            }
        }
        //未找到待删除节点
        if(node == null){
            return;
        }
        //判断待删除节点
        //1、待删除的节点左右节点都是空，直接删除该节点，父节点指向空。
        //2、待删除节点只有左子节点，左子节点节点替换待删除节点
        //3、待删除节点只有右子节点，右子节点节点替换待删除节点
        //4、待删除的节点左右节点都有节点，找到右子节点的最小节点，替换当前节点。
        Node childNode;
        if(node.left == null && node.right == null){
            childNode = null;
        }else if(node.left == null){
            childNode = node.right;
        }else if(node.right == null){
            childNode = node.left;
        }else{
            //找出右子节点的最小节点
            Node minNode = node.right;
            while(minNode.left != null){
                Node mPNode = minNode;
                minNode = minNode.left;
                if(minNode.left == null){
                    mPNode.left = null;
                }
            }
            childNode = minNode;

        }
        //待删除的节点是根节点
        if(pNode==null){
            root = node;
        }else if(pNode.left == node){
            pNode.left = childNode;
        }else{
            pNode.right = childNode;
        }
        size--;

    }
}
