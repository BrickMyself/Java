package Test;
class Cat{	
	public static void main(String[] args)
	{
	 int age=10;
    System.out.print("hello world");
    System.out.print(" "+age+" ");
    System.out.println(" "+age+" ");
    //print 和 println 区别是输出后 光标是否换行
	}	
}
/*class A
{	
	public static void main(String[] args)
	{
		
	}	
}

class B
{
	//空类也不能通过编译，未定义主方法 显示找不到入口   有点像C++  这个class 不是必须定义的
}
*/
/*public class D
{
	//报错显示这个类型的 类只能定义在它自己的文件里
}*/
public class test {//这个 公开的类只能有一个 且类名与文件名相同，别的类可以定义多个
//类体中不能直接编写java 语句 但可以声明变量 
	public static void main(String[] args) {//主方法   定义一个静态的公开的方法   括号里的是参数
		//方法体
		// TODO Auto-generated method stub
//		System.out.println("hello world");
		//关于java语言当中的标识符
		//1、什么是标识符？
		//-在java源程序中凡是程序员有权利自己命名的单词都是标识符
		//-标识符可以标识以下元素
		//:*类名 *方法名 *变量名 *接口名 * 常量名
		//2、标识符的命名规则
		//-一个合法的标识符只能由"数字、字母、下划线_\美元符号$"组成
		//-不能数字开头
		//-严格区分大小写
		//-关键字不能做标识符 
		//-最好不要太长
		//3、标识符的命名规范 
		//-只是一种规范，不属于语法，不遵守规范编译器不会报错
		Cat a=new Cat();
		a.main(null);//调用另一个类里面的函数
		System.out.println("haha");
		//java 中的两种数据类型： 基本类型  引用数据类型
		//基本数据类型分为8种：
		//*1:数值类型  布尔数据类型   字符数据类型
		// 数值类型： 整数类型：字节类型 （byte)短整型 (short) 整形 （int） 长整形（long)  
		//小数类型： 单精度（float） 双精度（double）
		//字符类型：（char)
		byte s=127;//字节型 -127 ~127 超出范围的话会报错
		long d=1333333;//长整形
		System.out.println("s");
		float w=1.2f;//注意 小数后的f  不加是一个double了类型的值 小数常量的默认值是double 
		double t=9.56;//双精度
		char c='s';//只能存一个字符
		//局部变量 
		int i;//变量在定义时尽量赋初始值  且不能在同一个作用域中重复定义
//		public  Print()
//		{
//			
//		}
		//局部变量和全局变量，局部可以调全局 但全局不能调用局部
		{
			int o=10;	
		}
		//System.out.println(o);//这里会报错  无法解析为变量
		byte b=1;
		//byte b1=b+1; //这里报错 因为 这里的 " 1 " 在java中默认是 int 类型的
		//报错显示不能转换到byte类型
		byte b2=1;
		//byte b3=b+b2;//这种也不可以 会自动转换为 int 类型
		int b3=b+b2;//这样就不会报错
		// byte , short,int,char ,四种类型只要是发生计算都会把结果提升为int类型
		//
		char c2='a';
		int c1='a';
		System.out.println("c2"+" "+c1);//这里也要设置打印的类型在 print 库函数有很多默认是int  打印符号需要加上双引号 
		//上述打印结果为 c2  97
		//字符和int 类型可以自动转换 如上面的代码 如果要打印出字符' a '的话需要
		System.out.print(c2);//在 .print 选择 print（char c) 就可以打印出字符
		//int 类型超出的时候溢出不会发生自动提升为long 会变成负值 应该提前 定义long 来接收
		//不同的类型来计算的时候会向大的类型进行提升
	}

}
