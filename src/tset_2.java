import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class tset_2 extends JFrame {
    //Lotto------------------------------------------------------------------------------------------------------------
    private JLabel jlbs[] = new JLabel[6];
    private int data[] = new int[6];
    private Random rnd = new Random(System.currentTimeMillis());

    private JButton jbtn_close = new JButton("Close");
    private JButton jbtn_generate = new JButton("Generate");
    private JPanel jpn = new JPanel(new GridLayout(1,6,5,5));
    private Container jifCP;
  //-------------------------------------------------------------------------------------------------------------------
  private int screenH = Toolkit.getDefaultToolkit().getScreenSize().height;
  private int screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
  private int frmH = 500, frmW = 450;

    public tset_2(){
        initComp();
    }
    private void initComp(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);

        for (int i=0;i<6;i++){
            jlbs[i] = new JLabel();
            jlbs[i].setFont(new Font(null,Font.PLAIN,22));
            jlbs[i].setOpaque(true);
            jlbs[i].setBackground(new Color(186,85,211));
            jlbs[i].setHorizontalAlignment(JLabel.CENTER);
            jpn.add(jlbs[i]);
        }



    }
    private void LottoGenerate(){
        int i =0;
        while(i<6){
            data[i] = rnd.nextInt(42)+1;
            int j =0;
            boolean flag = true;
            while(j<i && flag){
                if (data[i]== data[j]){
                    flag = false;
                }
                j++;
            }
            if(flag){
                jlbs[i].setText(Integer.toString(data[i]));
                i++;
            }
        }
    }
}
