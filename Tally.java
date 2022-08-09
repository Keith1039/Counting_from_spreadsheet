import java.io.*;
import java.util.Scanner;
public class Tally{
    private Custom_Map map;
    private LinkedList companies;
    private Custom_Binary_Tree tree;
    private int total;

    public Tally(File e_waste_file, File companies_file, File KeyList_file)throws IOException{
        map = makeMap(KeyList_file);
        companies = makeComlist(companies_file);
        tree = makeBinary_Tree(map, e_waste_file, companies_file);
    }

    public static class Node{
        private String value;
        private Node next;

        public Node(String value){
            this.value = value;
        }
    }
    public static class LinkedList{
        Node first;
        Node last;

        public LinkedList(){
            first = null;
        }
        public void push(String value){
            if(first == null){
                first = new Node(value);
                last = first;
            }
            else{
                last.next = new Node(value);
                last = last.next;
            }
        }
        public Boolean isIn(String value){
            Boolean flag = false;
            Node traverseNode = first;
            while(traverseNode != null && flag != true){
                if(traverseNode.value.equals(value)==true){
                    flag = true;
                }
                traverseNode = traverseNode.next;
            }

            return(flag);
        }

    }
    
    
    public static void main(String[] args) throws IOException{
        File e_waste_file = new File("CFS_and_EWASTE-Template.txt");
        File companies_file = new File("Companies.txt");
        File KeyList_file = new File("keys.txt");
        Tally tally = new Tally(e_waste_file, companies_file, KeyList_file);
        System.out.println(tally);
    }

    public static Custom_Map makeMap(File KeyList_file) throws IOException{
        Custom_Map map = new Custom_Map();
        KeyList keylist = new KeyList();
        Scanner scan = new Scanner(KeyList_file);
        while(scan.hasNext()==true){
            String word = "";
            char[] array = scan.nextLine().toCharArray();
            Boolean flag = false;
            for(int i=0; i<array.length;i++){
                if(array[i]==','){
                    if(flag==false){
                        keylist.put(new KeyList.Node1(word.strip()));
                    }
                    word=" ";

                }
                
                else if(array[i]=='#'){
                    flag=true;
                }
                
                else if(flag == true && i==(array.length-1)){
                    word+=array[i];
                    map.add(new Node2(keylist, word));
                    keylist = new KeyList();
                }
                
                else{
                    word+=array[i];
                }
            }
        }
        scan.close();
        return(map);
    }
    public static Custom_Binary_Tree makeBinary_Tree(Custom_Map map,File e_waste_file, File companies_file) throws IOException{
        int z =1;
        boolean flager = false;
        Custom_Binary_Tree tree = new Custom_Binary_Tree(map);
        Scanner scanner = new Scanner(e_waste_file);
        LinkedList companies = makeComlist(companies_file);
        //for(int i=0;i<5;i++){
        //    scanner.nextLine();
        //}
        while(scanner.hasNext()==true){
            
            String word = "";
            char[] array = scanner.nextLine().strip().toCharArray();
            boolean flag1 = false;
            boolean flag2 = false;
            for(int i=0; i<array.length && flag2 != true;i++){
                if(flag1 == false){
                    word+=array[i];
                    if(companies.isIn(word)==true){
                        flag1=true;
                        word ="";
                    }
                }
                else if(flag1 == true){
                    if(map.isValue(word.strip())==true){ //make or break condition
                        flag2=true;
                    }
                    else{
                        word+=array[i];
                    }
                }
            }
            //System.out.println(flag2);
            flager =tree.push(word.strip());
            
            if(flager == false){
                System.out.println("Line "+Integer.toString(z)+" has an unregistered key: "+word.strip());
            }
            
            z++;
        }

        scanner.close();
        return(tree);
    }
    
    public static LinkedList makeComlist(File Companies_file) throws IOException{
        LinkedList complist = new LinkedList();
        Scanner scanner = new Scanner(Companies_file);
        while(scanner.hasNext()==true){
            complist.push(scanner.nextLine().strip());
        }
        scanner.close();
        return(complist);
    }

    public String toString(){
        String returnable ="{ "+"\n";
        Node2 traverseNode = map.getFirst();
        while(traverseNode!= null){
            returnable+=(tree.get(traverseNode.getValue()));
            total+= tree.getAmount(traverseNode.getValue());

            traverseNode=traverseNode.getNext();
            
        }
        returnable+=" }"+"\n";
        returnable+="For a total of "+ Integer.toString(total)+" items!";
        return(returnable);

    }



}      
                        