package airline_reservation_awt;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class mainFn extends Frame implements ActionListener {
	TextField phone_dob, email;
    Button login, signUp;
    Label topic, phone_dob_lb, email_lb;
    Image backgroundImage;
    String[] emails = new String[100];
    String[] name = new String[100];
    long[] phoneNumber = new long[100];
    String[] city = new String[100];
    String[] date = new String[100];
    static int nos = 4;
    static int index = 0;
    Frame f = new Frame();

    public mainFn() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        backgroundImage = Toolkit.getDefaultToolkit().getImage("F:\\Bluetooth\\airline.jpg");
        setSize(new Dimension(600, 600));
        setTitle("Airline Reservation Application");

        emails[0] = "nitish@gmail.com";
        emails[1] = "kumaresan@gmail.com";
        emails[2] = "karthik@gmail.com";
        emails[3] = "malini@gmail.com";

        name[0] = "Nitish";
        name[1] = "Kumaresan";
        name[2] = "Karthik";
        name[3] = "Malini";

        phoneNumber[0] = 1111111111L;
        phoneNumber[1] = 2222222222L;
        phoneNumber[2] = 3333333333L;
        phoneNumber[3] = 4444444444L;

        city[0] = "Komarapalayam";
        city[1] = "Thiruvarur";
        city[2] = "Karur";
        city[3] = "Perundurai";

        date[0] = "20/03/2006";
        date[1] = "11/11/2005";
        date[2] = "10/04/2006";
        date[3] = "01/01/2006";

        topic = new Label("Airline Reservation");
        topic.setFont(new Font("Times New Roman", Font.BOLD, 24));
        email_lb = new Label("Enter your email : ");
        email = new TextField();
        email.setPreferredSize(new Dimension(150, 25));
        phone_dob_lb = new Label("Enter your phoneNumber or dob(DD/MM/YYYY) : ");
        phone_dob = new TextField();
        phone_dob.setEchoChar('*');
        phone_dob.setPreferredSize(new Dimension(150, 25));

        login = new Button("Login");
        login.setPreferredSize(new Dimension(60, 30));
        signUp = new Button("Signup");
        signUp.setPreferredSize(new Dimension(60, 30));
        login.addActionListener(this);
        signUp.addActionListener(this);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(topic, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 2, 2, 2);
        add(email_lb, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(email, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 2, 2, 2);
        add(phone_dob_lb, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(phone_dob, gbc);

        
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(login);
        buttonPanel.add(signUp);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        add(buttonPanel, gbc);

        email.addActionListener(this);
        phone_dob.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage, 1, 1, getWidth(), getHeight(), this);
    }

    public void actionPerformed(ActionEvent ae) {
    	
        if (ae.getSource() == login) {
        	revalidate();
            int flag = 0,flag1 = 0,flag2 = 0;
            String emailTxt = email.getText();
            String phone_dobTxt = phone_dob.getText();
            for(int i=0;i<emailTxt.length();i++) {
            	char ch = emailTxt.charAt(i);
            	if(ch == '@') {
            		flag2++;
            	}
            }
            if(emailTxt.contains("gmail") || emailTxt.contains("outlook") || emailTxt.contains("yahoo") || emailTxt.contains("zoho")) {
            	flag2++;
            }
            if(flag2 != 2) {
            	Dialog dialog3 = new Dialog(f,"Error",true);
                dialog3.setSize(220,80);
                dialog3.setLayout(new FlowLayout());
                Label notFound = new Label("Please enter a valid email-address");
                dialog3.add(notFound);
                
                dialog3.addWindowListener(new WindowAdapter() {
            		public void windowClosing(WindowEvent we) {
            			dialog3.setVisible(false);
            		}
            	});
                
                dialog3.setVisible(true);
            }
            else {
            	for (int i = 0; i < nos; i++) {
                    if (emailTxt.equalsIgnoreCase(emails[i])) {
                    	index = i;
                    	flag = 1;
                    	
                    	if(phone_dobTxt.equalsIgnoreCase(date[index])) {
                    		flag1 = 1;

                    		
                    	}
                    	if(flag1 == 0) {
                    		
                    		long phoneNumberGiven = 0;
                    		try {
                    			
                    			phoneNumberGiven = Long.parseLong(phone_dobTxt);
                    			if(phoneNumberGiven == phoneNumber[index]) {
                    				flag1 = 1;
                    				
                    			}
                    		}
                    		catch(Exception e) {
                    			
                    		}
                    		for(int j = 0;j < nos; j++) {
                    			if(phoneNumberGiven == phoneNumber[j]) {
                    				flag1 = 1;
                    				
                    				break;
                    			}
                    		}
                    	}
                    	if(flag1 == 1) {
                    		displayAirlineClass obj1 = new displayAirlineClass(name[index]);
                            dispose();
                    	}
                    	else {
                    		Dialog dialog2 = new Dialog(f,"Error",true);
                            dialog2.setSize(200,80);
                            dialog2.setLayout(new FlowLayout());
                            Label notFound = new Label("Password is invalid \n Try again");
                            dialog2.add(notFound);
                            
                            dialog2.addWindowListener(new WindowAdapter() {
                        		public void windowClosing(WindowEvent we) {
                        			dialog2.setVisible(false);
                        		}
                        	});
                            
                            dialog2.setVisible(true);
                    	}
                        
                    }
                 
                }
                if (flag == 0) {
                    Dialog dialog1 = new Dialog(f,"Error",true);
                    dialog1.setSize(200,80);
                    dialog1.setLayout(new FlowLayout());
                    Label notFound = new Label("User not found. Please signup");
                    dialog1.add(notFound);
                    
                    dialog1.addWindowListener(new WindowAdapter() {
                		public void windowClosing(WindowEvent we) {
                			dialog1.setVisible(false);
                		}
                	});
                    
                    dialog1.setVisible(true);
                }
            } 
            
        } 
        else if (ae.getSource() == signUp) {
        	Label heading,emailLb,nameLb,phonenumberLb,dateLb,cityLb;
        	TextField emailSignup,nameSignup,phonenumberSignup,dateSignup,citySignup;
        	Button submit,clear;
        	Image bgImage;
        	bgImage = Toolkit.getDefaultToolkit().getImage("F:\\Bluetooth\\signup.png");

            Frame newFrame = new Frame() {
            	public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(bgImage, 1, -90, getWidth(), 400, this);
                }
            };
        	newFrame.setSize(new Dimension(650,450));
        	newFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        	newFrame.setLayout(new GridBagLayout());
        


        	heading = new Label("Register here!!                     ");
        	heading.setFont(new Font("Arial",Font.BOLD,22));
        	
        	emailLb = new Label("Email Address:");
            emailSignup = new TextField(20);
            emailSignup.addActionListener(this);
            
            nameLb = new Label("Name:");
            nameSignup = new TextField(20);
            nameSignup.addActionListener(this);
            
            phonenumberLb = new Label("Contact Number:");
            phonenumberSignup = new TextField(20);
        	phonenumberSignup.addActionListener(this);
        	
        	dateLb = new Label("Date of Birth (DD/MM/YYYY):");
            dateSignup = new TextField(20);
            dateSignup.addActionListener(this);
            
            cityLb = new Label("City:");
            citySignup = new TextField(20);
            citySignup.addActionListener(this);
        	
            GridBagConstraints gbc = new GridBagConstraints();
        	gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(10, 10, 10, 10);
            
            gbc.gridx = 0;
            gbc.gridy = 0;
            newFrame.add(heading, gbc);
            
            gbc.gridx = 0;
            gbc.gridy = 1;
            newFrame.add(emailLb, gbc);

            gbc.gridx = 1;
            newFrame.add(emailSignup, gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            newFrame.add(nameLb, gbc);

            gbc.gridx = 1;
            newFrame.add(nameSignup, gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
            newFrame.add(phonenumberLb, gbc);

            gbc.gridx = 1;
            newFrame.add(phonenumberSignup, gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            newFrame.add(dateLb, gbc);

            gbc.gridx = 1;
            newFrame.add(dateSignup, gbc);

            gbc.gridx = 0;
            gbc.gridy = 5;
            newFrame.add(cityLb, gbc);

            gbc.gridx = 1;
            newFrame.add(citySignup, gbc);
            
            submit = new Button("Submit");
        	submit.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent ae) {
        			String emailsignup = emailSignup.getText();
        			String namesignup = nameSignup.getText();
        			String phonenumbersignup = phonenumberSignup.getText();
        			String datesignup = dateSignup.getText();
        			String citysignup = citySignup.getText();
        			
        			if(emailsignup.isEmpty() || namesignup.isEmpty() || phonenumbersignup.isEmpty() || datesignup.isEmpty() || citysignup.isEmpty()) {
        				Dialog dialog3 = new Dialog(f,"Error",true);
                        dialog3.setSize(200,80);
                        dialog3.setLayout(new FlowLayout());
                        Label notFound = new Label("Please fill all the details");
                        dialog3.add(notFound);
                        
                        dialog3.addWindowListener(new WindowAdapter() {
                    		public void windowClosing(WindowEvent we) {
                    			dialog3.setVisible(false);
                    		}
                    	});
                        
                        dialog3.setVisible(true);
        			}
        			else {
        				int flag = 1;
        				for(String mail : emails) {
        					if(mail.equalsIgnoreCase(emailsignup)) {
        						flag = 0;
        						break;
        					}
        				}
        				if(flag == 0) {
        					Dialog dialog3 = new Dialog(f,"Error",true);
                            dialog3.setSize(280,80);
                            dialog3.setLayout(new FlowLayout());
                            Label notFound = new Label("User already exists. Please login");
                            dialog3.add(notFound);
                            
                            dialog3.addWindowListener(new WindowAdapter() {
                        		public void windowClosing(WindowEvent we) {
                        			dialog3.setVisible(false);
                        		}
                        	});
                            
                            dialog3.setVisible(true);
        				}
        				else {
        					int flag2 = 0;
            				emails[nos] = emailsignup;
                			name[nos] = namesignup;
                			phoneNumber[nos] = Long.parseLong(phonenumbersignup);
                			date[nos] = datesignup;
                			city[nos] = citysignup;
                			
                			for(int i=0;i<emailsignup.length();i++) {
                            	char ch = emailsignup.charAt(i);
                            	if(ch == '@') {
                            		flag2++;
                            	}
                            }
                            if(emailsignup.contains("gmail") || emailsignup.contains("outlook") || emailsignup.contains("yahoo") || emailsignup.contains("zoho")) {
                            	flag2++;
                            }
                            if(flag2 != 2) {
                            	Dialog dialog3 = new Dialog(f,"Error",true);
                                dialog3.setSize(220,80);
                                dialog3.setLayout(new FlowLayout());
                                Label notFound = new Label("Please enter a valid email-address");
                                dialog3.add(notFound);
                                
                                dialog3.addWindowListener(new WindowAdapter() {
                            		public void windowClosing(WindowEvent we) {
                            			dialog3.setVisible(false);
                            		}
                            	});
                                
                                dialog3.setVisible(true);
                            }
                			
                            else {
                            	int flag3 = 0,flag4 = 0;
                            	for(int i=0;i<datesignup.length();i++) {
                            		char ch = datesignup.charAt(i);
                            		if(ch=='/') {
                            			flag3++;
                            		}
                            		else {
                            			try {
                            				int checking = Integer.parseInt(String.valueOf(datesignup.charAt(i)));
                            				flag4++;
                            			}
                            			catch(Exception e) {
                            				
                            			}
                            		}
                            	}
                            	if(flag3==2 && flag4==8) {
                            		nos++;
                        			
                        			
                        			Dialog dialog4 = new Dialog(f,"Error",true);
                                    dialog4.setSize(250,80);
                                    dialog4.setLayout(new FlowLayout());
                                    Label notFound = new Label("Registration successfully!! Please login");
                                    dialog4.add(notFound);
                                    
                                    dialog4.addWindowListener(new WindowAdapter() {
                                		public void windowClosing(WindowEvent we) {
                                			dialog4.setVisible(false);
                                		}
                                	});
                                    
                                    dialog4.setVisible(true);
                        			
                        			newFrame.setVisible(false);
                        	
                            	}
                            	else {
                            		Dialog dialog3 = new Dialog(f,"Error",true);
                                    dialog3.setSize(300,80);
                                    dialog3.setLayout(new FlowLayout());
                                    Label notFound = new Label("Please enter a valid Date of Birth (DD-MM-YYYY)");
                                    dialog3.add(notFound);
                                    
                                    dialog3.addWindowListener(new WindowAdapter() {
                                		public void windowClosing(WindowEvent we) {
                                			dialog3.setVisible(false);
                                		}
                                	});
                                    
                                    dialog3.setVisible(true);
                            	}
                            	
                            }
        				}
        				
        					
            			
        			}
        			
        		}
        	});
        	submit.setPreferredSize(new Dimension(60,30));
        	clear = new Button("Clear");
        	clear.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			emailSignup.setText("");
        			nameSignup.setText("");
        			phonenumberSignup.setText("");
        			dateSignup.setText("");
        			citySignup.setText("");
        		}
        	});
        	clear.setPreferredSize(new Dimension(60,30));
        	
            
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.anchor = GridBagConstraints.EAST;
            newFrame.add(submit,gbc);
        	
            gbc.gridx = 1;
            gbc.gridy = 6;
            gbc.anchor = GridBagConstraints.WEST;
        	newFrame.add(clear,gbc);

        	

        	newFrame.addWindowListener(new WindowAdapter() {
        		public void windowClosing(WindowEvent e) {
        			newFrame.setVisible(false);
        		}
        	});
        	
        	newFrame.setVisible(true);
        }
    }
    
    

    public static void main(String[] args) {
        mainFn obj = new mainFn();
        obj.setVisible(true);
    }
}

