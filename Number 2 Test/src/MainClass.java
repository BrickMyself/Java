import java.util.Arrays;
import java.util.Scanner;

class People{
	static int age;
	static String name;
	static People zhangsan=new People();
	static Scanner reader=new Scanner(System.in);	
	public static void PeopleInit(){
		System.out.println("输入年龄");
		zhangsan.age=reader.nextInt();
		System.out.println("输入姓名");
		zhangsan.name=reader.next();
	}
	public static void PeoPlePrintf(){
		System.out.println(zhangsan.age);
		System.out.println(zhangsan.name);
	}

	
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("你好，只需要编译我");
//		System.out.println("\\n");//转义字符 " \ "
//      A a=new A();
//      a.fA();
//      B b=new B();
//      b.fB();
//      char ChinaWord='好';
//      System.out.println((int)ChinaWord);
//      int A=476;
//      System.out.println((char)A);
//      int S=(int)23.23;
//      System.out.println(S);
//		People zhangsan=new People();
//	    People.PeopleInit();
//		zhangsan.PeoPlePrintf();
//		for(int i=65; i<=90;i++){
//		System.out.println((char)i);
//		}
//		
		//运算符与表达式
		//+ - * % / 二目运算符  * % / 的运算符 优先级 高于 + - 
		// 自增 ++ 自减 运算符   单目运算符   与 C++ 是一样 的  
		// 算数混合运算的精度    自动向大的类型的数据 进行提升 
		
		//关系运算符 与关系表达式 
		// > < >= <= == != 都是从左到右 和 c++ 差不了多少 
		// 逻辑表达式   
		// && || ! 运算符优先级在 关系运算符之后 
		// 赋值 = 与 == 和C一样
		//位运算符 
		// &  同时为1时才为1  其余均为 0  也就是 有 0 为零
		// |  有一为 一  
		// !  按位全部取反 
		// ^  异或 相同为 0 不同为 1
		
		// 分支语句   基本 表达语句
		// if语句 
		// if -else 语句
		// switch   case  记得 break; 否则就是顺序执行语句  default 
		
		//循环语句 
         // 数组 
		
		// 声明一维数组的方式
		// 1
		int num1[];//数组元素类型   数组名  [] 
		int [] num2;// 数组元素类型  [] 数组名
		// 二维数组也类似 
		//数组的元素的类型可以滴java 的任何一种类型  比如 People 是一个类可以 定义
		People num3[];
		//注意 在java 中  [] 中不能指定数组元素的个数
		// int num4[10]; 这在java 中是不被允许的
		
		//声明数组仅仅是为了给出数组名  变量的类型 如果想真正的使用的话就必须给他分配变量  比如
		int num5[];
		num5= new int[5];
		//赋值为 
		num5[0]=1;
		num5[1]=2;
		num5[2]=3;
		num5[3]=4;
		num5[4]=5;
		for(int j=0;j<5; j++){
			//System.out.println(num5[j]);
		}
		//System.out.println(num5.length);// length 是java 内置的一个元素的属性可以直接获得数组的长度
		//声明数组和创建数组可以同时进行
		byte arr[]=new byte[5];
	   //二维数组也一样必须使用new来进行数组的创建
		//二维数组可以不知道他的每一行有多少个元素 可以在后面使用之前定义 但是在声明的时候必须声明他的行数  也就是声明一维数组比如
		int a[][]=new int[3][];
//		int a[0]=new int[3];
//		int a[1]=new int[3];
//		int a[2]=new int[3];
		//与C/C++ 不同的是 java 允许 声明数组的时候允许使用 int 型变量的值指定数组的元素的个数  例如 
		int k=5;
		int arr1[]=new int[k];//这里数组的长度用 变量k表示是完全没有问题的
		//length  在一维数组 中表示的是数组的长度  在二维数组中是表示 一维数组的个数
		//比如
//		int b[][]=new int[2][3];
//		int b1[]=new int[5];
//		System.out.println(b.length);
//		System.out.println(b1.length);
//		//数组的初始化
//		int z[]=new int[5];
//		int v[]={1,2,3,4};
//		//初始化二维数组 
//		int as[][]={ {2},{3,4}};
//		for(int o =0;o<v.length;o++){
//			System.out.println(v[o]);
//		}
		//引用
		int y[]={1,2,3,4,5,6};
//		int x[]={2,3,4};
//		y=x;//x 和 y 类型必须相同 
//		// 看起来像是赋值但是通过打印出地址就可以发现 y的地址和x的地址是相同的 并且系统会释放最初分配给 y的资源 
//        System.out.println(x);
//        System.out.println(x);
//        //打印出来之后可以发现地址是一样的 这个和c++ 中的引用是一样的差不多的
//        //但需要注意的是 在char 类型的数组中 out.printl 是不会打印出 地址的 反而会打印出所有的 元素 比如
//        char a1[]={ '1','2','3'};
//        System.out.println(a1);
//        //如果想输出 char 型数组的引用  必须让数组a和字符串做并置运算比如
//        System.out.println(""+a1);
        for(int w:y){
        	//这里有点像 c++ 的 auto  不过这里 定义的变量的类型必须要和 数组的类型相同 而 c++ 是内部有自己的识别方法自动识别
        	System.out.println(w);
        }
        System.out.println(Arrays.toString(y));	//或者调用自己内部的函数 Arrays.toString 打印结果为
        //[1,2,3,4,5,6]
        char c='\0';
        for(int t=1;t<=4;t++){
        	switch(t){
        	case 1: c='新';
        	System.out.print(c);
        	case 2: c='亲';
        	System.out.print(c);
        	break;
        	case 3: c='斤';
        	System.out.print(c);
        	default:System.out.print("!");
        	}
        }
	}

}
