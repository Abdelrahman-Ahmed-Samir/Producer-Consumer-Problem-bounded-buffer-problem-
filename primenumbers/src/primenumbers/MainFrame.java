package primenumbers;

import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException; 
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Scrollbar;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfnum;
	private JLabel lblBufferSize;
	private JTextField tfbuffer;
	private JLabel lblOutputFile;
	private JTextField tfoutput;
	private JTextField resLnum;
	private JTextField restime;
	private JTextField resprimecount;
	private JLabel lblNewLabel_1;
	private JLabel lblOfPrime;
	private JLabel lblTimeElapsed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("             Welcome ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   N");
		lblNewLabel.setBounds(10, 12, 414, 19);
		contentPane.add(lblNewLabel);
		
		tfnum = new JTextField();
		tfnum.setBounds(261, 11, 139, 20);
		contentPane.add(tfnum);
		tfnum.setColumns(10);
		
		lblBufferSize = new JLabel("Buffer Size");
		lblBufferSize.setBounds(10, 48, 73, 14);
		contentPane.add(lblBufferSize);
		
		tfbuffer = new JTextField();
		tfbuffer.setBounds(261, 45, 139, 20);
		contentPane.add(tfbuffer);
		tfbuffer.setColumns(10);
		
		lblOutputFile = new JLabel("Output File");
		lblOutputFile.setBounds(10, 84, 84, 14);
		contentPane.add(lblOutputFile);
		
		tfoutput = new JTextField();
		tfoutput.setBounds(261, 81, 139, 20);
		contentPane.add(tfoutput);
		tfoutput.setColumns(10);
		
		JButton btnOK = new JButton("Start Producer");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					String Lnum = tfnum.getText();
					int num = Integer.parseInt(Lnum);
					List<Integer> aList = new ArrayList();
					

					long start = System.currentTimeMillis();
					for (int i = 1; i <= num; i++) {
			            int count = 0;
			            for (int j = 2; j <= i / 2; j++) {
			             if (i % j == 0) {
			              count++;
			              break;
			             }
			            }
			        
			            if (count == 0) {
			            	aList.add(i);
			            }
			            int size = aList.size()-1;
						String s = Integer.toString(size);
						resprimecount.setText(s);

			           }
					resLnum.setText(aList.get(aList.size()-1).toString());
				    String fileName =tfoutput.getText();
				    
				    try{
				    	FileWriter myobj = new FileWriter(fileName);
				    	for( int i = 1 ; i < aList.size();i++){
			                myobj.write(aList.get(i).toString());
			                myobj.write(" , ");
			            }
			            myobj.close();
				    }
				    catch(Exception e){
				    	System.out.println("Error in writing to the file.");
				    }
					
					// some time passes
					long end = System.currentTimeMillis();
					long elapsedTime = end - start;
					String time = Long.toString(elapsedTime);
					restime.setText(time+" ms");
					
					
			}
		});
		btnOK.setBounds(105, 112, 196, 23);
		contentPane.add(btnOK);
		
		resLnum = new JTextField();
		resLnum.setBounds(261, 161, 152, 20);
		contentPane.add(resLnum);
		resLnum.setColumns(10);
		
		restime = new JTextField();
		restime.setColumns(10);
		restime.setBounds(261, 223, 152, 20);
		contentPane.add(restime);
		
		resprimecount = new JTextField();
		resprimecount.setColumns(10);
		resprimecount.setBounds(261, 192, 152, 20);
		contentPane.add(resprimecount);
		
		lblNewLabel_1 = new JLabel("Largest Prime Number");
		lblNewLabel_1.setBounds(10, 167, 189, 14);
		contentPane.add(lblNewLabel_1);
		
		lblOfPrime = new JLabel("# of Prime Numbers ");
		lblOfPrime.setBounds(10, 195, 189, 14);
		contentPane.add(lblOfPrime);
		
		lblTimeElapsed = new JLabel("Time Elapsed");
		lblTimeElapsed.setBounds(10, 226, 189, 14);
		contentPane.add(lblTimeElapsed);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(417, 0, 17, 50);
		contentPane.add(scrollbar);
	}
}
