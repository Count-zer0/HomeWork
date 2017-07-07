package ONE;

import java.io.*;
import java.lang.management.RuntimeMXBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
public class Util {

	public static void main(String[] args) {
		String oldPath="e:\\drivethelife6_net_setup.exe";
		String newPath="c:\\Users\\Galaxy\\Desktop";
		float money=238.00f;
		int[] num={88,6,97,12,63,98,21,2,0,6,13,77};
		String str="asd a 十大 444 5     突突 突5 a突突 ";
		new Util().OddEvenSorting(num);
		
	}	
	
	public String copyFile(String oldPath,String newPath){
		File file = new File(oldPath);
		newPath+=oldPath.substring(oldPath.lastIndexOf("\\"),oldPath.length());
		System.out.println("oldPath="+oldPath);		
		System.out.println("newPath="+newPath);		
		if(file.exists()){
			InputStream is=null;
			OutputStream os=null;
			int length=0;
			int len=0;
			byte[] buffer=new byte[1024];
			try{
				 is=new BufferedInputStream(new FileInputStream(oldPath));
				 os=new BufferedOutputStream(new FileOutputStream(newPath));
				 while((len=is.read(buffer))>0){
					 length+=len;
					 System.out.println(length);
					 os.write(buffer, 0, len);
				 }
				return "复制完成";
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(is!=null){
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
						return "遇到异常";
					}
				}
				if(os!=null){
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		return "没有找到要复制的文件";
	}

	public int 斐波那契数列(int num){
		if(num==1||num==2)
			return 1;
		return 斐波那契数列(num-1)+斐波那契数列(num-2);
	}

	public void toUPstring(float money){
		int n1,n2,n3,n4,n5,n6;
		char c1,c2,c3,c4,c5,c6;	
		int minNUM=(int) (money*100);
		String str="";
		class Char{
			public char toChar(int num){
				char r=' ';
				 switch(num){
				 case 0:
				  	 r='零';
				  	 break;
				 case 1:
					 r='壹';
					 break;
				 case 2:
					 r='贰';
					 break;
				 case 3:
					 r='叁';
					 break;
				 case 4:
					 r='肆';
					 break;
				 case 5:
					 r='伍';
					 break;
				 case 6:
					 r='陆';
					 break;
				 case 7:
					 r='柒';
					 break;
				 case 8:
					 r='捌';
					 break;
				 case 9:
					 r='玖';
					 break;
				}
				return r;
			}
		};
		n1= minNUM % 1000000/100000;
		n2= minNUM % 100000/10000;
		n3= minNUM % 10000/1000;
		n4= minNUM % 1000/100;
		n5= minNUM % 100/10;
		n6= minNUM % 10;
		c1=new Char().toChar(n1);
		c2=new Char().toChar(n2);
		c3=new Char().toChar(n3);
		c4=new Char().toChar(n4);
		c5=new Char().toChar(n5);
		c6=new Char().toChar(n6);
		if(n1 != 0){
			str+=c1+"千";
		}
		if(n2 !=0){
			str+=c2+"百";
		}
		if(n1!=0 && n2==0 && (n3!=0||n4!=0)){
			str+="零";
		}
		if(n3 !=0){
			str+=c3+"十";
		}
		if(n2!=0 && n3==0 && n4!=0 ){
			str+="零";			
		}
		if(n4 !=0){
			str+=c4;
		}
		str+="元";
		if(n5==0&&n6==0){
			str+="整";
		}
		if(n5!=0){
			str+=c5+"毛";
		}
		if(n5==0 && n6!=0){
			str+="零";
		}
		if(n6!=0){
			str+=c6+"分";
		}
		System.out.println(str);
	}
	
	public void bubbleSort(int [] num){
		for(int a=0;a<num.length;a++){
			for(int b=a;b<num.length;b++){
				if(num[a]<num[b]){
					num[a]=num[a]+num[b];
					num[b]=num[a]-num[b];
					num[a]=num[a]-num[b];
				}
			}
		}
	System.out.print("排序完成,输出结果：");
	for(int c=0;c<num.length;c++){
		System.out.print(num[c]);
		if(c!=num.length-1)
			System.out.print(",");
	}
	}

	public void printRhombus(int num){
		for(int a=0;a<num+1;a++){
			for(int b=a;b<num;b++){
				System.out.print(" ");
			}
			for(int c=0;c<2*a-1;c++){
				System.out.print("*");
			}
			System.out.println(" ");
		}
		for(int a=num-1;a>0;a--){
			for(int b=a;b<num;b++){
				System.out.print(" ");
			}
			for(int c=0;c<2*a-1;c++){
				System.out.print("*");
			}
			System.out.println(" ");
		}
		
	}
	
	public String removeSpace(String str){
		String result="";
		for(int a=0;a<str.length();a++){
			String nstr=str.substring(a, a+1);
			if(!(nstr.equals(" "))){
				result+=nstr;
			}
		}
		return result;
	}

	public void lastTime(){
		Calendar time= Calendar.getInstance();
		//把日期设置为当月第一天
		time.set(Calendar.DATE, 1);
		//日期回滚一天，也就是最后一天
		time.roll(Calendar.DATE, -1);
		int MaxDate=time.get(Calendar.DATE);
		System.out.println(MaxDate);
	}

	public void OddEvenSorting(int [] num) {
		int len = num.length;
		int front =0;
		int end=len-1;
		if(len<=0)
			return ;
		while(front<end) {
			while(front<end&&(num[front]%2)!=0)
				front++;
			while(front<end&&(num[end]%2)==0)
				end--;
			if(front<end){
				num[front]=num[front]+num[end];
				num[end]=num[front]-num[end];
				num[front]=num[front]-num[end];
			}
		}
		System.out.println(Arrays.toString(num));
	}

}