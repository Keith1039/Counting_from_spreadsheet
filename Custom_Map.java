public class Custom_Map{
   

    private Node2 first;
    private Node2 last;

    public Custom_Map(){
        first=null;
        last=null;
    }

    public void add(Node2 node){
        if(first==null){
            first=node;
            last=first;
        }
        else{
            last.setNext(node);
            last=last.getNext();
        }
    }

    public String Get(String name){ //nickname of device
        Boolean flag = false;
        String returnable="";
        Node2 traverseNode = first;
        while(flag==false &&traverseNode!= null){
            if(traverseNode.getKeyList().isIn(name)==true){
                flag=true;
                returnable = traverseNode.getValue();
            }
            traverseNode=traverseNode.getNext();
            
        }
        if(flag == false){
            return(null);
        }
        else{
            return(returnable.strip());
        }
    }

    public boolean isValue(String value){
        Node2 traverseNode = first;
        Boolean flag = false;
        while(traverseNode != null && flag == false){
            if(traverseNode.getKeyList().isIn(value)==true){
                flag = true;
            }
            traverseNode = traverseNode.getNext();
        }
        //System.out.println(flag);

        return(flag);
    }
    public Node2 getFirst(){
        return(first);
    }

    public String toString(){
        String returnable = "(";
        Node2 traverseNode = first;
        while(traverseNode!= null){
            returnable+=traverseNode.toString();
            if(traverseNode.getNext()!=null){
                returnable+="\n"+"\n";
            }
            traverseNode=traverseNode.getNext();


        }
        returnable+=" )";
        return(returnable);
    }
    
}