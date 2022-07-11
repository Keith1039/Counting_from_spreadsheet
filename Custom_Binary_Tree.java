public class Custom_Binary_Tree{
    public static class Node3{
        private Node2 node2;
        private int value;
        private Node3 greater;
        private Node3 lesser;
        private Node3 prev;
        private int ammount=1;
        public Node3(Node2 node){
            this.value = node.getVal();
            this.node2=node;
        }
    }

    private Node3 root;
    private int total =0;

    public Custom_Binary_Tree(){
        root=null;
    }

    public void push(Node3 node ){
        Boolean flag = false;
        if(root == null){
            root= node;
        }
        else{
            Node3 current_node=root;
            while(flag==false){
                if(current_node.value<node.value && current_node.greater==null){
                    current_node.greater=node;
                    node.prev=current_node;
                    flag=true;
                }
                else if(current_node.value>node.value&&current_node.lesser==null){
                    current_node.lesser=node;
                    node.prev=current_node;
                    flag=true;
                }
                else if(current_node.value<node.value){
                    current_node=current_node.greater;
                }
                else if(current_node.value>node.value){
                    current_node=current_node.lesser;
                }
                else if(current_node.value==node.value){
                    current_node.amount++;
                    this.total++;
                    flag=true;
                }
            }
        }
    }
    public String toString(){
        Node3 current_node=root;
        if(current_node==null){
            return("[ ]");
        }
        Boolean flag1=false;
        String returnable = "[ "+current_node.getValue()+ " x"+Integer.toString(current_node.amount)+", ";
        
        Node right_side = current_node.greater_than;
        Node left_side= current_node.less_than;
        
        Node most_right=new Node();
        Node most_left= new Node();

        int tracker2=0;
        int tracker=0;

        Node new_pos = new Node();
        while(right_side!= null){
            returnable+= right_side.getValue()+" x"+Integer.toString(right_side.amount)+", ";
            if(right_side.greater_than == null){
                most_right=right_side;
            }
            right_side=right_side.greater_than;
        }
        while(most_right!=root && most_right.getValue() != null){
            if(new_pos== most_right){
                most_right=most_right.prev;
                tracker2=0;
            }
            if(most_right.less_than!= null && tracker2 ==0){
                new_pos=most_right.less_than;
                tracker2=1;
                returnable+= new_pos.getValue()+" x"+Integer.toString(new_pos.amount)+", ";
                right_side=new_pos.greater_than;
                while(right_side!= null){
                    returnable+= right_side.getValue()+" x"+Integer.toString(right_side.amount)+", ";
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
            if(new_pos.less_than != null && returnable.indexOf(new_pos.less_than.getValue())==-1 ){
                new_pos=new_pos.less_than;
                returnable+= new_pos.getValue()+" x"+Integer.toString(new_pos.amount)+", ";
                right_side=new_pos.greater_than;
                while(right_side!= null){
                    returnable+= right_side.getValue()+" x"+Integer.toString(right_side.amount)+", ";
                    if(right_side.greater_than == null){
                        new_pos=right_side;
                    }
                    right_side=right_side.greater_than;
                }
            }
            if(new_pos.less_than != null && returnable.indexOf(new_pos.less_than.getValue())!=-1){
                new_pos=new_pos.prev;
            }
            
        }

        while(left_side!= null){
            returnable+= left_side.getValue()+" x"+Integer.toString(left_side.amount)+", ";
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
                returnable+= new_pos.getValue()+" x"+Integer.toString(new_pos.amount)+", ";
                left_side=new_pos.less_than;
                while(left_side!= null){
                    returnable+= left_side.getValue()+" x"+Integer.toString(left_side.amount)+", ";
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
            if(new_pos.greater_than != null && returnable.indexOf(new_pos.greater_than.getValue())==-1){
                new_pos=new_pos.greater_than;
                returnable+= new_pos.getValue()+" x"+Integer.toString(new_pos.amount)+", ";
                left_side=new_pos.less_than;
                while(left_side!= null){
                    returnable+= left_side.getValue()+" x"+Integer.toString(left_side.amount)+", ";
                    if(left_side.less_than == null){
                        new_pos=left_side;
                    }
                    left_side=left_side.less_than;
                }
            }
            if(new_pos.greater_than!= null && returnable.indexOf(new_pos.greater_than.getValue())!=-1){
                new_pos=new_pos.prev;
            }
            
        }
        returnable+="]";
        return(returnable);
    }
}