class displayAirlineClass extends Frame implements ActionListener,ItemListener{
    String[] airlines_name = {"Airway 1", "Airway 2", "Airway 3", "Airway 4", "Airway 5"};
    int[] airlines_number = {1, 2, 3, 4, 5};
    String[] from = {"Delhi", "Mumbai", "Bangalore", "Jammu & Kashmir", "Goa"};
    String[] to = {"Bangalore", "Delhi", "Coimbatore", "Delhi", "Bangalore"};
    double[] prices = {1200.50, 1500.90, 1000.10, 2000, 5000};
    Label l1,l2,l3,l4,l5;
    TextField noPassenger;
	List airwayList;
	Button submit,cash,card;
	Checkbox single,round;
	String msg = "",nameDisplay;
	Image backgroundImage;
	Frame f = new Frame();
	Random random = new Random();
	CheckboxGroup cbg;
	int numberPassengers;
	double price;
	
    public displayAirlineClass(String nameDisplay) {
    	cbg = new CheckboxGroup();
    	backgroundImage = Toolkit.getDefaultToolkit().getImage("F:\\Bluetooth\\confirmation.jpg");
    	this.nameDisplay = nameDisplay;
    	setTitle("Display Airlines");
		setSize(500,400);
		setLayout(new FlowLayout());
		mainFn obj = new mainFn();
		
		for(int i=0;i<9;i++) {
			add(new Label(" "));
		}
		
		l3 = new Label("Welcome back!!  " + nameDisplay);
		l3.setFont(new Font("Arial",Font.ITALIC,20));;
		add(l3);
		String line = "";
		for(int i=0;i<120;i++) {
			msg+="-";
		}
		l4 = new Label(msg);
		add(l4);
		l1 = new Label("Select any one of the available Airlines ",0);
		l1.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(l1);
		airwayList = new List(4);
		for(int i=0;i<5;i++) {
			msg = "";
			msg+=airlines_name[i] + "         " + airlines_number[i] + "             " + from[i] + "  ";
			for(int j=(from[i].length());j<=20;j++) {
				msg+=" ";
				if(j==15) {
					msg+="->";
				}
			}
			msg+=to[i];
			airwayList.add(msg);
		}
		airwayList.select(0);
		add(airwayList);
		
		single = new Checkbox("Single trip",cbg,true);
		single.setFont(new Font("Arial",Font.ITALIC,20));
		single.addItemListener(this);
		round = new Checkbox("Round trip",cbg,false);
		round.setFont(new Font("Arial",Font.ITALIC,20));
		round.addItemListener(this);
		add(single);
		add(round);
		
		for(int i=0;i<10;i++) {
			add(new Label("   "));
		}
		
		submit = new Button("Submit");
		submit.setPreferredSize(new Dimension(60, 30));
		submit.addActionListener(this);
		airwayList.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		l2 = new Label("Enter the number of passengers : ",1);
		add(l2);
		noPassenger = new TextField(5);
		noPassenger.setText("1");
		add(noPassenger);
		for(int i=0;i<5;i++) {
			add(new Label("     "));
		}
		
		add(submit);
		setResizable(false);
		setVisible(true);
    }
    
