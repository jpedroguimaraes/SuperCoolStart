import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Menu extends JFrame
{
	private static final long serialVersionUID = 1L;
	private StartUpItemManager itemManager;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	
	public void updateTable()
	{
		String [] header = {"id","active","command"};
        String [][] data = new String [itemManager.getItemListSize()][3];
        
        int i = 0;
        for(StartUpItem item: itemManager.getItemList())
		{
        	data[i][0] = String.valueOf(item.getId());
        	data[i][1] = item.getStatus()?"yes":"no";
        	data[i][2] = item.getCommand();
        	i++;
        }
        
        DefaultTableModel model = new DefaultTableModel(data,header)
        {
			private static final long serialVersionUID = 1L;
			@Override
            public boolean isCellEditable(int row, int column)
			{
				return column == 2;
            }
			
		    public void setValueAt(Object value, int row, int col)
		    {
		        if(!value.toString().isEmpty() && !value.toString().trim().isEmpty() && row > -1 && row < itemManager.getItemListSize() && col == 2)
        		{
		        	itemManager.editItemCommand(Integer.parseInt(table.getValueAt(row, 0).toString()), value.toString());
        		}
    			updateTable();
		    }
        };
        
        table.setModel(model);        
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        table.getColumnModel().getColumn(1).setMaxWidth(50);
        table.getColumnModel().getColumn(1).setMinWidth(50);
        table.getColumnModel().getColumn(1).setWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
	}

	public Menu(StartUpItemManager sm)
	{
		itemManager = sm;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 500);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);

		JButton btnStart = new JButton("START");
		btnStart.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				itemManager.startItems();
			}
		});
		btnStart.setBounds(168, 27, 200, 50);
		contentPane.add(btnStart);
		
		textField = new JTextField();
		textField.setBounds(85, 100, 370, 20);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(!(textField.getText() == null) && !textField.getText().trim().isEmpty())
				{
					itemManager.addItemToList(textField.getText().toString());
					textField.setText(null);
        			updateTable();
				}
			}
		});
		btnAdd.setBounds(460, 100, 70, 20);
		contentPane.add(btnAdd);
		
		table = new JTable();
        updateTable();
        table.addMouseListener(new MouseAdapter()
        {
        	@Override
        	public void mouseClicked(MouseEvent e)
        	{
        		if(table.columnAtPoint(e.getPoint()) == 1 && table.getSelectedRow() > -1 && table.getSelectedRow() < itemManager.getItemListSize())
        		{
        			itemManager.toggleItemStatus(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
        			updateTable();
        		}
        	}
        });
        table.addKeyListener(new KeyAdapter()
        {
        	@Override
        	public void keyPressed(KeyEvent e)
        	{
        		if(e.getKeyCode() == KeyEvent.VK_DELETE && table.getSelectedRow() > -1 && table.getSelectedRow() < itemManager.getItemListSize())
        		{
        			itemManager.removeItemFromList(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
        			updateTable();
        		}
        	}
        });
        table.setFillsViewportHeight(true);
        JScrollPane js = new JScrollPane(table);
        js.setBounds(85, 150, 450, 200);
        js.setVisible(true);
        contentPane.add(js);
        
        contentPane.setVisible(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
}