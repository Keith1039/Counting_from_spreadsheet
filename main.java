import java.io.*;

public class main{
    public static void main(String[] args) throws IOexception{
        try{
            File KeyList_file = new File("keys.txt");
            File e_waste_file = new File("CFS_and_EWASTE-Template.txt");
            if(KeyList_file.exists()==true && e_waste_file.exists()==true){

            }
            else{
                if(KeyList_file.exists()==false){
                    System.out.println("keys.txt file missing. If keys file is present please check the spelling of its name.");
                }
                else{
                    System.out.println("CFS_and_EWASTE-Template.txt is missing. If CFS_and_EWASTE-Template file is present please check the spelling of its name");
                }
            }
        }
        catch(IOexception IO){
            System.out.println("Error has occured");
        }

        
    }

    public static Custom_Map makeMap(File KeyList_file){
        Custom_Map map = new Custom_Map();
        KeyList keylist = new KeyList();
    }
}