    public void itemStateChanged(ItemEvent ie) {
    	repaint();
    }
    
    public void actionPerformed(ActionEvent ae) {
		repaint();
		numberPassengers = Integer.parseInt(noPassenger.getText());
		if(ae.getSource() == submit) {
			
			String tripType = cbg.getSelectedCheckbox().getLabel();
	    	if(tripType.equalsIgnoreCase("Single Trip")) {
	    		price = prices[airwaySelected()]*numberPassengers;
	    	}
	    	else {
	    		double randomNumber = Math.round(random.nextInt(100));
	    		price = (prices[airwaySelected()]*numberPassengers)+randomNumber;
	    	}
	    	
			
			Dialog dialog3 = new Dialog(f,"Confirmation",true) {
				public void paint(Graphics g) {
					super.paint(g);
					g.drawImage(backgroundImage, 1, 1, getWidth(), getHeight(), this);
				}
			};
			
	   
			
			GridBagConstraints gbc = new GridBagConstraints();
			dialog3.setSize(500,300);
            dialog3.setLayout(new GridBagLayout());
            Label confirmation = new Label("Are you sure to book this airline? ");
            confirmation.setFont(new Font("Times New Roman",Font.BOLD,18));
            
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            dialog3.add(confirmation,gbc);
            String msg = "";
            msg+=airlines_name[airwaySelected()] + "     :   " + airlines_number[airwaySelected()] + "             " + from[airwaySelected()] + "  ";
            for(int j=(from[airwaySelected()].length());j<=20;j++) {
            	msg+=" ";
            	if(j==15) {
            		msg+="->";
            	}
            }
            msg+=to[airwaySelected()];
            Label display = new Label(msg);
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            dialog3.add(display,gbc);
            Button yes,no;
            yes = new Button("Yes");
            yes.setPreferredSize(new Dimension(60,30));
            yes.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent ae) {
            		setVisible(false);
            		dialog3.dispose();
            		backgroundImage = Toolkit.getDefaultToolkit().getImage("F:\\Bluetooth\\atm.jpg");
            		Dialog dialog4 = new Dialog(f,"Select payment gateway",true) {
            			public void paint(Graphics g) {
            				super.paint(g);
            		        g.drawImage(backgroundImage, 1, 1, getWidth(), getHeight(), this);
            			}
            		};
            		dialog4.setLayout(new GridBagLayout());
            		dialog4.setSize(new Dimension(250,250));
            		
            		cash = new Button("Cash?");
            		cash.addActionListener(new ActionListener() {
            			public void actionPerformed(ActionEvent ae) {
            				dialog4.dispose();
            				Dialog dialog5 = new Dialog(f,"Cash",true) {
            					public void paint(Graphics g) {
            						super.paint(g);
            						g.drawImage(backgroundImage, 1, 1, getWidth(), getHeight(), this);
            					}
            				};
            				
            				GridBagConstraints gbc = new GridBagConstraints();
            				dialog5.setSize(400,250);
            	            dialog5.setLayout(new GridBagLayout());
            	            
            	            Label l10 = new Label("Enter the amount : ");
            	            gbc.gridwidth = 1;
            	            gbc.gridx = 0;
            	            gbc.gridy = 0;
            	            gbc.anchor = GridBagConstraints.CENTER;
            	            dialog5.add(l10,gbc);
            	            
            	            TextField amount = new TextField(20);
            	            gbc.gridx = 1;
            	            gbc.gridy = 0;
            	            dialog5.add(amount,gbc);
            	         
            	            Button addMoney = new Button("Submit");
            	            addMoney.addActionListener(new ActionListener() {
                    			public void actionPerformed(ActionEvent ae) {
                    				String amountGiven = amount.getText();
                    				double handAmt = Double.parseDouble(amountGiven);
                    				if(handAmt < price) {
                    					Dialog dialog6 = new Dialog(f,"Error",true);
                                        dialog6.setSize(200,80);
                                        dialog6.setLayout(new FlowLayout());
                                        Label notFound = new Label("Insufficient amount!!");
                                        dialog6.add(notFound);
                                        
                                        dialog6.addWindowListener(new WindowAdapter() {
                                    		public void windowClosing(WindowEvent we) {
                                    			dialog6.setVisible(false);
                                    		}
                                    	});
                                        
                                        dialog6.setVisible(true);
                    				}
                    				else {
                    					double balanceAmt = handAmt - price;
                    					Dialog dialog6 = new Dialog(f,"Error",true);
                                        dialog6.setSize(200,120);
                                        dialog6.setLayout(new FlowLayout());
                                        Label notFound1 = new Label("Transcation successful");
                                        dialog6.add(notFound1);
                                        Label notFound2 = new Label("Your balance amount is " + balanceAmt);
                                        dialog6.add(notFound2);
                                        
                                        
                                        dialog6.addWindowListener(new WindowAdapter() {
                                    		public void windowClosing(WindowEvent we) {
                                    			dialog5.dispose();
                                    			dialog6.setVisible(false);
                                    		}
                                    	});
                                        
                                        dialog6.setVisible(true);
                    				}
                    			}
            	            });
            	            gbc.gridwidth = 2;
            	            gbc.gridx = 0;
            	            gbc.gridy = 3;
            	            dialog5.add(addMoney,gbc);
            	            
            	            dialog5.addWindowListener(new WindowAdapter() {
                    			public void windowClosing(WindowEvent we) {
                    				dialog5.setVisible(false);
                    			}
                    		});
            	            
            	            dialog5.setVisible(true);
            			}
            		});
            		card = new Button("Card?");
            		card.addActionListener(new ActionListener() {
            			public void actionPerformed(ActionEvent ae) {
            				dialog4.dispose();
            				transcations obj = new transcations(price);
            			}
            		});
            		Label heading = new Label("Select the payment mode");
            		gbc.fill = GridBagConstraints.HORIZONTAL;
            	    gbc.anchor = GridBagConstraints.CENTER;
            	    

            	    gbc.gridx = 0;
            	    gbc.gridy = 0;
            	    gbc.gridwidth = 2;
            	    dialog4.add(heading, gbc);
            	    
            	    gbc.gridwidth = 1;

            	    gbc.gridx = 0;
            	    gbc.gridy = 1;
            	    dialog4.add(cash, gbc);
            	    
            	    gbc.gridx = 1;
            	    gbc.gridy = 1;
            	    dialog4.add(card, gbc);
            		dialog4.addWindowListener(new WindowAdapter() {
            			public void windowClosing(WindowEvent we) {
            				dialog4.setVisible(false);
            			}
            		});
            		
            		dialog4.setVisible(true);
            		
            	}
            });
            no = new Button("No");
            no.setPreferredSize(new Dimension(60,30));
            no.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent ae) {
            		dialog3.dispose();
            	}
            });
            
            gbc.gridx =  0;
            gbc.gridy = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            l5 = new Label("Ticket price for " + numberPassengers + " passenger/s : " + price);
            l5.setFont(new Font("Times New Roman",Font.PLAIN,16));
            dialog3.add(l5,gbc);
            
            Panel buttonPanel = new Panel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
            buttonPanel.add(yes);
            buttonPanel.add(no);

            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            gbc.insets = new Insets(1,1,1,1);
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.weightx = 0;
            gbc.fill = GridBagConstraints.NONE;
            dialog3.add(buttonPanel, gbc);
            dialog3.addWindowListener(new WindowAdapter() {
        		public void windowClosing(WindowEvent we) {
        			dialog3.setVisible(false);
        		}
        	});
            
            dialog3.setVisible(true);
		}
	}
    
    
    
    public int airwaySelected() {
    	int index = airwayList.getSelectedIndex();
    	return index;
    }
}

