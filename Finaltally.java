import java.util.*;
import java.io.*;

public class Binary_Item_Tree {
    private Node root;
    private int total;
    private linkedlist;
    
    

    public static class class linkedlist{
        //pop method isn't required
        private Node2 first;
        private Node2 rear;
        private int size;
    
        public static class Node2 {
            private Node ref;
            private String key_value;
            private Node2 next;
            private boolean isValid;
            

            public Node2(Node ref, File file) throws IOException{
                this.ref=ref;
                boolean flag = false;
                Scanner scanner = new Scanner(file);


                while(flag==false&& scanner.hasNext()==true){

                }
                if(flag == false){
                    System.out.println("value is not valid in Keylist");
                    this.isValid=false;
                }
                else{
                    this.isValid=true;
                }
                
                
            }
        }
    
        public linkedlist(){
            this.first=null;
            this.rear=null;
            this.size=0;
        }
        public void append(Node ref){
           Node2 appendable = new Node2(ref);
            if(this.first==null){
                first=appendable;
                rear=first;
            }
            else{
                rear.Next=appendable;
                rear=rear.Next;
            }
            this.size++;
        }
    
        public String toString(){
            String res="";
            Node2 traversenode=first;
            for(int i=0; i<this.size;i++){
                
            }
            return(res);
        }
    }


    public static class Node{
        private int value;
        private int amount;
        private String Model_no;
        private Node prev;
        private Node greater_than;
        private Node less_than;

        public Node(String Model_no){
            String val=""
            this.Model_no=Model_no;
            char[] chars = Model_no.toCharArray();
            
            for(int i=0; i< chars.length;i++){
                this.val+= Integer.toString((int)chars[i]);
            }
            this.value=Integer.parseInt(val);
            this.amount=1;
            this.total++;
        }
        public Node(){

        }
        public int getAmount(){
            return(this.amount);
        }
    }
        
    public void push(String string){
        Node new_node = new Node(string);
        Boolean flag = false;
        if(root == null){
            root= new_node;
        }
        else{
            Node current_node=root;
            while(flag==false){
                if(current_node.value<new_node.value && current_node.greater_than==null){
                    current_node.greater_than=new_node;
                    new_node.prev=current_node;
                    flag=true;
                }
                else if(current_node.value>new_node.value&&current_node.less_than==null){
                    current_node.less_than=new_node;
                    new_node.prev=current_node;
                    flag=true;
                }
                else if(current_node.value<new_node.value){
                    current_node=current_node.greater_than;
                }
                else if(current_node.value>new_node.value){
                    current_node=current_node.less_than;
                }
                else if(current_node.value==new_node.value){
                    current_node.amount++;
                    this.total++;
                    flag=true;
                }
            }
        }

    }

    public Boolean is_in(String string){
        Boolean flag = false;
        Node new_node= new Node(string);
        Node current_node= root;
        while(current_node != null){
            if(current_node.value < new_node.value){
                current_node=current_node.greater_than;
            }
            else if(current_node.value>new_node.value){
                current_node=current_node.less_than;
            }
            else if(current_node.value== new_node.value){
                current_node=null;
                flag=true;
            }
        }
        return(flag);
    }

    public void use_item(String string){
        if(is_in(string)==false){
            System.out.println("You do not have this item.");
        }
        else{
            Node new_node = new Node(string);
            Boolean flag=false;
            Node current_node= root;
            while(flag==false){
                if(current_node.value < new_node.value){
                    current_node=current_node.greater_than;
                }
                else if(current_node.value>new_node.value){
                    current_node=current_node.less_than;
                }
                else if(current_node.value== new_node.value){ //removes it
                    flag=true;
                    current_node.amount--;
                    this.total--;
                    if(current_node.amount==0){
                        if(current_node.value>current_node.prev.value){
                            current_node.prev.greater_than=null;
                        }
                        else{
                            current_node.prev.less_than=null;
                        }
                    }
                }

            }

        }
    }

