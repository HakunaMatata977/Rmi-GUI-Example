import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiClient extends JFrame implements ActionListener {
    JButton lowerBtn, upperBtn, palindromeBtn;
    JLabel lowerLbl, upperLbl, palindromeLbl;
    RemoteMethod stub;

    public RmiClient() throws Exception {
        Registry rg = LocateRegistry.getRegistry("localhost", 8005);
        stub = (RemoteMethod) rg.lookup("skeleton");
        setTitle("RMI Example");
        setSize(600, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        lowerBtn = new JButton("To Lower Case");
        upperBtn = new JButton("To Upper Case");
        palindromeBtn = new JButton("Check Palindrome");
        lowerLbl = new JLabel();
        upperLbl = new JLabel();
        palindromeLbl = new JLabel();

        lowerBtn.setBounds(30, 30, 180, 30);
        lowerLbl.setBounds(250, 30, 300, 30);
        upperBtn.setBounds(30, 80, 180, 30);
        upperLbl.setBounds(250, 80, 300, 30);
        palindromeBtn.setBounds(30, 130, 180, 30);
        palindromeLbl.setBounds(250, 130, 300, 30);

        add(lowerBtn);
        add(lowerLbl);
        add(upperBtn);
        add(upperLbl);
        add(palindromeBtn);
        add(palindromeLbl);

        lowerBtn.addActionListener(this);
        upperBtn.addActionListener(this);
        palindromeBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String text = JOptionPane.showInputDialog(this, "Enter String:");
        if (text == null) return;
        try {
            if (e.getSource() == lowerBtn) {
                lowerLbl.setText(stub.changeToLowerCase(text));
            }
            if (e.getSource() == upperBtn) {
                upperLbl.setText(stub.changeToUpperCase(text));
            }
            if (e.getSource() == palindromeBtn) {
                palindromeLbl.setText(stub.palindromeChecker(text));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new RmiClient();
    }
}