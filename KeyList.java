public class KeyList{

    public static class Node1{
        private String name;
        private Node1 next;

        public Node1(String name){
            this.name=name;
        }
    }
    private Node1 first;
    private Node1 last;

    public KeyList(){
        first=null;
        last=null;
    }
    
    public void put(Node1 node){
        if(first==null){
            first=node;
            last=first;
        }
        else{
            last.next=node;
            last=last.next;
        }
    }
    public Boolean isIn(String name){
        Node1 traverseNode = first;
        Boolean flag = false;
        while(traverseNode!=null && flag == false){
            if(traverseNode.name.equals(name)){
                flag=true;
            }
            traverseNode = traverseNode.next; 
        }
        
        return(flag);
    }

    public String toString(){
        String returnable= " ";
        Node1 traversNode = first;
        while(traversNode!= null){
            returnable+=traversNode.name;
            if(traversNode.next!=null){
                returnable+=",";
            }
            traversNode=traversNode.next;
        }
        return(returnable);

    }
}