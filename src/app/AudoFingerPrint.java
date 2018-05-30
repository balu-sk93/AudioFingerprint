package app;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import action.AudioRecognizer;

public class AudoFingerPrint {

  private static Logger logger = Logger.getLogger(AudoFingerPrint.class);

  private JFrame mainFrame;
  private JLabel headerLabel;
  private JLabel statusLabel;
  private JPanel controlPanel;
  private String path = null;

  public AudoFingerPrint() {
    createWindow();
  }

  private void createWindow() {
    logger.info("Creating GUI");
    mainFrame = new JFrame("Audio Fingerprint");
    mainFrame.setSize(400, 200);
    mainFrame.setLayout(new GridLayout(3, 1));

    headerLabel = new JLabel("", JLabel.CENTER);
    statusLabel = new JLabel("", JLabel.CENTER);

    statusLabel.setSize(350, 100);
    mainFrame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent windowEvent) {
        System.exit(0);
      }
    });
    controlPanel = new JPanel();
    controlPanel.setLayout(new FlowLayout());

    mainFrame.add(headerLabel);
    mainFrame.add(controlPanel);
    mainFrame.add(statusLabel);
    mainFrame.setVisible(true);
  }

  private void createUI() {

    headerLabel.setText("Upload Audio File");

    JButton okButton = new JButton("Browse");
    JButton submitButton = new JButton("Submit");
    // JButton cancelButton = new JButton("Cancel");

    okButton.setActionCommand("Browse");
    submitButton.setActionCommand("Submit");
    // cancelButton.setActionCommand("Cancel");

    okButton.addActionListener(new ButtonClickListener());
    submitButton.addActionListener(new ButtonClickListener());
    // cancelButton.addActionListener(new ButtonClickListener());

    controlPanel.add(okButton);
    controlPanel.add(submitButton);
    // controlPanel.add(cancelButton);

    mainFrame.setVisible(true);
  }

  private class ButtonClickListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      String command = e.getActionCommand();
      if (command.equals("Browse")) {
        FileChooser fc = new FileChooser();
        path = fc.openAction();
        statusLabel.setText(path);
        logger.info(path);
      } else if (command.equals("Submit")) {
        AudioRecognizer obj = new AudioRecognizer();
        String resp = obj.doRecognize(path);
        statusLabel.setText(resp);
      } else {
        statusLabel.setText("Cancel Button clicked.");
      }
    }
  }

  public static void main(String[] args) {
    AudoFingerPrint obj = new AudoFingerPrint();
    obj.createUI();
  }
}