class transcations extends Frame implements ActionListener {
	String[] customerName = new String[100];
	long[] cardNumber = new long[100];
	int[] pin = new int[100];
	double[] balance = new double[100];
	static int nos = 4;
	Button fetchData,reset;
	CheckboxGroup cbg = new CheckboxGroup();
	Frame f = new Frame();
	TextField debitNumber,pinNumber;
	Label debitLabel,pinLabel;
	Image backgroundImage;
	long dbtNumber;
	int atmPin,index = 0;
	double price;

	public transcations(double price) {
		this.price = price;
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		setSize(new Dimension(400,400));
		backgroundImage = Toolkit.getDefaultToolkit().getImage("F:\\Bluetooth\\atmPage.jpg");
		customerName[0] = "Nitish";
		customerName[1] = "Kumaresan";
		customerName[2] = "Karthik";
		customerName[3] = "Malini";
		
		cardNumber[0] = 111111111111L;
		cardNumber[1] = 222222222222L;
		cardNumber[2] = 333333333333L;
		cardNumber[3] = 444444444444L;
		
		pin[0] = 123;
		pin[1] = 456;
		pin[2] = 789;
		pin[3] = 123;
		
		balance[0] = 123456.10;
		balance[1] = 43588.10;
		balance[2] = 89642.10;
		balance[3] = 84762.10;
		
		debitLabel = new Label("Enter your debit card number : ");
		pinLabel = new Label("Enter your pin number : ");
		
		debitNumber = new TextField(20);
		pinNumber = new TextField(20);
		pinNumber.setEchoChar('*');
		
		fetchData = new Button("Fetch data");
		fetchData.addActionListener(this);
		reset = new Button("Reset");
		reset.addActionListener(this);
		
		gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(debitLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(debitNumber, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(pinLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pinNumber, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(fetchData, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(reset, gbc);
		
		addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent we) {
    			System.exit(0);
    		}
    	});
		
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
        g.drawImage(backgroundImage, 1, 1, getWidth(), getHeight(), this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == reset) {
			pinNumber.setText("");
			debitNumber.setText("");
		}
		else {
			String debitnumberstr = debitNumber.getText();
			String pinnumberstr = pinNumber.getText();
			try {
				dbtNumber = Long.parseLong(debitnumberstr);
				atmPin = Integer.parseInt(pinnumberstr);
				int flag = 0;
				for(int i=0;i<cardNumber.length;i++) {
					if(dbtNumber == cardNumber[i]) {
						flag = 1;
						index = i;
						break;
					}
				}
				if(flag == 1) {
					if(atmPin == pin[index]) {
						if(price<=balance[index]) {
							balance[index]-=price;
							Dialog dialog1 = new Dialog(f,"Success",true);
							dialog1.setSize(new Dimension(210,160));
							dialog1.setLayout(new GridBagLayout());
							GridBagConstraints gbc = new GridBagConstraints();
							gbc.gridx = 0;
							gbc.gridy = 0;
							dialog1.add(new Label("Transcation Successful"),gbc);
							gbc.gridx = 0;
							gbc.gridy = 1;
							dialog1.add(new Label("Avaiable balance : " + balance[index]),gbc);
							dialog1.addWindowListener(new WindowAdapter() {
								public void windowClosing(WindowEvent we) {
									System.exit(0);
								}
							});
							dialog1.setVisible(true);
						}
						else {
							Dialog dialog1 = new Dialog(f,"Error",true);
							dialog1.setSize(new Dimension(110,80));
							dialog1.add(new Label("Insufficient balance"));
							dialog1.addWindowListener(new WindowAdapter() {
								public void windowClosing(WindowEvent we) {
									dialog1.dispose();								}
							});
							dialog1.setVisible(true);
						}
					}
					else {
						Dialog dialog1 = new Dialog(f,"Error",true);
						dialog1.setSize(new Dimension(110,80));
						dialog1.add(new Label("Invalid atm pin"));
						dialog1.addWindowListener(new WindowAdapter() {
							public void windowClosing(WindowEvent we) {
								dialog1.dispose();							}
						});
						dialog1.setVisible(true);
					}
				}
				else {
					Dialog dialog1 = new Dialog(f,"Error",true);
					dialog1.setSize(new Dimension(150,80));
					dialog1.add(new Label("Card number not found"));
					dialog1.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent we) {
							dialog1.dispose();
						}
					});
					dialog1.setVisible(true);
				}
			}
			catch(Exception e) {
				Dialog dialog1 = new Dialog(f,"Error",true);
				dialog1.setSize(new Dimension(210,80));
				dialog1.add(new Label("Please enter only valid characters!"));
				dialog1.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						dialog1.dispose();					}
				});
				dialog1.setVisible(true);
			}
		}
	}
}