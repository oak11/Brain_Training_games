

import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class vowel extends Applet implements ActionListener,Runnable
{AudioClip sound,wrong,correct;
Thread t,t1;String str="";private Image bg,card;
int rand1,rand2,rand3,rand4,flag=0,flag1=0,score=0,i=0,ctr=0,sec=30;char vowels[]={'A','E','I','O','U'};
int repeat;
boolean b=true;
char alpha1,alpha2;
Random r=new Random();
Button quit,play,yes,no;

Font font=new Font("Sans Serif",Font.BOLD,50);
	public void init()
	{bg=getImage(getDocumentBase(),"bg.jpg");card=getImage(getDocumentBase(),"flashcard.png");
		setSize(200,200);
	t=new Thread(this);
	sound=getAudioClip(getDocumentBase(),"clktick.au");
	wrong=getAudioClip(getDocumentBase(),"beep.au");
	correct=getAudioClip(getDocumentBase(),"beep_c.au");
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
	t.start();
	}
	
	public void run() {
		while(b)
		{sound.play();
		rand1=r.nextInt(26);
		rand2=r.nextInt(10);
		rand3=r.nextInt(26);
		rand4=r.nextInt(10);
		alpha1=(char)(rand1+65);
		alpha2=(char)(rand3+65);
		flag=flag1=0;
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}sec=sec-3;
		repaint();
		}
	}
   
		public void actionPerformed(ActionEvent e) {
        	
		if(rand2 % 2==0 && isVowel(alpha2) && e.getSource()==yes){
		if(flag==0)
			{score++;correct.play();
			flag=1;str="CORRECT!";
			repaint();
			}
			}
		
		else if(rand2 % 2==0 && isVowel(alpha2) && e.getSource()==no){
			if(flag1==0)
			{score--;wrong.play();
			flag1=1;str="WRONG!";ctr++;
			repaint();}
		}
		
		else if((rand2 % 2==1 || !isVowel(alpha2)) && e.getSource()==yes){
			if(flag==0)
			{score--;wrong.play();
			flag=1;str="WRONG!";
			repaint();}
		}
		else if((rand2 % 2==1 || !isVowel(alpha2)) && e.getSource()==no){
			if(flag1==0)
			{score++;correct.play();
			flag1=1;str="CORRECT!";ctr++;
			repaint();}
		}

		else if(e.getSource()==quit){stop();}
		else if(e.getSource()==play){restart();}
		
	}
        
    public void stop() {
		b=false;
		repaint();sound.stop();
	}
    void restart()
    {score=0;sound.play();
    	b=true;
    	sec=33;
    	t1=new Thread(this);
    	t1.start();
    }
    
	
    
    public void paint(Graphics g)
    {  
    	 if(b==false)
         {  g.drawImage(bg, 0, 0, this.getWidth(),this.getHeight(),this);
             g.setColor(Color.WHITE);
             g.setFont(new Font("Comic Sans",Font.BOLD,50));
         	g.drawString("GAME OVER",500,500);
         	g.drawString("your score is:"+score,450,300);
         	g.setFont(new Font("Comic Sans",Font.BOLD,50));
         	g.drawString("IMPULSE CONTROL: "+((double)score*100/10)+" %",400,400);
         }else
         {g.drawImage(bg, 0, 0, this.getWidth(),this.getHeight(),this);
         g.drawImage(card, 525, 100, 300,150,this);g.drawImage(card, 525, 300, 300,150,this);
    	g.setFont(new Font("Comic Sans",Font.BOLD,20));
    	g.setColor(Color.WHITE);
    	g.drawString(sec+" seconds remain!",1000,20);
    	g.drawString("SCORE:"+score, 10, 20);
    	g.drawString(str,10,40);
        g.setFont(font);
    	g.setColor(Color.WHITE);
    	if(ctr%3==0){alpha2=vowels[(i++)%5];}
    	String s1=alpha1+"   "+rand2;
    	String s2=alpha2+"   "+rand4;
    	
    	g.setColor(Color.GRAY);
    	 g.drawString("is no. even?",100,200);
    	 g.setFont(new Font("Comic Sans",Font.BOLD,80));
    	 g.setColor(Color.RED);
        g.drawString(s1,600,200);
        g.setFont(font);
    	g.setColor(Color.GRAY);

        g.drawString("is letter a vowel?",100,400);
        g.setFont(new Font("Comic Sans",Font.BOLD,80));
        g.setColor(Color.BLUE);
        g.drawString(s2,600,400);
        if(sec<=0){stop();}}
       
        
    }
    	
    

public boolean isVowel(char c)
{
if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A'|| c == 'E'||c == 'I'|| c == 'O'|| c == 'U')
        return true;
else
        return false;
}
}
