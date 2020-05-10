package calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;

class calculator { 
	
    private String s0, s1, s2 ; 											// store operator and operands 
    
    calculator(){ 													// default constrcutor 			
        s0 = s1 = s2 = "" ; 									// s0 is num1, s1 is operator, s2 is num2
    }
    
	public static void main(String[] args) {
		
		OpenWindow f = new OpenWindow() ;
		f.makeFrame();
        
	}
	
	public String compare(String s) {  														// if the value is a number 
        if (('0' <= s.charAt(0) && s.charAt(0) <= '9') || s.charAt(0) == '.') { 

            if (!s1.equals(""))									// When operator was entered.
                s2 += s ; 
            else												// When operator wasn't entered.
                s0 += s ; 
            
            s = s0 + s1 + s2 ; 							// Set the value of text 
        } 
        else if (s.charAt(0) == 'C') { 							// When Clear is entered

            s0 = s1 = s2 = ""; 									// Initialize the string.
  
            s = s0 + s1 + s2 ; 							// Set the value of text 
        } 
        else if(s.charAt(0) == '<') {							// When Backspace is entered
        	if(!s2.equals("")) {
        		s2 = s2.substring(0, s2.length()-1) ; 			// Removes the last character in the string s2.
        	}													
        	else if(!s1.equals(""))
        		s1 = "" ;										// Initialize the operator.
        	else if(!s0.equals(""))
        		s0 = s0.substring(0, s0.length()-1) ; 			// Removes the last character in the string s2.

            s = s0 + s1 + s2 ; 							// Set the value of text 
        }
        else if (s.charAt(0) == '=') { 							// Output result.
        	if(s1.equals(""))
        		return s0 ;
        	
    		DecimalFormat df = new DecimalFormat("#.######");	// Set the format to output up to six decimal places.
        	BigDecimal num1 = new BigDecimal(s0) ;				// Because BigDecimal used to correct double error.
        	BigDecimal num2 = new BigDecimal(s2) ; 
        	String te ;
            													// Compare operators.
            if (s1.equals("+")) 								// Operator is "+"
                te = (num1.add(num2)).toString() ; 
            
            else if (s1.equals("-")) 							// Operator is "-"
                te = (num1.subtract(num2)).toString(); 
            
            else if (s1.equals("÷")) 							// Operator is "÷"
                te = df.format(num1.divide(num2, MathContext.DECIMAL32));				
            /* MathContext.DECIMAL32 : Limit the total number of digits to seven and round it up.
            	Insert the calculation results into the string te for the specified format. */
            
            else if (s1.equals("X"))							// Operator is "X"
                te = (num1.multiply(num2)).toString(); 
            
            else												// Operator wasn't entered.
            	te = num1.toString() ;
            										
        	s = s0 + s1 + s2 + "=" + te ; 				// Set the value of text
           	
        	s0 = te.toString(); 								// Convert it to string
            s1 = s2 = ""; 										// Initialize num2, operator
        	
        } 
        else if (s1.equals("") || s2.equals("")) { 				// Input Operator
            s1 = s; 
            s = s0 + s1 + s2 ; 							// Set the value of text 
        } 
        
        return(s) ; 							// Set the value of text 
    }
}