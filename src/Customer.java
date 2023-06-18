import java.util.Arrays;

public class Customer {
    

    String fullName;
    String password;
    String email;
    String address;
    private Resource[]resources;

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        int count = 0;
        if(fullName.trim().equals("") || fullName==null){
            throw new IllegalArgumentException("Name must be provided.");
        }
        for(int i=0; i<fullName.length();i++){
            if(Character.isLetter(fullName.charAt(i))){
                count ++;
            }
            else if(Character.isSpaceChar(fullName.charAt(i))){
                count ++;
            }
        }
        if(count == fullName.length()) this.fullName = fullName;
        else {throw new IllegalArgumentException("Name must be only letters");}
    }
    public String getPassword() {
        return password;
    }
   
   
   
   
    public void setPassword(String password) {
        boolean isDigit = false;
        boolean isUpper = false;
        boolean isLower = false;
        boolean specialChar = false;


        if(password.length()<8 || password.length()>16){
            throw new IllegalArgumentException("Password must be between 8-16 characters.");
        }
        for(int i = 0;i<password.length();i++){
            if(Character.isDigit(password.charAt(i))){
                isDigit = true;
            }
            if(Character.isUpperCase(password.charAt(i))){
                isUpper = true;
            }
            if(Character.isLowerCase(password.charAt(i))){
                isLower = true;
            }
            if(!Character.isDigit(password.charAt(i)) && !Character.isLetter(password.charAt(i))){
                specialChar = true;
            }
            if(isDigit && isUpper && isLower && specialChar){
                this.password = password;
            }    
        }
        if(!isDigit){
            throw new IllegalArgumentException("Password must have at least 1 digit.");
        }
        if(!isUpper){
            throw new IllegalArgumentException("Password must have at least 1 uppercase letter.");
        }
        if(!isLower){
            throw new IllegalArgumentException("Password must have at least 1 lowercase letter.");
        }
        if(!specialChar){
            throw new IllegalArgumentException("Password must have at least 1 special character.");
        }
    }




    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        String pattern = ".+@.+\\.com";
        if(email == null || email.equalsIgnoreCase("")){
            throw new IllegalArgumentException("email cannot be empty.");
        }
        if(!email.matches(pattern)){
            throw new IllegalArgumentException("Please include your full email address.\n\n Example: rkrohne@gmail.com");
        } 
        this.email = email;
    }
    public Resource[] getResources() {
        return resources;
    }
    public void setResources(Resource[] resources) {
        this.resources = resources;
    }

    
    public Customer(String fullName, String password, String email,
            Resource[] resources) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.resources = resources;
    }

    public double getSubtotal(Resource resources[]){
        double subtotal =0;
        for (int i=0;i<Resource.getNumResources();i++){
            subtotal+=resources[i].calculateFees();
        }
        return subtotal;
    }
    
    public String toString() {
        return "Customer [fullName=" + fullName + ", password=" + password + ", email="
                + email+", resources="
                + Arrays.toString(resources) + "]";
    }
}
