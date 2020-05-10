package calculator;


import java.awt.* ;
import java.awt.event.*;


class OpenWindow extends calculator{

	
	calculator c = new calculator() ;						// create a object of class
	
	TextField l = new TextField(15) ;  				// create a JTextField
		
	String Text ;
	
	public void makeFrame() {
		Frame frame = new Frame("Calculrator");				// create a frame
		
		int width = 360, height = 480;						// Set width, height of frame size
		
		String btnSText[] = {"C", "="} ;						// This is what's inside the JButton btnS.
		
		Button btnS[] = new Button[2] ;					// Create a JButton btnS in a 2 X 1 array.
		
		String[][] btnText= {{"7", "8", "9", "÷"},
							{"4", "5", "6", "X"},
							{"1", "2", "3", "-"},
							{".", "0", "<", "+"}};			// This is what's inside the JButton btn.
		
		Button[][] btn = new Button[4][4] ; 		// Create a JButton btn in a 4 x 4 array.

	    Font font1 = new Font("DialogIntput",Font.BOLD,30) ;	// number & operator font
	    
	    Font font2 = new Font("DialogIntput",Font.ITALIC,20) ;	// Calculrator interface font.
		
	    
	    l.setEditable(false); 									// JTextField l can only be used as a keypad to prevent editing.
	    l.setFont(font2) ;										// Set the JTextField l to font2. 
	    
		frame.setSize(width, height) ;							// The frame setting width is 360px and height = 480px.
	    frame.setResizable(false);								// The frame cannot be resized.
	    
	    frame.addWindowListener(new WindowAdapter(){
	    	
	         public void windowClosing(WindowEvent e) //WindowAdapter class Overriding
	         {
	            frame.dispose(); 					//Memory free method
	            System.exit(0);
	         }
	      });
	    Panel head = new Panel() ;							// Create a JPanel head
	    Panel panel = new Panel() ;							// Create a JPanel panel
	    
	    head.setPreferredSize(new Dimension(360, 85));			// Adjust the size of the JPanel panel to width 360px, height 85px.
	   
	    
	    frame.add(head, BorderLayout.NORTH) ;					// Insert the head into the NORTH side of the frame.
		frame.add(panel, BorderLayout.CENTER) ;					// Insert the panel into the CENTER side of the frame.
	
		Panel head1 = new Panel() ;							// Create a JPanel head1, head2
		Panel head2 = new Panel() ;							// head1 is JTextField l
																// head2 is JButton btnS, {"C", "="}
	    head.setLayout(new GridLayout(1, 0, 5, 5)) ;			// Set GridLayout for head.
	    
	    head.add(head1) ;										// Head1 Layout
	    head1.setLayout(new GridLayout()) ;
	    head1.add(l) ;
	    
	    head.add(head2) ;										// Head2 Layout
	    head2.setLayout(new GridLayout(1, 0, 5, 5)) ;
	    
	    for(int i = 0; i < 2; i++) {
			btnS[i] = new Button(btnSText[i]) ;				// Initialize the button.
			btnS[i].setFont(font1);								// Set the font to font1
			
			if(i == 0)
				btnS[i].setBackground(Color.RED) ;				// Set the Background color for button "C"
			else
				btnS[i].setBackground(new Color(69, 73, 78)) ;	// Set the Background color for button "="
			
			btnS[i].setForeground(Color.white); 				// Set the character color to white.
			btnS[i].addActionListener(new ActionListener(){			/*Add button-click action. c is Class calculator*/
				@Override
				public void actionPerformed(ActionEvent e) {
					l.setText(c.compare(e.getActionCommand())) ;
				}
			}) ;
			head2.add(btnS[i]) ;								// Add JButton btnS to head2
		}
	    
	    panel.setLayout(new GridLayout(4, 4, 5, 5)) ;			// Set GridLayout for panel
	    
	    for(int j = 0; j < 4; j++) {
			for(int i = 0; i < 4; i++) {
				btn[j][i] = new Button(btnText[j][i]) ;		// Initialize the button.
				
				if(i == 3 || i == 2 && j == 3)					// Set operator Color
					btn[j][i].setBackground(new Color(69, 73, 78)) ;	
				else											// Set number Color
					btn[j][i].setBackground(new Color(39, 41, 43)) ;
				
				btn[j][i].setFont(font1);						// Set the font to font1 
				btn[j][i].setForeground(Color.white); 			// Set the character color to white.
				btn[j][i].addActionListener(new ActionListener(){			/*Add button-click action. c is Class calculator*/
					@Override
					public void actionPerformed(ActionEvent e) {
						l.setText(c.compare(e.getActionCommand())) ;
					}
				}) ;
				panel.add(btn[j][i]) ;							// Add JButton btn to panel
			}	    
	    }
	    frame.setVisible(true);                        			// Frame show
	    
	}
}
