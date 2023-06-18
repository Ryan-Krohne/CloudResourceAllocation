import javax.swing.JOptionPane;

public class CloudResourceAllocation {

    static double storagePrice=0.5;
    public static void main(String[] args) {

        final int maxResources = 10;
        Resource allResources[] = new Resource[maxResources];
        Customer Customer1 = new Customer(null, null, null, allResources);
        registration(Customer1);
        int choice=0;

        do{   
            try{
                choice = Integer.parseInt(JOptionPane.showInputDialog(null, "**AWS Cloud Resources**\n\n1. View Pricing \n2. Add Resources \n3. Remove Resource\n4. View Cart\n5. Checkout"));
                switch(choice){
                    
                    case 1: //view discounts
                        JOptionPane.showMessageDialog(null, "Current Discounts:\n1) 20% off on all storage purchased over 500GB");
                        break;

                    case 2: //add resource or just browse
                    if(Resource.getNumResources()<allResources.length){
                        Add(allResources);
                    }else{JOptionPane.showMessageDialog(null, "You can only have a maximum of 10 resources");
                    }
                        break;

                    case 3: //remove
                    removeItem(allResources);
                        break;

                    case 4: //view cart, does not show user information
                    displayCart(allResources, Customer1);
                        break;

                    case 5://exit
                    checkout(Customer1, allResources);
                    if(allResources[0]==null){
                        choice=6;
                    }
                    
                    break;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Inalid, Please enter a number from 1-5");
            }
        }while (choice!=5);    
    }

    public static Customer registration(Customer Customer){
        boolean done;
        do{
            done = false;
            try{
                String Name = JOptionPane.showInputDialog(null, "Welcome to AWS Cloud Resource Allocation.\nCreate an Account to continue.\n\nEnter your full name:");
                Customer.setFullName(Name);
                done = true;
            }catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                done = false;
            } 
        } while (!done);
        do{
            done = false;
            try{
                String email = JOptionPane.showInputDialog(null, "Enter your email address:");
                Customer.setEmail(email);
                done = true;
            }catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                done = false;
            }
        } while (!done);
        do{
            done = false;
            try{
                String password = JOptionPane.showInputDialog(null, "Please create a password:\n\n* Between 8 and 16 characters\n* Atleast one digit\n* Atleast one uppercase\n* Atleast one lowercase\n* Atleast one special character\n\n\nCreate your password:");      
                Customer.setPassword(password);
                done = true;
            }catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                //done = false;
            }
        }while(!done);

        return Customer;
    }

    public static void Add(Resource allResources[]){

        Object[] options = {"Go Back", "Free Trials", "Virtual Servers", "Machine Learning", "Storage"};
        int option = JOptionPane.showOptionDialog(null, "Which cloud resource would you like to look at?\n\n"
        +" \nVirtual Servers: Create multiple isolated virtual machines on a single physical server\nFree Trials: View our other free trials!","AWS Resource Allocation", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[4]);

        switch(option){

            case 0://go back to main menu
            break;

            case 1: //free trials
            JOptionPane.showMessageDialog(null, "Unfortunately, there are no free trials available at the moment.");
            break;

            case 2: //virtual servers

            Resource newServer = addServer();
            if(newServer!=null){
                for(int i=0;i<Resource.getNumResources();i++){
                    if(allResources[i]==null){
                        allResources[i]=newServer;
                        break;
                    }
                }
            }
            
            break;

            case 3://machine learning

            Resource newMLResource = addML();
            if(newMLResource!=null){
                for(int i=0;i<Resource.getNumResources();i++){
                    if(allResources[i]==null){
                        allResources[i]=newMLResource;
                        break;
                    }
                }
            }
            break;

            case 4://Storage
            
            Resource newResource = addStorage();
            if (newResource != null) {
                for (int i=0; i<Resource.getNumResources(); i++) {
                    if (allResources[i] == null) {
                        allResources[i] = newResource;
                        break;
                    }
                }
            }
            break;
        }

    }

    public static Resource addStorage() {
        Object[] options = {"Go Back", "100GB", "500GB", "1TB", "Custom"};
        int option = JOptionPane.showOptionDialog(null, "Select the storage size you want to add:", "Add Storage", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[4]);
    
        switch (option) {
    
            case 0://go back to previous menu
                return null;
    
            case 1://100GB
            int size=100;
                return new Storage("Storage", size*storagePrice, 100);
    
            case 2://500GB
            size=500;
                return new Storage("Storage", size*storagePrice, 500);
    
            case 3://1TB
            size =1000;
                return new Storage("Storage", size*storagePrice, 1000);
    
            case 4://Custom
                String customSizeString = JOptionPane.showInputDialog(null, "Enter the size (in GB) of the storage you want to add:");
                try {
                    int customSize = Integer.parseInt(customSizeString);
                    return new Storage("Storage", customSize*0.5, customSize);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                    return addStorage();
                }
    
        }
        return null;
    }

    public static Resource addML() {
        Object[] options = {"Go Back", "3 months", "6 months", "12 months", "Custom Duration"};
        int option = JOptionPane.showOptionDialog(null, "How long would you like access to our ML tools?", "Machine Learning Duration", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[4]);
    
        switch (option) {
            case 0://go back to previous menu
                return null;
    
            case 1://3 months
            int duration =3;
            return new MachineLearning("Machine", duration*150, 3);
            
            case 2://6 months
            duration = 6;
                return new MachineLearning("Machine", duration*150, 6);
    
            case 3://12 months
            duration =12;
                return new MachineLearning("Machine", duration*150, 12);
    
            case 4://custom ML 
                String customSizeString = JOptionPane.showInputDialog(null, "How many months would you like access to our Machine Learning tools?");
                try {
                    int customSize = Integer.parseInt(customSizeString);
                    return new MachineLearning("Machine",customSize*150,customSize);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                    return addStorage();
                }
        }
        return null;
    }

    public static Resource addServer() {
        Object[] options = {"Go Back", "1", "2", "3", "Custom"};
        int option = JOptionPane.showOptionDialog(null, "How many server would you like to add:", "Add Server", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[4]);
    
        int ratio = 1000;
        switch (option) {

    
            case 0://go back to previous menu
                return null;
    
            case 1://1
            int size=1;
                return new VirtualServers("Server", size*ratio, 1);
    
            case 2://52
            size=2;
                return new VirtualServers("Server", size*ratio, 2);
    
            case 3://3
            size =3;
                return new VirtualServers("Server", size*ratio, 3);
    
            case 4://Custom
                String customSizeString = JOptionPane.showInputDialog(null, "How many virtual servers would you like to purchase for the next year?:");
                try {
                    int customSize = Integer.parseInt(customSizeString);
                    return new VirtualServers("Virtual Server", customSize*ratio,customSize);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                    return addStorage();
                }
    
        }
        return null;
    }
   
    public static void removeItem(Resource allResources[]){
        //display the items in the cart, then prompt them to enter a number that corresponds to the list
        String output = "    Type  |  Final Price  |  Savings  |  Initial Price  |  Additional\n";


        if(Resource.getNumResources()>0){
            int x=1;
            for (int i=0;i<Resource.getNumResources();i++){
               output+=x+")  "+allResources[i].toString()+"\n";
                x++;
            }

            int removeResource=Integer.parseInt(JOptionPane.showInputDialog(null, "Cloud Resource in your cart:\n\n"+output+"\nPlease select one you would like to remove."))-1;
            if (removeResource < 0 || removeResource >= Resource.getNumResources()) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number 1 through " + Resource.getNumResources() + ".");
                return;
            }
            for (int i = removeResource; i < Resource.getNumResources() - 1; i++) {
                allResources[i] = allResources[i+1]; // Shift all elements after the removed one to the left
            }

            allResources[Resource.getNumResources() - 1] = null;
            Resource.numResources-=1;
        }else{
            JOptionPane.showMessageDialog(null, "You have not added any resources yet.");
        }


    }
   
    public static void displayCart(Resource allResources[], Customer Customer1){
        if(allResources[0]!=null){
            int numStorage=0;
            int numServers=0;
            int numML=0;

            String output = "Number of Cloud Resources: "+Resource.getNumResources();
            //first for loop is to get num of each resources
            for (int i=0; i<Resource.getNumResources(); i++){
                if (allResources[i] != null) {
                    if(allResources[i]instanceof Storage){
                        numStorage++;
                    }
                    if(allResources[i]instanceof MachineLearning){
                        numML++;
                    }
                    if(allResources[i]instanceof VirtualServers){
                        numServers++;
                    } 
                }
            }
            output+="\nStorage: "+numStorage+"\nMachine Learning: "+numML+"\nVirtual Server: "+numServers;
            output+="\n\nType  |  Final Price  |  Savings  |  Initial Price  |  Additional\n";
            for(int i=0; i<Resource.getNumResources();i++){
                output+=allResources[i].toString()+"\n";
            }
            output+="\n\nSubtotal: $"+Customer1.getSubtotal(allResources);

            JOptionPane.showMessageDialog(null, output);
            
        }else{JOptionPane.showMessageDialog(null, "You have not added any resources yet.");}
    }

    public static void checkout(Customer Customer1, Resource allResources[]){
        if(allResources[0]!=null){
            int numStorage=0;
            int numServers=0;
            int numML=0;

            String output = "Your Information:\nName: "+Customer1.getFullName()+"\nEmail: "+Customer1.getEmail();
            for (int i=0; i<Resource.getNumResources(); i++){
                if (allResources[i] != null) {
                    if(allResources[i]instanceof Storage){
                        numStorage++;
                    }
                    if(allResources[i]instanceof MachineLearning){
                        numML++;
                    }
                    if(allResources[i]instanceof VirtualServers){
                        numServers++;
                    }
                }
            }
            output+="\n\nNumber of Cloud Resources: "+Resource.getNumResources()+"\nStorage: "+numStorage+"\nMachine Learning: "+numML+"\nVirtual Server: "+numServers;
            output+= "\n\nYour Resources:\nType  |  Final Price  |  Savings  |  Initial Price  |  Additional\n";
            for (int i=0;i<Resource.getNumResources();i++){
                output+=allResources[i].toString()+"\n";
            }
            output+="\n\nTotal: $"+Customer1.getSubtotal(allResources);

            JOptionPane.showMessageDialog(null, output);
    }else{JOptionPane.showMessageDialog(null, "You have not added any resources yet.");}
}
}
