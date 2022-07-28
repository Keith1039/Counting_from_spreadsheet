public class Node2 {
    private KeyList keylist;
    private String value;
    private Node2 next;
    

    public Node2(KeyList keylist, String value){
        this.keylist=keylist;
        this.value=value;
        this.next=null;
    }

    public String getValue(){
        return(this.value);
    }
    public KeyList getKeyList(){
        return(this.keylist);
    }
    public Node2 getNext(){
        return(this.next);
    }
    public void setNext(Node2 node){
        this.next=node;
    }
    public String toString(){
        String returnable =" [";
        returnable+=keylist.toString()+"]:";
        returnable+=value;
        return(returnable);
    }
}
