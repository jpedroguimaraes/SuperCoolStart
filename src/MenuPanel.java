import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public MenuPanel() {
		setLayout(null);

		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(88, 39, 21, 21);
		add(chckbxNewCheckBox);

		textField = new JTextField();
		textField.setBounds(141, 39, 275, 19);
		add(textField);
		textField.setColumns(100);
		
		JButton btnStart = new JButton("START");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] args = new String[] {"/bin/bash", "-c", "gnome-terminal --working-directory=/home/jpguimaraes/project/accounting_provisory & disown"};
				try {
					/*Process proc = */new ProcessBuilder(args).start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnStart.setBounds(159, 206, 200, 50);
		add(btnStart);

        this.setVisible(true);

	}
}