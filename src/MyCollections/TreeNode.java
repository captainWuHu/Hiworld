package MyCollections;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    TreeNode leftNode;
    TreeNode rightNode;
    Object value;

    public TreeNode(){

    }
    public TreeNode(int value){
        this.value = value;

    }

    public void add(Object value){
        if(this.value == null){
            this.value = value;
        }else{
            if((Integer)value - (Integer)this.value>=0){
                if(rightNode == null)rightNode = new TreeNode();
                rightNode.add(value);
            }else{
                if(leftNode==null)leftNode = new TreeNode();
                leftNode.add(value);
            }
        }
    }
    public List<Object> values(){
        List<Object> values = new ArrayList<>();
        if(leftNode!=null)values.addAll(leftNode.values());
        if(value!=null)values.add(value);
        if(rightNode!=null)values.addAll(rightNode.values());
        return values;
    }

    public static void main(String[] args) {

        int[] randoms = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };

        TreeNode roots = new TreeNode();
        for (int number : randoms) {
            roots.add(number);
        }

        System.out.println(roots.values());
    }
}
