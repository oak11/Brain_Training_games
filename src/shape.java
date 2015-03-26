
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.Random;


public class shape extends java.applet.Applet implements Runnable,ActionListener {
Random symbol= new Random();private Image bg;AudioClip sound,wrong,correct;
    Random limit= new Random();    
    int prev, current;
    Thread t=null;
    boolean lastsymb=false;
    Image images[]=new Image[5];
    Image img;
    Button Y=new Button("YES");
    Button X=new Button("NO");
    int score=0;
    Button quit;
    boolean end=false;
        public void start()
        {
        t= new Thread(this);
        
        t.start();
        }
  
public void run()
        { sound.play();prev=6;
            try{
        for(int j=0;j<5;j++)
        {
        int thissymb=symbol.nextInt(5);
        
        current=thissymb;
       int lim=limit.nextInt(5);
        for(int i=0;i<=lim;i++)
        {
            img=images[thissymb];
        
           if(j==0)
           {
        	   prev=thissymb;
           }
           if(i==lim-1)
           {
        	   prev=thissymb;
           }
        
            
        lastsymb=true;
        repaint();
        Thread.sleep(150);
        lastsymb=false;
        repaint();
        Thread.sleep(2000);
        }
        
        }
        stop();
            }
            catch(InterruptedException e)
            {
                
            }
        }
    
    public void init() {
    	bg=getImage(getDocumentBase(),"bg.jpg");
sound=getAudioClip(getDocumentBase(),"clktick.au");
wrong=getAudioClip(getDocumentBase(),"beep.au");
correct=getAudioClip(getDocumentBase(),"beep_c.au");
        images[0]=getImage(getDocumentBase(),"a.jpg");
        images[1]=getImage(getDocumentBase(),"b.jpg");
        images[2]=getImage(getDocumentBase(),"c.jpg");
        images[3]=getImage(getDocumentBase(),"d.jpg");
        images[4]=getImage(getDocumentBase(),"e.jpg");
        quit=new Button ("quit");
        quit.addActionListener(this);
        add(quit);
       
        
        X.addActionListener(this);
        Y.addActionListener(this);
        add(X);
        add(Y);
    }
    public void stop() {
    	end=true;
    	sound.stop();
    	t.interrupt();
    	repaint();
    
    	}
    public void paint(Graphics g1)
{  Font f=new Font("Courier New",Font.BOLD,50);
g1.setFont(f);
g1.drawImage(bg, 0, 0, this.getWidth(),this.getHeight(),this);

    g1.setColor(Color.WHITE);
    correct.play();
    g1.drawImage(img,625,275,200,200,this);
    g1.drawString("Score: "+score, 50, 50);
    if(lastsymb==true)
    {
    g1.setColor(Color.BLACK);
        g1.fillRect(575, 225, 300, 300);
    }
    if(end)
    {	g1.drawImage(bg, 0, 0, this.getWidth(),this.getHeight(),this);
    	 g1.drawString("Your score is "+score, 200, 300);
    	 g1.drawString("Your spatial skill percentage is: "+(((double)score/15)*100),200 ,350);
    	 g1.drawString("Game Over", 200, 400);
    }
    
}
    
    
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }

public void actionPerformed(ActionEvent ae) {
if(ae.getSource()==Y)
{
if(prev==current)
{correct.play();
score++;
}
else 
{score--;wrong.play();}
}
else if(ae.getSource()==X){
if(prev!=current)
{correct.play();
score++;
}
else
{score--;wrong.play();}
}
if(ae.getSource()==quit){stop();}
repaint(); 
}

}

