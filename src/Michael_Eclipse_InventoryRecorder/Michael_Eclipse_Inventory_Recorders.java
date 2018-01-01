package Michael_Eclipse_InventoryRecorder;


import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JList;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Michael_Eclipse_Inventory_Recorders extends JFrame {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtxtEnterItem;
	private JFrame frame;
	private JList jlstAddItems;
	DefaultListModel fill = new DefaultListModel();
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Michael_Eclipse_Inventory_Recorders frame = new Michael_Eclipse_Inventory_Recorders();
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
	public Michael_Eclipse_Inventory_Recorders() {
		setTitle("Michael's Inventory Recording System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.LIGHT_GRAY, null, null));
		panel.setBounds(21, 10, 1201, 67);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblHowToAdd = new JLabel("How to add, Select and Delete Record from a JList");
		lblHowToAdd.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblHowToAdd.setBounds(10, 10, 1192, 47);
		panel.add(lblHowToAdd);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.LIGHT_GRAY, null, null));
		panel_1.setBounds(21, 519, 693, 150);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		final JLabel jlblConfirm = new JLabel("");
		jlblConfirm.setFont(new Font("Tahoma", Font.BOLD, 30));
		jlblConfirm.setBounds(7, 10, 676, 164);
		panel_1.add(jlblConfirm);
		
		
		JLabel lblEnterAData = new JLabel("Enter a Data");
		lblEnterAData.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblEnterAData.setBounds(21, 104, 430, 92);
		contentPane.add(lblEnterAData);
		
		JButton btnNewButton = new JButton("Add Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
			if(!jtxtEnterItem.getText().trim().equals(""))
			{
				fill.addElement(jtxtEnterItem.getText().trim().toUpperCase());
				jtxtEnterItem.setText("");
				jtxtEnterItem.grabFocus();
			}
			else
			{
				JOptionPane.showInternalMessageDialog(null, "You must enter an item");
				jtxtEnterItem.grabFocus();
			}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnNewButton.setBounds(671, 158, 358, 67);
		contentPane.add(btnNewButton);
		
		JButton btnConfirmData = new JButton("Confirm Data");
		btnConfirmData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String data = "";
			
			if (jlstAddItems.getSelectedIndex() != -1)
			{
				data = "Selected item:" + jlstAddItems.getSelectedValue();
				jlblConfirm.setText(data);
			}
			else
			{
			JOptionPane.showMessageDialog(null, "You must select an item");
			}
			}
		});
			btnConfirmData.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnConfirmData.setBounds(671, 245, 358, 67);
		contentPane.add(btnConfirmData);
		
		JButton btnDeleteAnItem = new JButton("Delete an Item");
		btnDeleteAnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(jlstAddItems.getSelectedIndex() != -1)
				{
					fill.removeElementAt(jlstAddItems.getSelectedIndex());
					jtxtEnterItem.grabFocus();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You must select an item to be deleted");
				}
			}
				});
		btnDeleteAnItem.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnDeleteAnItem.setBounds(671, 338, 358, 67);
		contentPane.add(btnDeleteAnItem);
		
		
		JButton btnResetAllSystem = new JButton("Reset all System");
		btnResetAllSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				jtxtEnterItem.setText(null);
				jlblConfirm.setText("");
				fill.clear();
				jlstAddItems.setModel(fill);
				
			}
		});
		btnResetAllSystem.setFont(new Font("Tahoma", Font.BOLD, 37));
		btnResetAllSystem.setBounds(671, 427, 358, 67);
		contentPane.add(btnResetAllSystem);
		
		JButton btnExitSystem = new JButton("Exit System");
		btnExitSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			frame = new JFrame ("Exit");
			if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Inventory Register",
					JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION){
				System.exit(0);
			  }
			}
		});
		btnExitSystem.setFont(new Font("Tahoma", Font.BOLD, 35));
		btnExitSystem.setBounds(724, 519, 305, 67);
		contentPane.add(btnExitSystem);
		
		jtxtEnterItem = new JTextField();
		jtxtEnterItem.setFont(new Font("Tahoma", Font.PLAIN, 30));
		jtxtEnterItem.setBounds(282, 121, 353, 50);
		contentPane.add(jtxtEnterItem);
		jtxtEnterItem.setColumns(10);
		
				
		jlstAddItems = new JList();
		jlstAddItems.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jlstAddItems.setVisibleRowCount(5);
		jlstAddItems.setToolTipText("Select a Data");
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.Texture.TextureLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jlstAddItems.setModel(fill);
		jlstAddItems.setFont(new Font("Tahoma", Font.PLAIN, 35));
		jlstAddItems.setBounds(21, 194, 614, 300);
		contentPane.add(jlstAddItems);
		
		
		
			}
	}

