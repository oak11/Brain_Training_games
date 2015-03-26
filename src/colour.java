
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Random;
import java.util.Calendar;
public class colour extends Applet implements ActionListener,Runnable
{
AudioClip sound,wrong,correct;
Thread t;int rand1,rand2,rand3,rand4,flag,flag1,score=0,sec=30;boolean b=true;
Button quit,play,yes,no;String s[]={"red","blue","yellow"};String str="",time="";
Color c[]={Color.RED,Color.BLUE,Color.YELLOW};private Image bg,card,scorecard;
Font font=new Font("Sans Serif",Font.BOLD,80);
public void init()
{bg=getImage(getDocumentBase(),"bg.jpg");
card=getImage(getDocumentBase(),"flashcard.png");
scorecard=getImage(getDocumentBase(),"timer.png");
	setSize(200,200);
t=new Thread(this);
quit=new Button ("quit");
quit.addActionListener(this);
add(quit);
play=new Button ("play");
play.addActionListener(this);
add(play);
yes=new Button ("YES");
yes.addActionListener(this);
add(yes);
no=new Button ("NO");
no.addActionListener(this);
add(no);
sound=getAudioClip(getDocumentBase(),"clktick.au");
wrong=getAudioClip(getDocumentBase(),"beep.au");
correct=getAudioClip(getDocumentBase(),"beep_c.au");
t.start();
}
public void run() {
while(b)
{Random r=new Random();
rand1=r.nextInt(3);
rand2=r.nextInt(3);
rand3=r.nextInt(3);
rand4=r.nextInt(3);
flag=flag1=0;
try {
Thread.sleep(3000);
} catch (InterruptedException e) {
e.printStackTrace();
}sec=sec-3;
sound.play();
repaint();
}
}

   
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==play){restart();}   
if(rand2==rand3 && e.getSource()==yes){
if(flag==0)
{score++;correct.play();
flag=1;str="CORRECT!";
repaint();
}
}
if(rand2!=rand3 && e.getSource()==no){
if(flag==0)
{score++;str="CORRECT!";
flag=1;correct.play();
repaint();
}
}
if(rand2==rand3 && e.getSource()==no){
if(flag1==0)
{score--;wrong.play();
flag1=1;str="WRONG!";
repaint();
}
}
if(rand2!=rand3 && e.getSource()==yes){
if(flag1==0)
{score--;wrong.play();
flag1=1;str="WRONG!";
repaint();
}
}
if(e.getSource()==quit){stop();}

}
    public void stop() {
b=false;
repaint();sound.stop();
}
    void restart()
    {score=0;
    b=true;sec=30;
    t=new Thread(this);
    t.start();
    }
    public void paint(Graphics g)
    { if(b==false)
    { 	g.drawImage(bg, 0, 0, this.getWidth(),this.getHeight(),this);
  
    	sound.stop();
		 g.setColor(Color.BLACK);
     
        g.setColor(Color.WHITE);
        g.setFont(new Font("Comic Sans",Font.BOLD,40));
        g.drawString("QUICK DECISION SKILLS: "+((double)score*100/10)+" %",500,400);
    g.drawString("GAME OVER",500,500);
    g.drawString("your score is:"+score,500,300);
  
}else
{
    	g.drawImage(bg, 0, 0, this.getWidth(),this.getHeight(),this);
    	g.drawImage(scorecard, 5, 5, 100,30,this);
    	g.drawImage(scorecard, 980, 5, 220,30,this);
    g.drawImage(card, 525, 150, 300,150,this);
    g.drawImage(card, 525, 350, 300,150,this);
    	this.yes.setSize(80,30);
    	this.no.setSize(80,30);
    	this.play.setSize(80,30);
    	this.quit.setSize(80,30);
    	this.yes.setLocation(400,50);
    	this.no.setLocation(500,50);
    	this.play.setLocation(600,50);
    	this.quit.setLocation(700,50);
    	
    g.setFont(new Font("Comic Sans",Font.BOLD,20));
    g.setColor(Color.WHITE);
    g.drawString(str, 10, 55);
    g.drawString("SCORE:"+score, 10, 25);
    g.setFont(new Font("Comic Sans",Font.BOLD,40));
    g.setColor(Color.GRAY);
        g.drawString("Does the MEANING", 10, 300);
        g.setColor(Color.GRAY);
        g.drawString("match the COLOUR?",10,500);
        g.setFont(font);
        g.drawString("", 10, 40);
    g.setColor(c[rand1]);
        g.drawString(s[rand2],550,250);
        g.setColor(c[rand3]);
        g.drawString(s[rand4],550,450);
        if(sec<=0)stop();
        g.setFont(new Font("Comic Sans",Font.BOLD,20));  g.setColor(Color.WHITE);
        g.drawString(sec+" seconds remain!",1000,25);
       }}}

