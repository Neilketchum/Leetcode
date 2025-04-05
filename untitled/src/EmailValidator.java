public class EmailValidator {
        public static boolean isValidEmail(String email) {
            // Regular expression for email validation
            String regex = "^[a-z]{1,6}_?[0-9]{0,4}[a-z0-9._%+-]*@[a-z0-9.-]+\\.[a-z]{2,}$";
            
            // Compile the regex and match the input email
            return email.matches(regex);
        }
    
        public static void main(String[] args) {
            // Test email IDs
            String[] emails = {
                "julia@hackerrank.com",     // Valid
                "julia_@hackerrank.com",    // Valid
                "julia_0@hackerrank.com",   // Valid
                "julia0_@hackerrank.com",   // Invalid (underscore comes after digit)
                "julia@gmail.com"           // Valid
            };
            
            // Validate emails
            for (String email : emails) {
                System.out.println(email + ": " + isValidEmail(email));
            }
        }
    
}
