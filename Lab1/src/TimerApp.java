import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.text.DateFormat;

public class TimerApp extends JFrame {

    private JLabel label, timeLabel, inputLabel, inputLabelALARM;
    private JTextField inputField, inputFieldHour, inputFieldMinutes;
    private JButton buttonStart, buttonStart1, buttonStart2;
    private JButton buttonStop, buttonStop1, buttonStop2;
    private Timer timer, timer1, timer2;


    public TimerApp() {
        setTitle("Timer App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Timer: 0");
        label.setBounds(150, 50, 100, 20);

        timeLabel = new JLabel("Stopwatch: 0");
        timeLabel.setBounds(250, 150, 100, 20);

        inputLabel = new JLabel("Enter time in seconds:");
        inputLabel.setBounds(40, 150, 150, 20);

        inputLabelALARM = new JLabel("Alarm set Time:");
        inputLabelALARM.setBounds(40, 250, 150, 20);

        inputField = new JTextField();
        inputField.setBounds(200, 150, 50, 20);

        inputFieldHour = new JTextField();
        inputFieldHour.setBounds(150, 250, 50, 20);

        inputFieldMinutes = new JTextField();
        inputFieldMinutes.setBounds(210, 250, 50, 20);

        buttonStart = new JButton("Start");
        buttonStart.setBounds(50, 100, 100, 30);
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTimer();
            }
        });

        buttonStop = new JButton("Stop");
        buttonStop.setBounds(250, 100, 100, 30);
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopTimer();
            }
        });

        buttonStart1 = new JButton("Start1");
        buttonStart1.setBounds(50, 200, 100, 30);
        buttonStart1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTimer1();
            }
        });

        buttonStop1 = new JButton("Stop1");
        buttonStop1.setBounds(250, 200, 100, 30);
        buttonStop1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopTimer1();
            }
        });

        buttonStart2 = new JButton("Start2");
        buttonStart2.setBounds(50, 300, 100, 30);
        buttonStart2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTimer2();
            }
        });

        buttonStop2 = new JButton("Stop2");
        buttonStop2.setBounds(250, 300, 100, 30);
        buttonStop2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopTimer2();
            }
        });

        add(label);
        add(timeLabel);
        add(inputField);
        add(inputFieldHour);
        add(inputFieldMinutes);
        add(inputLabel);
        add(inputLabelALARM);
        add(buttonStart);
        add(buttonStop);
        add(buttonStart1);
        add(buttonStop1);
        add(buttonStart2);
        add(buttonStop2);
    }

    private void startTimer() {
        timer = new Timer();
        // React with an indicated period
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                long currentDateTime = System.currentTimeMillis();
                Date currentDate = new Date(currentDateTime);
                DateFormat df = new SimpleDateFormat("HH:mm:ss");
                label.setText("Timer: " + df.format(currentDate));
                Toolkit.getDefaultToolkit().beep();
            }
        };
        timer.schedule(task1, 0, 1000); // react every 1 sec
    }

    private void startTimer1() {
        if (timer1 != null) {
            timer1.cancel();
        }
        timer1 = new Timer();

        int seconds;
        seconds = Integer.parseInt(inputField.getText());

        TimerTask task = new TimerTask() {
            private int count = 0;

            @Override
            public void run() {
                if (count < seconds) {
                    count++;
                    timeLabel.setText("Chronometer: " + count);
                } else {
                    timeLabel.setText("Time's up!");
                    Toolkit.getDefaultToolkit().beep();
                    stopTimer1();
                }
            }
        };

        timer1.schedule(task, 0, 1000); // react every 1 sec
    }

    private void startTimer2() {
        if (timer2 != null) {
            timer2.cancel();
        }
        timer2 = new Timer();

        int hours;
        hours = Integer.parseInt(inputFieldHour.getText());
        int minutes;
        minutes = Integer.parseInt(inputFieldMinutes.getText());

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                Date d = new Date();
                if(d.getHours() == hours && d.getMinutes() == minutes) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };

        timer2.schedule(task2, 0, 2000); // react every 2 sec
    }

    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    private void stopTimer1() {
        if (timer1 != null) {
            timer1.cancel();
            timer1 = null;
        }
    }

    private void stopTimer2() {
        if (timer2 != null) {
            timer2.cancel();
            timer2 = null;
        }
    }

    public static void main(String[] args) {
        TimerApp app = new TimerApp();
        app.setLayout(null);
        app.setVisible(true);
    }
}