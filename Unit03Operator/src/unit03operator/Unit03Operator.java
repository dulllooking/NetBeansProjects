/*
運算子(Operator),
一元運算(Unary Operator),二元運算(Binary Operator),三元運算(Ternary Operator)
*/
package unit03operator;


public class Unit03Operator {

   
    public static void main(String[] args) {
        
        int x=10, y=3, z=0 ,i=10, j=11;
        String str="";
        boolean isPass=false;
        int bitMask=0x000F ,value=0x2222;
        
        //算術運算子(Arithmetic Operator)
        //相加運算
        //二元運算(Binary Operator)
        z=x+y;  // x及y 為運算元(Operand), + 為運算子(Operator), = 為指派運算子(assignment)
        System.out.println(x+ "+" + y + "=" +z);
        
        //相減運算
        z=x-y; 
        System.out.println(x+ "-" + y + "=" +z);
        
        //相乘運算
        z=x*y;
        System.out.println(x+ "*" + y + "=" +z);
        
        //相除運算
        z=x/y;
        System.out.println(x+ "/" + y + "=" +z);
        
        //餘數運算
        z=x%y;
        System.out.println(x+ "%" + y + "=" +z);
        
        //一元運算(Unary)
        System.out.println("x=" + x);   //x=10
        System.out.println("y=" + y);   //y=3
        System.out.println("z=" + z);   //z=1
        
        //相加指派運算子
        x +=1;  //x=x+1
        System.out.println("x += 1, x=" + x);   //11
        
        //相減指派運算子
        x -=1;  //x=x-1
        System.out.println("x -= 1, x=" + x);   //10
        
        //相乘指派運算子
        x *=2;  //x=x*2
        System.out.println("x *= 2, x=" + x);   //20
        
        //相除指派運算子
        x /=3;  //x=x/3
        System.out.println("x /= 3, x=" + x);   //6
        
        //餘數指派運算子
        x %=3;  //x=x%3
        System.out.println("x %= 3, x=" + x);   //0
        
        //遞增運算(Increment Operator)++,遞減運算(Decrement Operator)--
        // ++ , x=x+1
        // -- , x=x-1
        System.out.println("x++ , x=" + x++);  //後置遞增,先輸出,再加1, 先輸出0,但x為1
        System.out.println("x=" + x);
        
        System.out.println("x-- , x=" + x--);  //後置遞減,先輸出,再減1, 先輸出1,但x為0
        System.out.println("x=" + x);
        
        System.out.println("++x , x=" + ++x);  //前置遞增,先加1,再輸出
        System.out.println("x=" + x);
        
        System.out.println("--x , x=" + --x);  //前置遞減,先減1,再輸出
        System.out.println("x=" + x);
        
        z= x++ + ++y;
        System.out.println("x=" + x);   //x=1
        System.out.println("y=" + y);   //y=4
        System.out.println("z=" + z);   //z=0+4
        
        //計算練習
        int A = 10;
        int B = 20;
        int C = A++ + B;
        
        System.out.println("A=" + A);   //11
        System.out.println("B=" + B);   //20
        System.out.println("C=" + C);   //30
        
        //三元運算(Ternary Operator)
        System.out.println("---三元運算---");
        z=x<y?x:y;
        System.out.println("x=" + x);   //1
        System.out.println("y=" + y);   //4
        System.out.println("z=" + z);   //1
        
        //String str=""; 宣告習慣放在初始
        str=x>y?"x比較大":"x比較小";
        System.out.println(str);
        
        //boolean isPass=false; 宣告習慣放在初始
        //布林運算子(Boolean Logical Operator)
        System.out.println("---布林運算---");
        System.out.println("isPass=" + isPass);  //false
        System.out.println("isPass=" + !isPass);  //true
        
        //關係運算子(Relational Operator) 課本p.2-17
        System.out.println("---關係運算---");
        isPass=i>j;
        System.out.println("i=" + i);  //10
        System.out.println("j=" + j);  //11
        System.out.println("i>j, isPass=" + isPass);  //false
        
        isPass=i==j;
        System.out.println("i==j, isPass=" + isPass);  //false
        
        isPass=i!=j;
        System.out.println("i!=j, isPass=" + isPass);  //true
        
        isPass=++i==j;
        System.out.println("++i==j, isPass=" + isPass);  //true
        System.out.println("i=" + i);  //11
        System.out.println("j=" + j);  //11
        
        //條件運算子(Conditional Operator),&&(And,且),||(Or,或)
        //&&,||短路運算(求值運算)Short Circuit
        isPass=(++i==j)&&(--j==10); //前面false所以--j不執行,所以j=11,短路運算
        System.out.println("(++i==j)&&(--j==10), isPass=" + isPass);  //false
        System.out.println("i=" + i);  //12
        System.out.println("j=" + j);  //11
        
        isPass=(--i==j)||(--j==10); //前面true已成立,所以--j不執行,所以j=11,短路運算
        System.out.println("(--i==j)&&(--j==10), isPass=" + isPass);  //true
        System.out.println("i=" + i);  //11
        System.out.println("j=" + j);  //11
        
        isPass=(--i==j)&(--j==10); //非短路運算,判斷式皆執行,false&true
        System.out.println("(--i==j)&(--j==10), isPass=" + isPass);  //false
        System.out.println("i=" + i);  //10
        System.out.println("j=" + j);  //10
        
        isPass=(i==j)|(--j==10); //非短路運算,判斷式皆執行,true|false
        System.out.println("(i==j)|(--j==10), isPass=" + isPass);  //true
        System.out.println("i=" + i);  //10
        System.out.println("j=" + j);  //9
        
        //int bitMask=0x000F ,value=0x2222; 宣告習慣放在初始
        //位元運算子(Bitwise Operator),&(and),|(or),^(xor)
        System.out.println("---位元運算子---");
        System.out.println("bitMask=" + bitMask);   //15
        System.out.println("value=" + value);   //8738
        System.out.println("bitMask&value=" + (bitMask & value));   //2
        System.out.println("bitMask|value=" + (bitMask | value));   //8751
        System.out.println("bitMask^value=" + (bitMask ^ value));   //8749
        //0x000F=0x 0000 0000 0000 1111
        //0x2222=0x 0010 0010 0010 0010
   //bitMask&value= 0000 0000 0000 0010 = 0 0 0 1(10進制=2)
   //bitMask|value= 0010 0010 0010 1111 = 2 2 2 F(10進制=8751)
   //bitMask^value= 0010 0010 0010 1101 = 2 2 2 D(10進制=8749)
   
        int m=7 ,n=5;   //7=0111,5=0101
        //xor,相同=0,不同=1
        System.out.println("m^n=" + (m ^ n));   //0010=2
        //補數~
        System.out.println("~m=" + (~m));   //0111補1變1000=8加負號變-8
        System.out.println("~n=" + (~n));   //0101補1變0110=6加負號變-6
        
        //位移運算>>(右移Right Shift Operator),<<(左移Left Shift Operator)
        System.out.println("---右移位移運算子---"); //Right Shift Operator, /2
        System.out.println("n>>1=" + (n>>1));//右移0101>>0010變2
        System.out.println("n>>1=" + (n>>2));//右移0101>>0001變1
        System.out.println("n>>1=" + (n>>3));//右移0101>>0000變0
        System.out.println("n>>1=" + (n>>4));//右移0101>>0000變0
        
        System.out.println("---右移位移運算子---"); //*2
        System.out.println("n<<1=" + (n<<1));//左移0101>>1010變10(左移變大2倍)
        System.out.println("n<<2=" + (n<<2));//左移0101>>10100變20(左移變大2倍)
        System.out.println("n<<2=" + (n<<3));//左移0101>>101000變40
        System.out.println("n<<2=" + (n<<4));//左移0101>>1010000變80
        System.out.println("n<<2=" + (n<<5));//左移0101>>10100000變160
        
        //無符號右移運算>>>(Unsigned Right Shift Operator)
        System.out.println("n>>>1=" + (n>>>1));//右移0101>>0010變2(有負號時捨棄負號)
        //System.out.println("n<<<1=" + (n<<<1));//java無<<<運算
        int k=-1;
        System.out.println("k>>>1=" + (k>>>1)); //2^31-1=2147483648捨棄負數後-1
        
        
    }
    
}
