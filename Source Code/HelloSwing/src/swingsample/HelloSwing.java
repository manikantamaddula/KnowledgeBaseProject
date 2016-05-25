	package swingsample;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import org.semanticweb.owlapi.model.OWLException;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import java.awt.Font;

@SuppressWarnings("serial")
public class HelloSwing extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1;
	private JLabel lblFamilyOntology;
	private JPanel panel_2;
	private JPanel panel_3;
	public JTree tree;
	public JList list;
	public JList list_1;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_19;

	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel panel_9;
	private JButton btnNewButton_5;
	private JPanel panel_13;
	public JList list_2;
	public JList list_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloSwing frame = new HelloSwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	String selectedvalue=null;
	String selectedvalue2=null;
	private JLabel lblRelationsOfSelected;
	private JList list_4;
	private JPanel panel_14;
	private JScrollPane scrollPane_3;
	private JPanel panel_15;
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_1;
	/**
	 * Create the frame.
	 */
	public HelloSwing() {
		
		Object nodeInfo=null;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Sylfaen", Font.BOLD, 25));
		scrollPane.setColumnHeaderView(panel);
		
		lblFamilyOntology = new JLabel("Family Ontology");
		lblFamilyOntology.setFont(new Font("Sylfaen", Font.BOLD, 25));
		panel.add(lblFamilyOntology);
		
		panel_1 = new JPanel();
		panel_1.setSize(new Dimension(40, 0));
		scrollPane.setRowHeaderView(panel_1);
		
		scrollPane_3 = new JScrollPane();
		panel_1.add(scrollPane_3);
		
		panel_3 = new JPanel();
		panel_1.add(panel_3);


		PopulateTree class2 = new PopulateTree();
		try {
			panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
			
			scrollPane_1 = new JScrollPane();
			panel_3.add(scrollPane_1);
			
			//scrollPane_2 = new JScrollPane();
			//panel_3.add(scrollPane_2);
			tree = new JTree();
			scrollPane_1.setViewportView(tree);
			tree.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			tree.setMaximumSize(new Dimension(77, 40));
			
			tree.setPreferredSize(new Dimension(150, 40));
			
        tree.addTreeSelectionListener(new TreeSelectionListener() {
			    
				public void valueChanged(TreeSelectionEvent e) {
					// TODO Auto-generated method stub
					 DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                         tree.getLastSelectedPathComponent();
					 if (node == null) return;
					 Object nodeInfo = node.getUserObject();
					 System.out.println("converted to string: "+nodeInfo.toString());
					 selectedvalue=nodeInfo.toString();
					 tree.getSelectionModel().setSelectionMode
				        (TreeSelectionModel.SINGLE_TREE_SELECTION);
					 System.out.println("Add button state: "+tree.isSelectionEmpty());
						if(!tree.isSelectionEmpty()){
							btnNewButton.setEnabled(true);
						}
					
				}});
        class2.populateTree(tree);
		} catch (OWLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//panel_3.add(tree);
		
		panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		
		panel_5 = new JPanel();
		panel_6.add(panel_5);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Selection List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		panel_9 = new JPanel();
		panel_5.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));
		
		panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10.setSize(new Dimension(2, 2));
		FlowLayout flowLayout_1 = (FlowLayout) panel_10.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_9.add(panel_10);
		
		btnNewButton = new JButton("Add");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add has been clicked");
				
				populateList(list_2,selectedvalue);
				
			}
		});
		panel_10.add(btnNewButton);
		
		
		panel_13 = new JPanel();
		panel_9.add(panel_13);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));
		
		scrollPane_4 = new JScrollPane();
		panel_13.add(scrollPane_4);
		
		list_2 = new JList();
		scrollPane_4.setViewportView(list_2);
		list_2.setModel(new DefaultListModel());
		list_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_2.addListSelectionListener(new ListSelectionListener(){

			public void valueChanged(ListSelectionEvent e) {

				//DefaultListModel lsm=(DefaultListModel)list_2.getModel();
				//int index = list_2.getSelectedIndex();
				//boolean adjust = e.getValueIsAdjusting();
				
				if(!list_2.isSelectionEmpty()){
					btnNewButton_5.setEnabled(true);
					btnNewButton_1.setEnabled(true);
				}
                }});
		//populateList(list_2,selectedvalue);
   
		
		
		btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.setEnabled(false);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Remove has been clicked");
				System.out.println(list_2.isSelectionEmpty());
				
				
				
				DefaultListModel listModel=(DefaultListModel)list_2.getModel();
				int index = list_2.getSelectedIndex();
				listModel.remove(index);
			}
		});
		panel_10.add(btnNewButton_1);
		
		
		
		btnNewButton_5 = new JButton("Submit");
		btnNewButton_5.setEnabled(false);
				panel_9.add(btnNewButton_5);
		
		panel_8 = new JPanel();
		panel_2.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));
		
		panel_12 = new JPanel();
		panel_12.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Results Panel", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_8.add(panel_12);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.X_AXIS));
		
		panel_11 = new JPanel();
		panel_12.add(panel_11);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.Y_AXIS));
		
		panel_7 = new JPanel();
		panel_11.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
		
		panel_15 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_15.getLayout();
		flowLayout.setVgap(0);
		panel_7.add(panel_15);
		
		lblRelationsOfSelected = new JLabel("Relations of selected person");
		lblRelationsOfSelected.setFont(new Font("Vijaya", Font.PLAIN, 20));
		panel_15.add(lblRelationsOfSelected);
		
		panel_14 = new JPanel();
		panel_7.add(panel_14);
		panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.X_AXIS));
		
		scrollPane_2 = new JScrollPane();
		panel_14.add(scrollPane_2);
		
		list_4 = new JList();
		scrollPane_2.setViewportView(list_4);
		list_4.setModel(new DefaultListModel());
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    panel_19 = new JPanel();
				panel_11.add(panel_19);


				list_3 = new JList();
				panel_19.add(list_3);

				int index2 = list_2.getSelectedIndex();
				String inputvalue=list_2.getSelectedValue().toString();
				
                //DefaultListModel listModel2=(DefaultListModel)list_4.getModel();		
                //listModel2.addElement("Hey manikanta");
				System.out.println("input to ontology: "+inputvalue);
                
                PopulateList class3 = new PopulateList();
                try {
					class3.populateList(list_4,inputvalue);
				} catch (OWLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("submit is clicked");
				//ResultPanel class3 = new ResultPanel();
			        
				//class3.ResultPanel2(list_2);
			}
		});


	}
	
	
	//populate list
     
	public void populateList(JList list,String selectedvalue) {
		
		DefaultListModel listModel=(DefaultListModel)list.getModel();
		
		listModel.addElement(selectedvalue);
		//listModel.addElement("Mukesh");
		//listModel.removeElement("Mukesh");
	}
	//delete elements from list
	
public void depopulateList(JList list,String selectedvalue2) {
		
		DefaultListModel listModel=(DefaultListModel)list.getModel();
		System.out.println("input for depopulate"+selectedvalue2);
		//listModel.addElement(selectedvalue);
		//listModel.addElement("Mukesh");
		listModel.removeElement(selectedvalue2);
	}

}
