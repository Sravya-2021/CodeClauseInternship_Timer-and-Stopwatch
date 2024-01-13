import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch implements ActionListener {
    JFrame frame=new JFrame();
    JButton startbutton= new JButton("START");
    JButton resetbutton=new JButton("RESET");
    JLabel timelabel=new JLabel();
    int elapsedtime=0;
    int seconds=0;
    int minutes=0;
    int hours=0;
    boolean started=false;
    String seconds_string=String.format("%02d",seconds);
    String minutes_string=String.format("%02d",minutes);
    String hours_string=String.format("%02d",hours);

    Timer timer=new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedtime=elapsedtime+1000;
            hours=(elapsedtime/3600000);
            minutes=(elapsedtime/60000)%60;
            seconds=(elapsedtime/1000)%60;
            seconds_string=String.format("%02d",seconds);
            minutes_string=String.format("%02d",minutes);
            hours_string=String.format("%02d",hours);
            timelabel.setText(hours_string+":"+minutes_string+":"+seconds_string);

        }
    });
    Stopwatch()
    {
        timelabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        timelabel.setBounds(100,100,200,100);
        timelabel.setFont(new Font("Verdana",Font.PLAIN,35));
        timelabel.setBorder(BorderFactory.createBevelBorder(1));
        timelabel.setOpaque(true);
        timelabel.setHorizontalAlignment(JTextField.CENTER);

        startbutton.setBounds(100,200,100,50);
        startbutton.setFont(new Font("Forte",Font.PLAIN,20));
        startbutton.setFocusable(false);
        startbutton.addActionListener(this);

        resetbutton.setBounds(200,200,100,50);
        resetbutton.setFont(new Font("Forte",Font.PLAIN,20));
        resetbutton.setFocusable(false);
        resetbutton.addActionListener(this);

        frame.add(startbutton);
        frame.add(resetbutton);
        frame.add(timelabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==startbutton)
        {
            if(started==false)
            {
                started=true;
                startbutton.setText("STOP");
                start();
            }
            else
            {
                started=false;
                startbutton.setText("START");
                stop();
            }
        }
        if(e.getSource()==resetbutton)
        {
            started=false;
            startbutton.setText("START");
            reset();
        }
    }
    void start()
    {
        timer.start();
    }
    void stop()
    {
        timer.stop();
    }
    void reset()
    {
        timer.stop();
        elapsedtime=0;
        seconds=0;
        minutes=0;
        hours=0;
        seconds_string=String.format("%02d",seconds);
        minutes_string=String.format("%02d",minutes);
        hours_string=String.format("%02d",hours);
        timelabel.setText(hours_string+":"+minutes_string+":"+seconds_string);

    }
}

