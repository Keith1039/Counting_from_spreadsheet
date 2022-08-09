public class Custom_Binary_Tree{
    public static class Node3{
        private String name;
        private int value;
        private Node3 greater;
        private Node3 lesser;
        private Node3 prev;
        private int amount=1;

        public Node3(String name){
            this.name = name;
            value = getVal(name);


        }
        public Node3(){
            greater=null;
            lesser=null;
            prev=null;

        }
        public static int getVal(String value){
            int returnable=0;
            char[] array = value.toCharArray(); 
            for(int i=0;i<array.length;i++){
                returnable+=(int)array[i];
            }
            return(returnable);
        }
    }

    private Node3 root;
    
    private Custom_Map map;
    public Custom_Binary_Tree(Custom_Map map){
        this.map = map;
        root=null;
    }

    public Boolean push(String name ){
        //Boolean truflag = false;
        Boolean flag = false;
        String actual_str = map.Get(name);
        if(actual_str != null){
            Node3 node = new Node3(actual_str);
            if(root == null){
                root= node;
                flag = true;
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
                        
                        flag=true;
                    }
                }
            }
        }
        return(flag);



    }

    public String get(String name){
        Node3 traverseNode = root;
        String returnable = "";
        Boolean flag = false;
        int num =Node3.getVal(name.strip());
        //System.out.println(total);
        //System.out.println(num);
        while(flag == false && traverseNode!= null){
            //System.out.println(traverseNode.value);
            if(traverseNode.value==num){
                returnable+=traverseNode.name+" x"+Integer.toString(traverseNode.amount)+"\n";
                flag = true;
            }
            else if(traverseNode.value< num ){
                traverseNode=traverseNode.greater;
            }
            else if(traverseNode.value > num){
                traverseNode = traverseNode.lesser;
            }
        }
        //System.out.println(".............................................");
        

        return(returnable);
    }
    public int getAmount(String name){
        Node3 traverseNode = root;
        int returnable=0;
        Boolean flag = false;
        int num =Node3.getVal(name.strip());
        //System.out.println(total);
        //System.out.println(num);
        while(flag == false && traverseNode!= null){
            //System.out.println(traverseNode.value);
            if(traverseNode.value==num){
                returnable = traverseNode.amount;
                flag = true;
            }
            else if(traverseNode.value< num ){
                traverseNode=traverseNode.greater;
            }
            else if(traverseNode.value > num){
                traverseNode = traverseNode.lesser;
            }
        }
        return(returnable);
    }
    

}