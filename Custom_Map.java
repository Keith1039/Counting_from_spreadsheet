public class Custom_Map{
    public static class Node2{
        private KeyList keylist;
        private String value;
        private Node2 next;

        public Node2(KeyList keylist, String value){
            this.keylist=keylist;
            this.value=value;
            this.next=null;
        }
        public int getVal(){
            int returnable=0;
            String digitstring="";
            char[] array = value.toCharArray(); 
            for(int i=0;i<array.length;i++){
                digitstring+=(int)array[i];
            }
            returnable=Integer.parseInt(digitstring);
            return(returnable);
        }
        public String getValue(){
            return(this.value);
        }
    }

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
            last.next=node;
            last=last.next;
        }
    }

    public String Get(String name){ //nickname of device
        Boolean flag = false;
        String returnable;
        Node2 traverseNode = first;
        while(flag==false &&traverseNode!= null){
            if(traverseNode.keylist.isIn(name)==true){
                flag=true;
                returnable = traverseNode.value;
            }
            else{
                traverseNode=traverseNode.next;
            }
        }
        if(flag == false){
            return(null);
        }
        else{
            return(returnable);
        }
    }
}