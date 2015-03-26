
import java.applet.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Random;
public class leaf extends Applet implements ActionListener,Runnable{
int x=0,y=0;boolean b1=true;Random r=new Random();int rand,rand1;
Thread t;int s=0,count=0,flag=0,flag1=0;;int i;String str="";AudioClip sound,wrong,correct;
private Image leaf_green,leaf_orange,img,bg,scorecard;
private Graphics g1;Button quit,play,right,left,up,down;
public void paint(Graphics g)
{bg=getImage(getDocumentBase(),"bg.jpg");
scorecard=getImage(getDocumentBase(),"timer.png");
	leaf_green=getImage(getDocumentBase(),"leafg.png");
	leaf_orange=getImage(getDocumentBase(),"leafo.png");
	g.drawImage(bg, 0, 0, this.getWidth(),this.getHeight(),this);
this.right.setLocation(1210,55);
this.left.setLocation(1140,55);
this.up.setLocation(1175,10);
this.down.setLocation(1175,100);
this.right.setSize(50,30);
this.left.setSize(50,30);
this.up.setSize(50,30);
this.down.setSize(50,30);
this.play.setSize(80,30);
this.quit.setSize(80,30);
this.play.setLocation(500,5);
this.quit.setLocation(600,5);
if(b1==false){
	g.setColor(Color.GRAY);
	g.setFont(new Font("Comic Sans",Font.BOLD,50));
	g.drawString("GAME OVER..SCORE: "+s+" / 12",400,250);
	g.drawString("FLEXIBILITY: "+((double)s*100/12)+" %",400,350);
	}
else
{g.setColor(Color.WHITE);
g.setFont(new Font("Comic Sans",Font.BOLD,30));
if(count<=12)
	{g.drawImage(scorecard, 490, 620, 300, 35,this);
	g.drawString("... "+(12-count)+"  more  to  go !...",500,650);}
else {stop();repaint();}
	g.setFont(new Font("Comic Sans",Font.BOLD,20));
	g.drawString("SCORE:"+s,15,28);
	g.drawImage(scorecard, 10,10, 105, 25,this);
	if(rand1==0)
	{g.drawImage(leaf_green, x+100, y+130, 50, 20,this);
	g.drawImage(leaf_green, x+180, y+190, 50, 20,this);
	g.drawImage(leaf_green, x+100, y+250, 50, 20,this);
	g.drawImage(leaf_green, x+180, y+310, 50, 20,this);
	g.drawImage(leaf_green, x+100, y+370, 50, 20,this);
	g.drawImage(leaf_green, x+180, y+430, 50, 20,this);
	g.drawImage(leaf_green, x+100, y+490, 50, 20,this);
	g.drawImage(leaf_green, x+20, y+190, 50, 20,this);
	g.drawImage(leaf_green, x+20, y+310, 50, 20,this);
	g.drawImage(leaf_green, x+20, y+430, 50, 20,this);
	g.drawImage(leaf_green, x-40, y+370, 50, 20,this);
	g.drawImage(leaf_green, x+240, y+370, 50, 20,this);
	g.drawString(str,10,55);
	}
	else
	{
		g.drawImage(leaf_orange, x+100, y+130, 50, 20,this);
		g.drawImage(leaf_orange, x+180, y+190, 50, 20,this);
		g.drawImage(leaf_orange, x+100, y+250, 50, 20,this);
		g.drawImage(leaf_orange, x+180, y+310, 50, 20,this);
		g.drawImage(leaf_orange, x+100, y+370, 50, 20,this);
		g.drawImage(leaf_orange, x+180, y+430, 50, 20,this);
		g.drawImage(leaf_orange, x+100, y+490, 50, 20,this);
		g.drawImage(leaf_orange, x+20, y+190, 50, 20,this);
		g.drawImage(leaf_orange, x+20, y+310, 50, 20,this);
		g.drawImage(leaf_orange, x+20, y+430, 50, 20,this);
		g.drawImage(leaf_orange, x-40, y+370, 50, 20,this);
		g.drawImage(leaf_orange, x+240, y+370, 50, 20,this);
		g.drawString(str,10,55);
	}}
	
}
public void init()
{
	setSize(200,200);
t=new Thread(this);
t.start();
quit=new Button ("quit");
quit.addActionListener(this);
add(quit);
play=new Button ("play");
play.addActionListener(this);
add(play);
right=new Button ("right");
right.addActionListener(this);
add(right);
left=new Button ("left");
left.addActionListener(this);
add(left);
down=new Button ("down");
down.addActionListener(this);
add(down);
up=new Button ("up");
up.addActionListener(this);
add(up);sound=getAudioClip(getDocumentBase(),"clktick.au");
wrong=getAudioClip(getDocumentBase(),"beep.au");
correct=getAudioClip(getDocumentBase(),"beep_c.au");sound.play();
}

public void run()
{sound.play();
	while(b1)
	{rand1=r.nextInt(2);
		rand=r.nextInt(4)+1;
		count=count+1;flag1=flag=0;
switch(rand)
	{case 1:y=x=0;
		do{
	x=x+5;	
	try {
		Thread.sleep(10);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

	repaint();
	
}while(x<=getWidth());
		
	break;

	case 2:y=0;x=getWidth();
	do
{x=(x-5);
	try {
		Thread.sleep(10);
	} catch (InterruptedException f) {
		f.printStackTrace();
	}
	repaint();
}while(x>=0);
	break;
	
	case 3:x=0;y=getHeight();do
	{y=(y-2);
		try {
			Thread.sleep(10);
		} catch (InterruptedException f) {
			f.printStackTrace();
		}
		repaint();
	}while(y>=0);
		break;
	
	case 4:x=getWidth()/2;y=0;do
	{y=(y+2);
		try {
			Thread.sleep(10);
		} catch (InterruptedException f) {
			f.printStackTrace();
		}
		repaint();
	}while(y<=getHeight());
		break;
	}
}
}

public void stop()
{
	b1=false;sound.stop();
}
public void resume()
{
	b1=true;s=0;str="";
	t=new Thread(this);count=0;
	sound.play();flag1=flag=0;
	t.start();
}
public void update(Graphics g)
{
img=createImage(this.getSize().width,this.getSize().height);
g1=img.getGraphics();
g1.setColor(getBackground());
g1.fillRect(0,0,this.getSize().width,this.getSize().height);
g1.setColor(getForeground());
paint(g1);
g.drawImage(img, 0, 0, this);
}
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource()==quit || e.getSource()==play)
	{if(e.getSource()==quit){stop();repaint();}
	if(e.getSource()==play){resume();}}
	else
	{switch(rand1)
	{case 0:
	if(rand==1 && e.getSource()==right){if(flag==0){s++;str="CORRECT!";flag=1;repaint();correct.play();}}
	if(rand==2 && e.getSource()==left){if(flag==0){s++;str="CORRECT!";correct.play();flag=1;repaint();}}
	if(rand==3 && e.getSource()==up){if(flag==0){s++;str="CORRECT!";correct.play();flag=1;repaint();}}
	if(rand==4 && e.getSource()==down){if(flag==0){s++;str="CORRECT!";correct.play();flag=1;repaint();}}
	if(rand==1 && e.getSource()!=right){if(flag1==0){s--;str="WRONG..";wrong.play();flag1=1;repaint();}}
	if(rand==2 && e.getSource()!=left){if(flag1==0){s--;str="WRONG..";wrong.play();flag1=1;repaint();}}
	if(rand==3 && e.getSource()!=up){if(flag1==0){s--;str="WRONG..";wrong.play();flag1=1;repaint();}}
	if(rand==4 && e.getSource()!=down){if(flag1==0){s--;str="WRONG..";wrong.play();flag1=1;repaint();}}
	break;
	case 1:
		if(rand==2 && e.getSource()==right){if(flag==0){s++;str="CORRECT!";repaint();correct.play();flag=1;}}
		if(rand==1 && e.getSource()==left){if(flag==0){s++;str="CORRECT!";repaint();correct.play();flag=1;}}
		if(rand==4 && e.getSource()==up){if(flag==0){s++;str="CORRECT!";repaint();correct.play();flag=1;}}
		if(rand==3 && e.getSource()==down){if(flag==0){s++;str="CORRECT!";repaint();correct.play();flag=1;}}
		if(rand==2 && e.getSource()!=right){if(flag1==0){s--;str="WRONG..";wrong.play();flag1=1;repaint();}}
		if(rand==1 && e.getSource()!=left){if(flag1==0){s--;str="WRONG..";wrong.play();flag1=1;repaint();}}
		if(rand==4 && e.getSource()!=up){if(flag1==0){s--;str="WRONG..";wrong.play();flag1=1;repaint();}}
		if(rand==3 && e.getSource()!=down){if(flag1==0){s--;str="WRONG..";wrong.play();flag1=1;repaint();}}
		break;
	}
}
}
}
