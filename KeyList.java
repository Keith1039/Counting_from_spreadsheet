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
            if(traverseNode.name==name){
                flag=true;
            }
            else{
                traverseNode=traverseNode.next;
            }
        }
        return(flag);
    }
}