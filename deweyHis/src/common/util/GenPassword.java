/**
 * 
 */
package common.util;

import java.util.Random;

/**
 * @author Administrator
 *
 */
public class GenPassword {
	
	private static String[] str=new String[62];
	
	static{
		str[0]="1";
		str[1]="2";
		str[2]="3";
		str[3]="4";
		str[4]="5";
		str[5]="6";
		str[6]="7";
		str[7]="8";
		str[8]="9";
		str[9]="0";
		str[10]="a";
		str[11]="b";
		str[12]="c";
		str[13]="d";
		str[14]="e";
		str[15]="f";
		str[16]="g";
		str[17]="h";
		str[18]="i";
		str[19]="j";
		str[20]="k";
		str[21]="l";
		str[22]="m";
		str[23]="n";
		str[24]="o";
		str[25]="p";
		str[26]="q";
		str[27]="r";
		str[28]="s";
		str[29]="t";
		str[30]="u";
		str[31]="v";
		str[32]="w";
		str[33]="x";
		str[34]="y";
		str[35]="z";
		str[36]="A";
		str[37]="B";
		str[38]="C";
		str[39]="D";
		str[40]="E";
		str[41]="F";
		str[42]="G";
		str[43]="H";
		str[44]="I";
		str[45]="J";
		str[46]="K";
		str[47]="L";
		str[48]="M";
		str[49]="N";
		str[50]="O";
		str[51]="P";
		str[52]="Q";
		str[53]="R";
		str[54]="S";
		str[55]="T";
		str[56]="U";
		str[57]="V";
		str[58]="W";
		str[59]="X";
		str[60]="Y";
		str[61]="Z";
	}
	
	public String RandomPassword(int length){
		String password="";

		Random r=new Random();
		for(int i=0;i<length;i++){
			password+=str[r.nextInt(str.length)];
		}
		
		return password;
	}
	
}
