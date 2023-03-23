package cpt205_Ass;
import java.io.*;
import java.util.*;

public class staffAssignment {

    public static File staffListCSV =  new File("staff.csv");

    //Initialize an array of N records
    public static staff register[] = new staff[20];

    public static int recordCount=0;

    static class staff{

        
    
        int id;
        String name;
        int jobClass;
        boolean gender;
        String nationality;
        String phNum;
        String address;

        public int getID(){
            return this.id;
        }
        public String getName(){
            return this.name;
        }
        public int getjobClass(){
            return this.jobClass;
        }
        public boolean getGender(){
            return this.gender;
        }
        public String getNationality(){
            return this.nationality;
        }
        public String getPhNum(){
            return this.phNum;
        }
        public String getAddress(){
            return this.address;
        }
        public void setDetails(int id, String name, int jobClass, boolean gender, String nationality, String phNum, String address){
            
            this.id = id;
            this.name = name;
            this.jobClass = jobClass;
            this.gender = gender;
            this.nationality = nationality;
            this.phNum = phNum;
            this.address = address;

        }

        public void printDetails(){
            System.out.println(getID()+" "+ getName()+" "+getjobClass()+ " " + getGender()+" "+ getNationality()+" "+getPhNum()+" "+ getAddress());
        }
        
        public void addStaff(staff [] register, int nextIdVal, int staffLoc){

            Scanner input = new Scanner(System.in);

            //register[staffLoc] = new staff();
            String temporary;
            String temp[] = new String[6];
            String tempQuestions[] = {"name:", "Job class:", "gender (Male-0, Female-1):", "nationality:", "Phone Number:", "address:"};

            System.out.println("Please provide...");

            // for(int i=0; i<6; i++){
                //System.out.print("name");
                //System.out.println(tempQuestions[i]);
                temporary = input.nextLine();
                temp[0] = temporary;
                 
            // }
            // thisinput.close();
                //System.out.println(temp[1]);
            register[staffLoc].setDetails(nextIdVal, temp[0], Integer.parseInt(temp[1]), Boolean.parseBoolean(temp[2]), temp[3], temp[4], temp[5]);
            register[staffLoc].printDetails();
        }
        
    }

    public static void main(String[] args) {
        
        //output number of records in the file
        System.out.println("there are "+reader()+" records in the records file");

        reader();
        System.out.println("\nHello this is succes. next id is this ---> "+getNextId());
        // for(int i =0; i<3; i++){
        //     register[i].printDetails();
        // }
        int staffLoc = getStaffLocation();
        int nextID = getNextId();
        register[staffLoc] = new staff();
        register[staffLoc].setDetails(nextID, null, nextID, false, null, null, null);
        if(register[staffLoc]!=null){
            System.out.println("succhess");
        }else{
            System.out.println(2);
        }
        register[staffLoc].addStaff(register, nextID, staffLoc);

    }

    //reading data from file to array
    public static int reader(){
        
        String [] currentLineVal = null;
        String currentLine;

        //store records into the array (read using buffrdr)
        try{
            BufferedReader bReader = new BufferedReader(new FileReader(staffListCSV));
            
            while((currentLine = bReader.readLine())!=null){
                currentLineVal = currentLine.split(",");
                //System.out.println(recordCount);
                
                register[recordCount] = new staff();
                register[recordCount].setDetails(Integer.parseInt(currentLineVal[0]), currentLineVal[1], Integer.parseInt(currentLineVal[2]), 
                Boolean.parseBoolean(currentLineVal[3]), currentLineVal[4], currentLineVal[5], currentLineVal[6]); 

                //count number of records in csv file
                ++recordCount;
            }
            bReader.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return recordCount;
    }

    //getting the next id for staff automatically
    public static int getNextId(){
        
        String [] currentLineVal = null;
        String currentLine;
        try{
            BufferedReader bReader = new BufferedReader(new FileReader(staffListCSV));
            
            while((currentLine = bReader.readLine())!=null){
                currentLineVal = currentLine.split(",");

            }
            bReader.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return Integer.parseInt(currentLineVal[0])+1;
    }

    public static int getStaffLocation(){
        int staffLocation;
        Scanner input  =  new Scanner(System.in);
        System.out.println("Where would you like to add the new Staff?");
        staffLocation = input.nextInt();
        input.close();
        return staffLocation;
    }

    //2
    
    //iterate through array to a given position
    //add a record as the first. (measure time taken)

    //iterate through array to given position
    //remove record in position (measure time taken for removing)

    //binary search by recursion on array
    
    //sort array by staff name (should be the second column)

    //search for staff name (linear search). note time taken to search for first record and last record.

    //binary search for staff name. compare times for binary vs linear search


    //3
    
    //linked list from records in array
    
    //store data as a linked list (custom class for linking and storing data) >> DIFFERENT CLASS NEEDED FOR LINK AND STORE.

    //insert new record as the first node of the list
    //compare times to first node insertion vs first array index insertion
    // and again time to insert at first node vs last node

    //remove first and last node in list. compare times taken to remove each


}


