/**
* The ATM machine program uses a GUI interface which allows users to do withdraw, deposit, 
* transfers and view balances of there checking and savings account
* @author  Bradley Isaacs
* @version 1.0
* @since   2017-09-25 
*/

import java.awt.event.*;
import java.text.*;
import javax.swing.*;

/*Documentation
Lessons Learned
 * I learned how to program with GUI, prior to this class, I had 
never used GUI in any programs in my prior high school and college courses
Possible Improvements
 * Add a check that only allows the user to enter a decimal number with two decimal numbers
If a user enters 18.975 into the text box the program will interpret that as 18.98 which is incorrect in money.
Approach
 * I broke the project into steps first by looking up how to create the visual GUI. Second how to add listeners.
 * Then I programmed the listeners of each button to complete there selected task.
Extra Efforts
 * Added two addition checks: Text field has a value (not empty), value is positive
 * Added a DecimalFormat in which I show all money values to two decimal places
Test Plan
 * Case 1:
 1. Click on Balance button.
 2. A JOptionPane will show the amounts balance of your Checking Account and Savings Account are $0.00 and $0.00 dollars respectively.
 3. Click on Savings radio button.
 4. Type in "text" in Text Field.
 5. Click on Deposit button
 6. A JOptionPane will show that text is not valid please enter a number.
 7. Type "10" in Text field.
 8. Click on Deposit button
 9. Observe that screen is cleared after you've been shown the JOpitionPane saying the deposit was successful.
 10. Click on Balance button.
 11. Verify that JOptionPane window shows displaying the amounts for Checking Account and Savings Account are $0.00 and $10.00 dollars respectively.
 * Case 2:
 1. Type 40 in the Text Field.
 2. Click the withdrawal button.
 3. A JOptionPane with show that the action is not possible due to lack of money in your Checking Account.
 4. Type 100 into the Text field
 5. Click the deposit button
 6. Press the balance button to verify that the Checking Account now holds $100.00
 7. Type 40 in the Text Field
 8. Click the withdrawal button.
 9. A JOptionPane will verify the transaction was successful.
 10.Press the balance button to verify that the Checking Account now holds $60.00
 * Case 3:
 1. Type 100 in the Text Field
 2. Click deposit 
 3. Click on balance and verify that the checking account now has $100.00
 4. Click on Savings radio button.
 5. Type 50 in the Text Field
 6. Click on Transfer To button 
 7. Click on Balance button
 8. Verify that JOptionPane window shows displaying the amounts for Checking Account and Savings Account are $50.00 and $50.00 dollars respectively.
 * Case 4:
 1. Type -200 in the Text Field
 2. Click Deposit button
 3. JOpitionPane will ask for a positive number
 4. Type 200 in the Text Field
 5. Click Deposit button
 6. Click on Balance button
 7. Verify that JOptionPane window shows displaying the amounts for Checking Account and Savings Account are $200.00 and $0.00 dollars respectively.
 */
public class GUI {
	static boolean account; //Variable that handles which account is handled //Checking=true Savings=False
	static int wCount = 0;
	static DecimalFormat money = new DecimalFormat("$0.00");