    public String toString(){
        Node current_node=root;
        if(current_node==null){
            return("[ ]");
        }
        Boolean flag1=false;
        String returnable = "[ "+current_node.Model_no+ " x"+Integer.toString(current_node.amount)+", ";
        
        Node right_side = current_node.greater_than;
        Node left_side= current_node.less_than;
        
        Node most_right=new Node();
        Node most_left= new Node();

        int tracker2=0;
        int tracker=0;

        Node new_pos = new Node();
        while(right_side!= null){
            returnable+= right_side.Model_no+" x"+Integer.toString(right_side.amount)+", ";
            if(right_side.greater_than == null){
                most_right=right_side;
            }
            right_side=right_side.greater_than;
        }
        while(most_right!=root && most_right.Model_no != null){
            if(new_pos== most_right){
                most_right=most_right.prev;
                tracker2=0;
            }
            if(most_right.less_than!= null && tracker2 ==0){
                new_pos=most_right.less_than;
                tracker2=1;
                returnable+= new_pos.Model_no+" x"+Integer.toString(new_pos.amount)+", ";
                right_side=new_pos.greater_than;
                while(right_side!= null){
                    returnable+= right_side.Model_no+" x"+Integer.toString(right_side.amount)+", ";
                    if(right_side.greater_than == null){
                        new_pos=right_side;
                    }
                    right_side=right_side.greater_than;
                }
            }
            if(most_right.less_than == null){
                most_right=most_right.prev;
                tracker2=0;
            }

            if(new_pos.less_than==null && new_pos.prev != null){
                new_pos=new_pos.prev;

            }
            if(new_pos.less_than != null && returnable.indexOf(new_pos.less_than.Model_no)==-1 ){
                new_pos=new_pos.less_than;
                returnable+= new_pos.Model_no+" x"+Integer.toString(new_pos.amount)+", ";
                right_side=new_pos.greater_than;
                while(right_side!= null){
                    returnable+= right_side.Model_no+" x"+Integer.toString(right_side.amount)+", ";
                    if(right_side.greater_than == null){
                        new_pos=right_side;
                    }
                    right_side=right_side.greater_than;
                }
            }
            if(new_pos.less_than != null && returnable.indexOf(new_pos.less_than.Model_no)!=-1){
                new_pos=new_pos.prev;
            }
            
        }

        while(left_side!= null){
            returnable+= left_side.Model_no+" x"+Integer.toString(left_side.amount)+", ";
            if(left_side.less_than == null){
                most_left=left_side;
            }
            left_side=left_side.less_than;
        }
        
        while(most_left!=root && root.less_than != null){
            new_pos= new Node();
            if(new_pos== most_left){
                most_left=most_left.prev;
                tracker2=0;
            }
            if(most_left.greater_than!= null && tracker2 ==0){
                new_pos=most_right.greater_than;
                tracker2=1;
                returnable+= new_pos.Model_no+" x"+Integer.toString(new_pos.amount)+", ";
                left_side=new_pos.less_than;
                while(left_side!= null){
                    returnable+= left_side.Model_no+" x"+Integer.toString(left_side.amount)+", ";
                    if(left_side.less_than == null){
                        new_pos=left_side;
                    }
                    left_side=left_side.less_than;
                }
            }
            if(most_left.greater_than == null){
                most_left=most_left.prev;
                tracker2=0;
            }

            if(new_pos.greater_than==null && new_pos.prev!= null){
                new_pos=new_pos.prev;
            }
            if(new_pos.greater_than != null && returnable.indexOf(new_pos.greater_than.Model_no)==-1){
                new_pos=new_pos.greater_than;
                returnable+= new_pos.Model_no+" x"+Integer.toString(new_pos.amount)+", ";
                left_side=new_pos.less_than;
                while(left_side!= null){
                    returnable+= left_side.Model_no+" x"+Integer.toString(left_side.amount)+", ";
                    if(left_side.less_than == null){
                        new_pos=left_side;
                    }
                    left_side=left_side.less_than;
                }
            }
            if(new_pos.greater_than!= null && returnable.indexOf(new_pos.greater_than.Model_no)!=-1){
                new_pos=new_pos.prev;
            }
            
        }
        returnable+="]";
        return(returnable);
    }




    
}