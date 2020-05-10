import java.awt.*;
import java.awt.event.* ;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import javax.swing.* ;

class calculator extends JFrame implements ActionListener { 
	
	static int width = 360, height = 480;						// Set width, height of frame size
	
	
	static String btnSText[] = {"C", "="} ;						// This is what's inside the JButton btnS.
	
	static JButton btnS[] = new JButton[2] ;					// Create a JButton btnS in a 2 X 1 array.
	
	
	static String[][] btnText= {{"7", "8", "9", "÷"},
								{"4", "5", "6", "X"},
								{"1", "2", "3", "-"},
								{".", "0", "◁", "+"}};			// This is what's inside the JButton btn.
	
	public static JButton[][] btn = new JButton[4][4] ; 		// Create a JButton btn in a 4 x 4 array.
	
	static JTextField l = new JTextField(15) ;  				// create a JTextField 
	
    String s0, s1, s2; 											// store operator and operands 
    
    calculator(){ 												// default constrcutor 			
        s0 = s1 = s2 = "" ; 									// s0 is num1, s1 is operator, s2 is num2
    } 						

    
	public static void main(String[] args) {
		JFrame frame = new JFrame("Calculrator");				// create a frame
		
        calculator c = new calculator();						// create a object of class
        
        Font font1 = new Font("DialogIntput",Font.BOLD,30) ;	// number & operator font
        
        Font font2 = new Font("DialogIntput",Font.ITALIC,20) ;	// Calculrator interface font.
        
        l.setEditable(false); 									// JTextField l can only be used as a keypad to prevent editing.
	    l.setFont(font2) ;										// Set the JTextField l to font2. 
	    l.setHorizontalAlignment(SwingConstants.RIGHT);			// Set the JTextField l to right alignment
	    
		frame.setSize(width, height) ;							// The frame setting width is 360px and height = 480px.
        frame.setResizable(false);								// The frame cannot be resized.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 	// Exit program as soon as frame is closed
		
        JPanel head = new JPanel() ;							// Create a JPanel head
        JPanel panel = new JPanel() ;							// Create a JPanel panel
        
        head.setPreferredSize(new Dimension(360, 85));			// Adjust the size of the JPanel panel to width 360px, height 85px.
       
        
        frame.add(head, BorderLayout.NORTH) ;					// Insert the head into the NORTH side of the frame.
		frame.add(panel, BorderLayout.CENTER) ;					// Insert the panel into the CENTER side of the frame.

		JPanel head1 = new JPanel() ;							// Create a JPanel head1, head2
		JPanel head2 = new JPanel() ;							// head1 is JTextField l
																// head2 is JButton btnS, {"C", "="}
	    head.setLayout(new GridLayout(1, 0, 5, 5)) ;			// Set GridLayout for head.
	    
	    head.add(head1) ;										// Head1 Layout
	    head1.setLayout(new GridLayout()) ;
	    head1.add(l) ;
	    
	    head.add(head2) ;										// Head2 Layout
	    head2.setLayout(new GridLayout(1, 0, 5, 5)) ;
	    
	    for(int i = 0; i < 2; i++) {
			btnS[i] = new JButton(btnSText[i]) ;				// Initialize the button.
			btnS[i].setFont(font1);								// Set the font to font1
			
			if(i == 0)
				btnS[i].setBackground(Color.RED) ;				// Set the Background color for button "C"
			else
				btnS[i].setBackground(new Color(69, 73, 78)) ;	// Set the Background color for button "="
			
			btnS[i].setForeground(Color.white); 				// Set the character color to white.
			btnS[i].addActionListener(c);						// Add button-click action. c is Class calculator
			head2.add(btnS[i]) ;								// Add JButton btnS to head2
		}
	    
	    panel.setLayout(new GridLayout(4, 4, 5, 5)) ;			// Set GridLayout for panel
	    
	    for(int j = 0; j < 4; j++) {
			for(int i = 0; i < 4; i++) {
				btn[j][i] = new JButton(btnText[j][i]) ;		// Initialize the button.
				
				if(i == 3 || i == 2 && j == 3)					// Set operator Color
					btn[j][i].setBackground(new Color(69, 73, 78)) ;	
				else											// Set number Color
					btn[j][i].setBackground(new Color(39, 41, 43)) ;
				
				btn[j][i].setFont(font1);						// Set the font to font1 
				btn[j][i].setForeground(Color.white); 			// Set the character color to white.
				btn[j][i].addActionListener(c);					// Add button-click action. c is Class calculator
				panel.add(btn[j][i]) ;							// Add JButton btn to panel
			}	    
	    }
        frame.setVisible(true);                        			// Frame show
	}
	
	
	public void actionPerformed(ActionEvent e){ 
        String s = e.getActionCommand();  
        
        														// if the value is a number 
        if (('0' <= s.charAt(0) && s.charAt(0) <= '9') || s.charAt(0) == '.') { 

            if (!s1.equals(""))									// When operator was entered.
                s2 += s ; 
            else												// When operator wasn't entered.
                s0 += s ; 
            
            l.setText(s0 + s1 + s2); 							// Set the value of text 
        } 
        else if (s.charAt(0) == 'C') { 							// When Clear is entered

            s0 = s1 = s2 = ""; 									// Initialize the string.
  
            
            l.setText(s0 + s1 + s2); 							// Set the value of text 
        } 
        else if(s.charAt(0) == '◁') {							// When Backspace is entered
        	if(!s2.equals("")) {
        		s2 = s2.substring(0, s2.length()-1) ; 			// Removes the last character in the string s2.
        	}													
        	else if(!s1.equals(""))
        		s1 = "" ;										// Initialize the operator.
        	else if(!s0.equals(""))
        		s0 = s0.substring(0, s0.length()-1) ; 			// Removes the last character in the string s2.

            l.setText(s0 + s1 + s2) ; 							// Set the value of text 
        }
        else if (s.charAt(0) == '=') { 							// Output result.
        	
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
            										
        	l.setText(s0 + s1 + s2 + "=" + te) ; 				// Set the value of text
             
            s0 = te.toString(); 								// Convert it to string
            s1 = s2 = ""; 										// Initialize num2, operator
        } 
        else if (s1.equals("") || s2.equals("")) { 				// Input Operator
            s1 = s; 
            l.setText(s0 + s1 + s2); 							// Set the value of text 
        } 
	}
}