	public static void main(String[] args) {
		final Account test = new Account(0,0);//Create new Account object with checking and savings set to zero
		final JFrame frame = new JFrame("ATM Machine");//Create JFrame frame with the title ATM Machine
		frame.setSize(270, 190);//Set size of frame to be 270 x 190 pixels 
		frame.setLocationRelativeTo(null);//Center the frame on the screen 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets the program to close when the frame is closed 
		frame.setLayout(null);//using no layout managers
		JButton withdrawal = new JButton("Withdrawl");//creates new Button withdrawal with title Withdrawal
		withdrawal.setBounds(10, 10, 120, 30);//Sets the position and size of the button:x axis, y axis (top left corner), width, height
		frame.add(withdrawal);//Adds button withdrawal to the frame
		JButton deposit = new JButton("Deposit");//creates new Button deposit with title Deposit
		deposit.setBounds(140, 10, 120, 30);//Sets the position and size of the button:x axis, y axis (top left corner), width, height
		frame.add(deposit);//Adds button deposit to the frame
		JButton transfer = new JButton("Transfer to");//creates new Button transfer with title Transfer to
		transfer.setBounds(10, 50, 120, 30);//Sets the position and size of the button:x axis, y axis (top left corner), width, height
		frame.add(transfer);//Adds button transfer to the frame
		JButton balance = new JButton("Balance");//creates new Button balance with title Balance
		balance.setBounds(140, 50, 120, 30);//Sets the position and size of the button:x axis, y axis (top left corner), width, height
		frame.add(balance);//Adds button balance to the frame
		final JRadioButton checking = new JRadioButton("Checking");//creates new Radio Button checking with title Checking
		checking.setBounds(10, 80, 120, 30);//Sets the position and size of the button:x axis, y axis (top left corner), width, height
		checking.setSelected(true);//Sets this button to be the default account upon starting the program
		frame.add(checking);//Adds radio button checking to the frame
		final JRadioButton savings = new JRadioButton("Savings");//creates new Radio Button checking with title Checking
		savings.setBounds(140, 80, 120, 30);//Sets the position and size of the button:x axis, y axis (top left corner), width, height
		frame.add(savings);//Adds radio button savings to the frame
		final JTextField text = new JTextField();//creates new text field (input field) text 
		text.setBounds(10, 120, 250, 30);//Sets the position and size of the button:x axis, y axis (top left corner), width, height
		text.setVisible(true);//Sets the text field visible
		text.setText("");//Sets the text field to blank
		frame.add(text);//Adds text field text to the frame
		frame.setResizable(false);//Sets frame to be not resizable (fixed size)
		frame.setVisible(true);//Sets the frame visible
		account = true;
		// Action Listeners
		// Withdrawal
		withdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amount = text.getText();
				//Check: is there anything entered in the text field
				if (isValue(amount)) {
					//Check: is the value in the text field a number
					if (isNumeric(amount)) {
						//Check: is the number in the text field positive
						if (isPositive(amount)) {
							//Check: is this positive number a multiple of 20
							if (Integer.parseInt(amount) % 20 == 0) {
								//Which account?
								if (account) {
									//Check: Is there enough money in the account to complete the transaction
									if (test.getChecking() - Double.parseDouble(amount) >= 0) {
										test.setChecking(test.getChecking() - Double.parseDouble(amount));//Subtract the withdrawal amount from account
										JOptionPane.showMessageDialog(frame,"You have sucessfully withdrawn "+ money.format(Double.parseDouble(amount)));//Show message successful transaction 
										wCount++;//Increment the withdrawal count
										if(wCount > 4){
											JOptionPane.showMessageDialog(frame,"A service charge of $1.50 was deducted from your account");//Display message if more than 4 total withdrawals are made
											test.setChecking(test.getChecking()-1.50);//Subtract 1.50 from account
											wCount=0;//Reset the withdrawal count to 0
										}
									} else {
										JOptionPane.showMessageDialog(frame,"You cannot withdrawal, Insufficient funds in your checking account");//Display message if Insufficient funds in your account
									}
								}
								//Which account?
								else if (!account) {
									//Check: Is there enough money in the account to complete the transaction
									if (test.getSavings()- Double.parseDouble(amount) >= 0) {
										test.setSavings(test.getSavings() - Double.parseDouble(amount));//Subtract the withdrawal amount from account
										JOptionPane.showMessageDialog(frame,"You have sucessfully withdrawn "+ money.format(Double.parseDouble(amount)));//Show message successful transaction 
										wCount++;//Increment the withdrawal count
										if(wCount > 4){
											JOptionPane.showMessageDialog(frame,"A service charge of $1.50 was deducted from your account");//Display message if more than 4 total withdrawals are made 
											test.setSavings(test.getSavings()-1.50);//Subtract 1.50 from account
											wCount=0;//Reset the withdrawal count to 0
										}
									} else {
										JOptionPane.showMessageDialog(frame,"You cannot withdrawal, Insufficient funds in your savings account");//Display message if Insufficient funds in your account
									}
								}
							} else {
								JOptionPane.showMessageDialog(frame,"Please enter a integer with a value that is multiple of 20 like: 20, 40, 60, 80");//Display message if value in Text Field is not a multiple of 20 (Like a real ATM)
							}
						} else {
							JOptionPane.showMessageDialog(frame,"Please enter a positive number in the text field");//Display message if value in Text Field is not a positive number 
						}
					} else {
						JOptionPane.showMessageDialog(frame,"Please enter Numerical value like: 20.25 or 48.");//Display message if value in Text Field is not a number
					}
				} else {
					JOptionPane.showMessageDialog(frame,"Make sure the text field is not empty");//Display message if nothing in Text Field
				}
				text.setText(""); // Clear text field
			}
		});
		// Deposit
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amount = text.getText();
				//Check: is there anything entered in the text field
				if (isValue(amount)) {
					//Check: is the value in the text field a number
					if (isNumeric(amount)) {
						//Check: is the number in the text field positive
						if (isPositive(amount)) {
							//Which account?
							if (account) {
								test.setChecking(Double.parseDouble(amount) + test.getChecking());//Add the deposit amount from account
								JOptionPane.showMessageDialog(frame,"You have sucessfully deposited "+ money.format(Double.parseDouble(amount)));//Show message successful transaction
							} else {
								test.setSavings(Double.parseDouble(amount) + test.getSavings());//Add the deposit amount from account
								JOptionPane.showMessageDialog(frame,"You have sucessfully deposited "+ money.format(Double.parseDouble(amount)));//Show message successful transaction
							}
						} else {
							JOptionPane.showMessageDialog(frame,"Please enter a positive number in the text field");//Display message if value in Text Field is not a positive number
						}
					} else {
						JOptionPane.showMessageDialog(frame,"Please enter Numerical value like: 20.25 or 48.");//Display message if value in Text Field is not a number
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Make sure the text field is not empty");//Display message if nothing in Text Field
				}
				text.setText(""); // Clear text field
			}
		});
		// Transfer
		transfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amount = text.getText();
				//Check: is there anything entered in the text field
				if (isValue(amount)) {
					//Check: is the value in the text field a number
					if (isNumeric(amount)) {
						//Check: is the number in the text field positive
						if (isPositive(amount)) {
							//Which account?
							if (account) {
								// From Savings
								//Check: Is there enough money in the account to complete the transaction
								if (test.getSavings() - Double.parseDouble(amount) >= 0) {
									test.setChecking(test.getChecking() + Double.parseDouble(amount));// Add amount to checking
									test.setSavings(test.getSavings() - Double.parseDouble(amount));// Subtract amount from savings
									JOptionPane.showMessageDialog(frame,"You have sucessfully transfered " + money.format(Double.parseDouble(amount)) + " to checking");//Show message successful transaction
								} else {
									JOptionPane.showMessageDialog(frame,"Transfer unsuccessful, insefisccent funds in savings account");//Display message if Insufficient funds in your account
								}
							} else {
								// From Checking
								//Check: Is there enough money in the account to complete the transaction
								if (test.getChecking() - Double.parseDouble(amount) >= 0) {
									test.setSavings(test.getSavings() + Double.parseDouble(amount));// Add amount to savings
									test.setChecking(test.getChecking() - Double.parseDouble(amount));// Subtract amount from checking
									JOptionPane.showMessageDialog(frame,"You have sucessfully transfered " + money.format(Double.parseDouble(amount)) + " to savings");//Show message successful transaction
								} else {
									JOptionPane.showMessageDialog(frame,"Transfer unsuccessful, insefisccent funds in checking account");//Display message if Insufficient funds in your account
								}
							}
						} else {
							JOptionPane.showMessageDialog(frame,"Please enter a positive number in the text field");//Display message if value in Text Field is not a positive number
						}
					} else {
						JOptionPane.showMessageDialog(frame,"Please enter Numerical value like: 20.25 or 48.");//Display message if value in Text Field is not a number
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Make sure the text field is not empty");//Display message if nothing in Text Field
				}
				text.setText(""); // Clear text field
			}
		});
		// Balance Button
		balance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "The balance of your Checking Account is: " + money.format(test.getChecking())
										        + "\n The balance of your Savings Account is: "+ money.format(test.getSavings()));
				text.setText(""); // Clear text field
			}
		});
		// Checking Radio Button
		checking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checking.setSelected(true);
				savings.setSelected(false);
				account = true;
			}
		});
		// Savings Radio Button
		savings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checking.setSelected(false);
				savings.setSelected(true);
				account = false;
			}
		});
	}
	// Utility method used the check if the value entered into the text field is numeric when returned from action listeners
	// Is numeric
	public static boolean isNumeric(String str) {
		return str != null && str.matches("[-+]?\\d*\\.?\\d+");
	}
	// Utility method used the check if the value entered into the text field is a positive when returned from action listeners
	// Is positive
	public static boolean isPositive(String str) {
		if (Double.parseDouble(str) < 0) {
			return false;
		} else {
			return true;
		}
	}
	// Utility method used the check if there is a value entered into the text field (text field is not blank)
	// Is value
	public static boolean isValue(String str) {
		if (str.equals("")) {
			return false;
		} else {
			return true;
		}
	}
}
