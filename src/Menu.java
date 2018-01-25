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
	public StartUpItemManager startManager;
	private JPanel contentPane;
	private JTextField textField;

	public Menu(StartUpItemManager sm)
	{
		startManager = sm;
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
				startManager.startItems();
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
				//procedure to add new item
			}
		});
		btnAdd.setBounds(460, 100, 70, 20);
		contentPane.add(btnAdd);
		
		String [] header={"active","command"};
        String [][] data={{"akash","20"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"}};
        
        DefaultTableModel model = new DefaultTableModel(data,header)
        {
			private static final long serialVersionUID = 1L;
			@Override
            public boolean isCellEditable(int row, int column)
			{
               return false;
            }
        };
        final JTable table = new JTable(model);
        table.addMouseListener(new MouseAdapter()
        {
        	@Override
        	public void mouseClicked(MouseEvent e)
        	{
        		System.out.println(table.rowAtPoint(e.getPoint()) + ":" + table.columnAtPoint(e.getPoint()));
        		if(table.columnAtPoint(e.getPoint()) == 0)
        		{
        			//toggle do estado do comando
        		}
        	}
        });
        table.addKeyListener(new KeyAdapter()
        {
        	@Override
        	public void keyPressed(KeyEvent e)
        	{
        		if(e.getKeyCode() == KeyEvent.VK_DELETE)
        		{
        			//o que fazer para garantir que o que esta na linha x da tabela é o que esta na posição x na lista?
        			//incluir id do objecto na tabela? coluna escondida?
        			//startManager.removeItemFromList(ojecto);
        		}
        	}
        });
        table.getColumnModel().getColumn(0).setMaxWidth(50);
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